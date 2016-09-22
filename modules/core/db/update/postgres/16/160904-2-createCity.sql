alter table YESS_CITY add constraint FK_YESS_CITY_REGION_ID foreign key (REGION_ID) references YESS_REGION(ID);
create index IDX_YESS_CITY_REGION on YESS_CITY (REGION_ID);
