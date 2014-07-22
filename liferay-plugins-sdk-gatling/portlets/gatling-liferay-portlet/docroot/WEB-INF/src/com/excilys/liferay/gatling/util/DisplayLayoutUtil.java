package com.excilys.liferay.gatling.util;

import com.excilys.liferay.gatling.util.DisplayLayout.RequestState;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.Layout;
import com.liferay.sample.model.Request;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DisplayLayoutUtil {

	private final static transient Log log = LogFactoryUtil.getLog(DisplayLayoutUtil.class.getName());

	/**
	 * Add to sorted layout list
	 */
	public static void addLayoutToDisplayLayoutList(List<DisplayLayout> displayLayoutList, List<Layout> listLayouts) {
		for(Layout l : listLayouts) {
			displayLayoutList.add(new DisplayLayout(l));
			//Recusive call
			try {
				// Get its children
				if(!l.getChildren().isEmpty())
					addLayoutToDisplayLayoutList(displayLayoutList, l.getChildren());
			} catch (SystemException e) {
				e.printStackTrace();
			}	
		}
	}

	public static List<DisplayLayout> addRequestToDisplayLayoutList(List<DisplayLayout> displayLayoutList, List<Request> listRequests) {
		List<DisplayLayout> result = new ArrayList<DisplayLayout>();
		List<DisplayLayout> requestToDisplayLayout = new ArrayList<DisplayLayout>();
		// Create a DisplayLayoutList of listRequests (for comparison) 
		for(Request r : listRequests) {
			requestToDisplayLayout.add(new DisplayLayout(r));
		}
		// Add displayLayoutList to result list
		result.addAll(displayLayoutList);
		// New
		for(DisplayLayout dl : result) {
			// if in result(here ie displayLayoutList) but not in listRequests it's a new request
			if(!requestToDisplayLayout.contains(dl)) {
				dl.setState(RequestState.NEW_REQUEST);
			}
		}
		// Old
		for(DisplayLayout dlr : requestToDisplayLayout) {
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
		//display test 
		for (DisplayLayout dl : result) {
			if(dl.getState() != RequestState.DEFAULT) {
				log.info(dl.getName());
			}
		}
		//return
		return result;
	}
	
	private static int findParentPosition(List<DisplayLayout> result, long parentLayoutId) {
		for (int i = 0; i < result.size(); i++) {
			DisplayLayout dl = result.get(i);
			if(dl.getLayoutId() == parentLayoutId) {
				return i;
			}
		}
		return -1;
	}

	public static void indentDisplayLayout(List<DisplayLayout> list) {
		Map<Long, Integer> indentTab = new HashMap<Long, Integer>();
		for(DisplayLayout dl : list) {
			if(indentTab.containsKey(dl.getParentLayoutId())) {
				dl.setNumberOfSpace(dl.getNumberOfSpace()+indentTab.get(dl.getParentLayoutId()));
			}
			indentTab.put(dl.getLayoutId(), dl.getNumberOfSpace()+1);
		}
	}
}
