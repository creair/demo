package com.enclavetechnology.website.mapper;

import java.util.List;

import com.enclavetechnology.website.bean.ContentResource;
import com.enclavetechnology.website.bean.LocationContent;
import com.enclavetechnology.website.bean.PageLocation;

public interface WebsiteMapper {

	public PageLocation getPageLocationByPageName(String pageName);

	public List<LocationContent> getLocationContentByPageName(String pageName);

	public List<ContentResource> getContentResourceByLocation(String location);

	public ContentResource getContentResourceById(String id);

}
