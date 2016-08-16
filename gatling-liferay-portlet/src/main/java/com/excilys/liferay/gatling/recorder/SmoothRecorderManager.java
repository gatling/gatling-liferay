package com.excilys.liferay.gatling.recorder;

import com.excilys.liferay.gatling.recorder.records.GetURL;
import com.excilys.liferay.gatling.recorder.records.RecordURL;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.HttpUtil;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SmoothRecorderManager extends RecorderManager {

	protected static final Log LOG = LogFactoryUtil.getLog(SmoothRecorderManager.class);

	
	@Override
	protected void saveURL(HttpServletRequest request,
			ServletResponse response, HttpSession session,
			List<RecordURL> currentRecords) throws IOException {
		
		Map<String, String[]> parametersMap = request.getParameterMap();
		String params = HttpUtil.parameterMapToString(filterParameters(parametersMap));
		String requestURL = request.getRequestURI().replace(URL_CONTROL_PANEL, "");
		
		LOG.info("URL TO SAVE: " + requestURL);
		
	}

	@Override
	protected void stopRecording(HttpSession session, String[] infos,
			List<RecordURL> currentRecords) {
		// TODO Auto-generated method stub
		

		LOG.info("PERSIST DATA !!!");
	}
	
	
	
}
