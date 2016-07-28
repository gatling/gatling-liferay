/**
 * Copyright 2015 Altendis, Groupe Excilys (www.altendis.fr)
 */
package com.excilys.liferay.gatling.util;

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
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Company;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.Layout;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.portlet.RenderRequest;

public class GatlingUtil {

	/**
	 * create variable name for gatling scenario
	 * 
	 * @param prefix
	 * @param name
	 * @return
	 */
	private static String createVariableName(String prefix, String name) {
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

	/*
	 * Zip the test environment: simulations + predifined scenarios
	 */
	public static void zipMyEnvironment(OutputStream os, ClassLoader classLoader, ThemeDisplay themeDisplay, long groupId)
			throws IOException, SystemException {

		// final ZipOutputStream zipOutputStream = new
		// ZipOutputStream(response.getPortletOutputStream());
		final ZipOutputStream zipOutputStream = new ZipOutputStream(os);

		// TODO: add a README -> Hey I just met you, and this is crazy, but
		// here're my scalas, so readme maybe
		// Get file from resources folder
		File[] files = new File(classLoader.getResource("gatling").getFile())
				.listFiles();
		// Goes through the sources directories (scenario and feeder)
		for (File rootDirectory : files) {
			File[] sources = rootDirectory.listFiles();
			for (File source : sources) {
				zipOutputStream.putNextEntry(new ZipEntry(rootDirectory
						.getName() + "/" + source.getName()));
				zipOutputStream.write((getFile(source)).getBytes());
				zipOutputStream.closeEntry();
			}
		}

		// TODO: receive the simulation ids
		// long[] simulationsIds = ParamUtil.getLongValues(request, "export");
		// Adds the generated simulations
		/*
		 * for (final long id : simulationsIds) { if (id > 0) { simulation =
		 * SimulationLocalServiceUtil.getSimulation(id);
		 * zipOutputStream.putNextEntry(new ZipEntry("Simulation" +
		 * simulation.getName() + date.getTime() + ".scala")); final String
		 * currentPath =
		 * request.getPortletSession().getPortletContext().getRealPath
		 * ("/WEB-INF/classes") + template; final String tmp =
		 * Mustache.compiler().compile(new FileReader(currentPath)).execute(new
		 * ScriptGeneratorGatling(id,PortalUtil.getPortalURL(request)));
		 * zipOutputStream.write(tmp.getBytes()); zipOutputStream.closeEntry();
		 * } }
		 */

		// Saving feeders:
		zipOutputStream.putNextEntry(new ZipEntry("feeders/siteMapPages.csv"));
		zipOutputStream.write("site,URL\n".getBytes());
		for (Layout layout : getSiteMap(groupId)) {
			String currentFriendlyURL = GroupLocalServiceUtil.fetchGroup(layout.getGroupId()).getIconURL(themeDisplay);
			StringBuilder sb = new StringBuilder(currentFriendlyURL.split("/")[0]);
			sb.append("//").append(currentFriendlyURL.split("/")[2]).append("/web").append(GroupLocalServiceUtil.fetchGroup(layout.getGroupId()).getFriendlyURL()).append(layout.getFriendlyURL());
			zipOutputStream.write((layout.getFriendlyURL().substring(1)+","+sb.toString()+"\n").getBytes());
		}
		zipOutputStream.closeEntry();
		
		zipOutputStream.close();
	}

	// TODO: Move me in a right way!
	// Get file loads a specific file from WEB-INF/classes
	// https://web.liferay.com/community/forums/-/message_boards/message/10307074
	public static String getFile(String path, ClassLoader classLoader) {

		StringBuilder result = new StringBuilder("");

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

	// NOTE get scenario group id -> scenario.getGroup_id();
	public static List<Layout> getSiteMap(long groupId) throws SystemException {
		
		// get private layout list


		List<Layout> layouts = new ArrayList<>();
		layouts.addAll(LayoutLocalServiceUtil.getLayouts(
				groupId, true, 0));
		layouts.addAll(LayoutLocalServiceUtil.getLayouts(
				groupId, false, 0));		
		return layouts;
		/*
		//Note: String concatenation copied fomr ScenarioController
		for (Layout l : listPrivateLayouts) {
			
			String currentFriendlyURL = GroupLocalServiceUtil.fetchGroup(l.getGroupId()).getIconURL(themeDisplay);
			StringBuilder sb = new StringBuilder(currentFriendlyURL.split("/")[0]);
			sb.append("//").append(currentFriendlyURL.split("/")[2]).append("/web").append(GroupLocalServiceUtil.fetchGroup(l.getGroupId()).getFriendlyURL()).append(l.getName());
			pagesURL.add(sb.toString());
		}

		for (Layout l : listPublicLayouts) {
			
			String currentFriendlyURL = GroupLocalServiceUtil.fetchGroup(l.getGroupId()).getIconURL(themeDisplay);
			StringBuilder sb = new StringBuilder(currentFriendlyURL.split("/")[0]);
			sb.append("//").append(currentFriendlyURL.split("/")[2]).append("/web").append(GroupLocalServiceUtil.fetchGroup(l.getGroupId()).getFriendlyURL()).append(l.getFriendlyURL());
			pagesURL.add(sb.toString());
		}*/

	}

}
