update YESS_REGION set REGION_NAME = '' where REGION_NAME is null ;
alter table YESS_REGION alter column REGION_NAME set not null ;
