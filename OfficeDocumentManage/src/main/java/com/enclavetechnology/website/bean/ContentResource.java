package com.enclavetechnology.website.bean;

import java.io.Serializable;

public class ContentResource implements Serializable {

	private String resourceId;

	private String resourceTitle;

	private String resourceType;

	private String resourceIcon;

	private String resourceUrl;

	private String status;

	private String rcdsts;

	public String getResourceId() {
		return resourceId;
	}

	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}

	public String getResourceTitle() {
		return resourceTitle;
	}

	public void setResourceTitle(String resourceTitle) {
		this.resourceTitle = resourceTitle;
	}

	public String getResourceType() {
		return resourceType;
	}

	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}

	public String getResourceIcon() {
		return resourceIcon;
	}

	public void setResourceIcon(String resourceIcon) {
		this.resourceIcon = resourceIcon;
	}

	public String getResourceUrl() {
		return resourceUrl;
	}

	public void setResourceUrl(String resourceUrl) {
		this.resourceUrl = resourceUrl;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRcdsts() {
		return rcdsts;
	}

	public void setRcdsts(String rcdsts) {
		this.rcdsts = rcdsts;
	}

}
