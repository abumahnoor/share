alter table YESS_REGION add column UUID uuid not null default newid() ;
alter table YESS_REGION drop column VERSION cascade ;
alter table YESS_REGION drop column UPDATE_TS cascade ;
alter table YESS_REGION drop column UPDATED_BY cascade ;
alter table YESS_REGION drop column DELETE_TS cascade ;
alter table YESS_REGION drop column DELETED_BY cascade ;
alter table YESS_REGION alter column REGION_NAME set data type varchar(50) ;
