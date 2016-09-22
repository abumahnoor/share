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
    NATIONAL_ID_CARD_NUMBER varchar(30) not null,
    SYED_FLAG boolean,
    STREE_ADDRESS varchar(255),
    CITY_ID uuid,
    POSTAL_CODE varchar(10),
    CELL_PHONE varchar(15),
    ADDITIONAL_CONTACTS varchar(255),
    --
    primary key (ID)
);
