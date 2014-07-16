create table StressTool_Request (
	request_id LONG not null primary key,
	scenario_id LONG,
	url VARCHAR(75) null,
	rate INTEGER
);

create table StressTool_Scenario (
	scenario_id LONG not null primary key,
	name VARCHAR(75) null,
	group_id LONG,
	simulation_id LONG
);

create table StressTool_Simulation (
	simulation_id LONG not null primary key,
	name VARCHAR(75) null
);