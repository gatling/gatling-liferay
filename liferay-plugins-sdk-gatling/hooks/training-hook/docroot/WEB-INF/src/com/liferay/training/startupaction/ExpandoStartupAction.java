package com.liferay.training.startupaction;

import com.liferay.portal.kernel.events.SimpleAction;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.UnicodeProperties;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portlet.expando.DuplicateColumnNameException;
import com.liferay.portlet.expando.DuplicateTableNameException;
import com.liferay.portlet.expando.model.ExpandoColumn;
import com.liferay.portlet.expando.model.ExpandoColumnConstants;
import com.liferay.portlet.expando.model.ExpandoTable;
import com.liferay.portlet.expando.model.ExpandoValue;
import com.liferay.portlet.expando.service.ExpandoColumnLocalServiceUtil;
import com.liferay.portlet.expando.service.ExpandoTableLocalServiceUtil;
import com.liferay.portlet.expando.service.ExpandoValueLocalServiceUtil;

public class ExpandoStartupAction extends SimpleAction {

	public void run(String[] ids) {
		try {

			// Get a reference to the ExpandoTable (User class)

			ExpandoTable table = null;

			long companyId = Long.parseLong(ids[0]);

			try {
				table = ExpandoTableLocalServiceUtil.addDefaultTable(companyId,
						User.class.getName());
			} catch (DuplicateTableNameException dtne) {
				table = ExpandoTableLocalServiceUtil.getDefaultTable(companyId,
						User.class.getName());
			}

			// Add the ExpandoColumn ("comments-astronauts")

			ExpandoColumn column = null;

			long tableId = table.getTableId();

			try {
				column = ExpandoColumnLocalServiceUtil.addColumn(tableId,
						"comments-astronauts", ExpandoColumnConstants.STRING);

				// Add Unicode Properties

				UnicodeProperties properties = new UnicodeProperties();

				properties.setProperty(ExpandoColumnConstants.INDEX_TYPE,
						Boolean.TRUE.toString());

				column.setTypeSettingsProperties(properties);

				ExpandoColumnLocalServiceUtil.updateExpandoColumn(column);
			} catch (DuplicateColumnNameException dcne) {

				// Get the ExpandoColumn ("comments-astronauts")

				column = ExpandoColumnLocalServiceUtil.getColumn(tableId,
						"comments-astronauts");
			}

			// Get the User object for "test@liferay.com"

			String emailAddress = "b.boyer28@gmail.com";

			User user = UserLocalServiceUtil.getUserByEmailAddress(companyId,
					emailAddress);

			// Add or Update Comments Astronauts to
			// "I've loved astronauts since I was a child!"

			long classNameId = table.getClassNameId();
			long columnId = column.getColumnId();
			long classPK = user.getUserId();
			String data = "I've loved astronauts since I was a child!";

			ExpandoValue value = ExpandoValueLocalServiceUtil.addValue(
					classNameId, tableId, columnId, classPK, data);

			System.out.println("Comments: " + value.getData());
		} catch (Exception e) {
			_log.error(e);
		}
	}

	private static Log _log = LogFactoryUtil.getLog(ExpandoStartupAction.class);
}
