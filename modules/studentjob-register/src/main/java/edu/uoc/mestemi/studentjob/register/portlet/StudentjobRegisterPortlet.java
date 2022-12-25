package edu.uoc.mestemi.studentjob.register.portlet;

import com.liferay.expando.kernel.exception.NoSuchTableException;
import com.liferay.expando.kernel.model.ExpandoColumn;
import com.liferay.expando.kernel.model.ExpandoColumnConstants;
import com.liferay.expando.kernel.model.ExpandoTable;
import com.liferay.expando.kernel.model.ExpandoTableConstants;
import com.liferay.expando.kernel.service.ExpandoColumnLocalService;
import com.liferay.expando.kernel.service.ExpandoTableLocalService;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.GroupConstants;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.model.LayoutConstants;
import com.liferay.portal.kernel.model.LayoutTypePortlet;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.UserGroup;
import com.liferay.portal.kernel.model.role.RoleConstants;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.LayoutLocalServiceUtil;
import com.liferay.portal.kernel.service.ResourcePermissionLocalService;
import com.liferay.portal.kernel.service.ResourcePermissionLocalServiceUtil;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserGroupLocalServiceUtil;
import com.liferay.portal.kernel.service.UserGroupRoleLocalServiceUtil;
import com.liferay.portal.kernel.service.persistence.LayoutFriendlyURLUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;

import java.net.URL;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.portlet.Portlet;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import edu.uoc.mestemi.studentjob.constants.StudentjobConstants;
import edu.uoc.mestemi.studentjob.register.constants.StudentjobRegisterPortletKeys;
import edu.uoc.mestemi.studentjob.util.UserManagementUtil;

