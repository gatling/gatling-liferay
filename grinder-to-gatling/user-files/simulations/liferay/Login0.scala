
// import scala.concurrent.duration._
//
// import io.gatling.core.Predef._
// import io.gatling.http.Predef._
// import io.gatling.jdbc.Predef._
//
// class Login0 extends Simulation {
//
// 	val httpProtocol = http
// 		.baseURL("http://localhost:8080")
// 		.inferHtmlResources()
// 		.acceptHeader("*/*")
// 		.acceptEncodingHeader("gzip, deflate")
// 		.acceptLanguageHeader("en-US,en;q=0.5")
// 		.userAgentHeader("Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:47.0) Gecko/20100101 Firefox/47.0")
//
// 	val headers_0 = Map("Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
//
// 	val headers_1 = Map("Accept" -> "text/css,*/*;q=0.1")
//
// 	val headers_39 = Map(
// 		"Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8",
// 		"Content-Type" -> "application/x-www-form-urlencoded; charset=UTF-8",
// 		"X-Requested-With" -> "XMLHttpRequest")
//
//
//
// 	val scn = scenario("Login")
// 		// HomePage
// 		.exec(http("request_0")
// 			.get("/web/guest/home")
// 			.headers(headers_0)
// 			.resources(http("request_1")
// 			.get("/html/themes/classic/css/aui.css?browserId=firefox&themeId=classic&minifierType=css&languageId=en_US&b=6210&t=1467628057000")
// 			.headers(headers_1),
//             http("request_2")
// 			.get("/html/css/main.css?browserId=firefox&themeId=classic&minifierType=css&languageId=en_US&b=6210&t=1466781321000")
// 			.headers(headers_1),
//             http("request_3")
// 			.get("/html/portlet/login/css/main.css?browserId=firefox&themeId=classic&minifierType=css&languageId=en_US&b=6210&t=1467628119000")
// 			.headers(headers_1),
//             http("request_4")
// 			.get("/notifications-portlet/notifications/css/main.css?browserId=firefox&themeId=classic&minifierType=css&languageId=en_US&b=6210&t=1467628118000")
// 			.headers(headers_1),
//             http("request_5")
// 			.get("/html/themes/classic/js/main.js?browserId=firefox&minifierType=js&languageId=en_US&b=6210&t=1467628057000"),
//             http("request_6")
// 			.get("/html/js/barebone.jsp?browserId=firefox&themeId=classic&colorSchemeId=01&minifierType=js&minifierBundleId=javascript.barebone.files&languageId=en_US&b=6210&t=1466781322000"),
//             http("request_7")
// 			.get("/notifications-portlet/notifications/js/main.js?browserId=firefox&minifierType=js&languageId=en_US&b=6210&t=1467628118000"),
//             http("request_8")
// 			.get("/html/themes/classic/css/main.css?browserId=firefox&themeId=classic&minifierType=css&languageId=en_US&b=6210&t=1467628057000")
// 			.headers(headers_1),
//             http("request_9")
// 			.get("/combo/?browserId=firefox&minifierType=&languageId=en_US&b=6210&t=1466781322000&/html/js/aui/color-base/color-base-min.js&/html/js/aui/event-touch/event-touch-min.js&/html/js/liferay/dockbar.js"),
//             http("request_10")
// 			.get("/combo/?browserId=firefox&minifierType=&languageId=en_US&b=6210&t=1466781322000&/html/js/aui/widget-base/assets/skins/sam/widget-base.css&/html/js/aui/widget-stack/assets/skins/sam/widget-stack.css")
// 			.headers(headers_1),
//             http("request_11")
// 			.get("/combo/?browserId=firefox&minifierType=&languageId=en_US&b=6210&t=1466781322000&/html/js/aui/base-core/base-core-min.js&/html/js/aui/base-observable/base-observable-min.js&/html/js/aui/aui-widget-cssclass/aui-widget-cssclass-min.js&/html/js/aui/aui-widget-toggle/aui-widget-toggle-min.js&/html/js/aui/base-build/base-build-min.js&/html/js/aui/widget-position/widget-position-min.js&/html/js/aui/widget-stack/widget-stack-min.js&/html/js/aui/widget-position-align/widget-position-align-min.js&/html/js/aui/widget-position-constrain/widget-position-constrain-min.js&/html/js/aui/widget-stdmod/widget-stdmod-min.js&/html/js/aui/aui-overlay-base-deprecated/aui-overlay-base-deprecated-min.js&/html/js/aui/aui-overlay-mask-deprecated/aui-overlay-mask-deprecated-min.js"),
//             http("request_12")
// 			.get("/combo/?browserId=firefox&minifierType=&languageId=en_US&b=6210&t=1466781322000&/html/js/aui/event-move/event-move-min.js"),
//             http("request_13")
// 			.get("/combo/?browserId=firefox&minifierType=&languageId=en_US&b=6210&t=1466781322000&/html/js/aui/cssbutton/cssbutton-min.css&/html/js/aui/widget-modality/assets/skins/sam/widget-modality.css&/html/js/aui/resize-base/assets/skins/sam/resize-base.css")
// 			.headers(headers_1),
//             http("request_14")
// 			.get("/combo/?browserId=firefox&minifierType=&languageId=en_US&b=6210&t=1466781322000&/html/js/aui/escape/escape-min.js&/html/js/aui/aui-loading-mask-deprecated/aui-loading-mask-deprecated-min.js&/html/js/aui/aui-dialog-iframe-deprecated/aui-dialog-iframe-deprecated-min.js&/html/js/aui/widget-autohide/widget-autohide-min.js&/html/js/aui/button-core/button-core-min.js&/html/js/aui/button-plugin/button-plugin-min.js&/html/js/aui/widget-buttons/widget-buttons-min.js&/html/js/aui/widget-modality/widget-modality-min.js&/html/js/aui/dd-ddm-base/dd-ddm-base-min.js&/html/js/aui/dd-drag/dd-drag-min.js&/html/js/aui/dd-plugin/dd-plugin-min.js&/html/js/aui/dd-constrain/dd-constrain-min.js&/html/js/aui/event-flick/event-flick-min.js&/html/js/aui/event-valuechange/event-valuechange-min.js&/html/js/aui/event-tap/event-tap-min.js&/html/js/aui/dd-ddm/dd-ddm-min.js&/html/js/aui/dd-ddm-drop/dd-ddm-drop-min.js&/html/js/aui/dd-drop/dd-drop-min.js&/html/js/aui/dd-drop-plugin/dd-drop-plugin-min.js"),
//             http("request_15")
// 			.get("/html/js/liferay/available_languages.jsp?browserId=firefox&themeId=classic&colorSchemeId=01&minifierType=js&languageId=en_US&b=6210&t=1466781322000"),
//             http("request_16")
// 			.get("/combo/?browserId=firefox&minifierType=&languageId=en_US&b=6210&t=1466781322000&/html/js/aui/dd-delegate/dd-delegate-min.js&/html/js/aui/resize-base/resize-base-min.js&/html/js/aui/resize-plugin/resize-plugin-min.js&/html/js/aui/button/button-min.js&/html/js/aui/button-group/button-group-min.js&/html/js/aui/aui-button-core/aui-button-core-min.js&/html/js/aui/aui-toolbar/aui-toolbar-min.js&/html/js/aui/aui-widget-toolbars/aui-widget-toolbars-min.js&/html/js/aui/aui-modal/aui-modal-min.js&/html/js/liferay/widget_zindex.js&/html/js/liferay/util_window.js&/html/js/liferay/language.js&/html/js/aui/transition/transition-min.js&/html/js/aui/querystring-stringify/querystring-stringify-min.js&/html/js/aui/cookie/cookie-min.js&/html/js/liferay/session.js&/html/js/aui/aui-io-request/aui-io-request-min.js&/html/js/liferay/ajax_session.js"),
//             http("request_17")
// 			.get("/combo/?browserId=firefox&minifierType=&languageId=en_US&b=6210&t=1466781322000&/html/js/liferay/language.js"),
//             http("request_18")
// 			.get("/combo/?browserId=firefox&minifierType=&languageId=en_US&b=6210&t=1466781322000&/html/js/liferay/hudcrumbs.js&/html/js/aui/async-queue/async-queue-min.js&/html/js/aui/gesture-simulate/gesture-simulate-min.js&/html/js/liferay/navigation_interaction.js&/html/js/aui/aui-parse-content/aui-parse-content-min.js&/html/js/liferay/portlet_url.js&/html/js/liferay/sign_in_modal.js"),
//             http("request_19")
// 			.get("/combo/?browserId=firefox&minifierType=&languageId=en_US&b=6210&t=1466781322000&/html/js/aui/querystring-parse/querystring-parse-min.js&/html/js/aui/aui-url/aui-url-min.js")))
// 		.pause(20)
// 		// Login
// 		.exec(http("request_20")
// 			.post("/web/guest/home?p_p_id=58&p_p_lifecycle=1&p_p_state=normal&p_p_mode=view&p_p_col_id=column-1&p_p_col_count=1&_58_struts_action=%2Flogin%2Flogin")
// 			.headers(headers_0)
// 			.formParam("_58_formDate", "1467642252985")
// 			.formParam("_58_saveLastPath", "false")
// 			.formParam("_58_redirect", "")
// 			.formParam("_58_doActionAfterLogin", "false")
// 			.formParam("_58_login", "nraymond.blue@gmail.com")
// 			.formParam("_58_password", "Liferay")
// 			.formParam("_58_rememberMe", "false")
// 			.resources(http("request_21")
// 			.get("/html/themes/classic/css/aui.css?browserId=firefox&themeId=classic&minifierType=css&languageId=en_US&b=6210&t=1467628057000")
// 			.headers(headers_1),
//             http("request_22")
// 			.get("/html/css/main.css?browserId=firefox&themeId=classic&minifierType=css&languageId=en_US&b=6210&t=1466781321000")
// 			.headers(headers_1),
//             http("request_23")
// 			.get("/notifications-portlet/notifications/css/main.css?browserId=firefox&themeId=classic&minifierType=css&languageId=en_US&b=6210&t=1467628118000")
// 			.headers(headers_1),
//             http("request_24")
// 			.get("/notifications-portlet/notifications/js/main.js?browserId=firefox&minifierType=js&languageId=en_US&b=6210&t=1467628118000"),
//             http("request_25")
// 			.get("/html/portlet/login/css/main.css?browserId=firefox&themeId=classic&minifierType=css&languageId=en_US&b=6210&t=1467628119000")
// 			.headers(headers_1),
//             http("request_26")
// 			.get("/html/themes/classic/js/main.js?browserId=firefox&minifierType=js&languageId=en_US&b=6210&t=1467628057000"),
//             http("request_27")
// 			.get("/html/themes/classic/css/main.css?browserId=firefox&themeId=classic&minifierType=css&languageId=en_US&b=6210&t=1467628057000")
// 			.headers(headers_1),
//             http("request_28")
// 			.get("/html/js/everything.jsp?browserId=firefox&themeId=classic&colorSchemeId=01&minifierType=js&minifierBundleId=javascript.everything.files&languageId=en_US&b=6210&t=1466781322000"),
//             http("request_29")
// 			.get("/combo/?browserId=firefox&minifierType=&languageId=en_US&b=6210&t=1466781322000&/html/js/aui/widget-base/assets/skins/sam/widget-base.css")
// 			.headers(headers_1),
//             http("request_30")
// 			.get("/combo/?browserId=firefox&minifierType=&languageId=en_US&b=6210&t=1466781322000&/html/js/aui/color-base/color-base-min.js&/html/js/aui/base-core/base-core-min.js&/html/js/aui/base-observable/base-observable-min.js&/html/js/aui/aui-widget-cssclass/aui-widget-cssclass-min.js&/html/js/aui/aui-widget-toggle/aui-widget-toggle-min.js"),
//             http("request_31")
// 			.get("/combo/?browserId=firefox&minifierType=&languageId=en_US&b=6210&t=1466781322000&/html/js/aui/event-move/event-move-min.js"),
//             http("request_32")
// 			.get("/combo/?browserId=firefox&minifierType=&languageId=en_US&b=6210&t=1466781322000&/html/js/aui/widget-stack/assets/skins/sam/widget-stack.css")
// 			.headers(headers_1),
//             http("request_33")
// 			.get("/html/js/liferay/available_languages.jsp?browserId=firefox&themeId=classic&colorSchemeId=01&minifierType=js&languageId=en_US&b=6210&t=1466781322000"),
//             http("request_34")
// 			.get("/combo/?browserId=firefox&minifierType=&languageId=en_US&b=6210&t=1466781322000&/html/js/aui/event-tap/event-tap-min.js&/html/js/liferay/layout.js&/html/js/liferay/language.js&/html/js/liferay/navigation.js&/html/js/aui/transition/transition-min.js&/html/js/liferay/ajax_session.js&/html/js/liferay/node.js&/html/js/liferay/portlet_base.js&/html/js/liferay/portlet_url.js&/html/js/liferay/store.js"),
//             http("request_35")
// 			.get("/combo/?browserId=firefox&minifierType=&languageId=en_US&b=6210&t=1466781322000&/html/js/aui/querystring-parse/querystring-parse-min.js&/html/js/aui/aui-url/aui-url-min.js"),
//             http("request_36")
// 			.get("/combo/?browserId=firefox&minifierType=&languageId=en_US&b=6210&t=1466781322000&/html/js/aui/cssbutton/cssbutton-min.css&/html/js/aui/widget-modality/assets/skins/sam/widget-modality.css&/html/js/aui/resize-base/assets/skins/sam/resize-base.css")
// 			.headers(headers_1),
//             http("request_37")
// 			.get("/combo/?browserId=firefox&minifierType=&languageId=en_US&b=6210&t=1466781322000&/html/js/liferay/hudcrumbs.js&/html/js/aui/gesture-simulate/gesture-simulate-min.js&/html/js/liferay/navigation_interaction.js&/html/js/aui/aui-dialog-iframe-deprecated/aui-dialog-iframe-deprecated-min.js&/html/js/aui/widget-autohide/widget-autohide-min.js&/html/js/aui/button-core/button-core-min.js&/html/js/aui/button-plugin/button-plugin-min.js&/html/js/aui/widget-buttons/widget-buttons-min.js&/html/js/aui/widget-modality/widget-modality-min.js&/html/js/aui/dd-ddm-base/dd-ddm-base-min.js&/html/js/aui/dd-drag/dd-drag-min.js&/html/js/aui/dd-plugin/dd-plugin-min.js&/html/js/aui/dd-constrain/dd-constrain-min.js&/html/js/aui/event-flick/event-flick-min.js&/html/js/aui/event-valuechange/event-valuechange-min.js&/html/js/aui/dd-ddm/dd-ddm-min.js&/html/js/aui/dd-ddm-drop/dd-ddm-drop-min.js&/html/js/aui/dd-drop/dd-drop-min.js&/html/js/aui/dd-drop-plugin/dd-drop-plugin-min.js&/html/js/aui/dd-delegate/dd-delegate-min.js"),
//             http("request_38")
// 			.get("/combo/?browserId=firefox&minifierType=&languageId=en_US&b=6210&t=1466781322000&/html/js/aui/resize-base/resize-base-min.js&/html/js/aui/resize-plugin/resize-plugin-min.js&/html/js/aui/button/button-min.js&/html/js/aui/button-group/button-group-min.js&/html/js/aui/aui-button-core/aui-button-core-min.js&/html/js/aui/aui-toolbar/aui-toolbar-min.js&/html/js/aui/aui-widget-toolbars/aui-widget-toolbars-min.js&/html/js/aui/aui-modal/aui-modal-min.js&/html/js/liferay/widget_zindex.js&/html/js/liferay/util_window.js&/html/js/liferay/sign_in_modal.js"),
//             http("request_39")
// 			.post("/poller/receive")
// 			.headers(headers_39)
// 			.formParam("pollerRequest", """[{"browserKey":408047781922,"companyId":"20155","portletIdsMap":{"2_WAR_notificationsportlet":true},"startPolling":true,"userId":"pcoNcOQQ6+6dXZoHWIVN5w==","timestamp":1467642275004}]""")))
// 		.pause(1)
// 		.exec(http("request_40")
// 			.post("/poller/receive")
// 			.headers(headers_39)
// 			.formParam("pollerRequest", """[{"browserKey":408047781922,"companyId":"20155","portletIdsMap":{"2_WAR_notificationsportlet":false},"userId":"pcoNcOQQ6+6dXZoHWIVN5w==","timestamp":1467642276053}]"""))
// 		.pause(1)
// 		.exec(http("request_41")
// 			.post("/poller/receive")
// 			.headers(headers_39)
// 			.formParam("pollerRequest", """[{"browserKey":408047781922,"companyId":"20155","portletIdsMap":{"2_WAR_notificationsportlet":false},"userId":"pcoNcOQQ6+6dXZoHWIVN5w==","timestamp":1467642277063}]"""))
// 		.pause(1)
// 		.exec(http("request_42")
// 			.post("/poller/receive")
// 			.headers(headers_39)
// 			.formParam("pollerRequest", """[{"browserKey":408047781922,"companyId":"20155","portletIdsMap":{"2_WAR_notificationsportlet":false},"userId":"pcoNcOQQ6+6dXZoHWIVN5w==","timestamp":1467642278073}]"""))
// 		.pause(2)
// 		.exec(http("request_43")
// 			.post("/poller/receive")
// 			.headers(headers_39)
// 			.formParam("pollerRequest", """[{"browserKey":408047781922,"companyId":"20155","portletIdsMap":{"2_WAR_notificationsportlet":false},"userId":"pcoNcOQQ6+6dXZoHWIVN5w==","timestamp":1467642280082}]"""))
// 		.pause(2)
// 		.exec(http("request_44")
// 			.post("/poller/receive")
// 			.headers(headers_39)
// 			.formParam("pollerRequest", """[{"browserKey":408047781922,"companyId":"20155","portletIdsMap":{"2_WAR_notificationsportlet":false},"userId":"pcoNcOQQ6+6dXZoHWIVN5w==","timestamp":1467642282093}]"""))
// 		.pause(2)
// 		.exec(http("request_45")
// 			.post("/poller/receive")
// 			.headers(headers_39)
// 			.formParam("pollerRequest", """[{"browserKey":408047781922,"companyId":"20155","portletIdsMap":{"2_WAR_notificationsportlet":false},"userId":"pcoNcOQQ6+6dXZoHWIVN5w==","timestamp":1467642284104}]"""))
// 		.pause(3)
// 		// Logout
// 		.exec(http("request_46")
// 			.get("/combo/?browserId=firefox&minifierType=&languageId=en_US&b=6210&t=1466781322000&/html/js/aui/dd-proxy/dd-proxy-min.js&/html/js/aui/sortable/sortable-min.js")
// 			.resources(http("request_47")
// 			.get("/combo/?browserId=firefox&minifierType=&languageId=en_US&b=6210&t=1466781322000&/html/js/aui/aui-sortable-layout/assets/skins/sam/aui-sortable-layout.css")
// 			.headers(headers_1),
//             http("request_48")
// 			.get("/combo/?browserId=firefox&minifierType=&languageId=en_US&b=6210&t=1466781322000&/html/js/aui/aui-sortable-layout/aui-sortable-layout-min.js&/html/js/aui/dd-scroll/dd-scroll-min.js&/html/js/liferay/layout_column.js"),
//             http("request_49")
// 			.get("/combo/?browserId=firefox&minifierType=&languageId=en_US&b=6210&t=1466781322000&/html/js/liferay/dockbar_keyboard_interaction.js"),
//             http("request_50")
// 			.get("/combo/?browserId=firefox&minifierType=&languageId=en_US&b=6210&t=1466781322000&/html/js/aui/aui-autosize-deprecated/aui-autosize-deprecated-min.js&/html/js/aui/aui-form-field-deprecated/aui-form-field-deprecated-min.js&/html/js/aui/aui-form-textfield-deprecated/aui-form-textfield-deprecated-min.js&/html/js/aui/aui-form-textarea-deprecated/aui-form-textarea-deprecated-min.js&/html/js/aui/aui-form-combobox-deprecated/aui-form-combobox-deprecated-min.js&/html/js/aui/escape/escape-min.js&/html/js/aui/aui-editable-deprecated/aui-editable-deprecated-min.js")))
// 		.pause(1)
// 		.exec(http("request_51")
// 			.get("/c/portal/logout")
// 			.headers(headers_0)
// 			.resources(http("request_52")
// 			.get("/c")
// 			.headers(headers_0),
//             http("request_53")
// 			.get("/html/themes/classic/css/aui.css?browserId=firefox&themeId=classic&minifierType=css&languageId=en_US&b=6210&t=1467628057000")
// 			.headers(headers_1),
//             http("request_54")
// 			.get("/html/css/main.css?browserId=firefox&themeId=classic&minifierType=css&languageId=en_US&b=6210&t=1466781321000")
// 			.headers(headers_1),
//             http("request_55")
// 			.get("/html/portlet/login/css/main.css?browserId=firefox&themeId=classic&minifierType=css&languageId=en_US&b=6210&t=1467628119000")
// 			.headers(headers_1),
//             http("request_56")
// 			.get("/notifications-portlet/notifications/css/main.css?browserId=firefox&themeId=classic&minifierType=css&languageId=en_US&b=6210&t=1467628118000")
// 			.headers(headers_1),
//             http("request_57")
// 			.get("/html/themes/classic/css/main.css?browserId=firefox&themeId=classic&minifierType=css&languageId=en_US&b=6210&t=1467628057000")
// 			.headers(headers_1),
//             http("request_58")
// 			.get("/html/js/barebone.jsp?browserId=firefox&themeId=classic&colorSchemeId=01&minifierType=js&minifierBundleId=javascript.barebone.files&languageId=en_US&b=6210&t=1466781322000"),
//             http("request_59")
// 			.get("/notifications-portlet/notifications/js/main.js?browserId=firefox&minifierType=js&languageId=en_US&b=6210&t=1467628118000"),
//             http("request_60")
// 			.get("/html/themes/classic/js/main.js?browserId=firefox&minifierType=js&languageId=en_US&b=6210&t=1467628057000"),
//             http("request_61")
// 			.get("/combo/?browserId=firefox&minifierType=&languageId=en_US&b=6210&t=1466781322000&/html/js/aui/color-base/color-base-min.js&/html/js/aui/event-touch/event-touch-min.js&/html/js/liferay/dockbar.js"),
//             http("request_62")
// 			.get("/combo/?browserId=firefox&minifierType=&languageId=en_US&b=6210&t=1466781322000&/html/js/aui/widget-base/assets/skins/sam/widget-base.css&/html/js/aui/widget-stack/assets/skins/sam/widget-stack.css")
// 			.headers(headers_1),
//             http("request_63")
// 			.get("/combo/?browserId=firefox&minifierType=&languageId=en_US&b=6210&t=1466781322000&/html/js/aui/base-core/base-core-min.js&/html/js/aui/base-observable/base-observable-min.js&/html/js/aui/aui-widget-cssclass/aui-widget-cssclass-min.js&/html/js/aui/aui-widget-toggle/aui-widget-toggle-min.js&/html/js/aui/base-build/base-build-min.js&/html/js/aui/widget-position/widget-position-min.js&/html/js/aui/widget-stack/widget-stack-min.js&/html/js/aui/widget-position-align/widget-position-align-min.js&/html/js/aui/widget-position-constrain/widget-position-constrain-min.js&/html/js/aui/widget-stdmod/widget-stdmod-min.js&/html/js/aui/aui-overlay-base-deprecated/aui-overlay-base-deprecated-min.js&/html/js/aui/aui-overlay-mask-deprecated/aui-overlay-mask-deprecated-min.js"),
//             http("request_64")
// 			.get("/combo/?browserId=firefox&minifierType=&languageId=en_US&b=6210&t=1466781322000&/html/js/aui/event-move/event-move-min.js"),
//             http("request_65")
// 			.get("/combo/?browserId=firefox&minifierType=&languageId=en_US&b=6210&t=1466781322000&/html/js/aui/cssbutton/cssbutton-min.css&/html/js/aui/widget-modality/assets/skins/sam/widget-modality.css&/html/js/aui/resize-base/assets/skins/sam/resize-base.css")
// 			.headers(headers_1),
//             http("request_66")
// 			.get("/combo/?browserId=firefox&minifierType=&languageId=en_US&b=6210&t=1466781322000&/html/js/aui/escape/escape-min.js&/html/js/aui/aui-loading-mask-deprecated/aui-loading-mask-deprecated-min.js&/html/js/aui/aui-dialog-iframe-deprecated/aui-dialog-iframe-deprecated-min.js&/html/js/aui/widget-autohide/widget-autohide-min.js&/html/js/aui/button-core/button-core-min.js&/html/js/aui/button-plugin/button-plugin-min.js&/html/js/aui/widget-buttons/widget-buttons-min.js&/html/js/aui/widget-modality/widget-modality-min.js&/html/js/aui/dd-ddm-base/dd-ddm-base-min.js&/html/js/aui/dd-drag/dd-drag-min.js&/html/js/aui/dd-plugin/dd-plugin-min.js&/html/js/aui/dd-constrain/dd-constrain-min.js&/html/js/aui/event-flick/event-flick-min.js&/html/js/aui/event-valuechange/event-valuechange-min.js&/html/js/aui/event-tap/event-tap-min.js&/html/js/aui/dd-ddm/dd-ddm-min.js&/html/js/aui/dd-ddm-drop/dd-ddm-drop-min.js&/html/js/aui/dd-drop/dd-drop-min.js&/html/js/aui/dd-drop-plugin/dd-drop-plugin-min.js"),
//             http("request_67")
// 			.get("/html/js/liferay/available_languages.jsp?browserId=firefox&themeId=classic&colorSchemeId=01&minifierType=js&languageId=en_US&b=6210&t=1466781322000"),
//             http("request_68")
// 			.get("/combo/?browserId=firefox&minifierType=&languageId=en_US&b=6210&t=1466781322000&/html/js/aui/dd-delegate/dd-delegate-min.js&/html/js/aui/resize-base/resize-base-min.js&/html/js/aui/resize-plugin/resize-plugin-min.js&/html/js/aui/button/button-min.js&/html/js/aui/button-group/button-group-min.js&/html/js/aui/aui-button-core/aui-button-core-min.js&/html/js/aui/aui-toolbar/aui-toolbar-min.js&/html/js/aui/aui-widget-toolbars/aui-widget-toolbars-min.js&/html/js/aui/aui-modal/aui-modal-min.js&/html/js/liferay/widget_zindex.js&/html/js/liferay/util_window.js&/html/js/liferay/language.js&/html/js/aui/transition/transition-min.js&/html/js/aui/querystring-stringify/querystring-stringify-min.js&/html/js/aui/cookie/cookie-min.js&/html/js/liferay/session.js&/html/js/aui/aui-io-request/aui-io-request-min.js&/html/js/liferay/ajax_session.js"),
//             http("request_69")
// 			.get("/combo/?browserId=firefox&minifierType=&languageId=en_US&b=6210&t=1466781322000&/html/js/liferay/language.js"),
//             http("request_70")
// 			.get("/combo/?browserId=firefox&minifierType=&languageId=en_US&b=6210&t=1466781322000&/html/js/liferay/hudcrumbs.js&/html/js/aui/async-queue/async-queue-min.js&/html/js/aui/gesture-simulate/gesture-simulate-min.js&/html/js/liferay/navigation_interaction.js&/html/js/aui/aui-parse-content/aui-parse-content-min.js&/html/js/liferay/portlet_url.js&/html/js/liferay/sign_in_modal.js"),
//             http("request_71")
// 			.get("/combo/?browserId=firefox&minifierType=&languageId=en_US&b=6210&t=1466781322000&/html/js/aui/querystring-parse/querystring-parse-min.js&/html/js/aui/aui-url/aui-url-min.js")))
//
// 	setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
// }
