package com.enclavetechnology.odm.framework.core.intercepter;

import java.io.IOException;

import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;

import com.enclavetechnology.odm.framework.mvc.security.response.ResponseHeader;

/**
 * JSON data back before the package class (International)
 * 
 * @author AB team
 * 
 */
@SuppressWarnings("deprecation")
public class MappingJackson2HttpMessageConverter extends
		MappingJacksonHttpMessageConverter {

	@Override
	protected void writeInternal(Object object, HttpOutputMessage outputMessage)
			throws IOException, HttpMessageNotWritableException {

		if (object instanceof ResponseHeader) {

			ResponseHeader responseHeader = (ResponseHeader) object;

		}

		super.writeInternal(object, outputMessage);
	}
}
