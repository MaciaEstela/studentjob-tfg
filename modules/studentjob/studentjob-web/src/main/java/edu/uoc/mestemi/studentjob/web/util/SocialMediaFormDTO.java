package edu.uoc.mestemi.studentjob.web.util;

public class SocialMediaFormDTO {

	private String url;
	private String name;
	private long networkId;
	
	public SocialMediaFormDTO(String url, String name, long networkId) {
		super();
		this.url = url;
		this.name = name;
		this.networkId = networkId;
	}
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getNetworkId() {
		return networkId;
	}
	public void setNetworkId(long networkId) {
		this.networkId = networkId;
	}
	
}
