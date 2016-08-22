create unique index IX_5FD9C16F on StressTool_FormParam (urlRecordId);

create unique index IX_3B711FD8 on StressTool_LinkProcessRecord (process_id);
create unique index IX_48C20AB9 on StressTool_LinkProcessRecord (recordId);

create index IX_462AC7AB on StressTool_LinkUsecaseRequest (recordId);
create index IX_587C282A on StressTool_LinkUsecaseRequest (request_id);
create index IX_A5AE18EA on StressTool_LinkUsecaseRequest (request_id, recordId);
create index IX_3C3D8616 on StressTool_LinkUsecaseRequest (request_id, weight);

create index IX_9577D1B8 on StressTool_Process (scenario_id);

create unique index IX_C2CCD189 on StressTool_Record (name);
create index IX_531D7B9B on StressTool_Record (portletId);

create index IX_34F85EB7 on StressTool_Request (parentPlId);
create index IX_7899B483 on StressTool_Request (parentPlId, scenario_id);
create index IX_E7D9A96F on StressTool_Request (parentPlId, scenario_id, weight);
create index IX_2C404E63 on StressTool_Request (portletId);
create index IX_258F3998 on StressTool_Request (scenario_id);
create index IX_4F385812 on StressTool_Request (scenario_id, portlet);
create index IX_A55F4DFE on StressTool_Request (scenario_id, portlet, weight);
create index IX_87174984 on StressTool_Request (scenario_id, weight);

create index IX_4E9E331A on StressTool_Scenario (simulation_id);

create index IX_CB06F193 on StressTool_UrlRecord (recordId);