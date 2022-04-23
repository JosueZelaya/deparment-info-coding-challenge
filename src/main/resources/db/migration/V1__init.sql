DROP TABLE IF EXISTS DEPARMENTS CASCADE;

CREATE TABLE DEPARTMENTS (
    ID bigint not null,
    NAME varchar(30),
    primary key (ID)
);

INSERT INTO "DEPARTMENTS" (ID, NAME) values (1, 'sales');
INSERT INTO "DEPARTMENTS" (ID, NAME) values (2, 'engineering');