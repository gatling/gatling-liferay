package io.gatling.generation.service;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.samskivert.mustache.Escapers;
import com.samskivert.mustache.Mustache;
import com.samskivert.mustache.MustacheException;

import io.gatling.generation.AST.ScenarioAST;
import io.gatling.generation.AST.SimulationAST;
import io.gatling.generation.AST.process.ProcessAST;
import io.gatling.generation.AST.resource.ResourceFileAST;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipOutputStream;

import javax.portlet.ResourceRequest;

/**
 * This class give access to Simulation Gatling's Source code genreation
 * features.
 */
public class GenerationService {
	
	private static final Log LOG = LogFactoryUtil.getLog(GenerationService.class);
	
	
	/* Exportation */
	
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
					 SourceCodeIdentifierServices.createSimulationVariable(script.getSimulationName())+ ".scala")); 
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
	
	
	
	/* Loading a File */
	
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
	
}
