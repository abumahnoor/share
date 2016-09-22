alter table YESS_INCIDENT add constraint FK_YESS_INCIDENT_CITY_ID foreign key (CITY_ID) references YESS_POSTAL_CODES(ID);
create index IDX_YESS_INCIDENT_CITY on YESS_INCIDENT (CITY_ID);
