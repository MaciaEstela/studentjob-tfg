package edu.uoc.mestemi.studentjob.rest.application;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.Region;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.RegionLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

import edu.uoc.mestemi.studentjob.model.CompanyProfile;
import edu.uoc.mestemi.studentjob.model.Degree;
import edu.uoc.mestemi.studentjob.model.Offer;
import edu.uoc.mestemi.studentjob.rest.dto.DegreeConsumerDTO;
import edu.uoc.mestemi.studentjob.rest.dto.OfferConsumerDTO;
import edu.uoc.mestemi.studentjob.rest.dto.ProvinceConsumerDTO;
import edu.uoc.mestemi.studentjob.rest.util.StudentjobRestUtil;
import edu.uoc.mestemi.studentjob.service.CompanyProfileLocalServiceUtil;
import edu.uoc.mestemi.studentjob.service.DegreeLocalServiceUtil;
import edu.uoc.mestemi.studentjob.service.OfferLocalService;
import edu.uoc.mestemi.studentjob.service.OfferLocalServiceUtil;
import edu.uoc.mestemi.studentjob.util.CountryA3Constants;
import edu.uoc.mestemi.studentjob.util.ProvinceUtil;

/**
 * @author macia
 */
@Component(
	property = {
		JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/studentjob",
		JaxrsWhiteboardConstants.JAX_RS_NAME + "=Studentjob.Rest"
	},
	service = Application.class
)
public class StudentjobRestApplication extends Application {

	private static final Log log = LogFactoryUtil.getLog(StudentjobRestApplication.class);
	
	public Set<Object> getSingletons() {
		return Collections.<Object>singleton(this);
	}

	@POST
	@Path("/addOffer")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String addOffer(
			@Context HttpServletRequest request,
			String requestBody
		) {

		User user = null;

		String friendlyURL = "/guest";
		
		try {
			Group group = _groupLocalService.getFriendlyURLGroup(
					PortalUtil.getDefaultCompanyId(), 
					friendlyURL);
			
			long groupId = group.getGroupId();
			
			user = PortalUtil.getUser(request);
			long userId = user.getUserId();
			
			if (!StudentjobRestUtil.isUserCompany(group.getCompanyId(), userId))
				return "You're not a company user!";
			
			JSONObject object = JSONFactoryUtil.createJSONObject(requestBody);
			
			if (!object.has("degreeIds"))
				return "JSONObject should have the degreeIds key";
			
			if (!object.has("title"))
				return "JSONObject should have the title key";
			
			if (!object.has("description"))
				return "JSONObject should have the description key";
			
			if (!object.has("preference"))
				return "JSONObject should have the preference key";
			
			if (!object.has("provinceId"))
				return "JSONObject should have the provinceId key";
			
			try {
				CompanyProfile companyProfile = CompanyProfileLocalServiceUtil.getCompanyProfileByGroupIdAndUserId(groupId, userId);
				if (!companyProfile.isActive()) {
					return "Your company profile is not active!";
				}
			} catch (Exception e) {
				return "You don't have a company profile!";
			}
			
			JSONArray degreeIdsArray = object.getJSONArray("degreeIds");
			List<Long> degreeIds = new ArrayList<>();
			
			for (int i = 0 ; i < degreeIdsArray.length() ; i++) {
				degreeIds.add(degreeIdsArray.getLong(i));
			}
			
			JSONObject titleObject = object.getJSONObject("title");
			Map<Locale, String> titleMap = new HashMap<>();
			titleMap.put(LocaleUtil.fromLanguageId("es_ES"), titleObject.getString("es_ES"));
			
			if (titleObject.has("ca_ES")) {
				titleMap.put(LocaleUtil.fromLanguageId("ca_ES"), titleObject.getString("ca_ES"));
			}
			if (titleObject.has("en_US")) {
				titleMap.put(LocaleUtil.fromLanguageId("en_US"), titleObject.getString("en_US"));
			}
			
			JSONObject descriptionObject = object.getJSONObject("description");
			Map<Locale, String> descriptionMap = new HashMap<>();
			descriptionMap.put(LocaleUtil.fromLanguageId("es_ES"), descriptionObject.getString("es_ES"));

			if (descriptionObject.has("ca_ES")) {
				descriptionMap.put(LocaleUtil.fromLanguageId("ca_ES"), descriptionObject.getString("ca_ES"));
			}
			if (descriptionObject.has("en_US")) {
				descriptionMap.put(LocaleUtil.fromLanguageId("en_US"), descriptionObject.getString("en_US"));
			}
			
			long provinceId = object.getLong("provinceId");
			String preference = object.getString("preference");
			
			Offer offer = OfferLocalServiceUtil.addOffer(
					group.getGroupId(), 
					provinceId, 
					titleMap, 
					descriptionMap, 
					preference, 
					degreeIds, 
					ServiceContextFactory.getInstance(request)
				);
			
			return "Offer created with id " + offer.getOfferId();
		} catch (PortalException e) {
			log.error(e);
			return "You should be authenticated to make this request";
		} catch (Exception e) {
			log.error(e);
			return "Error";
		}
	}

