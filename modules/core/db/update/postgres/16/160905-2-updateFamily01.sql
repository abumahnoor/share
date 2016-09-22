alter table YESS_FAMILY add column FAMILY_IDENTITY_CARD_NUMBER varchar(30) not null default '' ;
alter table YESS_FAMILY add column FAMILY_HEAD_DEATH_DATE date ;
alter table YESS_FAMILY drop column NATIONAL_ID_CARD_NUMBER cascade ;
