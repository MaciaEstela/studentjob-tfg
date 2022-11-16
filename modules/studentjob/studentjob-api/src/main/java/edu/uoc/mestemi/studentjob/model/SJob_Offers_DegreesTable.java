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
 * The table class for the &quot;SJob_Offers_Degrees&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Degree
 * @see Offer
 * @generated
 */
public class SJob_Offers_DegreesTable
	extends BaseTable<SJob_Offers_DegreesTable> {

	public static final SJob_Offers_DegreesTable INSTANCE =
		new SJob_Offers_DegreesTable();

	public final Column<SJob_Offers_DegreesTable, Long> companyId =
		createColumn(
			"companyId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<SJob_Offers_DegreesTable, Long> degreeId = createColumn(
		"degreeId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<SJob_Offers_DegreesTable, Long> offerId = createColumn(
		"offerId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);

	private SJob_Offers_DegreesTable() {
		super("SJob_Offers_Degrees", SJob_Offers_DegreesTable::new);
	}

}