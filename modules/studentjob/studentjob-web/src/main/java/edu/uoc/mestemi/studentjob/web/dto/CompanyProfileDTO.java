package edu.uoc.mestemi.studentjob.web.dto;

public class CompanyProfileDTO {

	private String name;
	private String sector;
	private String viewURL;
	private String logoURL;
	
	public CompanyProfileDTO(String name, String sector, String viewURL, String logoURL) {
		super();
		this.name = name;
		this.sector = sector;
		this.viewURL = viewURL;
		this.logoURL = logoURL;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSector() {
		return sector;
	}
	
	public void setSector(String sector) {
		this.sector = sector;
	}

	public String getViewURL() {
		return viewURL;
	}

	public void setViewURL(String viewURL) {
		this.viewURL = viewURL;
	}

	public String getLogoURL() {
		return logoURL;
	}

	public void setLogoURL(String logoURL) {
		this.logoURL = logoURL;
	}
}
