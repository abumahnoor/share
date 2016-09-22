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
);
