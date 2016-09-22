-- begin YESS_REGION
create table YESS_REGION (
    ID integer,
    UUID uuid not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    --
    REGION_NAME varchar(50) not null,
    --
    primary key (ID)
)^
-- end YESS_REGION
-- begin YESS_CITY
create table YESS_CITY (
    ID uuid,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    VERSION integer not null,
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    CITY_NAME varchar(255) not null,
    REGION_ID integer not null,
    --
    primary key (ID)
)^
-- end YESS_CITY
-- begin YESS_INCIDENT
create table YESS_INCIDENT (
    ID uuid,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    VERSION integer not null,
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    INCIDENT_DATE date not null,
    INCIDENT_NAME varchar(255) not null,
    DESCRIPTION text,
    INCIDENT_REGION_ID integer not null,
    INCIDENT_CITY_ID uuid,
    INCIDENT_LOCATION varchar(255) not null,
    --
    primary key (ID)
)^
-- end YESS_INCIDENT
-- begin YESS_FAMILY
create table YESS_FAMILY (
    ID uuid,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    VERSION integer not null,
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    FAMILY_HEAD_NAME varchar(255) not null,
    FAMILY_HEAD_BIRTH_DATE date,
    FAMILY_IDENTITY_CARD_NUMBER varchar(30) not null,
    FAMILY_HEAD_DEATH_DATE date,
    IS_SYED boolean,
    STREE_ADDRESS varchar(255),
    CITY_ID uuid,
    POSTAL_CODE varchar(10),
    CONTACT_PHONE varchar(15),
    ADDITIONAL_CONTACTS text,
    DEATH_IN_INCIDENT_ID uuid,
    --
    primary key (ID)
)^
-- end YESS_FAMILY
-- begin YESS_SPONSORED
create table YESS_SPONSORED (
    ID uuid,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    VERSION integer not null,
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    FIRST_NAME varchar(100) not null,
    LAST_NAME varchar(100),
    GENDER varchar(50) not null,
    BIRTH_DATE date not null,
    IS_SYED boolean,
    ADDRESS_LINE1 varchar(100),
    CITY_ID uuid not null,
    POSTAL_CODE varchar(7),
    FAMILY_ID uuid,
    CONTACT_PHONE varchar(15),
    ADDITIONAL_CONTACTS text,
    IS_ACTIVE boolean not null,
    --
    primary key (ID)
)^
-- end YESS_SPONSORED
-- begin YESS_SPONSORSHIP_REQUEST
create table YESS_SPONSORSHIP_REQUEST (
    ID uuid,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    VERSION integer not null,
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    REQUEST_DATE date not null,
    APPLICANT_ID uuid not null,
    NATURE varchar(50) not null,
    REFERENCE_NAME varchar(255),
    REFERENCE_CONTACT text,
    REUQEST_STATUS varchar(50) not null,
    STATUS_CHANGE_DATE date,
    --
    primary key (ID)
)^
-- end YESS_SPONSORSHIP_REQUEST
-- begin YESS_PROVIDER
create table YESS_PROVIDER (
    ID uuid,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    VERSION integer not null,
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    PROVIDER_NAME varchar(255),
    PROVIDER_DESCRIPTION text,
    ADDRESS_LINE1 varchar(255),
    ADDRESS_LINE2 varchar(255),
    CITY_ID uuid,
    NATURE_OF_PROVIDER varchar(50),
    CONTACT_PHONE varchar(15),
    ADDITIONAL_CONTACTS text,
    --
    primary key (ID)
)^
-- end YESS_PROVIDER
