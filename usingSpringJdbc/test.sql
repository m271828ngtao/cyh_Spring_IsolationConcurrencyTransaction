
DROP DATABASE IF EXISTS cyhTest;
CREATE DATABASE cyhTest;

USE cyhTest;

DROP TABLE IF EXISTS employee;

CREATE TABLE employee(
  id INTEGER NOT NULL,
  money INTEGER,
  version INTEGER,
  PRIMARY KEY (id)
);

INSERT INTO employee VALUE (1, 0, 1);
