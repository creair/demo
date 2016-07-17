package com.enclavetechnology.website.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.enclavetechnology.website.bean.ContentResource;
import com.enclavetechnology.website.bean.LocationContent;
import com.enclavetechnology.website.bean.PageLocation;
import com.enclavetechnology.website.mapper.WebsiteMapper;
import com.rapid.j2ee.framework.core.exception.ApplicationException;

@Service
@Transactional(noRollbackFor = ApplicationException.class, value = "odm_service")
public class WebsiteServiceImpl implements WebsiteService {

	@Override
	public PageLocation getPageLocationByPageName(String pageName) {

		PageLocation pageLocation = new PageLocation();

		pageLocation.setPageName(pageName);

		List<LocationContent> locationContents = websiteMapper
				.getLocationContentByPageName(pageName);

		for (LocationContent locationContent : locationContents) {

			List<ContentResource> contentResources = websiteMapper
					.getContentResourceByLocation(locationContent.getLocation());

			for (ContentResource resource : contentResources) {

				resource = websiteMapper.getContentResourceById(resource
						.getResourceId());
			}

		}

		pageLocation.setLocationContents(locationContents);

		return pageLocation;
	}

	@Autowired
	private WebsiteMapper websiteMapper;

}
