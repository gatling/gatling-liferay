package com.excilys.liferay.gatling.service.messaging;

import com.excilys.liferay.gatling.service.ClpSerializer;
import com.excilys.liferay.gatling.service.FormParamLocalServiceUtil;
import com.excilys.liferay.gatling.service.LinkUsecaseRequestLocalServiceUtil;
import com.excilys.liferay.gatling.service.LoginLocalServiceUtil;
import com.excilys.liferay.gatling.service.ProcessLocalServiceUtil;
import com.excilys.liferay.gatling.service.RecordLocalServiceUtil;
import com.excilys.liferay.gatling.service.RequestLocalServiceUtil;
import com.excilys.liferay.gatling.service.ScenarioLocalServiceUtil;
import com.excilys.liferay.gatling.service.SimulationLocalServiceUtil;
import com.excilys.liferay.gatling.service.SiteMapLocalServiceUtil;
import com.excilys.liferay.gatling.service.UrlRecordLocalServiceUtil;
import com.excilys.liferay.gatling.service.UrlSiteMapLocalServiceUtil;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;


public class ClpMessageListener extends BaseMessageListener {
    public static String getServletContextName() {
        return ClpSerializer.getServletContextName();
    }

    @Override
    protected void doReceive(Message message) throws Exception {
        String command = message.getString("command");
        String servletContextName = message.getString("servletContextName");

        if (command.equals("undeploy") &&
                servletContextName.equals(getServletContextName())) {
            FormParamLocalServiceUtil.clearService();

            LinkUsecaseRequestLocalServiceUtil.clearService();

            LoginLocalServiceUtil.clearService();

            ProcessLocalServiceUtil.clearService();

            RecordLocalServiceUtil.clearService();

            RequestLocalServiceUtil.clearService();

            ScenarioLocalServiceUtil.clearService();

            SimulationLocalServiceUtil.clearService();

            SiteMapLocalServiceUtil.clearService();

            UrlRecordLocalServiceUtil.clearService();

            UrlSiteMapLocalServiceUtil.clearService();
        }
    }
}
