create table StressTool_FormParam (
	formParamId LONG not null primary key,
	urlRecordId LONG,
	data_ TEXT null,
	type_ VARCHAR(75) null
);

create table StressTool_LinkProcessRecord (
	link_process_record_id LONG not null primary key,
	process_id LONG,
	recordId LONG
);

create table StressTool_LinkUsecaseRequest (
	linkUsecaseRequestId LONG not null primary key,
	request_id LONG,
	recordId LONG,
	weight DOUBLE,
	sample BOOLEAN
);

create table StressTool_Process (
	process_id LONG not null primary key,
	name VARCHAR(75) null,
	type_ VARCHAR(75) null,
	order_ INTEGER,
	pause INTEGER,
	scenario_id LONG,
	recordId LONG
);

create table StressTool_Record (
	recordId LONG not null primary key,
	portletId VARCHAR(75) null,
	versionPortlet VARCHAR(75) null,
	name VARCHAR(75) null
);

create table StressTool_Request (
	request_id LONG not null primary key,
	scenario_id LONG,
	weight DOUBLE,
	privatePage BOOLEAN,
	parentPlId LONG,
	layoutId LONG,
	plId LONG,
	portlet BOOLEAN,
	portletId VARCHAR(75) null
);

create table StressTool_Scenario (
	scenario_id LONG not null primary key,
	name VARCHAR(75) null,
	url_site VARCHAR(75) null,
	group_id LONG,
	simulation_id LONG,
	numberOfUsers LONG,
	duration LONG
);

create table StressTool_Simulation (
	simulation_id LONG not null primary key,
	name VARCHAR(75) null,
	feederContent STRING null,
	isFeederAFile BOOLEAN
);

create table StressTool_UrlRecord (
	urlRecordId LONG not null primary key,
	recordId LONG,
	url TEXT null,
	type_ VARCHAR(75) null,
	order_ INTEGER
);