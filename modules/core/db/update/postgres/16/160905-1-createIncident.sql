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
    INCIDENT_TITLE varchar(255) not null,
    DESCRIPTION text,
    INCIDENT_REGION_ID integer not null,
    --
    primary key (ID)
);
