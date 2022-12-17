package edu.uoc.mestemi.studentjob.web.constants;

public class MVCCommandNames {

	private MVCCommandNames() {
		throw new IllegalStateException("Utility class");
	}
	
	public static final String ADD_OFFER_ADMIN = "/studentjob/offer/admin/add";
	public static final String DELETE_OFFER_ADMIN = "/studentjob/offer/admin/delete";
	public static final String EDIT_OFFER_ADMIN = "/studentjob/offer/admin/edit";
	public static final String LIST_OFFER_ADMIN = "/studentjob/offer/admin/view";
	
	public static final String LIST_OFFER_USER = "/studentjob/offer/public/list";
	public static final String VIEW_DETAIL_USER = "/studentjob/offer/public/view-detail";
	public static final String OFFER_PUBLIC_RESOURCE_COMMAND = "/studentjob/offer/public/resource";
	public static final String OFFER_PUBLIC_RESOURCE_COMMAND_GET_OFFERS = "getOffers";
	public static final String OFFER_PUBLIC_RESOURCE_COMMAND_AUX_DATA = "auxdataOffers";
	public static final String OFFER_PUBLIC_RESOURCE_COMMAND_ENROLL = "enroll";
	
	public static final String ADD_DEGREEAREA_ADMIN = "/studentjob/degreeArea/admin/add";
	public static final String DELETE_DEGREEAREA_ADMIN = "/studentjob/degreeArea/admin/delete";
	public static final String EDIT_DEGREEAREA_ADMIN = "/studentjob/degreeArea/admin/edit";
	public static final String LIST_DEGREEAREA_ADMIN = "/studentjob/degreeArea/admin/view";

	public static final String ADD_DEGREE_ADMIN = "/studentjob/degree/admin/add";
	public static final String DELETE_DEGREE_ADMIN = "/studentjob/degree/admin/delete";
	public static final String EDIT_DEGREE_ADMIN = "/studentjob/degree/admin/edit";
	public static final String LIST_DEGREE_ADMIN = "/studentjob/degree/admin/view";
	
	public static final String ADD_SOCIALMEDIANETWORK_ADMIN = "/studentjob/socialmedianetwork/admin/add";
	public static final String DELETE_SOCIALMEDIANETWORK_ADMIN = "/studentjob/socialmedianetwork/admin/delete";
	public static final String EDIT_SOCIALMEDIANETWORK_ADMIN = "/studentjob/socialmedianetwork/admin/edit";
	public static final String LIST_SOCIALMEDIANETWORK_ADMIN = "/studentjob/socialmedianetwork/admin/view";
	
	public static final String EDIT_COMPANYPROFILE_ADMIN_RENDER = "/studentjob/companyoprofile/edit";
	public static final String EDIT_COMPANYPROFILE_ADMIN_ACTION = "/studentjob/companyoprofile/edit/action";
	public static final String VIEW_COMPANYPROFILE_USER = "/studentjob/companyprofile/public/view";
	public static final String LIST_COMPANYPROFILE_USER = "/studentjob/companyprofile/public/list";
	
	public static final String EDIT_STUDENTPROFILE_ADMIN_ACTION = "/studentjob/studentoprofile/edit/action";
	public static final String EDIT_STUDENTPROFILE_ADMIN_RENDER = "/studentjob/studentoprofile/edit";
	public static final String VIEW_STUDENTPROFILE_USER = "/studentjob/studentprofile/public/view";
	public static final String LIST_STUDENTPROFILE_USER = "/studentjob/studentprofile/public/list";
	public static final String STUDENTPROFILE_PUBLIC_RESOURCE_COMMAND = "/studentjob/studentprofile/public/resource";
	public static final String STUDENTPROFILE_PUBLIC_RESOURCE_COMMAND_GET_STUDENTS = "getStudents";
	public static final String STUDENTPROFILE_PUBLIC_RESOURCE_COMMAND_AUX_DATA = "auxdataStudents";
}