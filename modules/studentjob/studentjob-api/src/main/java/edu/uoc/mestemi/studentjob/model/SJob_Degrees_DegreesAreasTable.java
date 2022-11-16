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

package edu.uoc.mestemi.studentjob.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;SJob_Degrees_DegreesAreas&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Degree
 * @see DegreeArea
 * @generated
 */
public class SJob_Degrees_DegreesAreasTable
	extends BaseTable<SJob_Degrees_DegreesAreasTable> {

	public static final SJob_Degrees_DegreesAreasTable INSTANCE =
		new SJob_Degrees_DegreesAreasTable();

	public final Column<SJob_Degrees_DegreesAreasTable, Long> companyId =
		createColumn(
			"companyId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<SJob_Degrees_DegreesAreasTable, Long> degreeId =
		createColumn("degreeId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<SJob_Degrees_DegreesAreasTable, Long> degreeAreaId =
		createColumn(
			"degreeAreaId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);

	private SJob_Degrees_DegreesAreasTable() {
		super("SJob_Degrees_DegreesAreas", SJob_Degrees_DegreesAreasTable::new);
	}

}