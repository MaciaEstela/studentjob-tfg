/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package edu.uoc.mestemi.studentjob.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link StudentProfileService}.
 *
 * @author Brian Wing Shun Chan
 * @see StudentProfileService
 * @generated
 */
public class StudentProfileServiceWrapper
	implements ServiceWrapper<StudentProfileService>, StudentProfileService {

	public StudentProfileServiceWrapper() {
		this(null);
	}

	public StudentProfileServiceWrapper(
		StudentProfileService studentProfileService) {

		_studentProfileService = studentProfileService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _studentProfileService.getOSGiServiceIdentifier();
	}

	@Override
	public StudentProfileService getWrappedService() {
		return _studentProfileService;
	}

	@Override
	public void setWrappedService(StudentProfileService studentProfileService) {
		_studentProfileService = studentProfileService;
	}

	private StudentProfileService _studentProfileService;

}