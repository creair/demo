package com.enclavetechnology.website;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.enclavetechnology.website.bean.PageLocation;
import com.enclavetechnology.website.service.WebsiteService;

@Controller
@Scope("prototype")
public class WebsiteAction {
	
	@RequestMapping("/")
	public String getIndexPage() {
		return "index";
	}

	@RequestMapping("/pageview/getPageView")
	@ResponseBody
	public PageLocation doGetPageView(@RequestParam("pageName") String pageName) {

		return websiteService.getPageLocationByPageName(pageName);
	}

	@Autowired
	private WebsiteService websiteService;

}
