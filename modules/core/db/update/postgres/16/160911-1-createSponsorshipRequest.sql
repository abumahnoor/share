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
);
