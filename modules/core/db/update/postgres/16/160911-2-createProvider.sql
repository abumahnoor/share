alter table YESS_PROVIDER add constraint FK_YESS_PROVIDER_CITY_ID foreign key (CITY_ID) references YESS_CITY(ID);
create index IDX_YESS_PROVIDER_CITY on YESS_PROVIDER (CITY_ID);
