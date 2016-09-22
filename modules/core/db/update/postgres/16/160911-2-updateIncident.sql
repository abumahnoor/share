alter table YESS_INCIDENT add column INCIDENT_NAME varchar(255) not null default '' ;
alter table YESS_INCIDENT drop column INCIDENT_TITLE cascade ;
