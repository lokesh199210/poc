
package com.honda.auto.login.handler;

import com.honda.auto.login.handler.constants.ConstantsKeys;
import com.honda.commom.utils.CommonUtil;
import com.honda.db.handlers.UserHandler;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.security.auto.login.AutoLogin;
import com.liferay.portal.kernel.security.auto.login.AutoLoginException;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Lokesh Sharma2
 */

@Component(immediate = true, service = AutoLogin.class)
public class AutoLoginHandler implements AutoLogin {

	@Override
	public String[] login(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
			throws AutoLoginException {

		try {
			User user = userHandler.getByEmailAddress(PortalUtil.getCompanyId(httpServletRequest),
					ConstantsKeys.DEALER_USER_EMAIL_ADDRESS.getValue());

			String cokVal = getCookieValue(httpServletRequest);

			_log.info("cokVal------------------------>" + cokVal);

			boolean allowAutoLogin = Validator.isNull(cokVal);

			_log.info( "Allow auto login --->" + allowAutoLogin);

			if (allowAutoLogin) {
				CommonUtil.writeDebugLogs(_log, "Auto logging in Dealer users to serve Landing pages.");

				/* prepare login params array */

				return new String[] { Long.toString(user.getUserId()), ConstantsKeys.DEALER_USER_PASS_KEY.getValue(),
						Boolean.TRUE.toString() };
			}

		} catch (PortalException e) {
			_log.error(e, e);
		}

		return new String[0];
	}

	/**
	 * 
	 * This method is to get JSESSIONID value from browser cookie to check Liferay
	 * session is maintained or not
	 * 
	 * @param httpServletRequest
	 * @return
	 */
	private String getCookieValue(HttpServletRequest httpServletRequest) {
		try {
			Cookie[] cookies = httpServletRequest.getCookies();

			for (Cookie cookie : cookies) {

				_log.info("Cookie name " + cookie.getName() + "value " + cookie.getValue());

				if (ConstantsKeys.JSESSIONID_COOKIE_KEY.getValue().equals(cookie.getName()))
					return cookie.getValue();
			}

		} catch (Exception e) {
			_log.info("Unable to find Liferay JSESSIONID cookie value");
		}

		return StringPool.BLANK;
	}

	private static final Log _log = LogFactoryUtil.getLog(AutoLoginHandler.class);

	@Reference
	private UserHandler userHandler;
}
