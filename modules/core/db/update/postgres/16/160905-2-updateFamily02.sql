alter table YESS_FAMILY add column CONTACT_PHONE varchar(15) ;
alter table YESS_FAMILY drop column CELL_PHONE cascade ;
alter table YESS_FAMILY alter column ADDITIONAL_CONTACTS set data type text ;
