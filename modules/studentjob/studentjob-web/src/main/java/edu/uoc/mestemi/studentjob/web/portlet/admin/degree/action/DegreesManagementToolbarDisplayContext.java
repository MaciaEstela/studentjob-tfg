package edu.uoc.mestemi.studentjob.web.portlet.admin.degree.action;

import com.liferay.frontend.taglib.clay.servlet.taglib.display.context.BaseManagementToolbarDisplayContext;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.CreationMenu;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.CreationMenuBuilder;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItem;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItemListBuilder;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.ViewTypeItem;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.ViewTypeItemList;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.PortalPreferences;
import com.liferay.portal.kernel.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portal.kernel.portlet.url.builder.PortletURLBuilder;
import com.liferay.portal.kernel.portlet.url.builder.PortletURLBuilder.PortletURLStep;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.List;

import javax.portlet.PortletURL;
import javax.servlet.http.HttpServletRequest;

import edu.uoc.mestemi.studentjob.constants.StudentjobConstants;
import edu.uoc.mestemi.studentjob.web.constants.MVCCommandNames;
import edu.uoc.mestemi.studentjob.web.constants.StudentjobPortletKeys;

/**
	* Assigments management toolbar display context.
	*
	* This class passes contextual information to the user interface
	* for the Clay management toolbar.
	*
	* @author Macia Estela (mestemi@uoc.edu)
	*/
