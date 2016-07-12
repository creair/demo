package com.enclavetechnology.odm.framework.core.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import com.enclavetechnology.odm.framework.mvc.security.response.ResponseHeader;
import com.rapid.j2ee.framework.core.charset.Charsets;
import com.rapid.j2ee.framework.core.exception.ApplicationException;
import com.rapid.j2ee.framework.core.exception.ApplicationRollbackException;
import com.rapid.j2ee.framework.core.exception.BaseException;
import com.rapid.j2ee.framework.core.exception.ExceptionUtils;
import com.rapid.j2ee.framework.core.io.json.JsonPropertyConfigPattern;
import com.rapid.j2ee.framework.core.io.json.JsonUtils;
import com.rapid.j2ee.framework.core.utils.ResponseUtils;

public class BusinessControllerExceptionResolver extends
		SimpleMappingExceptionResolver {

	/**
	 * do exception handler
	 */
	protected ModelAndView doResolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception e) {

		BaseException baseException = ExceptionUtils
				.convertThrowableToBaseException(e);

		logger.error(baseException.getResultMessage());

		// ApplicationException Handler for json
		if (baseException instanceof ApplicationException) {

			ApplicationException applicationException = (ApplicationException) baseException;

			ResponseHeader responseHeader = new ResponseHeader();
			responseHeader.setCode(applicationException.getResultCode());
			responseHeader.setKey(applicationException.getResultMessageCode());
			responseHeader.setMessage(applicationException.getMessage());

			ResponseUtils.writeJson(Charsets.UTF_8.getCharset(), JsonUtils
					.formatJsonText(responseHeader,
							JsonPropertyConfigPattern.getJsonIngoreConfig()),
					response);

			return new ModelAndView();

		}

		if (baseException instanceof ApplicationRollbackException) {

			ApplicationRollbackException applicationRollbackException = (ApplicationRollbackException) baseException;

			ResponseHeader responseHeader = new ResponseHeader();
			responseHeader
					.setCode(applicationRollbackException.getResultCode());
			responseHeader.setKey(applicationRollbackException
					.getResultMessageCode());
			responseHeader
					.setMessage(applicationRollbackException.getMessage());

			ResponseUtils.writeJson(Charsets.UTF_8.getCharset(), JsonUtils
					.formatJsonText(responseHeader,
							JsonPropertyConfigPattern.getJsonIngoreConfig()),
					response);

			return new ModelAndView();
		}

		// other exception handler for json

		ResponseHeader responseHeader = new ResponseHeader();
		responseHeader.setCode(baseException.getResultCode());
		responseHeader.setKey("E000001");
		responseHeader.setMessage(baseException.getMessage());

		ResponseUtils.writeJson(Charsets.UTF_8.getCharset(), JsonUtils
				.formatJsonText(responseHeader,
						JsonPropertyConfigPattern.getJsonIngoreConfig()),
				response);

		return new ModelAndView();
	}

	private Logger logger = LoggerFactory
			.getLogger(BusinessControllerExceptionResolver.class);

}
