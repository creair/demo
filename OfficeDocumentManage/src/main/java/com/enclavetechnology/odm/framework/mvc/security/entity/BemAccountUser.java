package com.enclavetechnology.odm.framework.mvc.security.entity;

import com.rapid.j2ee.framework.core.utils.ObjectAnalyzer;
import com.rapid.j2ee.framework.core.utils.TypeChecker;
import com.rapid.j2ee.framework.orm.medium.annotation.Column;
import com.rapid.j2ee.framework.orm.medium.annotation.ID;
import com.rapid.j2ee.framework.orm.medium.annotation.Table;

/**
 * account
 * 
 * @author
 * @version 1.0
 * @since 1.0
 */
@Table(value = "BEM_ACCOUNT_USER")
public class BemAccountUser implements java.io.Serializable {

	private static final long serialVersionUID = 5454155825314635342L;

	/** id */
	@ID
	@Column
	private java.lang.String id;
	/** firstname */
	@Column
	private java.lang.String firstname;
	/** middlename */
	@Column
	private java.lang.String middlename;
	/** lastname */
	@Column
	private java.lang.String lastname;

	@Column
	private java.lang.String email;

	@Column
	private String prooflinkId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public java.lang.String getFirstname() {
		return firstname;
	}

	public void setFirstname(java.lang.String firstname) {
		this.firstname = firstname;
	}

	public java.lang.String getMiddlename() {
		return middlename;
	}

	public void setMiddlename(java.lang.String middlename) {
		this.middlename = middlename;
	}

	public java.lang.String getLastname() {
		return lastname;
	}

	public void setLastname(java.lang.String lastname) {
		this.lastname = lastname;
	}

	public java.lang.String getEmail() {
		return email;
	}

	public void setEmail(java.lang.String email) {
		this.email = email;
	}

	public String toString() {

		return ObjectAnalyzer.toStringln(this);
	}

	public String getProoflinkId() {
		return prooflinkId;
	}

	public void setProoflinkId(String prooflinkId) {
		this.prooflinkId = prooflinkId;
	}

	public String getFullAccountName() {

		if (TypeChecker.isEmpty(this.getMiddlename())) {

			return getFirstname() + " " + getLastname();
		}

		return getFirstname() + " " + getMiddlename() + " " + getLastname();
	}

	public boolean hasProoflink() {

		return !TypeChecker.isEmpty(prooflinkId);

	}
}
