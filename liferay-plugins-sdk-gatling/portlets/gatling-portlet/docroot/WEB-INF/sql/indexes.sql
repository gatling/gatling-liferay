create index IX_FE05BE4F on GatlingTool_LinkUsecaseRequest (recordId);
create index IX_B9F1620B on GatlingTool_LinkUsecaseRequest (requestId);
create index IX_41B12D8B on GatlingTool_LinkUsecaseRequest (requestId, recordId);
create index IX_E58F4EF7 on GatlingTool_LinkUsecaseRequest (requestId, weight);

create index IX_2DFA4377 on GatlingTool_Record (portletId);

create index IX_CBC29F93 on GatlingTool_Request (parentPlId);
create index IX_D0B45F92 on GatlingTool_Request (parentPlId, scenarioId);
create index IX_55E5CDDD on GatlingTool_Request (scenarioId);
create index IX_6CD3C16D on GatlingTool_Request (scenarioId, portlet);
create index IX_BDD52C59 on GatlingTool_Request (scenarioId, portlet, weight);
create index IX_880BC8C9 on GatlingTool_Request (scenarioId, weight);

create index IX_39D81CE3 on GatlingTool_Scenario (simulationId);

create index IX_61D1326F on GatlingTool_UrlRecord (recordId);