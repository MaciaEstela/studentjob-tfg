package edu.uoc.mestemi.studentjob.rest.dto;

import java.util.List;
import java.util.Locale;
import java.util.Map;

public class OfferConsumerDTO {
	private Map<Locale, String> titleMap;
	private Map<Locale, String> descriptionMap;
	private List<String> degrees;
	private String preference;
	private String province;
	
	public OfferConsumerDTO(Map<Locale, String> titleMap, Map<Locale, String> descriptionMap,
			List<String> degrees, String preference, String province) {
		super();
		this.titleMap = titleMap;
		this.descriptionMap = descriptionMap;
		this.degrees = degrees;
		this.preference = preference;
		this.province = province;
	}

	public Map<Locale, String> getTitleMap() {
		return titleMap;
	}

	public void setTitleMap(Map<Locale, String> titleMap) {
		this.titleMap = titleMap;
	}

	public Map<Locale, String> getDescriptionMap() {
		return descriptionMap;
	}

	public void setDescriptionMap(Map<Locale, String> descriptionMap) {
		this.descriptionMap = descriptionMap;
	}

	public List<String> getDegrees() {
		return degrees;
	}

	public void setDegrees(List<String> degrees) {
		this.degrees = degrees;
	}

	public String getPreference() {
		return preference;
	}

	public void setPreference(String preference) {
		this.preference = preference;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}
}