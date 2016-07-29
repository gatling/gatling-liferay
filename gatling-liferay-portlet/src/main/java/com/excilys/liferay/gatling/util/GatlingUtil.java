/**
 * Copyright 2015 Altendis, Groupe Excilys (www.altendis.fr)
 */
package com.excilys.liferay.gatling.util;

import com.excilys.liferay.gatling.dto.LinkUsecaseRequestDTO;
import com.excilys.liferay.gatling.model.LinkUsecaseRequest;
import com.excilys.liferay.gatling.model.Record;
import com.excilys.liferay.gatling.model.Scenario;
import com.excilys.liferay.gatling.model.Simulation;
import com.excilys.liferay.gatling.mustache.ScriptGeneratorGatling;
import com.excilys.liferay.gatling.service.LinkUsecaseRequestLocalServiceUtil;
import com.excilys.liferay.gatling.service.RecordLocalServiceUtil;
import com.excilys.liferay.gatling.service.SimulationLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Company;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.Layout;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.samskivert.mustache.Mustache;
import com.samskivert.mustache.MustacheException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.portlet.RenderRequest;
import javax.portlet.ResourceRequest;

public class GatlingUtil {

	/**
	 * create variable name for gatling scenario
	 * 
	 * @param prefix
	 * @param name
	 * @return
	 */
	private static String createVariableName(String prefix, String name) {
		
		if (!name.isEmpty() && name.charAt(0)=='_') {
			//Hack if the name starts with '_' which causes an Error if not processed
			name = name.substring(1); 
		}
		
		// Create variable name
		String[] tab = name.trim().split("[_\\s]");
		StringBuffer sb = new StringBuffer(prefix);
		for (String string : tab) {
			sb.append(StringUtil.upperCaseFirstLetter(string));
		}
		return sb.toString();
	}

	public static String createScenarioVariable(String name) {
		return createVariableName("Scenario", name);
	}

	public static String createSimulationVariable(String name) {
		return createVariableName("Simulation", name);
	}

	/**
	 * create a javascript list of simulation name
	 * 
	 * @param list
	 * @return
	 */
	public static String createJSListOfSimulationName(List<Simulation> list) {
		StringBuilder sb = new StringBuilder("[");
		for (Iterator<Simulation> iterator = list.iterator(); iterator
				.hasNext();) {
			Simulation simulation = iterator.next();
			sb.append("'").append(simulation.getName()).append("'");
			if (iterator.hasNext()) {
				sb.append(",");
			}
		}
		return sb.append("]").toString();
	}

