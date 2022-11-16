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
 * The table class for the &quot;SJob_SocialMedia&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see SocialMedia
 * @generated
 */
public class SocialMediaTable extends BaseTable<SocialMediaTable> {

	public static final SocialMediaTable INSTANCE = new SocialMediaTable();

	public final Column<SocialMediaTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SocialMediaTable, Long> socialMediaId = createColumn(
		"socialMediaId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<SocialMediaTable, Long> socialMediaNetworkId =
		createColumn(
			"socialMediaNetworkId", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<SocialMediaTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SocialMediaTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SocialMediaTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SocialMediaTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SocialMediaTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<SocialMediaTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<SocialMediaTable, String> socialMediaType =
		createColumn(
			"socialMediaType", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<SocialMediaTable, String> socialURL = createColumn(
		"socialURL", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SocialMediaTable, String> className = createColumn(
		"className", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SocialMediaTable, Long> classPK = createColumn(
		"classPK", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private SocialMediaTable() {
		super("SJob_SocialMedia", SocialMediaTable::new);
	}

}