public class DegreesManagementToolbarDisplayContext
	extends BaseManagementToolbarDisplayContext {
	
	public DegreesManagementToolbarDisplayContext(
		LiferayPortletRequest liferayPortletRequest,
		LiferayPortletResponse liferayPortletResponse,
		HttpServletRequest httpServletRequest) {

		super(httpServletRequest, liferayPortletRequest, liferayPortletResponse);

		_portalPreferences = PortletPreferencesFactoryUtil.getPortalPreferences(
				liferayPortletRequest);

		_themeDisplay = (ThemeDisplay)httpServletRequest.getAttribute(
			WebKeys.THEME_DISPLAY);
	}

	/**
		* Returns the creation menu for the toolbar
		* (plus sign on the management toolbar).
		*
		* @return creation menu
		*/
	@Override
	public CreationMenu getCreationMenu() {

//		if (!DegreeTopLevelPermission.contains(
//				_themeDisplay.getPermissionChecker(),
//				_themeDisplay.getScopeGroupId(), "ADD_ENTRY")) {
//		
//			return null;
//		}
	
		// Create the menu.
		
		return CreationMenuBuilder.addDropdownItem(
				dropdownItem -> {
					dropdownItem.setHref(
						liferayPortletResponse.createRenderURL(),
						"degreeAreaParent", "0",
						"mvcRenderCommandName", MVCCommandNames.EDIT_DEGREE_ADMIN,
						"redirect", currentURLObj.toString());
					dropdownItem.setLabel(
						LanguageUtil.get(httpServletRequest, "add-assignment"));
				}
			).build();
	}

	@Override
	public String getClearResultsURL() {
		return getSearchActionURL();
	}

	/**
	* Returns list display style. 
	* 
	* Current selection is stored in portal preferences.
	* 
	* @return current display style
	*/
	@Override
	public String getDisplayStyle() {

		String displayStyle = ParamUtil.getString(httpServletRequest, "displayStyle");

		if (Validator.isNull(displayStyle)) {
			displayStyle = _portalPreferences.getValue(
					StudentjobPortletKeys.STUDENTJOB, "assignments-display-style",
				"descriptive");
		}
		else {
			_portalPreferences.setValue(
				StudentjobPortletKeys.STUDENTJOB, "assignments-display-style",
				displayStyle);

			httpServletRequest.setAttribute(
				WebKeys.SINGLE_PAGE_APPLICATION_CLEAR_CACHE, Boolean.TRUE);
		}

		return displayStyle;
	}

	/**
	* Returns the sort order column.
	* 
	* @return sort column
	*/
	@Override
	public String getOrderByCol() {

		return ParamUtil.getString(httpServletRequest, 
				StudentjobConstants.ORDER_BY_COL, StudentjobConstants.ORDER_NAME);
	}

	/**
	* Returns the sort type (ascending / descending).
	* 
	* @return sort type
	*/
	@Override
	public String getOrderByType() {

		return ParamUtil.getString(httpServletRequest, 
				StudentjobConstants.ORDER_BY_TYPE, StudentjobConstants.ORDER_ASC);
	}

	/**
	* Returns the action URL for the search.
	*
	* @return search action URL
	*/
	@Override
	public String getSearchActionURL() {		
		return PortletURLBuilder.createRenderURL(
				liferayPortletResponse
			).setMVCRenderCommandName(
				MVCCommandNames.LIST_DEGREE_ADMIN
			).setNavigation(
				ParamUtil.getString(httpServletRequest, "navigation", "entries")
			).setParameter(
				StudentjobConstants.ORDER_BY_COL, getOrderByCol()
			).setParameter(
				StudentjobConstants.ORDER_BY_TYPE, getOrderByType()
			).buildString();
	}


	/**
	* Returns the view type options (card, list, table).
	*
	* @return list of view types
	*/
	@Override
	public List<ViewTypeItem> getViewTypeItems() {
		PortletURLStep portletURL = PortletURLBuilder.createRenderURL(liferayPortletResponse);
		portletURL.setMVCRenderCommandName(MVCCommandNames.LIST_DEGREE_ADMIN);

		int delta =
				ParamUtil.getInteger(httpServletRequest, SearchContainer.DEFAULT_DELTA_PARAM);

		if (delta > 0) {
			portletURL.setParameter("delta", String.valueOf(delta));
		}

		String orderByCol =
			ParamUtil.getString(httpServletRequest, 
					StudentjobConstants.ORDER_BY_COL, StudentjobConstants.ORDER_NAME);
		String orderByType =
			ParamUtil.getString(httpServletRequest, 
					StudentjobConstants.ORDER_BY_TYPE, StudentjobConstants.ORDER_ASC);

		portletURL.setParameter(StudentjobConstants.ORDER_BY_COL, orderByCol);
		portletURL.setParameter(StudentjobConstants.ORDER_BY_TYPE, orderByType);

		int cur =
			ParamUtil.getInteger(httpServletRequest, SearchContainer.DEFAULT_CUR_PARAM);

		if (cur > 0) {
			portletURL.setParameter("cur", String.valueOf(cur));
		}

		return new ViewTypeItemList(portletURL.buildPortletURL(), getDisplayStyle()) {
			private static final long serialVersionUID = 1L;
			{
				addCardViewTypeItem(); addListViewTypeItem(); addTableViewTypeItem();
			}
		};
	}

	/**
	* Return the option items for the sort column menu.
	*
	* @return options list for the sort column menu
	*/
	@Override
	protected List<DropdownItem> getOrderByDropdownItems() {
		
		return DropdownItemListBuilder.add(
				 dropdownItem -> {
					 dropdownItem.setActive("name".equals(getOrderByCol()));
					 dropdownItem.setHref(
						 _getCurrentSortingURL(), StudentjobConstants.ORDER_BY_COL, StudentjobConstants.ORDER_NAME);
					 dropdownItem.setLabel(
						 LanguageUtil.get(httpServletRequest, "name"));
				 }
			).add(dropdownItem -> {
				dropdownItem.setActive(
						StudentjobConstants.ORDER_CREATE_DATE.equals(getOrderByCol()));
					dropdownItem.setHref(
						_getCurrentSortingURL(), StudentjobConstants.ORDER_BY_COL,
						StudentjobConstants.ORDER_CREATE_DATE);
					dropdownItem.setLabel(
						LanguageUtil.get(httpServletRequest, "create-date"));
			}
		).build();
		
	}

	/**
	* Returns the current sorting URL.
	*
	* @return current sorting portlet URL
	*
	*/
	private PortletURL _getCurrentSortingURL() {
		return PortletURLBuilder.create(
			getPortletURL()
		).setKeywords(
			() -> {
				String keywords = ParamUtil.getString(
					httpServletRequest, "keywords");

				if (Validator.isNotNull(keywords)) {
					return keywords;
				}

				return null;
			}
		).setParameter(
			SearchContainer.DEFAULT_CUR_PARAM, "0"
		).buildPortletURL();
	}

	private final PortalPreferences _portalPreferences;
	private final ThemeDisplay _themeDisplay;
}