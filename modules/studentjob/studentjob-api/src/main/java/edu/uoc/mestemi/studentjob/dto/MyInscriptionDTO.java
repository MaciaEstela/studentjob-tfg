package edu.uoc.mestemi.studentjob.dto;

public class MyInscriptionDTO {
	private long userId;
	private long offerId;
	private String companyLogo;
	private String offerTitle;
	private String companyName;
	private String agoString;
	private boolean activeOffer;
	
	public MyInscriptionDTO(long userId, long offerId, String companyLogo, String offerTitle, String companyName,
			String agoString, boolean activeOffer) {
		super();
		this.userId = userId;
		this.offerId = offerId;
		this.companyLogo = companyLogo;
		this.offerTitle = offerTitle;
		this.companyName = companyName;
		this.agoString = agoString;
		this.activeOffer = activeOffer;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getOfferId() {
		return offerId;
	}

	public void setOfferId(long offerId) {
		this.offerId = offerId;
	}

	public String getCompanyLogo() {
		return companyLogo;
	}

	public void setCompanyLogo(String companyLogo) {
		this.companyLogo = companyLogo;
	}

	public String getOfferTitle() {
		return offerTitle;
	}

	public void setOfferTitle(String offerTitle) {
		this.offerTitle = offerTitle;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getAgoString() {
		return agoString;
	}

	public void setAgoString(String agoString) {
		this.agoString = agoString;
	}

	public boolean isActiveOffer() {
		return activeOffer;
	}

	public void setActiveOffer(boolean activeOffer) {
		this.activeOffer = activeOffer;
	}
}
