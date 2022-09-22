package com.honda.servlet.filters;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;

@Component(
    immediate = true,
    property = {
    		"dispatcher=REQUEST",
            "servlet-context-name=",
            "servlet-filter-name=LifeDev Document Filter",
            "url-pattern=/web/guest/auth"
        },
        service = Filter.class
)
public class LoginServletFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		_log.info("Called SampleFilter.init(" + filterConfig + ") where hello=" + filterConfig.getInitParameter("hello"));
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		
		String uri = (String) servletRequest.getAttribute(WebKeys.INVOKER_FILTER_URI);
		
		_log.info("Found uid ------------------->" + servletRequest.getParameter("uid"));
		

		_log.info("Called SampleFilter.doFilter(" + servletRequest + ", " + servletResponse + ", "
				+ filterChain + ") for URI " + uri);
		
		if(Validator.isNull(servletRequest.getParameter("uid"))) {
			((HttpServletResponse)servletResponse).sendRedirect("/web/guest/login");
		}else {

			filterChain.doFilter(servletRequest, servletResponse);
		}

	}

	@Override
	public void destroy() {

		_log.info("Called SampleFilter.destroy()");

	}
	
	private static final Log _log = LogFactoryUtil.getLog(LoginServletFilter.class);

}
