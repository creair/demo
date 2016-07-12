package com.enclavetechnology.odm.framework.mvc.security;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.auth0.jwt.JWTVerifyException;
import com.enclavetechnology.odm.framework.mvc.security.annotation.MethodBeforeLogin;
import com.enclavetechnology.odm.framework.mvc.security.annotation.MethodUnforceLogin;
import com.enclavetechnology.odm.framework.mvc.security.utils.ActionContextUtils;
import com.rapid.j2ee.framework.core.exception.ApplicationException;
import com.rapid.j2ee.framework.core.utils.TypeChecker;
import com.rapid.j2ee.framework.mvc.constants.OperationResultConstants;
import com.rapid.j2ee.framework.orm.medium.MediumSessionMapperOperations;

/**
 * User access AOP control class
 * 
 * @author AB team
 * 
 */
public class SecurityAopController implements InitializingBean {

	/**
	 * do authorize
	 * 
	 * @param point
	 * @return
	 * @throws Throwable
	 */
	public Object authorize(ProceedingJoinPoint point) throws Throwable {

		MethodSignature methodSignature = (MethodSignature) point
				.getSignature();

		// the method is before login method(continue)

		if (this.isBeforeLoginMethod(methodSignature)) {

			return (Object) point.proceed();
		}

		// Load System Security at after login step with token id

		this.loadAccountSecurity(methodSignature);

		return (Object) point.proceed();

	}

	/**
	 * load account security
	 * 
	 * @param methodSignature
	 * @throws InvalidKeyException
	 * @throws NoSuchAlgorithmException
	 * @throws IllegalStateException
	 * @throws SignatureException
	 * @throws IOException
	 * @throws JWTVerifyException
	 */
	private void loadAccountSecurity(MethodSignature methodSignature)
			throws InvalidKeyException, NoSuchAlgorithmException,
			IllegalStateException, SignatureException, IOException,
			JWTVerifyException {

		// Check if token id exits.
		checkIfTokenIdExistsThrowAppExp(methodSignature);

		// if unforce login method
		if (isUnforceLoginMethod(methodSignature)) {

			//

			return;
		}

		// validate request parameter

//		securityTokenValidator.validateSecurityToken(ActionContextUtils
//				.getHttpServletRequest().getParameter(
//						Security_Token_Parameter_Name));

	}

	/**
	 * check tokenId is not null
	 * 
	 * @param methodSignature
	 */
	private void checkIfTokenIdExistsThrowAppExp(MethodSignature methodSignature) {

		String tokenId = ActionContextUtils.getHttpServletRequest()
				.getParameter(Security_Token_Parameter_Name);

		if (isUnforceLoginMethod(methodSignature)) {
			return;
		}

		if (TypeChecker.isEmpty(tokenId)) {

			throw new ApplicationException(
					OperationResultConstants.FAILED_SESSION_TIMEOUT_ERROR);
		}

	}

	/**
	 * judge the method have isUnforceLoginMethod annotation
	 * 
	 * @param methodSignature
	 * @return
	 */
	private boolean isUnforceLoginMethod(MethodSignature methodSignature) {

		return methodSignature.getMethod().isAnnotationPresent(
				MethodUnforceLogin.class);
	}

	/**
	 * judge the method have isBeforeLoginMethod annotation
	 * 
	 * @param methodSignature
	 * @return
	 */
	private boolean isBeforeLoginMethod(MethodSignature methodSignature) {

		return methodSignature.getMethod().isAnnotationPresent(
				MethodBeforeLogin.class);
	}

	private static final String Security_Token_Parameter_Name = "tokenId";

	private static final String Security_Plan_Parameter_Name = "planId";

	public void afterPropertiesSet() throws Exception {

	}

	// ORM 数据库操作
	@Autowired
	@Qualifier("VOP_SessionMapper")
	private MediumSessionMapperOperations mediumSessionMapperOperations;

//	@Autowired
//	private SecurityTokenValidator securityTokenValidator;
//
//	@Autowired
//	SystemParamService systemParamService;

}