	@GET
	@Path("/provinces")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ProvinceConsumerDTO> getProvinces(@Context HttpServletRequest request) {
		List<ProvinceConsumerDTO> provinces = new ArrayList<>();
		
		try {
			Company company = PortalUtil.getCompany(request);
			List<Region> regions = ProvinceUtil.getRegionsByCountryA3(company.getCompanyId(), CountryA3Constants.SPAIN, true);
			
			for (Region region : regions) {
				ProvinceConsumerDTO provinceConsumerDTO = new ProvinceConsumerDTO(region.getName(), region.getRegionId());
				provinces.add(provinceConsumerDTO);
			}
		} catch (PortalException e) {
			log.error(e);
		}
		
		return provinces;
	}
	
	@GET
	@Path("/degrees")
	@Produces(MediaType.APPLICATION_JSON)
	public List<DegreeConsumerDTO> getDegrees(@Context HttpServletRequest request) {
		List<DegreeConsumerDTO> degreesDTO = new ArrayList<>();
		
		try {
			String friendlyURL = "/guest";
			Group group = _groupLocalService.getFriendlyURLGroup(
					PortalUtil.getDefaultCompanyId(), 
					friendlyURL);
			
			List<Degree> degrees = DegreeLocalServiceUtil.getDegreesByGroupId(group.getGroupId());

			for (Degree degree : degrees) {
				DegreeConsumerDTO degreeConsumerDTO = new DegreeConsumerDTO(degree.getName("es_ES"), degree.getDegreeId());
				degreesDTO.add(degreeConsumerDTO);
			}
		} catch (PortalException e) {
			log.error(e);
		}
		
		return degreesDTO;
	}

	@GET
	@Path("/offers")
	@Produces({MediaType.APPLICATION_JSON})
	public List<OfferConsumerDTO> getMyOffers(@Context HttpServletRequest request) {
		
		User user = null;
		String friendlyURL = "/guest";
		
		List<OfferConsumerDTO> offerConsumerDTOList = new ArrayList<>();
		
		try {
			Group group = _groupLocalService.getFriendlyURLGroup(
					PortalUtil.getDefaultCompanyId(), 
					friendlyURL);
			user = PortalUtil.getUser(request);
			
			if (!StudentjobRestUtil.isUserCompany(group.getCompanyId(), user.getUserId()))
				return offerConsumerDTOList;
			
			List<Offer> offers = OfferLocalServiceUtil.getOffersByGroupIdAndUserId(group.getGroupId(), user.getUserId());
			
			for (Offer offer : offers) {
				List<String> degreesString = new ArrayList<>();
				
				List<Degree> degrees = DegreeLocalServiceUtil.getOfferDegrees(offer.getOfferId(), 0, 3);
				for (Degree degree : degrees) {
					degreesString.add(degree.getName("es_ES"));
				}
				
				Region region = RegionLocalServiceUtil.getRegion(offer.getRegionId());
				
				OfferConsumerDTO offerConsumerDTO = new OfferConsumerDTO(
						offer.getTitleMap(), offer.getDescriptionMap(), degreesString, offer.getPreference(), region.getName());
				
				offerConsumerDTOList.add(offerConsumerDTO);
			}
			
		} catch (Exception e) {
			log.error(e);
			return offerConsumerDTOList;
		}
		
		return offerConsumerDTOList;
	}

	@Reference
	private OfferLocalService _offerLocalService;
	
	@Reference
	private GroupLocalService _groupLocalService;
}