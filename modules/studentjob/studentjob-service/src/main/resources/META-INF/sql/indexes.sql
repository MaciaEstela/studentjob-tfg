create index IX_9C5AB666 on SJob_CompanyProfile (groupId, active_);
create index IX_EC7D313D on SJob_CompanyProfile (groupId, userId);
create index IX_B2939EBB on SJob_CompanyProfile (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_985A97FD on SJob_CompanyProfile (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_183FEAA3 on SJob_Degree (groupId);
create index IX_8822B41B on SJob_Degree (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_DF6F855D on SJob_Degree (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_15675056 on SJob_DegreeArea (groupId);
create index IX_2FD707C8 on SJob_DegreeArea (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_918EE04A on SJob_DegreeArea (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_93EAB876 on SJob_Degrees_DegreesAreas (companyId);
create index IX_2B3C5A5A on SJob_Degrees_DegreesAreas (degreeAreaId);

create index IX_58047857 on SJob_Offer (groupId, userId);
create index IX_B7F53AE1 on SJob_Offer (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_D5A105A3 on SJob_Offer (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_D173262E on SJob_Offers_Degrees (companyId);
create index IX_BC974D8D on SJob_Offers_Degrees (offerId);

create index IX_57E6F8B8 on SJob_SocialMedia (groupId, className[$COLUMN_LENGTH:75$], classPK, socialMediaNetworkId);
create index IX_C7B10120 on SJob_SocialMedia (groupId, className[$COLUMN_LENGTH:75$], classPK, socialURL[$COLUMN_LENGTH:75$]);
create index IX_180743EE on SJob_SocialMedia (socialMediaNetworkId);
create index IX_2283E53C on SJob_SocialMedia (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_A8FC8ABE on SJob_SocialMedia (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_A5F38692 on SJob_SocialMediaNetwork (groupId, userId);
create index IX_27E7F406 on SJob_SocialMediaNetwork (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_6CC9C408 on SJob_SocialMediaNetwork (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_78C3C9E8 on SJob_StudentProfile (groupId, active_);
create index IX_98C2A57B on SJob_StudentProfile (groupId, userId);
create index IX_8EFCB23D on SJob_StudentProfile (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_5396A3FF on SJob_StudentProfile (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_9379160D on SJob_Students_Degrees (companyId);
create index IX_D29F61D8 on SJob_Students_Degrees (studentProfileId);

create index IX_DEE60DB7 on SJob_UserEnrollOffer (groupId, offerId, createDate);
create index IX_4B64637F on SJob_UserEnrollOffer (groupId, userId, offerId);
create unique index IX_7D595C52 on SJob_UserEnrollOffer (uuid_[$COLUMN_LENGTH:75$], groupId);