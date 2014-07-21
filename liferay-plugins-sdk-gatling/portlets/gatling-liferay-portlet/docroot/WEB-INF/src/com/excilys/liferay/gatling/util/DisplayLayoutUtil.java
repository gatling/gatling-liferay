package com.excilys.liferay.gatling.util;

import com.excilys.liferay.gatling.util.DisplayLayout.RequestState;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.Layout;
import com.liferay.sample.model.Request;

import java.util.ArrayList;
import java.util.List;

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
				result.add(dlr);
			}
		}
		log.info("Size Result 1 : "+result.size());
		

		// Indent
		indentDisplayLayout(result);
		//return
		return result;
	}
	
	public static void indentDisplayLayout(List<DisplayLayout> list) {
		List<Long> indentTab = new ArrayList<Long>();
		for(DisplayLayout dl : list) {
			if(indentTab.contains(dl.getParentLayoutId())) {
				dl.setNumberOfSpace(dl.getNumberOfSpace()+indentTab.indexOf(dl.getParentLayoutId()));
			}
			indentTab.add(dl.getLayoutId());
		}
	}
}
