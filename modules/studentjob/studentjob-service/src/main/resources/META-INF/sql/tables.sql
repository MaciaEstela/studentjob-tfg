create table SJob_CompanyProfile (
	uuid_ VARCHAR(75) null,
	companyProfileId LONG not null primary key,
	regionId LONG,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	active_ BOOLEAN,
	title STRING null,
	description STRING null,
	email VARCHAR(75) null,
	sector STRING null,
	website VARCHAR(75) null
);

create table SJob_Degree (
	uuid_ VARCHAR(75) null,
	degreeId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name STRING null
);

create table SJob_DegreeArea (
	uuid_ VARCHAR(75) null,
	degreeAreaId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	name STRING null
);

create table SJob_Degrees_DegreesAreas (
	companyId LONG not null,
	degreeId LONG not null,
	degreeAreaId LONG not null,
	primary key (degreeId, degreeAreaId)
);

create table SJob_Offer (
	uuid_ VARCHAR(75) null,
	offerId LONG not null primary key,
	provinceId LONG,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name STRING null,
	preference VARCHAR(75) null,
	description STRING null
);

create table SJob_Offers_Degrees (
	companyId LONG not null,
	degreeId LONG not null,
	offerId LONG not null,
	primary key (degreeId, offerId)
);

create table SJob_SocialMedia (
	uuid_ VARCHAR(75) null,
	socialMediaId LONG not null primary key,
	socialMediaNetworkId LONG,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	socialMediaType VARCHAR(75) null,
	socialURL VARCHAR(75) null,
	className VARCHAR(75) null,
	classPK LONG
);

create table SJob_SocialMediaNetwork (
	uuid_ VARCHAR(75) null,
	socialMediaNetworkId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	name VARCHAR(75) null,
	logo LONG,
	baseURL VARCHAR(75) null
);

create table SJob_StudentProfile (
	uuid_ VARCHAR(75) null,
	studentProfileId LONG not null primary key,
	regionId LONG,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	active_ BOOLEAN,
	title STRING null,
	description STRING null,
	email VARCHAR(75) null,
	preference VARCHAR(75) null,
	curriculumId LONG
);

create table SJob_Students_Degrees (
	companyId LONG not null,
	degreeId LONG not null,
	studentProfileId LONG not null,
	primary key (degreeId, studentProfileId)
);

create table SJob_UserEnrollOffer (
	uuid_ VARCHAR(75) null,
	userId LONG not null,
	offerId LONG not null,
	companyId LONG,
	createDate DATE null,
	primary key (userId, offerId)
);