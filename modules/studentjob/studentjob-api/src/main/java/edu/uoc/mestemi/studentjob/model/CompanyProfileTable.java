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

import java.util.Date;

/**
 * The table class for the &quot;SJob_CompanyProfile&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see CompanyProfile
 * @generated
 */
public class CompanyProfileTable extends BaseTable<CompanyProfileTable> {

	public static final CompanyProfileTable INSTANCE =
		new CompanyProfileTable();

	public final Column<CompanyProfileTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CompanyProfileTable, Long> companyProfileId =
		createColumn(
			"companyProfileId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<CompanyProfileTable, Long> regionId = createColumn(
		"regionId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CompanyProfileTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CompanyProfileTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CompanyProfileTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CompanyProfileTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CompanyProfileTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<CompanyProfileTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<CompanyProfileTable, Boolean> active = createColumn(
		"active_", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<CompanyProfileTable, String> title = createColumn(
		"title", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CompanyProfileTable, String> description = createColumn(
		"description", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CompanyProfileTable, String> email = createColumn(
		"email", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CompanyProfileTable, String> sector = createColumn(
		"sector", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CompanyProfileTable, String> website = createColumn(
		"website", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private CompanyProfileTable() {
		super("SJob_CompanyProfile", CompanyProfileTable::new);
	}

}