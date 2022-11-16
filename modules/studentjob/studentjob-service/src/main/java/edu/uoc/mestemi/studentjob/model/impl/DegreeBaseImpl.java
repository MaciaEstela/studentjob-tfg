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

package edu.uoc.mestemi.studentjob.model.impl;

import edu.uoc.mestemi.studentjob.model.Degree;
import edu.uoc.mestemi.studentjob.service.DegreeLocalServiceUtil;

/**
 * The extended model base implementation for the Degree service. Represents a row in the &quot;SJob_Degree&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link DegreeImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DegreeImpl
 * @see Degree
 * @generated
 */
public abstract class DegreeBaseImpl extends DegreeModelImpl implements Degree {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a degree model instance should use the <code>Degree</code> interface instead.
	 */
	@Override
	public void persist() {
		if (this.isNew()) {
			DegreeLocalServiceUtil.addDegree(this);
		}
		else {
			DegreeLocalServiceUtil.updateDegree(this);
		}
	}

}