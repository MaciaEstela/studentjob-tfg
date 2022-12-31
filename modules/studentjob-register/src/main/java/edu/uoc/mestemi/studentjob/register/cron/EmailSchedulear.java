package edu.uoc.mestemi.studentjob.register.cron;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.DestinationNames;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.scheduler.SchedulerEngineHelperUtil;
import com.liferay.portal.kernel.scheduler.SchedulerEntryImpl;
import com.liferay.portal.kernel.scheduler.Trigger;
import com.liferay.portal.kernel.scheduler.TriggerFactoryUtil;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionCheckerFactoryUtil;
import com.liferay.portal.kernel.security.permission.PermissionThreadLocal;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.template.TemplateConstants;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.internet.AddressException;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;
import edu.uoc.mestemi.studentjob.constants.StudentjobConstants;
import edu.uoc.mestemi.studentjob.model.CompanyProfile;
import edu.uoc.mestemi.studentjob.model.Degree;
import edu.uoc.mestemi.studentjob.model.Offer;
import edu.uoc.mestemi.studentjob.model.StudentProfile;
import edu.uoc.mestemi.studentjob.register.util.RegisterUtil;
import edu.uoc.mestemi.studentjob.register.util.TemplateProcessor;
import edu.uoc.mestemi.studentjob.service.CompanyProfileLocalServiceUtil;
import edu.uoc.mestemi.studentjob.service.DegreeLocalServiceUtil;
import edu.uoc.mestemi.studentjob.service.OfferLocalServiceUtil;
import edu.uoc.mestemi.studentjob.service.StudentProfileLocalServiceUtil;
import edu.uoc.mestemi.studentjob.service.UserEnrollOfferLocalServiceUtil;
import edu.uoc.mestemi.studentjob.util.UserManagementUtil;

@Component(
		immediate = true,
		property = {
			"cron.expression= 0 0 * ? * *"   // scheduler runs every hour
		},
		service = EmailSchedulear.class
	)
public class EmailSchedulear extends BaseMessageListener {
	
	private static final Log log = LogFactoryUtil.getLog(EmailSchedulear.class);
	
	@Override
	protected void doReceive(Message message) throws Exception {
		
		log.info("On cron doReceive()");
		
		PermissionChecker originalPermissionChecker = PermissionThreadLocal.getPermissionChecker();
		User adminUser = UserManagementUtil.getAdminUser(PortalUtil.getDefaultCompanyId());
		
		try {
			
			PermissionThreadLocal.setPermissionChecker(
					PermissionCheckerFactoryUtil.create(adminUser));
			
			String friendlyURL = "/guest";
			Group group = GroupLocalServiceUtil.getFriendlyURLGroup(
					PortalUtil.getDefaultCompanyId(), 
					friendlyURL);
			
			long groupId = group.getGroupId();
			
			List<StudentProfile> studentProfiles = StudentProfileLocalServiceUtil.getStudentProfilesByGroupIdAndActive(groupId, true);
			Date greaterThanDate = new Date(System.currentTimeMillis() - 3600 * 1000);
			
			for (StudentProfile studentProfile : studentProfiles) {
				processStudentAlertMail(studentProfile, greaterThanDate);
			}
			
			List<CompanyProfile> companyProfiles = CompanyProfileLocalServiceUtil.getCompanyProfilesByGroupIdAndActive(groupId, true);
			
			for (CompanyProfile companyProfile : companyProfiles) {
				processCompanyAlertMail(companyProfile, greaterThanDate);
			}
			
		} catch (Exception e) {
			log.error(e);
		} finally {
			PermissionThreadLocal.setPermissionChecker(originalPermissionChecker);
		}
		
		System.out.println("CRON!");
		
	}
	
	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {
		try {
			String cronExpression = GetterUtil.getString(properties.get("cron.expression"), "cronExpression");
			log.info(" cronExpression: " + cronExpression);
	 
			String listenerClass = getClass().getName();
			Trigger jobTrigger = TriggerFactoryUtil.createTrigger(listenerClass, listenerClass, new Date(), null, cronExpression);
	 
			SchedulerEntryImpl schedulerEntryImpl = new SchedulerEntryImpl(listenerClass, jobTrigger);
	 
			SchedulerEngineHelperUtil.register(this, schedulerEntryImpl, DestinationNames.SCHEDULER_DISPATCH);
	 
		} catch (Exception e) {
			log.error(e);
		}
	}
	
	@Deactivate
	protected void deactive() {
		SchedulerEngineHelperUtil.unregister(this);
	}
	
