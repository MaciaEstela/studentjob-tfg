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
 * The table class for the &quot;SJob_UserEnrollOffer&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see UserEnrollOffer
 * @generated
 */
public class UserEnrollOfferTable extends BaseTable<UserEnrollOfferTable> {

	public static final UserEnrollOfferTable INSTANCE =
		new UserEnrollOfferTable();

	public final Column<UserEnrollOfferTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<UserEnrollOfferTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<UserEnrollOfferTable, Long> offerId = createColumn(
		"offerId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<UserEnrollOfferTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<UserEnrollOfferTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private UserEnrollOfferTable() {
		super("SJob_UserEnrollOffer", UserEnrollOfferTable::new);
	}

}