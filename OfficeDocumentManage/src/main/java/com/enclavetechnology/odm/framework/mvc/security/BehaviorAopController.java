package com.enclavetechnology.odm.framework.mvc.security;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

import com.enclavetechnology.odm.framework.mvc.security.utils.ActionContextUtils;

/**
 * butter fly behavior aop controller
 * 
 * @author AB team
 * 
 */
public class BehaviorAopController {

	public Object traceAction(ProceedingJoinPoint point) throws Throwable {

		MethodSignature methodSignature = (MethodSignature) point
				.getSignature();

		ActionContextUtils.setActionController(point.getTarget());
		ActionContextUtils.setActionMethod(methodSignature.getMethod());

		return (Object) point.proceed();

	}

}