/**
 * @author Macia Estela (mestemi@uoc.edu)
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.studentjob",
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
		log.info("Module " + StudentjobRegisterPortletKeys.STUDENTJOB_REGISTER + " started ");
		String companyWebId = "uoc.edu";
		long companyId = 0;
		
		log.info("ON ACTIVATE");
		try {
			companyId = CompanyLocalServiceUtil.getCompanyByWebId(companyWebId).getCompanyId();
		} catch (PortalException e) {
			log.error("Can't get companyId for companyWebId " + companyWebId, e);
		}
		String className = User.class.getName();
		String tableName = ExpandoTableConstants.DEFAULT_TABLE_NAME;
		
		ExpandoTable expandoTable = addExpandoTable(companyId, className, tableName);
		
		if (expandoTable != null) {
			addExpandoColumn(companyId, className, tableName, 
					StudentjobConstants.USER_EMAIL_OFFERS, expandoTable, 
					ExpandoColumnConstants.BOOLEAN, false);
			addExpandoColumn(companyId, className, tableName, 
					StudentjobConstants.USER_NIF, expandoTable, 
					ExpandoColumnConstants.STRING, StringPool.BLANK);
			addExpandoColumn(companyId, className, tableName, 
					StudentjobConstants.USER_PHONE, expandoTable, 
					ExpandoColumnConstants.STRING, StringPool.BLANK);
			addExpandoColumn(companyId, className, tableName, 
					StudentjobConstants.USER_COMPANY_EXPANDO, expandoTable, 
					ExpandoColumnConstants.STRING, StringPool.BLANK);
		}

		String layoutModelClass = Layout.class.getName();
		
		ExpandoTable expandoTableLayout = addExpandoTable(companyId, Layout.class.getName(), tableName);
		
		if (expandoTableLayout != null) {
			addExpandoColumn(companyId, layoutModelClass, 
					tableName, StudentjobConstants.LAYOUT_ICON, 
					expandoTableLayout, ExpandoColumnConstants.STRING, StringPool.BLANK);
		}
		
		long studentRoleId = 0;
		long companyRoleId = 0;
		try {
			Map<Locale, String> roleStudentMap = new HashMap<>();
			roleStudentMap.put(LocaleUtil.getDefault(), "Student Role");
			
			Map<Locale, String> roleCompanyMap = new HashMap<>();
			roleCompanyMap.put(LocaleUtil.getDefault(), "Company Role");
			
			Role studentRole = createRole(companyId, StudentjobConstants.STUDENT_ROLE, roleStudentMap);
			UserGroup studentGroup = createGroup(companyId, StudentjobConstants.STUDENT_GROUP);
			GroupLocalServiceUtil.addRoleGroup(studentRole.getRoleId(), studentGroup.getGroupId());
			studentRoleId = studentRole.getRoleId();
			
			Role companyRole = createRole(companyId, StudentjobConstants.COMPANY_ROLE, roleCompanyMap);
			UserGroup companyGroup = createGroup(companyId, StudentjobConstants.COMPANY_GROUP);
			GroupLocalServiceUtil.addRoleGroup(companyRole.getRoleId(), companyGroup.getGroupId());
			companyRoleId = companyRole.getRoleId();
		} catch (PortalException e) {
			log.error(e);
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
				log.error(
					"Error adding a ExpandoTable for companyId " + companyId + 
					" with following data. - ClassName " + className + " -TableName " + tableName, 
					e1
					);
			}
		} catch (PortalException e) {
			log.error("Error obtaining a ExpandoTable for companyId " + companyId + 
					" with following data. - ClassName " + className + " - TableName " + tableName,
					e
				);
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
				expandoColumn = _expandoColumnLocalService.addColumn(
						expandoTable.getTableId(), columnName, expandoColumnType, defaultData);
				setExpandoColumnPermissions(companyId, expandoColumn);
			} catch (PortalException e) {
				log.error("Error adding a ExpandoColumn for companyId " + companyId + " with following data. "+ 
						" - ClassName " + className + 
						" - TableName " + tableName + 
						" - ColumnName " + columnName + 
						" - ExpandoTable " + expandoTable.getName() + 
						" - ExpandoColumnType " + expandoColumnType + 
						" - DefaultData " + defaultData.toString(),
						e
					);
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
			Role guest = UserManagementUtil.getRoleById(companyId, RoleConstants.GUEST);
			Role userRole = UserManagementUtil.getRoleById(companyId, RoleConstants.USER);
			String[] actionsR = new String[] { ActionKeys.VIEW };
			String[] actionsU = new String[] { ActionKeys.UPDATE };
			_resourcePermissionLocalService.setResourcePermissions(companyId, ExpandoColumn.class.getName(), 
					ResourceConstants.SCOPE_INDIVIDUAL, Long.toString(expandoColumn.getPrimaryKey()), guest.getRoleId(), actionsR);
			
			_resourcePermissionLocalService.setResourcePermissions(companyId, ExpandoColumn.class.getName(), 
					ResourceConstants.SCOPE_INDIVIDUAL, Long.toString(expandoColumn.getPrimaryKey()), userRole.getRoleId(), actionsU);
		} catch (Exception e) {
			log.error("Error setting Guest Role on Expando Column " + expandoColumn.getName());
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Create the role or return it if already exists one with this roleName
	 * 
	 * @param companyId
	 * @param roleName
	 * @param titleMap
	 */
	private Role createRole(long companyId, String roleName, Map<Locale, String> titleMap) throws PortalException {
		Role role = null;
		try {
			role = RoleLocalServiceUtil.getRole(companyId, roleName); 
		} catch (PortalException e) {
			log.error("Role with name " + roleName + " doesn't exist");
			role = RoleLocalServiceUtil.addRole(
					UserManagementUtil.getAdminUser(companyId).getUserId(), 
					null, 
					0, 
					roleName, 
					titleMap, 
					titleMap, 
					RoleConstants.TYPE_REGULAR, 
					null, 
					new ServiceContext());
		}
		
		return role;
	}
	
	/**
	 * Create the user group or return it if already exists one with this groupName
	 * 
	 * @param companyId
	 * @param groupName
	 */
	private UserGroup createGroup(long companyId, String groupName) throws PortalException {
		UserGroup userGroup = null;
		try {
			userGroup = UserGroupLocalServiceUtil.getUserGroup(companyId, groupName);
		} catch (PortalException e) {
			log.error("Group with name " + groupName + " doesn't exist");
			
			userGroup = UserGroupLocalServiceUtil.addUserGroup(
					UserManagementUtil.getAdminUser(companyId).getUserId(), 
					companyId, 
					groupName, 
					groupName, 
					new ServiceContext()
				);
		}
		
		return userGroup;
	}
	
	
	@Reference
	ExpandoColumnLocalService _expandoColumnLocalService;
	
	@Reference
	ExpandoTableLocalService _expandoTableLocalService;
	
	@Reference
	ResourcePermissionLocalService _resourcePermissionLocalService;
}