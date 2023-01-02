package edu.uoc.mestemi.studentjob.rest.dto;

public class ProvinceConsumerDTO {
	private String name;
	private long provinceId;
	
	public ProvinceConsumerDTO(String name, long provinceId) {
		super();
		this.name = name;
		this.provinceId = provinceId;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getProvinceId() {
		return provinceId;
	}
	public void setProvinceId(long provinceId) {
		this.provinceId = provinceId;
	}
}
