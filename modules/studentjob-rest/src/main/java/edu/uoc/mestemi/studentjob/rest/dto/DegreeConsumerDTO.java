package edu.uoc.mestemi.studentjob.rest.dto;

public class DegreeConsumerDTO {
	private String name;
	private long degreeId;
	
	public DegreeConsumerDTO(String name, long degreeId) {
		super();
		this.name = name;
		this.degreeId = degreeId;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getdegreeId() {
		return degreeId;
	}
	public void setdegreeId(long degreeId) {
		this.degreeId = degreeId;
	}
}
