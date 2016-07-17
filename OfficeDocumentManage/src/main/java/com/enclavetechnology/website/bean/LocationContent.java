package com.enclavetechnology.website.bean;

import java.io.Serializable;
import java.util.List;

public class LocationContent implements Serializable {

	private String location;

	private List<ContentResource> contentResources;

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<ContentResource> getContentResources() {
		return contentResources;
	}

	public void setContentResources(List<ContentResource> contentResources) {
		this.contentResources = contentResources;
	}

}
