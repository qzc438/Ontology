package com.qzc.controller;

import javax.inject.Named;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.annotation.FacesConfig;

@FacesConfig
@Named("titleController")
@RequestScoped
public class TitleController {
	private String pageTitle;

	public TitleController() {
		// Set the page title
		pageTitle = "Minor Thesis";
	}

	public String getPageTitle() {
		return pageTitle;
	}

	public void setPageTitle(String pageTitle) {
		this.pageTitle = pageTitle;
	}

	@PostConstruct
	public void init() {
		pageTitle = "Minor Thesis";
	}
}