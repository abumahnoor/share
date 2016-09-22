alter table YESS_FAMILY add constraint FK_YESS_FAMILY_CITY_ID foreign key (CITY_ID) references YESS_CITY(ID);
create index IDX_YESS_FAMILY_CITY on YESS_FAMILY (CITY_ID);
