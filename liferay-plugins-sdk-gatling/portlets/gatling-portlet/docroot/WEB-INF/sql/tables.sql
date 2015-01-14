create table GatlingTool_LinkUsecaseRequest (
	linkUsecaseRequestId LONG not null primary key,
	requestId LONG,
	recordId LONG,
	weight DOUBLE,
	sample BOOLEAN
);

create table GatlingTool_Record (
	recordId LONG not null primary key,
	portletId VARCHAR(75) null,
	versionPortlet VARCHAR(75) null,
	name VARCHAR(75) null
);

create table GatlingTool_Request (
	requestId LONG not null primary key,
	scenarioId LONG,
	name VARCHAR(75) null,
	url VARCHAR(75) null,
	weight DOUBLE,
	privatePage BOOLEAN,
	parentPlId LONG,
	layoutId LONG,
	plId LONG,
	portlet BOOLEAN,
	portetId VARCHAR(75) null
);

create table GatlingTool_Scenario (
	scenarioId LONG not null primary key,
	name VARCHAR(75) null,
	urlSite VARCHAR(75) null,
	group_id LONG,
	simulationId LONG,
	numberOfUsers LONG,
	duration LONG
);

create table GatlingTool_Simulation (
	simulationId LONG not null primary key,
	name VARCHAR(75) null,
	feederContent VARCHAR(75) null,
	isFeederAFile BOOLEAN
);

create table GatlingTool_UrlRecord (
	urlRecordId LONG not null primary key,
	recordId LONG,
	url VARCHAR(75) null,
	type_ VARCHAR(75) null,
	order_ INTEGER
);