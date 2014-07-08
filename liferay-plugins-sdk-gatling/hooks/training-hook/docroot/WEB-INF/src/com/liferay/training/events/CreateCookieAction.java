package com.liferay.training.events;

import com.liferay.portal.kernel.events.Action;
import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateCookieAction extends Action {
	/*
	 * (non-Java-doc)
	 * 
	 * @see com.liferay.portal.kernel.events.SimpleAction#SimpleAction()
	 */
	public void run(HttpServletRequest req, HttpServletResponse res)
			throws ActionException {

		try {
			Cookie[] cookies = req.getCookies();
			String cookieValue = "";
			if (cookies != null) {
				for (Cookie cookie : cookies) {
					if (cookie.getName().equals("LOGIN_COUNTER")) {
						cookieValue = cookie.getValue();
						break;
					}
				}
			}

			if (cookieValue.length() < 1) {
				cookieValue = "1";
			} else {
				try {
					int cookieValueInt = Integer.parseInt(cookieValue) + 1;
					cookieValue = "" + cookieValueInt;
				} catch (NumberFormatException nfe) {
					_log.error(nfe);
				}
			}

			Cookie cookie = new Cookie("LOGIN_COUNTER", cookieValue);

			cookie.setMaxAge(31557600); // Number of seconds in a year

			String domain = PropsUtil.get("session.cookie.domain");
			if (Validator.isNotNull(domain)) {
				cookie.setDomain(domain);
			}

			cookie.setPath(StringPool.SLASH);

			res.addCookie(cookie);
		} catch (Exception e) {
			_log.error(e);
		}
	}

	private static Log _log = LogFactoryUtil.getLog(CreateCookieAction.class);

}