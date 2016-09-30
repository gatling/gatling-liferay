/**
 * Copyright 2016 Gatling Corp (www.gatling.io)
 */
package io.gatling.liferay.util;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
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

import io.gatling.liferay.model.AST.ScenarioAST;
import io.gatling.liferay.model.AST.SimulationAST;
import io.gatling.liferay.model.AST.process.ProcessAST;
import io.gatling.liferay.model.AST.resource.ResourceFileAST;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
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
	 * Example: "my variable_name" becomes "PrefixMyVariableName"
	 * @param prefix The prefix to insert in the begining of the returned scenario name
	 * @param name The initial name
	 * @return The modified name
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

	/**
	 * Computes the scenario variable name by appending the 
	 * prefix "scenario".
	 * @param name The name of the variable
	 * @return The scenario variable
	 */
	public static String createScenarioVariable(String name) {
		return createVariableName("Scenario", name);
	}

	/**
	 * Computes the simulation variable name by appending the
	 * prefix "Simulation".
	 * @param name The name of the variable
	 * @return The simulation variable
	 */
	public static String createSimulationVariable(String name) {
		return createVariableName("Simulation", name);
	}

	/**
	 * Retrieve list of active sites present in the portal.
	 * @return The site list
	 */
	@SuppressWarnings("unchecked")
	public static List<Group> getListOfSites() {
		/* get sites list */
		DynamicQuery dq = DynamicQueryFactoryUtil.forClass(Group.class)
				.add(PropertyFactoryUtil.forName("type").eq(1)) // 1 -> site
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
	 * Get the friendlyUrl of the given site.
	 * @param themeDisplay The portal theme display needed to retrieve site
	 * 		informations
	 * @param layout The layout corresponding to the desired site
	 * @return The friendlyUrl of the site
	 * @throws SystemException If an error occured in the services
	 */
	public static String getGroupFriendlyURL(ThemeDisplay themeDisplay, Layout layout) throws SystemException {
		StringBuilder sb  = new StringBuilder();
		String currentFriendlyURL = GroupLocalServiceUtil.fetchGroup(layout.getGroupId()).getIconURL(themeDisplay);
	    sb.append(currentFriendlyURL.split("/")[0]);
	    sb.append("//").append(currentFriendlyURL.split("/")[2]).append("/web").append(GroupLocalServiceUtil.fetchGroup(layout.getGroupId()).getFriendlyURL()).append(layout.getFriendlyURL());
		return sb.toString();
	}
	
	public static String getAuthType(RenderRequest request)
			throws SystemException {
		final ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);
		Company company = themeDisplay.getCompany();
		return company.getAuthType();
	}
	
	/**
	 * Zip the test environment in 4 steps (predifined scenarios, simulations, feeders, properties).
	 * <ol>
	 *  	<li>Copies the predefined scenarios from resources to the zip environment
	 *  	<li> Generates the simulations based on the gatlingTemplate and mustache engine
	 *  	<li> Prepares all the feeders used for the execution
	 *  	<li> Copies all the propertie files
	 *  </ol>
	 * @param os: the outputStream used to transfer the zip
	 * @param classLoader: used to retreive the resource files' path
	 * @param request: resourcesRequest containing needed data (themeDisplay and portalURL)
	 * @param groupId
	 * @param simulationIds
	 */
	public static void zipMyEnvironment(OutputStream os, ClassLoader classLoader, ResourceRequest request, List<SimulationAST> scripts )
			throws MustacheException, Exception {

		final String packageFolder = "user-files/";
		final ZipOutputStream zipOutputStream = new ZipOutputStream(os);
		LOG.debug(scripts.get(0));

		// Scenario files:
		zipMyResources(packageFolder, classLoader, zipOutputStream);
		
		// Adds the generated simulations
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

		zipMyFeeders(packageFolder, classLoader, zipOutputStream, scripts);
		zipMyProperties(classLoader, zipOutputStream);
		zipOutputStream.close();
	}
	
	/**
	 * Zip the properties files.
	 * @param classLoader The current classloader
	 * @param zipOutputStream The produced zip output stream
	 * @throws IOException If an input/output error occurs
	 */
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
	/**
	 * Zip the resource files.
	 * @param packageFolder The folder representing the package in which the resource file
	 * 		will be present in the created directory structure.
	 * @param classLoader The current classloader
	 * @param zipOutputStream The produced zip output stream
	 * @throws IOException If an input/output error occurs
	 */
	private static void zipMyResources(String packageFolder, ClassLoader classLoader, ZipOutputStream zipOutputStream) throws IOException {
		
		File[] sources = new File(classLoader.getResource("gatling/processes/").getFile()).listFiles();
		// Goes through the sources directories
			for (File source : sources) {
				zipOutputStream.putNextEntry(new ZipEntry("gatling-for-liferay/"+packageFolder+"simulations/liferay/processes/" + source.getName()));
				zipOutputStream.write((getFile(source)).getBytes());
				zipOutputStream.closeEntry();
		}
	}
	
	/**
	 * Zip the feeder files.
	 * @param packageFolder The folder representing the package in which the resource file
	 * 		will be present in the created directory structure.
	 * @param classLoader The current classloader
	 * @param zipOutputStream The produced zip output stream
	 * @param simulations The simulations containing the feeder files
	 * @throws IOException If an input/output error occurs during the process
	 * @throws SystemException If an error occurs in the services
	 */
	private static void zipMyFeeders(String packageFolder, ClassLoader classLoader, ZipOutputStream zipOutputStream, List<SimulationAST> simulations) throws IOException, SystemException {
		
		// Going through the entire AST in order to generated the required feeder files
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
							//Duplicate entry exeptions are ignored, they come from feeder file duplication
							if(!e.getMessage().startsWith("duplicate entry:")) {
								throw e;
							}
						}
						
					}
				}
			}
		}
	}	
	
	
	/* 
	 * This function uses a trick found at this page
	 * https://web.liferay.com/community/forums/-/message_boards/message/10307074
	 * This should be improved by using NIO.2 (OCP, newby)
	 */
	
	/**
	 * Get file loads a specific file from WEB-INF/classes.
	 * @param path The file path
	 * @param classLoader The classloader used to retrieve the file
	 * @return The content of the file
	 */
	public static String getFile(String path, ClassLoader classLoader) {
		File file = new File(classLoader.getResource(path).getFile());
		return getFile(file);
	}

	/**
	 * Returns the file's content.
	 * @param file The desired file
	 * @return The content of the file
	 */
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

	/**
	 * Combines all the private (true) and public (false) layouts, the returned list represents the sipe map.
	 * @param groupId The site identifier
	 * @return The layout corresponding to the site
	 * @throws SystemException If an error occurs in the Layout Services
	 */
	public static List<Layout> getSiteMap(long groupId) throws SystemException {
		// NOTE get scenario group id -> scenario.getGroup_id();
		List<Layout> layouts = new ArrayList<>();
		layouts.addAll(LayoutLocalServiceUtil.getLayouts(groupId, true, 0));
		layouts.addAll(LayoutLocalServiceUtil.getLayouts(groupId, false, 0));		
		return layouts;
	
	}

}
