package com.enclavetechnology.odm.framework.mvc.security.response;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.rapid.j2ee.framework.mvc.constants.OperationResult;
import com.rapid.j2ee.framework.mvc.constants.OperationResultConstants;

public class ResponseHeader {

	private int code; // response status code

	private String message; // response i18n message

	private String key; // key

	@JsonIgnore
	private Object[] resultMessageArguments;// message parameter

	public Object[] getResultMessageArguments() {

		return resultMessageArguments;
	}

	public void setResultMessageArguments(Object[] resultMessageArguments) {

		this.resultMessageArguments = resultMessageArguments;
	}

	public ResponseHeader() {

		this(OperationResultConstants.SUCCESS_OPERATION);
	}

	public ResponseHeader(OperationResult operationResultConstants) {

		this.code = operationResultConstants.getResultCode();

		this.key = operationResultConstants.getMessageCode();
	}

	public ResponseHeader(int code, String key) {

		super();

		this.code = code;

		this.key = key;
	}

	public int getCode() {

		return code;
	}

	public void setCode(int code) {

		this.code = code;
	}

	public String getMessage() {

		return message;
	}

	public void setMessage(String message) {

		this.message = message;
	}

	public String getKey() {

		return key;
	}

	public void setKey(String key) {

		this.key = key;
	}

}
