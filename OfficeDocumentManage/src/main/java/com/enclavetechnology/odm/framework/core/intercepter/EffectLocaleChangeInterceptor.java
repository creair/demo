package com.enclavetechnology.odm.framework.core.intercepter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import com.enclavetechnology.odm.framework.mvc.security.utils.ActionContextUtils;
import com.rapid.j2ee.framework.core.spring.SpringPropertiesHolder;

/**
 * I18n Interceptor
 * 
 * @author AB team
 * 
 */
public class EffectLocaleChangeInterceptor extends LocaleChangeInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler)
			throws ServletException {

		ActionContextUtils.setHttpServletRequest(request);

		String requestLang = request.getParameter(this.getParamName());

		requestLang = convertLang(requestLang);
		// get supportLangs locale from
		// VOPEffectServicesAppConfig.properties
		String supportLangs = SpringPropertiesHolder
				.getProperty("SupportLangs");

		// If the international format and the format of the current request
		// support,
		// then the current locale language escape,
		// Otherwise use the default format PreferLang to convert
		if (StringUtils.indexOf(supportLangs, requestLang) < 0) {

			requestLang = SpringPropertiesHolder.getProperty("PreferLang");
		}

		ActionContextUtils.setLocale(org.springframework.util.StringUtils
				.parseLocaleString(requestLang));

		return true;
	}

	private String convertLang(String requestLang) {

		return SpringPropertiesHolder.getProperty("app.lang." + requestLang,
				requestLang);

	}
}
