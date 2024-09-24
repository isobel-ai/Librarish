CREATE TABLE library
(
    id           UUID         NOT NULL,
    name         VARCHAR(255) NOT NULL,
    address      VARCHAR(255),
    town_or_city VARCHAR(255),
    postcode     VARCHAR(255),
    CONSTRAINT pk_library PRIMARY KEY (id)
);