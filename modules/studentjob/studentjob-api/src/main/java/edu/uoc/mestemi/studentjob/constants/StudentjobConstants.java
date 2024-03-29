package edu.uoc.mestemi.studentjob.constants;

public class StudentjobConstants {

	private StudentjobConstants() { }
	
	public static final String SOCIALMEDIA_FORM_PREFIX = "network-";
	
	public static final String SOCIALMEDIANETWORK_IMAGE_FOLDER = "socialMediaNetworkImages-";
	
	public static final String[] JOB_PREFERENCE = {"remote", "person", "hybrid", "no-preference"};
	public static final String JOB_PREFERENCE_REMOTE = JOB_PREFERENCE[0];
	public static final String JOB_PREFERENCE_PERSON = JOB_PREFERENCE[1];
	public static final String JOB_PREFERENCE_HYBRID = JOB_PREFERENCE[2];
	public static final String JOB_PREFERENCE_NO_PREFERENCE = JOB_PREFERENCE[3];
	
	public static final int OFFERS_OFFSET = 6;
	public static final int STUDENTS_OFFSET = 6;
	
	public static final boolean USERS_INACTIVE_BY_DEFAULT = true;
	public static final boolean STUDENTS_ONLY_UOC = true;
	
	public static final String CMD = "cmd";
	
	public static final String USER_EMAIL_OFFERS = "userMailOffers";
	public static final String USER_NIF = "userNif";
	public static final String USER_PHONE = "userPhone";
	public static final String USER_COMPANY_EXPANDO = "userCompany";
	
	public static final String LAYOUT_ICON = "layoutIcon";
	
	public static final String USER_STUDENT = "student";
	public static final String USER_COMPANY = "company";
	
	public static final String EMAIL_SENDER = "noreply@mestemiuoc.com";
	
	public static final String ORDER_BY_COL = "orderByCol";
	public static final String ORDER_BY_TYPE = "orderByType";
	public static final String FILTER_BY_STATUS = "filterByStatus";
	
	public static final String ORDER_CREATE_DATE = "createDate";
	public static final String ORDER_MODIFIED_DATE = "modifiedDate";
	public static final String ORDER_NAME = "name";
	public static final String ORDER_ASC = "asc";
	public static final String ORDER_DESC = "desc";
	
	public static final String STUDENT_ROLE = "studentRole";
	public static final String COMPANY_ROLE = "companyRole";
	
	public static final String STUDENT_GROUP = "studentGroup";
	public static final String COMPANY_GROUP = "companyGroup";
	
	public static final String LOCALE_ES = "es_ES";
	public static final String LOCALE_CA = "ca_ES";
	public static final String LOCALE_EN = "en_US";
	
	public static final String REGEX_NIF = "([a-z]|[A-Z]|[0-9])[0-9]{7}([a-z]|[A-Z]|[0-9])";
	public static final String REGEX_PHONE = "(^\\\\+?[1-9][0-9]{7,14})";
	
	public static final String OFFER_ID = "offerId";
	public static final String GROUP_ID = "groupId";
	
	public static final String CONTENT_LANGUAGE = "content.Language";
	
}
