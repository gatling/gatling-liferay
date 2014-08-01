package com.excilys.liferay.gatling.util;

import com.excilys.liferay.gatling.model.Scenario;
import com.excilys.liferay.gatling.model.Simulation;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.Role;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class GatlingUtil {
	
	private static Log LOG = LogFactoryUtil.getLog(GatlingUtil.class);
	
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
	 * Retrieve list of active sites
	 * @return list
	 */
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
			e.printStackTrace();
		}

		return listGroups;
	}
	
	/**
	 * create new role 'gatling' if doesn't exist
	 * @param companyId
	 * @param userId
	 */
	public static void createRole(long companyId, long userId) throws SystemException, PortalException {

			DynamicQuery dq = DynamicQueryFactoryUtil.forClass(Role.class)
					.add(PropertyFactoryUtil.forName("name").eq("gatling"));
			
			List<Role> roles = RoleLocalServiceUtil.dynamicQuery(dq);
			if((roles ==null)|| roles.isEmpty() ){
				
				Locale locale=new Locale("English");
				Map<Locale,String> titleMap=new HashMap<Locale,String>();
				titleMap.put(locale,"English");
				Role objRole=RoleLocalServiceUtil.addRole(userId, companyId,"gatling",titleMap, null, 1);
				if(objRole!=null){
					LOG.info("gatling role was added successfuly") ;
				}else{
					LOG.info("failed to add gatling role");
				}
			}
			else{
				if(LOG.isInfoEnabled()) {
					LOG.info("The role gatling already exists "+ roles.get(0));
				}
			}
	}
}