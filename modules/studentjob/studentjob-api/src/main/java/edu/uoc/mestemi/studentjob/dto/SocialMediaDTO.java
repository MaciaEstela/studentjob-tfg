package edu.uoc.mestemi.studentjob.dto;

public class SocialMediaDTO {
	private String name;
	private String imageUrl;
	private String socialMediaUrl;
	
	public SocialMediaDTO(String name, String imageUrl, String socialMediaUrl) {
		super();
		this.name = name;
		this.imageUrl = imageUrl;
		this.socialMediaUrl = socialMediaUrl;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getSocialMediaUrl() {
		return socialMediaUrl;
	}

	public void setSocialMediaUrl(String socialMediaUrl) {
		this.socialMediaUrl = socialMediaUrl;
	}
	
}
