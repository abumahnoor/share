alter table YESS_INCIDENT add column CITY varchar(255) ;
alter table YESS_INCIDENT drop column CITY_ID cascade ;
alter table YESS_INCIDENT drop column REGION cascade ;
alter table YESS_INCIDENT add column REGION varchar(255) ;
