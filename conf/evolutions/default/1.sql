# Countries schema

# --- !Ups
CREATE TABLE country (
    id bigint(20) NOT NULL AUTO_INCREMENT,
    name varchar(255) NOT NULL,
    capital varchar(255) NOT NULL,
    PRIMARY KEY (id)
);

# --- !Downs
DROP TABLE country