	void processCompanyAlertMail(CompanyProfile companyProfile, Date greaterThanDate) throws PortalException, AddressException {
		List<String> enrollmentsString = new ArrayList<>();
		
		User companyUser = UserLocalServiceUtil.getUser(companyProfile.getUserId());
		if ((boolean) companyUser.getExpandoBridge().getAttribute(StudentjobConstants.USER_EMAIL_OFFERS)) {
			System.out.println("Email company es "+ companyUser.getEmailAddress());
			List<Offer> offers = OfferLocalServiceUtil.getOffersByGroupIdAndUserId(companyProfile.getGroupId(), companyUser.getUserId());
			
			for (Offer offer : offers) {
				int userEnrollOffersCount = UserEnrollOfferLocalServiceUtil.getUserEnrollOffersByCreateDateCount(companyProfile.getGroupId(), offer.getOfferId(), greaterThanDate);
				if (userEnrollOffersCount == 1) {
					enrollmentsString.add(offer.getTitle("es_ES") + " -> " + userEnrollOffersCount + " nueva inscripción");
				} else if (userEnrollOffersCount > 0) {
					enrollmentsString.add(offer.getTitle("es_ES") + " -> " + userEnrollOffersCount + " nuevas inscripciones");
				}
				
//				List<UserEnrollOffer> userEnrollOffers = UserEnrollOfferLocalServiceUtil.getUserEnrollOffersByCreateDate(groupId, offer.getOfferId(), greaterThanDate);
//				
//				for (UserEnrollOffer userEnrollOffer : userEnrollOffers) {
//					StudentProfile studentProfile = StudentProfileLocalServiceUtil.getStudentProfileByGroupIdAndUserId(groupId, userEnrollOffer.getUserId());
//					User studentUser = UserLocalServiceUtil.getUser(userEnrollOffer.getUserId());
//					enrollmentsString.add()
//					
//					log.info("Se ha apuntado " + studentUser.getFirstName() + " " + studentUser.getLastName());
//				}
				
			}
			
			// Send mail
			if (!enrollmentsString.isEmpty()) {
				TemplateProcessor templateProcessor = new TemplateProcessor("/META-INF/resources/mails/companyResume.ftl");
				Map<String,Object> params = new HashMap<>();
				params.put("enrollmentsString", enrollmentsString);
				
				RegisterUtil.sendMailMessage(
						StudentjobConstants.EMAIL_SENDER, 
						companyUser.getEmailAddress(), 
						"Nuevas inscripciones a tus ofertas",
						templateProcessor.process(params, TemplateConstants.LANG_TYPE_FTL)
					);	
			}
		}
	}
	
	private void processStudentAlertMail(StudentProfile studentProfile, Date greaterThanDate) throws PortalException, AddressException {
		User studentUser = UserLocalServiceUtil.getUser(studentProfile.getUserId());
		if ((boolean) studentUser.getExpandoBridge().getAttribute(StudentjobConstants.USER_EMAIL_OFFERS)) {
			System.out.println("Email es "+ studentUser.getEmailAddress());
			List<Degree> degrees = DegreeLocalServiceUtil.getStudentProfileDegrees(studentProfile.getStudentProfileId());
			
			String preference = studentProfile.getPreference();
			long regionId = studentProfile.getRegionId();
			
			if (studentProfile.getPreference().equals(StudentjobConstants.JOB_PREFERENCE_REMOTE) || 
					studentProfile.getPreference().equals(StudentjobConstants.JOB_PREFERENCE_NO_PREFERENCE)) {
				regionId = 0;
			}
			
			if (studentProfile.getPreference().equals(StudentjobConstants.JOB_PREFERENCE_NO_PREFERENCE)) {
				preference = StringPool.BLANK;
			}
			
			List<String> offersString = new ArrayList<>();
			
			for (Degree degree : degrees) {
				List<Offer> offers = OfferLocalServiceUtil.getOffersByDateGreater(studentProfile.getGroupId(), preference, regionId, degree.getDegreeId(), greaterThanDate);
				for (Offer offer : offers) {
					User companyUser = UserLocalServiceUtil.getUser(offer.getUserId());
					String company = (String) companyUser.getExpandoBridge().getAttribute(StudentjobConstants.USER_COMPANY_EXPANDO);
					offersString.add(company + " --> " + offer.getTitle("es_ES"));
				}
			}
			
			// Send mail
			if(!offersString.isEmpty()) {
				TemplateProcessor templateProcessor = new TemplateProcessor("/META-INF/resources/mails/studentResume.ftl");
				Map<String,Object> params = new HashMap<>();
				params.put("offersString", offersString);
				
				RegisterUtil.sendMailMessage(
						StudentjobConstants.EMAIL_SENDER, 
						studentUser.getEmailAddress(), 
						"Nuevas ofertas de prácticas de tu interés",
						templateProcessor.process(params, TemplateConstants.LANG_TYPE_FTL)
					);
			}
		}
	}
}
