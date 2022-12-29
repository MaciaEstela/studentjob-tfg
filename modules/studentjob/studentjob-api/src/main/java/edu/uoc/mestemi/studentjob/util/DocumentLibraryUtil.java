package edu.uoc.mestemi.studentjob.util;

import com.liferay.document.library.kernel.exception.NoSuchFileEntryException;
import com.liferay.document.library.kernel.exception.NoSuchFolderException;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.document.library.util.DLURLHelperUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.role.RoleConstants;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionCheckerFactoryUtil;
import com.liferay.portal.kernel.security.permission.PermissionThreadLocal;
import com.liferay.portal.kernel.service.ResourcePermissionServiceUtil;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.portlet.ActionRequest;

import edu.uoc.mestemi.studentjob.util.UserManagementUtil;

public class DocumentLibraryUtil {

	private static final Log log = LogFactoryUtil.getLog(DocumentLibraryUtil.class);

	private DocumentLibraryUtil() {}
	
	public static FileEntry addFile(ActionRequest actionRequest, String folderName, 
			File file, String fileName) throws IOException, PortalException {
		
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		FileEntry fileEntry = null;
		
		long groupId = themeDisplay.getCompanyGroupId();
		User adminUser = UserManagementUtil.getAdminUser(themeDisplay.getCompanyId());
		
		Folder folder = getFolder(adminUser, groupId, folderName);
		
		if (folder != null) {
			Date date = new Date();
			
			ServiceContext serviceContext = ServiceContextFactory.getInstance(actionRequest);
			
			byte[] bytes = new byte[(int) file.length()];
			
			FileInputStream fis = null;
			try {
				fis = new FileInputStream(file);
				fis.read(bytes);
			} catch(Exception e) {
				log.error("Error reading file bytes", e);
			} finally {
				if (fis != null) {
					fis.close();
				}
			}
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			fileName = fileName.replaceFirst("\\.", "-" + sdf.format(date) + ".");
			long folderId = folder.getFolderId();
			
			try {
				FileEntry currentFileEntry = DLAppLocalServiceUtil.getFileEntryByFileName(groupId, folderId, fileName);
				DLAppLocalServiceUtil.deleteFileEntry(currentFileEntry.getFileEntryId());
			} catch (Exception e) {}
			
			fileEntry = DLAppLocalServiceUtil.addFileEntry(
				fileName,
				adminUser.getUserId(),
				groupId,
				folderId,
				fileName,
				MimeTypesUtil.getContentType(file),
				bytes,
				null,
				null,
				serviceContext);
			
			PermissionChecker originalPermissionChecker = PermissionThreadLocal.getPermissionChecker();
			
			try {
				PermissionThreadLocal.setPermissionChecker(
						PermissionCheckerFactoryUtil.create(adminUser));
				
				Role userRole = RoleLocalServiceUtil.getRole(
						folder.getCompanyId(),
						RoleConstants.USER);
				
				String[] viewAccess = new String[1];
				viewAccess[0] = ActionKeys.VIEW;
				
				ResourcePermissionServiceUtil.setIndividualResourcePermissions(
						groupId,
						fileEntry.getCompanyId(),
						DLFileEntry.class.getName(),
						String.valueOf(fileEntry.getPrimaryKey()),
						userRole.getRoleId(),
						viewAccess
					);
			} catch (Exception e) {
				log.error(e);
			} finally {
				PermissionThreadLocal.setPermissionChecker(originalPermissionChecker);
			}

		}
		
		return fileEntry;
	}
	
	protected static Folder getFolder(User adminUser, long groupId, String folderName)
			throws PortalException {
		Folder folder = null;
		try {
			folder = DLAppLocalServiceUtil.getFolder(
					groupId,
					DLFolderConstants.DEFAULT_PARENT_FOLDER_ID,
					folderName);
		} catch (NoSuchFolderException e) {
			log.warn("Folder with name " + folderName + "doesn't exist.");
			log.warn("Creating folder with name " + folderName);
			
			PermissionChecker originalPermissionChecker = PermissionThreadLocal.getPermissionChecker();
			
			try {
				folder = DLAppLocalServiceUtil.addFolder(
						adminUser.getUserId(),
						groupId,
						DLFolderConstants.DEFAULT_PARENT_FOLDER_ID,
						folderName,
						StringPool.BLANK,
						new ServiceContext());
				
				Role guestRole = RoleLocalServiceUtil.getRole(
						folder.getCompanyId(),
						RoleConstants.GUEST);

				Role userRole = RoleLocalServiceUtil.getRole(
						folder.getCompanyId(),
						RoleConstants.USER);
				
				PermissionThreadLocal.setPermissionChecker(
						PermissionCheckerFactoryUtil.create(adminUser));
				
				ResourcePermissionServiceUtil.setIndividualResourcePermissions(
						groupId,
						folder.getCompanyId(),
						DLFolder.class.getName(),
						String.valueOf(folder.getPrimaryKey()),
						guestRole.getRoleId(),
						new String[0]
					);
				
				String[] viewAccess = new String[1];
				viewAccess[0] = ActionKeys.VIEW;
				
				ResourcePermissionServiceUtil.setIndividualResourcePermissions(
						groupId,
						folder.getCompanyId(),
						DLFolder.class.getName(),
						String.valueOf(folder.getPrimaryKey()),
						userRole.getRoleId(),
						viewAccess
					);
				
			} catch (PortalException e1) {
				log.error("Error on create Folder " + folderName + ". " + e.getMessage());
			} finally {
				PermissionThreadLocal.setPermissionChecker(originalPermissionChecker);
			}
		}
		
		return folder;
	}
	
	public static String getFileDownloadURL(ThemeDisplay themeDisplay, long fileEntryId) {
		
		String downloadURL = StringPool.BLANK;
		
		try {
			if (fileEntryId != 0) {
				FileEntry file = DLAppLocalServiceUtil.getFileEntry(fileEntryId);
				if (file != null)
					downloadURL = DLURLHelperUtil.getDownloadURL(
						file, file.getFileVersion(), themeDisplay, StringPool.BLANK, false, true);
			}	
		} catch (PortalException pe) {
			log.error("Can't get file download URL for fileEntryId " + fileEntryId, pe);
		}
		
		
		return downloadURL;
	}
	
	public static void deleteFileEntryIfExists(long fileEntryId) {
		try {
			DLAppLocalServiceUtil.deleteFileEntry(fileEntryId);
		} catch (PortalException e) {
			// File doesn't exist
		}
	}
}
