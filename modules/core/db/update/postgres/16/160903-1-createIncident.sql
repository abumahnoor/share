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
    INCIDENT_DATE date,
    ISLAMIC_DATE date,
    INCIDENT_LABEL varchar(255),
    DESCRIPTION text,
    DEATH_TOLL integer,
    INJURED_COUNT integer,
    INCIDENT_ADDRESS1 varchar(255),
    INCIDENT_ADDRESS2 varchar(255),
    REGION integer,
    CITY_ID uuid,
    --
    primary key (ID)
);
