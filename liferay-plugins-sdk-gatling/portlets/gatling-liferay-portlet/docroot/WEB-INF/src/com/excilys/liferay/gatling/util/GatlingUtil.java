/**
 * Copyright 2011-2014 eBusiness Information, Groupe Excilys (www.ebusinessinformation.fr)
 */
package com.excilys.liferay.gatling.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.excilys.liferay.gatling.dto.LinkUsecaseRequestDTO;
import com.excilys.liferay.gatling.model.LinkUsecaseRequest;
import com.excilys.liferay.gatling.model.Record;
import com.excilys.liferay.gatling.model.Scenario;
import com.excilys.liferay.gatling.model.Simulation;
import com.excilys.liferay.gatling.service.LinkUsecaseRequestLocalServiceUtil;
import com.excilys.liferay.gatling.service.RecordLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.Group;
import com.liferay.portal.service.GroupLocalServiceUtil;

public class GatlingUtil {
	
	
	/**
	 * create variable name for gatling scenario
	 * @param prefix
	 * @param name
	 * @return
	 */
	public static String createVariableName(String prefix, String name) {
		// Create variable name
		return prefix.concat(StringUtil.upperCaseFirstLetter(name.replaceAll("\\P{Alnum}", "")));
	}
	
	/**
	 * create a javascript list of simulation name
	 * @param list
	 * @return
	 */
	public static String createJSListOfSimulationName(List<Simulation> list)  {
		StringBuilder sb = new StringBuilder("[");
		for (Iterator<Simulation> iterator = list.iterator(); iterator.hasNext();) {
			Simulation simulation = iterator.next();
			sb.append("'").append(simulation.getName()).append("'");
			if(iterator.hasNext()) {
				sb.append(",");
			}
		}
		return sb.append("]").toString();
	}
	
	/**
	 * create a javascript list of scenario name
	 * @param list
	 * @return
	 */
	public static String createJSListOfScenarioName(List<Scenario> list) {
		StringBuilder sb = new StringBuilder("[");
		for (Iterator<Scenario> iterator = list.iterator(); iterator.hasNext();) {
			Scenario scenario = iterator.next();
			sb.append("'").append(scenario.getName()).append("'");
			if(iterator.hasNext()) {
				sb.append(",");
			}
		}
		return sb.append("]").toString();
	}
	
	/**
	 * 
	 * @param list
	 * @return
	 */
	public static String createJSListOfRecordName(List<Record> list) {
		StringBuilder sb = new StringBuilder("[");
		for (Iterator<Record> iterator = list.iterator(); iterator.hasNext();) {
			Record record = iterator.next();
			sb.append("'").append(record.getName()).append("'");
			if(iterator.hasNext()) {
				sb.append(",");
			}
		}
		return sb.append("]").toString();
	}
	
	/**
	 * Retrieve list of active sites
	 * @return list
	 */
	@SuppressWarnings("unchecked")
	public static List<Group> getListOfSites()  {
		/*get sites list*/			
		DynamicQuery dq = DynamicQueryFactoryUtil.forClass(Group.class)
				.add(PropertyFactoryUtil.forName("type").eq(1)) //1 -> site
				.add(PropertyFactoryUtil.forName("site").eq(true))
				.add(PropertyFactoryUtil.forName("active").eq(true));

		List<Group> listGroups = new ArrayList<Group>();
		try {
			listGroups = (List<Group>) GroupLocalServiceUtil.dynamicQuery(dq);
		} catch (SystemException e) {
			throw new RuntimeException(e.getMessage());
		}

		return listGroups;
	}

	
	public static Map<Long, String> createMapRecordIdAndName(List<Record> records) {
		Map<Long,String> recordMap = new HashMap<Long, String>();
		for (Record record : records) {
			recordMap.put(record.getRecordId(), record.getName());
		}
		return recordMap;
	}
	
	

	/**
	 * 
	 * @param requestId
	 * @return
	 * @throws SystemException
	 * @throws PortalException
	 */
public static List<LinkUsecaseRequestDTO> fillArrayLinkUseCases(long requestId) throws SystemException, PortalException {
		int numberUseCases = LinkUsecaseRequestLocalServiceUtil.countByRequestId(requestId);
		String[][] arrayLinkUsecaseRequest = new String[numberUseCases][3];
		List<LinkUsecaseRequest> listUseCaseRequest= LinkUsecaseRequestLocalServiceUtil.findByRequestId(requestId);
		List<LinkUsecaseRequestDTO> listDisplayLink = new ArrayList<LinkUsecaseRequestDTO>();
		for (LinkUsecaseRequest link : listUseCaseRequest) {
			long recordId = link.getRecordId(); //ID
			long linkId = link.getLinkUsecaseRequestId();
			double weight = link.getWeight(); //WEIGHT
			boolean isSample = link.isSample();
			String name = null;
			if(link.isSample()){
				if(link.getRecordId() == 1){
					name = "Sample (only GETs)"; //NAME
				} else if(link.getRecordId() == 2){
					name = "Sample (POSTs & GETs)"; //NAME
				} else if(link.getRecordId() == 3){
					name = "Sample (Complex one)"; //NAME
				}
			} else {
				name = RecordLocalServiceUtil.getRecord(link.getRecordId()).getName(); //NAME

			}
			listDisplayLink.add(new LinkUsecaseRequestDTO(linkId, recordId, weight, name, isSample));
		}
		return listDisplayLink;
	}
}
