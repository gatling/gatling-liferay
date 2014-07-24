package com.excilys.liferay.gatling.util;

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
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class GatlingUtil {
	
	private static Log log = LogFactoryUtil.getLog(GatlingUtil.class);
	
	public static String createVariableName(String prefix, String name) {
		// Create variable name
		return prefix.concat(StringUtil.upperCaseFirstLetter(name));
	}
	
	/**
	 * Récupère la liste des sites du portail
	 * @return list des sites
	 */
	public static List<Group> getListOfSites()  {
		/*recupere la liste des sites*/			
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
	
	public static void createRole(long companyId, long userId){
			
			try {
//				for(Role r : RoleLocalServiceUtil.getRoles(companyId)){
//					log.info(r);
//				}
				
				DynamicQuery dq = DynamicQueryFactoryUtil.forClass(Role.class)
						.add(PropertyFactoryUtil.forName("name").eq("gatling"));
				
				List<Role> roles = RoleLocalServiceUtil.dynamicQuery(dq);
				if((roles ==null)|| roles.isEmpty() ){
	//				long roleId = CounterLocalServiceUtil.increment(Role.class.getName());
	//				Role role = RoleLocalServiceUtil.createRole(roleId);
	//				role.setName("gatling");
	//				Role objRole= RoleLocalServiceUtil.addRole(role);
					Locale locale=new Locale("English");
					Map<Locale,String> titleMap=new HashMap<Locale,String>();
					titleMap.put(locale,"English");
					Role objRole=RoleLocalServiceUtil.addRole(userId, companyId,"gatling",titleMap, null, 1);
					if(objRole!=null){
						log.info("gatling role was added successfuly") ;
					}else{
						log.info("failed to add gatling role");
					}
				}
				else{
					log.info("The role gatling already exists "+ roles.get(0));
//					RoleLocalServiceUtil.deleteRole(roles.get(0));
				}
			} catch (SystemException e) {
				log.error("unable de add gatling role : "+e.getMessage());
			} catch (PortalException e) {
				log.error("enable to create role "+e.getMessage());
			}
		}
	}
