package edu.uoc.mestemi.studentjob.web.portlet.admin.offer.action;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import edu.uoc.mestemi.studentjob.service.OfferService;
import edu.uoc.mestemi.studentjob.web.constants.MVCCommandNames;

import edu.uoc.mestemi.studentjob.web.constants.StudentjobPortletKeys;

/**
 * MVC Action Command for deleting offers.
 * 
 * @author Macia Estela (mestemi@uoc.edu)
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + StudentjobPortletKeys.STUDENTJOB_OFFER_ADMIN,
		"mvc.command.name=" + MVCCommandNames.DELETE_OFFER_ADMIN
	},
	service = MVCActionCommand.class
)
public class DeleteOfferMVCActionCommand extends BaseMVCActionCommand {

	private static final Log log = LogFactoryUtil.getLog(DeleteOfferMVCActionCommand.class);
	
	@Override
	protected void doProcessAction(
		ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		// Get offer id from request.
		long offerId = ParamUtil.getLong(actionRequest, "offerId");

		try {
			// Call service to delete the offer.
			_offerService.deleteOffer(offerId);
		}
		catch (PortalException pe) {
			log.error("Error deleting offer with offerId " + offerId + " - Message: " + pe.getMessage());
		}
	}

	@Reference
	protected OfferService _offerService;
}