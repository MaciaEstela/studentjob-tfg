package edu.uoc.mestemi.studentjob.dto;

public class OfferDTO {
	private String title;
	private String company;
	private String logoURL;
	private String preference;
	private String description;
	private String createString;
	private String viewURL;
	private String province;
	
	public OfferDTO(String title, String company, String logoURL, String preference, String description, 
			String createString, String viewURL, String province) {
		super();
		this.title = title;
		this.company = company;
		this.logoURL = logoURL;
		this.preference = preference;
		this.description = description;
		this.createString = createString;
		this.viewURL = viewURL;
		this.province = province;
	}

	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getLogoURL() {
		return logoURL;
	}

	public void setLogoURL(String logoURL) {
		this.logoURL = logoURL;
	}

	public String getPreference() {
		return preference;
	}

	public void setPreference(String preference) {
		this.preference = preference;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCreateString() {
		return createString;
	}

	public void setCreateString(String createString) {
		this.createString = createString;
	}

	public String getViewURL() {
		return viewURL;
	}

	public void setViewURL(String viewURL) {
		this.viewURL = viewURL;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}
	
}
