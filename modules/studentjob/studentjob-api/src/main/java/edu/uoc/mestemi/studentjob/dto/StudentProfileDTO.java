package edu.uoc.mestemi.studentjob.dto;

import java.util.List;

public class StudentProfileDTO {

	private String name;
	private String surname;
	private List<String> degrees;
	private String title;
	private String province;
	private String jobPreference;
	private String cvUrl;
	private String portraitUrl;
	private String description;
	private String email;
	private String phone;
	private String viewURL;
	
	public StudentProfileDTO(String name, String surname, List<String> degrees, String title, String province,
			String jobPreference, String cvUrl, String portraitUrl, String viewURL) {
		super();
		this.name = name;
		this.surname = surname;
		this.degrees = degrees;
		this.title = title;
		this.province = province;
		this.jobPreference = jobPreference;
		this.cvUrl = cvUrl;
		this.portraitUrl = portraitUrl;
		this.viewURL = viewURL;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public List<String> getDegrees() {
		return degrees;
	}

	public void setDegrees(List<String> degrees) {
		this.degrees = degrees;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getJobPreference() {
		return jobPreference;
	}

	public void setJobPreference(String jobPreference) {
		this.jobPreference = jobPreference;
	}

	public String getCvUrl() {
		return cvUrl;
	}

	public void setCvUrl(String cvUrl) {
		this.cvUrl = cvUrl;
	}

	public String getPortraitUrl() {
		return portraitUrl;
	}

	public void setPortraitUrl(String portraitUrl) {
		this.portraitUrl = portraitUrl;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getViewURL() {
		return viewURL;
	}

	public void setViewURL(String viewURL) {
		this.viewURL = viewURL;
	}
	
}
