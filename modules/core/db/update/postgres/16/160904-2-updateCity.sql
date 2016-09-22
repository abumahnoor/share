-- update YESS_CITY set REGION_ID = <default_value> where REGION_ID is null ;
alter table YESS_CITY alter column REGION_ID set not null ;
