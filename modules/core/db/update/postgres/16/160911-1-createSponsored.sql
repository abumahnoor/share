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
    --
    primary key (ID)
);
