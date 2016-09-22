create table YESS_REGION (
    ID integer,
    UUID uuid not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    --
    REGION_NAME varchar(50),
    --
    primary key (ID)
);
