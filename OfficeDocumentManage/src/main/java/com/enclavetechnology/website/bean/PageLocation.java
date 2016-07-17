package com.enclavetechnology.website.bean;

import java.io.Serializable;
import java.util.List;

public class PageLocation implements Serializable {

	private String pageName;

	private List<LocationContent> locationContents;

	public String getPageName() {
		return pageName;
	}

	public void setPageName(String pageName) {
		this.pageName = pageName;
	}

	public List<LocationContent> getLocationContents() {
		return locationContents;
	}

	public void setLocationContents(List<LocationContent> locationContents) {
		this.locationContents = locationContents;
	}

}
