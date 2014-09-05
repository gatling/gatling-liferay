/**
 * Copyright 2011-2014 eBusiness Information, Groupe Excilys (www.ebusinessinformation.fr)
 */
package com.excilys.liferay.gatling.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.excilys.liferay.gatling.dto.RequestDTO;
import com.excilys.liferay.gatling.dto.RequestDTO.RequestState;
import com.excilys.liferay.gatling.model.Request;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.PortletPreferences;
import com.liferay.portal.service.PortletPreferencesLocalServiceUtil;


public class DisplayItemDTOUtil {

	private final static transient Log LOG = LogFactoryUtil.getLog(DisplayItemDTOUtil.class.getName());

	/**
	 * Add {@link PortletPreferences} list the {@link RequestDTO} list
	 * @param displayItemtList
	 * @param listItems
	 */
	public static void addPortletToDisplayItemList(List<RequestDTO> displayItemtList, List<PortletPreferences> listPortletPreferences) {
		for(PortletPreferences pp : listPortletPreferences) {
			displayItemtList.add(new RequestDTO(pp));	
		}
	}

	/**
	 * Add {@link Layout} list the {@link RequestDTO} list
	 * @param displayItemList
	 * @param listLayouts
	 */
	public static void addLayoutToDisplayItemList(List<RequestDTO> displayItemList, List<Layout> listLayouts) {
		for(Layout layout : listLayouts) {
			displayItemList.add(new RequestDTO(layout));

			try {
				// Get portlet in layout
				Pattern p = Pattern.compile("column-\\d=(.*)");
				Matcher m =p.matcher(layout.getTypeSettings());
				List<String> listPortlet = new ArrayList<String>();
				while(m.find()){
					String[] tmp = m.group().substring(9).split(",");
					for (int i = 0; i < tmp.length; i++) {
						listPortlet.add(tmp[i]);
					}
				}

				List<PortletPreferences> listPortletPreferences = PortletPreferencesLocalServiceUtil.getPortletPreferencesByPlid(layout.getPlid());
				for (PortletPreferences portletPreferences : listPortletPreferences) {
					if(listPortlet.contains(portletPreferences.getPortletId())) {
						displayItemList.add(new RequestDTO(portletPreferences));
					}
				}
			} catch (SystemException e1) {
				new RuntimeException(e1.getMessage());
			}
			displayItemList.size();
			
			//Recusive call
			try {
				// Get its children
				if(!layout.getChildren().isEmpty())
					addLayoutToDisplayItemList(displayItemList, layout.getChildren());
			} catch (SystemException e) {
				LOG.error("Can't get children : "+e.getMessage());
			}	
		}
	}

	/**
	 * Add {@link Request} list to a {@link RequestDTO} list
	 * <br>
	 * This will add requests in the proper order (by hierachy)
	 * @param displayLayoutList
	 * @param listRequests
	 * @return the new list sorted and indent
	 */
	public static List<RequestDTO> addRequestToDisplayItemList(List<RequestDTO> displayLayoutList, List<Request> listRequests) {
		List<RequestDTO> result = new LinkedList<RequestDTO>();
		List<RequestDTO> requestToDisplayLayout = new ArrayList<RequestDTO>();
		// Create a DisplayLayoutList of listRequests (for comparison) 
		for(Request r : listRequests) {
			requestToDisplayLayout.add(new RequestDTO(r));
		}
		// Add displayLayoutList to result list
		result.addAll(displayLayoutList);
		// New
		for(RequestDTO dl : result) {
			// if in result(here displayLayoutList) but not in listRequests it's a new request
			if(!requestToDisplayLayout.contains(dl)) {
				dl.setState(RequestState.NEW_REQUEST);
			}
		}
		// Old
		for(RequestDTO dlr : requestToDisplayLayout) {
			// if in ListRequests but not in DisplayLayoutList it's an old request
			if(!result.contains(dlr)) {
				dlr.setState(RequestState.OLD_REQUEST);
			}
			//change the object (add weight, checked ...)
			int index = result.indexOf(dlr);
			// if in layout
			if(index >= 0) {
				// put in on the "old" object place
				result.add(index, dlr);
				// remove the replaced object
				result.remove(index+1);
			}
			// if not in layoutList add after its parent or at the end
			else {
				int parentIndex = findParentPosition(result,dlr.getParentDisplayId());
				if(parentIndex >= 0) {
					// put in on the "old" object place
					result.add(parentIndex+1, dlr);
				}
				else result.add(dlr);
			}
		}

		// Indent
		processIndentAndHierachy(result);
		//return
		return result;
	}

	/**
	 * max iteration result.size()
	 * @param result
	 * @param parentLayoutId
	 * @return
	 */
	private static int findParentPosition(List<RequestDTO> result, long parentDisplayId) {
		for (int i = 0; i < result.size(); i++) {
			RequestDTO dl = result.get(i);
			if(dl.getDisplayId() == parentDisplayId) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Indent a {@link RequestDTO} List
	 * @param list
	 */
	public static void processIndentAndHierachy(List<RequestDTO> list) {
		class Info {
			int depth;
			long parentNode;
			boolean isPortlet;
			public Info(int depth, long parentNode, boolean portlet) {
				this.depth = depth;
				this.parentNode = parentNode;
				this.isPortlet = portlet;
			}
		}
		// Indent and subnode
		Map<Long, Info> indentInfo = new HashMap<Long, Info>();
		for (RequestDTO dl : list) {
			Long parent = dl.getParentDisplayId();
			// if it is subnode
			if(indentInfo.containsKey(parent) && parent != 0) {
				dl.setDepth(dl.getDepth()+indentInfo.get(parent).depth+1);
			}
			// keep the parent for the second part
			indentInfo.put(dl.getDisplayId(), new Info(dl.getDepth(), parent, dl.isPortlet()));
		}
		
		// set the subnodes
		for (RequestDTO displayItem : list) {
			for(Entry<Long, Info> set : indentInfo.entrySet()) {
				if(set.getValue().parentNode == displayItem.getDisplayId()) {
					if(set.getValue().isPortlet) {
						displayItem.getPagePortlet().add(set.getKey());
					} else {
						displayItem.getSubNodes().add(set.getKey());
					}
				}
			}
		}

	}
	
}