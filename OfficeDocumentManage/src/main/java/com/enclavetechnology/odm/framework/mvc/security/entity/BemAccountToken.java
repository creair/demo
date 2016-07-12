package com.enclavetechnology.odm.framework.mvc.security.entity;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.rapid.j2ee.framework.orm.medium.annotation.Column;
import com.rapid.j2ee.framework.orm.medium.annotation.ID;
import com.rapid.j2ee.framework.orm.medium.annotation.Table;
import com.rapid.j2ee.framework.orm.medium.annotation.ID.IDMode;
/**
 * account token
 * @author AB team
 *
 */
@Table(value="BEM_ACCOUNT_TOKEN")
public class BemAccountToken  implements Serializable{
	
	private static final long serialVersionUID = 1L;

	/** accountid */
	@Column
	private String accountid;
	
	/** token */
	@Column
	@ID(IDMode.QUERY)
	private java.lang.String token;

	public String getAccountid() {
		return this.accountid;
	}
	
	public void setAccountid(String value) {
		this.accountid = value;
	}
	
	public java.lang.String getToken() {
		return this.token;
	}
	
	public void setToken(java.lang.String value) {
		this.token = value;
	}
	

	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
	
}