	/**
	 * create a javascript list of scenario name
	 * 
	 * @param list
	 * @return
	 */
	public static String createJSListOfScenarioName(List<Scenario> list) {
		StringBuilder sb = new StringBuilder("[");
		for (Iterator<Scenario> iterator = list.iterator(); iterator.hasNext();) {
			Scenario scenario = iterator.next();
			sb.append("'").append(scenario.getName()).append("'");
			if (iterator.hasNext()) {
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
			if (iterator.hasNext()) {
				sb.append(",");
			}
		}
		return sb.append("]").toString();
	}

	/**
	 * Retrieve list of active sites
	 * 
	 * @return list
	 */
	@SuppressWarnings("unchecked")
	public static List<Group> getListOfSites() {
		/* get sites list */
		DynamicQuery dq = DynamicQueryFactoryUtil.forClass(Group.class)
				.add(PropertyFactoryUtil.forName("type").eq(1))
				// 1 -> site
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

	/**
	 * 
	 * @param requestId
	 * @return
	 * @throws SystemException
	 * @throws PortalException
	 */
	public static List<LinkUsecaseRequestDTO> fillArrayLinkUseCases(
			long requestId) throws SystemException, PortalException {
		List<LinkUsecaseRequest> listUseCaseRequest = LinkUsecaseRequestLocalServiceUtil
				.findByRequestId(requestId);
		List<LinkUsecaseRequestDTO> listDisplayLink = new ArrayList<LinkUsecaseRequestDTO>();
		for (LinkUsecaseRequest link : listUseCaseRequest) {
			long recordId = link.getRecordId(); // ID
			long linkId = link.getLinkUsecaseRequestId();
			double weight = link.getWeight(); // WEIGHT
			boolean isSample = link.isSample();
			String name = null;
			if (isSample) {
				if (link.getRecordId() == 1) {
					name = "Sample (only GETs)"; // NAME
				} else if (link.getRecordId() == 2) {
					name = "Sample (POSTs & GETs)"; // NAME
				} else if (link.getRecordId() == 3) {
					name = "Sample (Complex one)"; // NAME
				}
			} else {
				name = RecordLocalServiceUtil.getRecord(link.getRecordId())
						.getName(); // NAME
			}
			listDisplayLink.add(new LinkUsecaseRequestDTO(linkId, recordId,
					weight, name, isSample));
		}
		return listDisplayLink;
	}

	public static String getAuthType(RenderRequest request)
			throws SystemException {
		final ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);
		Company company = themeDisplay.getCompany();
		return company.getAuthType();
	}

	/**
	 * Zip the test environment in 3 steps (predifined scenarios, simulations, feeders)
	 * 	
	 *  1 -> Copies the predefined scenarios from resources to the zip environment
	 *  2 -> Generates the simulations based on the gatlingTemplate and mustache engine
	 *  3 -> Prepares all the feeders used for the execution
	 *  
	 * @param os: the outputStream used to transfer the zip
	 * @param classLoader: used for coping resources file
	 * @param request: resourcesRequest containing needed data (themeDisplay, path and portalURL)
	 * @param groupId
	 * @param simulationIds
	 */
	
	public static void zipMyEnvironment(OutputStream os, ClassLoader classLoader, ResourceRequest request, long groupId, long[] simulationsIds )
			throws MustacheException, Exception {

		final String packageFolder = "com/ebusiness/liferay/";
		
		final ThemeDisplay themeDisplay =	(ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		final ZipOutputStream zipOutputStream = new ZipOutputStream(os);
		
		// TODO: add a README -> Hey I just met you, and this is crazy, but here're my scalas, so readme maybe
		
		// Get file from resources folder
		//-------------------------------------------------------------------------------------------------------------------------------------
		File[] files = new File(classLoader.getResource("gatling/"+packageFolder).getFile()).listFiles();
		// Goes through the sources directories (scenario and feeder)
		for (File rootDirectory : files) {
			File[] sources = rootDirectory.listFiles();
			for (File source : sources) {
				zipOutputStream.putNextEntry(new ZipEntry(packageFolder+rootDirectory
						.getName() + "/" + source.getName()));
				zipOutputStream.write((getFile(source)).getBytes());
				zipOutputStream.closeEntry();
			}
		}

		// Adds the generated simulations
		//-------------------------------------------------------------------------------------------------------------------------------------
		final long date = new Date().getTime();
		String template = "/templateGatling2.2.X.mustache";
		Simulation simulation = null;
		
		//create and export only one file with scenario script for this simulation id
		 for (final long id : simulationsIds) { if (id > 0) {
			 simulation = SimulationLocalServiceUtil.getSimulation(id);
			 zipOutputStream.putNextEntry(new ZipEntry(packageFolder+"simulations/"+"Simulation" +
					 createSimulationVariable(simulation.getName()) + date + ".scala")); 
			 final String currentPath =request.getPortletSession().getPortletContext().getRealPath("/WEB-INF/classes") + template; 
			 ScriptGeneratorGatling script = new ScriptGeneratorGatling(id,PortalUtil.getPortalURL(request));
			 script.setSimuName(script.getSimuName()+date);
			 final String tmp = Mustache.compiler().compile(
				new FileReader(currentPath)).execute(script);
			 zipOutputStream.write(tmp.getBytes()); zipOutputStream.closeEntry();
		 } }
		 

		// Saving feeders:
		//-------------------------------------------------------------------------------------------------------------------------------------
		// SiteMapFeeder
		zipOutputStream.putNextEntry(new ZipEntry(packageFolder+"feeders/siteMapPages.csv"));
		zipOutputStream.write("site,URL\n".getBytes());
		for (Layout layout : getSiteMap(groupId)) {
			String currentFriendlyURL = GroupLocalServiceUtil.fetchGroup(layout.getGroupId()).getIconURL(themeDisplay);
			StringBuilder sb = new StringBuilder(currentFriendlyURL.split("/")[0]);
			sb.append("//").append(currentFriendlyURL.split("/")[2]).append("/web").append(GroupLocalServiceUtil.fetchGroup(layout.getGroupId()).getFriendlyURL()).append(layout.getFriendlyURL());
			zipOutputStream.write((layout.getFriendlyURL().substring(1)+","+sb.toString()+"\n").getBytes());
		}
		zipOutputStream.closeEntry();
		
		// LoginFeeder
		zipOutputStream.putNextEntry(new ZipEntry(packageFolder+"feeders/loginFeeder.csv"));
		zipOutputStream.write("user,password\n".getBytes());
		String feederContent = simulation.getFeederContent();
		Scanner scanner=new Scanner(feederContent);
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			zipOutputStream.write(line.getBytes());
		}
		scanner.close();
		zipOutputStream.closeEntry();
		
		// Properties file:
		//-------------------------------------------------------------------------------------------------------------------------------------	
		File[] properties = new File(classLoader.getResource("gatling/").getFile()).listFiles();
		for (File f : properties) {
			if (f.isFile()) {
				zipOutputStream.putNextEntry(new ZipEntry(f.getName()));
				zipOutputStream.write(getFile(f).getBytes());
				zipOutputStream.closeEntry();
			}
				
			
		}
		
		zipOutputStream.close();
	}

	// Get file loads a specific file from WEB-INF/classes
	// https://web.liferay.com/community/forums/-/message_boards/message/10307074
	public static String getFile(String path, ClassLoader classLoader) {

		// Get file from resources folder
		File file = new File(classLoader.getResource(path).getFile());
		return getFile(file);
	}

	public static String getFile(File file) {
		StringBuilder result = new StringBuilder("");

		// File f = new File(
		// getClass().getClassLoader().getResource("/file.txt").getFile());
		try (Scanner scanner = new Scanner(file)) {

			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				result.append(line).append("\n");
			}

			scanner.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return result.toString();
	}

	// Combines all the private (true) and public (false) layouts
	public static List<Layout> getSiteMap(long groupId) throws SystemException {
		// NOTE get scenario group id -> scenario.getGroup_id();
		List<Layout> layouts = new ArrayList<>();
		layouts.addAll(LayoutLocalServiceUtil.getLayouts(groupId, true, 0));
		layouts.addAll(LayoutLocalServiceUtil.getLayouts(groupId, false, 0));		
		return layouts;
	
	}

}
