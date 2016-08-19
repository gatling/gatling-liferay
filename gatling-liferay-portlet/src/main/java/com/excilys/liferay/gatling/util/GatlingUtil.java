/**
 * Copyright 2015 Altendis, Groupe Excilys (www.altendis.fr)
 */
package com.excilys.liferay.gatling.util;

import com.excilys.liferay.gatling.dto.LinkUsecaseRequestDTO;
import com.excilys.liferay.gatling.model.LinkUsecaseRequest;
import com.excilys.liferay.gatling.model.Record;
import com.excilys.liferay.gatling.model.Scenario;
import com.excilys.liferay.gatling.model.Simulation;
import com.excilys.liferay.gatling.model.UrlRecord;
import com.excilys.liferay.gatling.mustache.DefaultMustachScript;
import com.excilys.liferay.gatling.service.LinkUsecaseRequestLocalServiceUtil;
import com.excilys.liferay.gatling.service.RecordLocalServiceUtil;
import com.excilys.liferay.gatling.service.SimulationLocalServiceUtil;
import com.excilys.liferay.gatling.service.UrlRecordLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Company;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.Layout;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.samskivert.mustache.Escapers;
import com.samskivert.mustache.Mustache;
import com.samskivert.mustache.MustacheException;
import com.samskivert.mustache.Mustache.Formatter;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.portlet.RenderRequest;
import javax.portlet.ResourceRequest;

public class GatlingUtil {

	private static final Log LOG = LogFactoryUtil.getLog(GatlingUtil.class);

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

	public static void zipMyProcess(OutputStream os, ClassLoader classLoader, ResourceRequest request, String recordName )
			throws MustacheException, Exception {

		final ZipOutputStream zipOutputStream = new ZipOutputStream(os);
		
		List<Record> records = RecordLocalServiceUtil.findByPortletId("_default_");
		//TODO find record with the recordName
		Record record = records.get(0);
		
		// Get processes from resources folder
		//-------------------------------------------------------------------------------------------------------------------------------------
		zipOutputStream.putNextEntry(new ZipEntry("record"+recordName+".csv"));
		zipOutputStream.write("url,type,datafile\n".getBytes());
		
		LOG.debug(record.getName());
		List<UrlRecord> urls = UrlRecordLocalServiceUtil.findByRecordId(record.getPrimaryKey());
		for (UrlRecord url : urls) {
			zipOutputStream.write((url.getUrl()+","+url.getType()+"\n").getBytes());
		}
		zipOutputStream.closeEntry();
		zipOutputStream.close();
	}
	
	/**
	 * Zip the test environment in 4 steps (predifined scenarios, simulations, feeders, properties)
	 * 	
	 *  1 -> Copies the predefined scenarios from resources to the zip environment
	 *  2 -> Generates the simulations based on the gatlingTemplate and mustache engine
	 *  3 -> Prepares all the feeders used for the execution
	 *  4 -> Copies all the propertie files
	 *  
	 * @param os: the outputStream used to transfer the zip
	 * @param classLoader: used to retreive the resource files' path
	 * @param request: resourcesRequest containing needed data (themeDisplay and portalURL)
	 * @param groupId
	 * @param simulationIds
	 */
	
