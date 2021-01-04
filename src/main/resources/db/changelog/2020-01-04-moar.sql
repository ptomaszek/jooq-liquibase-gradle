--liquibase formatted sql
--changeset ptomaszek:moar
CREATE TABLE person
(
    id      VARCHAR(64) PRIMARY KEY,
    name    VARCHAR(64) NOT NULL UNIQUE,
    address VARCHAR(64) NOT NULL REFERENCES address
);

DROP TABLE car;
