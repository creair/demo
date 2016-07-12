package com.enclavetechnology.odm.framework.mvc.security.utils;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.util.Assert;

import com.enclavetechnology.odm.framework.mvc.security.entity.BemAccountUser;
import com.opensymphony.xwork2.ActionContext;
import com.rapid.j2ee.framework.core.utils.TypeChecker;

public class ActionContextUtils {

	public static void setContext(String key, Object value) {

		ThreadLocal_Container.get().put(key, value);
	}

	public static void setContextWithSimpleClassName(Object value) {

		if (value == null) {

			return;
		}

		ThreadLocal_Container.get().put(getContextKey(value), value);
	}

	public static void setHttpServletRequest(
			HttpServletRequest httpServletRequest) {

		setContext(HttpServletRequest.class.getSimpleName(), httpServletRequest);

	}

	public static HttpServletRequest getHttpServletRequest() {

		return getContext(HttpServletRequest.class,
				HttpServletRequest.class.getSimpleName());
	}

	public static String getContextKey(Object value) {

		if (value instanceof Collection) {

			Iterator it = ((Collection) value).iterator();

			it.hasNext();

			return it.next().getClass().getSimpleName() + "s";
		}

		return value.getClass().getSimpleName();
	}

	public static <T> T getContext(Class<T> className, String key) {

		return (T) ThreadLocal_Container.get().get(key);
	}

	public static <T> T getContext(Class<T> className) {

		return getContext(className, className.getSimpleName());
	}

	public static Object getActionController() {

		return getContext(Object.class, "ActionController");
	}

	public static void setActionController(Object controller) {

		setContext("ActionController", controller);
	}

	public static void setActionMethod(Method method) {

		setContext("ActionControllerMethod", method);
	}

	public static Method getActionMethod() {

		return getContext(Method.class, "ActionControllerMethod");
	}

	public static BemAccountUser getSecurityAccount() {

		return getContext(BemAccountUser.class);
	}

	public static void setSecurityAccount(BemAccountUser bemAccountUser) {

		Assert.notNull(bemAccountUser);

		setContextWithSimpleClassName(bemAccountUser);
	}

	public static Locale getLocale() {
		return getContext(Locale.class);
	}

	public static void setLocale(Locale locale) {

		setContextWithSimpleClassName(locale);
	}

	public static ActionContext getActionContext() {

		if (TypeChecker.isNull(ActionContext.getContext())) {

			ActionContext.setContext(new ActionContext(
					new HashMap<String, Object>()));
		}

		return ActionContext.getContext();

	}

	private ActionContextUtils() {

	}

	public static String LOGIN_KEY = null;

	private static ThreadLocal<Map<String, Object>> ThreadLocal_Container = new ThreadLocal<Map<String, Object>>() {

		protected Map<String, Object> initialValue() {

			return new HashMap<String, Object>();
		};
	};
}
