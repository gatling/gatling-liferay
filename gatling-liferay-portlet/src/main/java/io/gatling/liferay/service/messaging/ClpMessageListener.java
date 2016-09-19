package io.gatling.liferay.service.messaging;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

import io.gatling.liferay.service.ClpSerializer;
import io.gatling.liferay.service.FormParamLocalServiceUtil;
import io.gatling.liferay.service.LinkUsecaseRequestLocalServiceUtil;
import io.gatling.liferay.service.LoginLocalServiceUtil;
import io.gatling.liferay.service.ProcessLocalServiceUtil;
import io.gatling.liferay.service.ProcessScenarioLinkLocalServiceUtil;
import io.gatling.liferay.service.RecordLocalServiceUtil;
import io.gatling.liferay.service.RequestLocalServiceUtil;
import io.gatling.liferay.service.ScenarioLocalServiceUtil;
import io.gatling.liferay.service.SimulationLocalServiceUtil;
import io.gatling.liferay.service.SiteMapLocalServiceUtil;
import io.gatling.liferay.service.UrlRecordLocalServiceUtil;
import io.gatling.liferay.service.UrlSiteMapLocalServiceUtil;


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

            ProcessScenarioLinkLocalServiceUtil.clearService();

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