	public static void zipMyEnvironment(OutputStream os, ClassLoader classLoader, ResourceRequest request, long groupId, List<DefaultMustachScript> scripts )
			throws MustacheException, Exception {

		final String packageFolder = "user-files/";
		//final long date = new Date().getTime();
		final ThemeDisplay themeDisplay =	(ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		final ZipOutputStream zipOutputStream = new ZipOutputStream(os);
		LOG.debug(scripts.get(0));

		// Resource files:
		//-------------------------------------------------------------------------------------------------------------------------------------	
		zipMyResources(packageFolder, classLoader, zipOutputStream);

		// Adds the generated simulations
		//-------------------------------------------------------------------------------------------------------------------------------------
		String template = "/templateGatling2.2.X.mustache";
		
		//create and export only one file with scenario script for this simulation id
		 for (DefaultMustachScript script : scripts) { 
			 //simulation = SimulationLocalServiceUtil.getSimulation(id);
			 zipOutputStream.putNextEntry(new ZipEntry("gatling-for-liferay/"+packageFolder+"simulations/liferay/" +
					 createSimulationVariable(script.getSimulationName())+ ".scala")); 
			 final String currentPath =request.getPortletSession().getPortletContext().getRealPath("/WEB-INF/classes") + template; 
			 Mustache.Compiler c = Mustache.compiler().withEscaper(Escapers.NONE);
			 
			 final String tmp = c.compile(
				new FileReader(currentPath)).execute(script);
			 
			 zipOutputStream.write(tmp.getBytes());
			 zipOutputStream.closeEntry();
		 } 
		 

		// Saving feeders:
		//-------------------------------------------------------------------------------------------------------------------------------------
		zipMyFeeders(packageFolder, groupId, themeDisplay, classLoader, zipOutputStream);
		
		// Properties file:
		//-------------------------------------------------------------------------------------------------------------------------------------	
		zipMyProperties(classLoader, zipOutputStream);
		
		zipOutputStream.close();
	}
	
	// Properties file:
	//-------------------------------------------------------------------------------------------------------------------------------------	
	private static void zipMyProperties(ClassLoader classLoader, ZipOutputStream zipOutputStream) throws IOException {
		File[] properties = new File(classLoader.getResource("gatling/")
				.getFile()).listFiles();
		for (File f : properties) {
			if (f.isFile()) {
				zipOutputStream.putNextEntry(new ZipEntry(
						"gatling-for-liferay/" + f.getName()));
				zipOutputStream.write(getFile(f).getBytes());
				zipOutputStream.closeEntry();
			}
		}
	}
	
	// Resource files:
	//-------------------------------------------------------------------------------------------------------------------------------------	
	private static void zipMyResources(String packageFolder, ClassLoader classLoader, ZipOutputStream zipOutputStream) throws IOException {
		// Get processes from resources folder
		//-------------------------------------------------------------------------------------------------------------------------------------
		File[] sources = new File(classLoader.getResource("gatling/processes/").getFile()).listFiles();
		// Goes through the sources directories
			for (File source : sources) {
				zipOutputStream.putNextEntry(new ZipEntry("gatling-for-liferay/"+packageFolder+"simulations/liferay/processes/" + source.getName()));
				zipOutputStream.write((getFile(source)).getBytes());
				zipOutputStream.closeEntry();
		}
	}
	
	// Feeder files:
	//-------------------------------------------------------------------------------------------------------------------------------------	
	private static void zipMyFeeders(String packageFolder, long groupId, ThemeDisplay themeDisplay, ClassLoader classLoader, ZipOutputStream zipOutputStream) throws IOException, SystemException {
		// Saving feeders:
		//-------------------------------------------------------------------------------------------------------------------------------------
		
		// SiteMapFeeder
		//TODO move siteMap creation to Database, it must be present in AST
		zipOutputStream.putNextEntry(new ZipEntry("gatling-for-liferay/"+packageFolder+"data/feeders/siteMapPage.csv"));
		zipOutputStream.write("site,URL\n".getBytes());
		for (Layout layout : getSiteMap(groupId)) {
			String currentFriendlyURL = GroupLocalServiceUtil.fetchGroup(layout.getGroupId()).getIconURL(themeDisplay);
			StringBuilder sb = new StringBuilder(currentFriendlyURL.split("/")[0]);
			sb.append("//").append(currentFriendlyURL.split("/")[2]).append("/web").append(GroupLocalServiceUtil.fetchGroup(layout.getGroupId()).getFriendlyURL()).append(layout.getFriendlyURL());
			zipOutputStream.write((layout.getFriendlyURL().substring(1)+","+sb.toString()+"\n").getBytes());
		}
		zipOutputStream.closeEntry();
		
		// LoginFeeder
		zipOutputStream.putNextEntry(new ZipEntry("gatling-for-liferay/"+packageFolder+"data/feeders/login.csv"));
		zipOutputStream.write("user,password\n".getBytes());
		//TODO iterate over process feeders
		/*String feederContent = s.getFeederContent();
		Scanner scanner=new Scanner(feederContent);
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			zipOutputStream.write(line.getBytes());
		}
		scanner.close();*/
		zipOutputStream.closeEntry();
		
	}	
	
	// Get file loads a specific file from WEB-INF/classes
	// https://web.liferay.com/community/forums/-/message_boards/message/10307074
	public static String getFile(String path, ClassLoader classLoader) {

		// Get file from resources folder
		File file = new File(classLoader.getResource(path).getFile());
		return getFile(file);
	}

	
	/* Returnes the file's content */
	public static String getFile(File file) {
		StringBuilder result = new StringBuilder("");

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
