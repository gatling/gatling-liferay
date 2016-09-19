/**
 * Copyright 2015 Altendis, Groupe Excilys (www.altendis.fr)
 */
package io.gatling.liferay.util;

import io.gatling.liferay.dto.LinkUsecaseRequestDTO;
import io.gatling.liferay.model.LinkUsecaseRequest;
import io.gatling.liferay.model.Record;
import io.gatling.liferay.model.Scenario;
import io.gatling.liferay.model.Simulation;
import io.gatling.liferay.model.AST.ScenarioAST;
import io.gatling.liferay.model.AST.SimulationAST;
import io.gatling.liferay.model.AST.feeder.ResourceFileAST;
import io.gatling.liferay.model.AST.process.ProcessAST;
import io.gatling.liferay.service.LinkUsecaseRequestLocalServiceUtil;
import io.gatling.liferay.service.RecordLocalServiceUtil;
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
import com.samskivert.mustache.Escapers;
import com.samskivert.mustache.Mustache;
import com.samskivert.mustache.MustacheException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
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
	public static String createVariableName(String prefix, String name) {
		
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

	
	public static String getGroupFriendlyURL(ThemeDisplay themeDisplay, Layout layout) throws SystemException {
		StringBuilder sb  = new StringBuilder();
		String currentFriendlyURL = GroupLocalServiceUtil.fetchGroup(layout.getGroupId()).getIconURL(themeDisplay);
	    sb.append(currentFriendlyURL.split("/")[0]);
	    sb.append("//").append(currentFriendlyURL.split("/")[2]).append("/web").append(GroupLocalServiceUtil.fetchGroup(layout.getGroupId()).getFriendlyURL()).append(layout.getFriendlyURL());
		return sb.toString();
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
	//TODO many parameters need to be removed, siteMap generation will soon be done somewhere else
	public static void zipMyEnvironment(OutputStream os, ClassLoader classLoader, ResourceRequest request, List<SimulationAST> scripts )
			throws MustacheException, Exception {

		final String packageFolder = "user-files/";
		final ZipOutputStream zipOutputStream = new ZipOutputStream(os);
		LOG.debug(scripts.get(0));

		// Scenario files:
		//-------------------------------------------------------------------------------------------------------------------------------------	
		zipMyResources(packageFolder, classLoader, zipOutputStream);

		
		// Adds the generated simulations
		//-------------------------------------------------------------------------------------------------------------------------------------
		String template = "/templateGatling2.2.X.mustache";
		
		//create and export only one file with scenario script for this simulation id
		 for (SimulationAST script : scripts) { 
			 zipOutputStream.putNextEntry(new ZipEntry("gatling-for-liferay/"+packageFolder+"simulations/liferay/" +
					 createSimulationVariable(script.getSimulationName())+ ".scala")); 
			 final String currentPath =request.getPortletSession().getPortletContext().getRealPath("/WEB-INF/classes") + template; 
			 
			 // Default escaper is HTMl, which doesn't process some caraters
			 Mustache.Compiler compiler = Mustache.compiler().withEscaper(Escapers.NONE);
			 
			 final String scalaCompiled = compiler.compile(
				new FileReader(currentPath)).execute(script);
			 
			 zipOutputStream.write(scalaCompiled.getBytes());
			 zipOutputStream.closeEntry();
		 } 
		 

		// Saving feeders:
		//-------------------------------------------------------------------------------------------------------------------------------------
		zipMyFeeders(packageFolder, classLoader, zipOutputStream, scripts);
		
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
	private static void zipMyFeeders(String packageFolder, ClassLoader classLoader, ZipOutputStream zipOutputStream, List<SimulationAST> simulations) throws IOException, SystemException {
		
		// Going throw the entire AST in order to generated the required feeder files
		for (SimulationAST simulationAST : simulations) {
			for (ScenarioAST scenarioAST : simulationAST.getScenarios()) {
				for (ProcessAST processAST : scenarioAST.getProcesses()) {
					for (ResourceFileAST feederFileAST : processAST.getFeederFiles()) {
						//TODO: remove ugly duplication handling
						//NOTE: process duplication implies that feeders are exported twice, an improvement in the AST must be done
						try {
							zipOutputStream.putNextEntry(new ZipEntry("gatling-for-liferay/"+packageFolder+feederFileAST.getLocatedName()));
							zipOutputStream.write(feederFileAST.getContent().getBytes());
							zipOutputStream.closeEntry();
						} catch(ZipException e) {
							if(!e.getMessage().startsWith("duplicate entry:")) {
								throw e;
							}
						}
						
					}
				}
			}
		}
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
