/**
 * Copyright 2011-2014 eBusiness Information, Groupe Excilys (www.ebusinessinformation.fr)
 */
package com.excilys.liferay.gatling.util;

import com.excilys.liferay.gatling.model.Request;
import com.excilys.liferay.gatling.util.DisplayItem.RequestState;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.PortletPreferences;
import com.liferay.portal.service.PortletPreferencesLocalServiceUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class DisplayItemUtil {

	private final static transient Log LOG = LogFactoryUtil.getLog(DisplayItemUtil.class.getName());

	/**
	 * Add {@link PortletPreferences} list the {@link DisplayItem} list
	 * @param displayItemtList
	 * @param listItems
	 */
	public static void addPortletToDisplayItemList(List<DisplayItem> displayItemtList, List<PortletPreferences> listPortletPreferences) {
		for(PortletPreferences pp : listPortletPreferences) {
			displayItemtList.add(new DisplayItem(pp));	
		}
	}

	/**
	 * Add {@link Layout} list the {@link DisplayItem} list
	 * @param displayItemList
	 * @param listLayouts
	 */
	public static void addLayoutToDisplayItemList(List<DisplayItem> displayItemList, List<Layout> listLayouts) {
		for(Layout layout : listLayouts) {
			displayItemList.add(new DisplayItem(layout));
			
			try {
				// Get portlet in layout
				Pattern p = Pattern.compile("column-\\d=(.*)");
				Matcher m =p.matcher(layout.getTypeSettings());
				List<String> listPortlet = new ArrayList<String>();
				while(m.find()){
					String[] tmp = m.group().substring(9).split(",");
					for (int i = 0; i < tmp.length; i++) {
						LOG.info("-> "+tmp[i]);
						listPortlet.add(tmp[i]);
					}
				}
				
				
				List<PortletPreferences> listPortletPreferences = PortletPreferencesLocalServiceUtil.getPortletPreferencesByPlid(layout.getPlid());
				for (PortletPreferences portletPreferences : listPortletPreferences) {
					LOG.info(portletPreferences.getPortletId());
					if(listPortlet.contains(portletPreferences.getPortletId())) {
						displayItemList.add(new DisplayItem(portletPreferences));
					}
				}
			} catch (SystemException e1) {
				new RuntimeException(e1.getMessage());
			}

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
	 * Add {@link Request} list to a {@link DisplayItem} list
	 * <br>
	 * This will add requests in the proper order (by hierachy)
	 * @param displayLayoutList
	 * @param listRequests
	 * @return the new list sorted and indent
	 */
	public static List<DisplayItem> addRequestToDisplayItemList(List<DisplayItem> displayLayoutList, List<Request> listRequests) {
		List<DisplayItem> result = new LinkedList<DisplayItem>();
		List<DisplayItem> requestToDisplayLayout = new ArrayList<DisplayItem>();
		// Create a DisplayLayoutList of listRequests (for comparison) 
		for(Request r : listRequests) {
			requestToDisplayLayout.add(new DisplayItem(r));
		}
		// Add displayLayoutList to result list
		result.addAll(displayLayoutList);
		// New
		for(DisplayItem dl : result) {
			// if in result(here displayLayoutList) but not in listRequests it's a new request
			if(!requestToDisplayLayout.contains(dl)) {
				dl.setState(RequestState.NEW_REQUEST);
			}
		}
		// Old
		for(DisplayItem dlr : requestToDisplayLayout) {
			// if in ListRequests but not in DisplayLayoutList it's a old request
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
				int parentIndex = findParentPosition(result,dlr.getParentLayoutId());
				if(parentIndex >= 0) {
					// put in on the "old" object place
					result.add(parentIndex+1, dlr);
				}
				else result.add(dlr);
			}
		}

		// Indent
		indentDisplayLayout(result);
		//return
		return result;
	}

	/**
	 * max iteration result.size()
	 * @param result
	 * @param parentLayoutId
	 * @return
	 */
	private static int findParentPosition(List<DisplayItem> result, long parentLayoutId) {
		for (int i = 0; i < result.size(); i++) {
			DisplayItem dl = result.get(i);
			if(dl.getDisplayLayoutId().getLayoutId() == parentLayoutId) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Indent a {@link DisplayItem} List
	 * @param list
	 */
	public static void indentDisplayLayout(List<DisplayItem> list) {
		Map<IdDisplayItem, Integer> indentTab = new HashMap<IdDisplayItem, Integer>();
		for(DisplayItem dl : list) {
			if(!dl.isPortlet()) {
				IdDisplayItem idl = new IdDisplayItem(dl.getDisplayLayoutId().isPrivatePage(),dl.getParentLayoutId());
				if(indentTab.containsKey(idl)) {
					dl.setNumberOfSpace(dl.getNumberOfSpace()+indentTab.get(idl));
				}
				indentTab.put(dl.getDisplayLayoutId(), dl.getNumberOfSpace()+1);
			}
		}
	}

	/**
	 * Create the Hierachy map from {@link DisplayItem} List
	 * @param list
	 * @param The result
	 */
	public static void mapHierachy(List<DisplayItem> list, Map<IdDisplayItem, List<IdDisplayItem>> mappage) {
		for(DisplayItem dl : list) {
			if(!dl.isPortlet() && dl.getParentLayoutId() !=0) {
				IdDisplayItem idl = new IdDisplayItem(dl.getDisplayLayoutId().isPrivatePage(),dl.getParentLayoutId());
				List<IdDisplayItem> childs = mappage.get(idl);
				//if not exits
				if(childs == null) {
					childs = new ArrayList<IdDisplayItem>();
				}
				childs.add(dl.getDisplayLayoutId());
				mappage.put(idl, childs);
			}
		}
	}
}
