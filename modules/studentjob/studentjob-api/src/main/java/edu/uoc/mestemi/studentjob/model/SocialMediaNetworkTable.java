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
 * The table class for the &quot;SJob_SocialMediaNetwork&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see SocialMediaNetwork
 * @generated
 */
public class SocialMediaNetworkTable
	extends BaseTable<SocialMediaNetworkTable> {

	public static final SocialMediaNetworkTable INSTANCE =
		new SocialMediaNetworkTable();

	public final Column<SocialMediaNetworkTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SocialMediaNetworkTable, Long> socialMediaNetworkId =
		createColumn(
			"socialMediaNetworkId", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<SocialMediaNetworkTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SocialMediaNetworkTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SocialMediaNetworkTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SocialMediaNetworkTable, Date> createDate =
		createColumn(
			"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<SocialMediaNetworkTable, Date> modifiedDate =
		createColumn(
			"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<SocialMediaNetworkTable, String> userName =
		createColumn(
			"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SocialMediaNetworkTable, String> name = createColumn(
		"name", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SocialMediaNetworkTable, Long> logo = createColumn(
		"logo", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SocialMediaNetworkTable, String> baseURL = createColumn(
		"baseURL", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private SocialMediaNetworkTable() {
		super("SJob_SocialMediaNetwork", SocialMediaNetworkTable::new);
	}

}