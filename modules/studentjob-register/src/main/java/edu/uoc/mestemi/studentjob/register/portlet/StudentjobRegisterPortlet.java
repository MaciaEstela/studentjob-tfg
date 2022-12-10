package edu.uoc.mestemi.studentjob.register.portlet;

import com.liferay.expando.kernel.exception.NoSuchTableException;
import com.liferay.expando.kernel.model.ExpandoColumn;
import com.liferay.expando.kernel.model.ExpandoColumnConstants;
import com.liferay.expando.kernel.model.ExpandoTable;
import com.liferay.expando.kernel.model.ExpandoTableConstants;
import com.liferay.expando.kernel.service.ExpandoColumnLocalService;
import com.liferay.expando.kernel.service.ExpandoTableLocalService;
import com.liferay.expando.kernel.service.permission.ExpandoColumnPermission;
import com.liferay.expando.kernel.service.permission.ExpandoColumnPermissionUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.ResourcePermission;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.role.RoleConstants;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.kernel.service.ResourcePermissionLocalService;
import com.liferay.portal.kernel.service.UserLocalService;

import javax.mail.internet.AddressException;
import javax.portlet.Portlet;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import edu.uoc.mestemi.studentjob.register.constants.StudentjobRegisterConstants;
import edu.uoc.mestemi.studentjob.register.constants.StudentjobRegisterPortletKeys;
import edu.uoc.mestemi.studentjob.register.util.RegisterUtil;

/**
 * @author macia
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.studentjob",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=StudentjobRegister",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + StudentjobRegisterPortletKeys.STUDENTJOB_REGISTER,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class StudentjobRegisterPortlet extends MVCPortlet {
	private static final Log log = LogFactoryUtil.getLog(StudentjobRegisterPortlet.class);
	
	@Activate
	public void onActivate() {
		log.info("Module " + StudentjobRegisterPortletKeys.STUDENTJOB_REGISTER + " started");
		String companyWebId = "uoc.edu";
		long companyId = 0;
		
		try {
			companyId = CompanyLocalServiceUtil.getCompanyByWebId(companyWebId).getCompanyId();
		} catch (PortalException e) {
			log.error("Can't get companyId for companyWebId " + companyWebId);
		}
		String className = User.class.getName();
		String tableName = ExpandoTableConstants.DEFAULT_TABLE_NAME;
		
		ExpandoTable expandoTable = addExpandoTable(companyId, className, tableName);
		
		if (expandoTable != null) {
			addExpandoColumn(companyId, className, tableName, 
					StudentjobRegisterConstants.USER_EMAIL_OFFERS, expandoTable, ExpandoColumnConstants.BOOLEAN, false);
			addExpandoColumn(companyId, className, tableName, 
					StudentjobRegisterConstants.USER_NIF, expandoTable, ExpandoColumnConstants.STRING, StringPool.BLANK);
			addExpandoColumn(companyId, className, tableName, 
					StudentjobRegisterConstants.USER_PHONE, expandoTable, ExpandoColumnConstants.STRING, StringPool.BLANK);
		}
		
	}
	
	/**
	 * Return and add an ExpandoTable if not exists
	 *
	 * @param companyId		companyId
	 * @param className		class className
	 * @param tableName		expando table name
	 *
	 * @return ExpandoTable
	 */
	private ExpandoTable addExpandoTable(long companyId, String className, String tableName){
		ExpandoTable expandoTable = null;
		
		try {
			expandoTable  = _expandoTableLocalService.getTable(companyId, className, tableName);
		} catch (NoSuchTableException e) {
			try {
				expandoTable = _expandoTableLocalService.addTable(companyId, className, tableName);
			} catch (PortalException e1) {
				log.error("Error adding a ExpandoTable for companyId " + companyId + " with following data. "+ 
						" - ClassName " + className + 
						" - TableName " + tableName
					);
				e1.printStackTrace();
			}
		} catch (PortalException e) {
			log.error("Error obtaining a ExpandoTable for companyId " + companyId + " with following data. "+ 
					" - ClassName " + className + 
					" - TableName " + tableName
				);
			e.printStackTrace();
		}
		
		return expandoTable;
	}
	
	/**
	 * Return and add an ExpandoColumn if not exists 
	 *
	 * @param companyId				companyId
	 * @param className				class className
	 * @param tableName				expando table name
	 * @param columnName			expando column name
	 * @param expandoTable			expandoTable object
	 * @param expandoColumnType 	ExpandoColumnConstants type
	 * @param defaultData			default column value
	 *
	 * @return ExpandoColumn
	 */
	private ExpandoColumn addExpandoColumn(long companyId, String className, String tableName, String columnName, 
			ExpandoTable expandoTable, int expandoColumnType, Object defaultData) {
		
		ExpandoColumn expandoColumn = null;

		expandoColumn = _expandoColumnLocalService.getColumn(companyId, className, tableName, columnName);
		if (expandoColumn == null) {
			try {
				expandoColumn = _expandoColumnLocalService.addColumn(expandoTable.getTableId(), columnName, expandoColumnType, defaultData);
				setExpandoColumnPermissions(companyId, expandoColumn);
			} catch (PortalException e) {
				log.error("Error adding a ExpandoColumn for companyId " + companyId + " with following data. "+ 
						" - ClassName " + className + 
						" - TableName " + tableName + 
						" - ColumnName " + columnName + 
						" - ExpandoTable " + expandoTable.getName() + 
						" - ExpandoColumnType " + expandoColumnType + 
						" - DefaultData " + defaultData.toString()
					);
				e.printStackTrace();
			}
		}
		
		return expandoColumn;
	}
	
	/**
	 * Set necessary expando column permissions
	 * 
	 * @param companyId
	 * @param expandoColumn
	 */
	private void setExpandoColumnPermissions(long companyId, ExpandoColumn expandoColumn) {
		try {
			Role guest = RegisterUtil.getRoleById(companyId, RoleConstants.GUEST);
			String[] actionsR = new String[] { ActionKeys.VIEW };
			_resourcePermissionLocalService.setResourcePermissions(companyId, ExpandoColumn.class.getName(), 
					ResourceConstants.SCOPE_INDIVIDUAL, Long.toString(expandoColumn.getPrimaryKey()), guest.getRoleId(), actionsR);
		} catch (Exception e) {
			log.error("Error setting Guest Role on Expando Column " + expandoColumn.getName());
			e.printStackTrace();
		}
	}
	
	@Reference
	ExpandoColumnLocalService _expandoColumnLocalService;
	
	@Reference
	ExpandoTableLocalService _expandoTableLocalService;
	
	@Reference
	ResourcePermissionLocalService _resourcePermissionLocalService;
	
	@Reference
	UserLocalService _userLocalService;
}