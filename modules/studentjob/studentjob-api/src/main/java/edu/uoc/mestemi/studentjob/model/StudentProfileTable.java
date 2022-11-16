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
 * The table class for the &quot;SJob_StudentProfile&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see StudentProfile
 * @generated
 */
public class StudentProfileTable extends BaseTable<StudentProfileTable> {

	public static final StudentProfileTable INSTANCE =
		new StudentProfileTable();

	public final Column<StudentProfileTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<StudentProfileTable, Long> studentProfileId =
		createColumn(
			"studentProfileId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<StudentProfileTable, Long> regionId = createColumn(
		"regionId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<StudentProfileTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<StudentProfileTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<StudentProfileTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<StudentProfileTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<StudentProfileTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<StudentProfileTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<StudentProfileTable, Boolean> active = createColumn(
		"active_", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<StudentProfileTable, String> title = createColumn(
		"title", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<StudentProfileTable, String> description = createColumn(
		"description", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<StudentProfileTable, String> email = createColumn(
		"email", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<StudentProfileTable, String> preference = createColumn(
		"preference", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<StudentProfileTable, Long> curriculumId = createColumn(
		"curriculumId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private StudentProfileTable() {
		super("SJob_StudentProfile", StudentProfileTable::new);
	}

}