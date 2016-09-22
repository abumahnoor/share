create table YESS_POSTAL_CODES (
    ID uuid,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    VERSION integer not null,
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    CITY_CODE integer,
    CITY_NAME varchar(100),
    POSTAL_CODE varchar(15),
    --
    primary key (ID)
);
