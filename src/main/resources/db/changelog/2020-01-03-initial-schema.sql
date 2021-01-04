--liquibase formatted sql
--changeset ptomaszek:initial-schema
CREATE TABLE address
(
    id    VARCHAR(64) PRIMARY KEY,
    value VARCHAR(64) NOT NULL
);

CREATE TABLE car
(
    id    VARCHAR(64) PRIMARY KEY,
    name VARCHAR(64) NOT NULL
);
