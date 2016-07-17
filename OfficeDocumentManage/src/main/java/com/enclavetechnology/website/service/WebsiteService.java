package com.enclavetechnology.website.service;

import java.util.List;

import com.enclavetechnology.website.bean.ContentResource;
import com.enclavetechnology.website.bean.LocationContent;
import com.enclavetechnology.website.bean.PageLocation;

public interface WebsiteService {

	public PageLocation getPageLocationByPageName(String pageName);
}
