CREATE DATABASE IF NOT EXISTS restaurantedb;

USE restaurantedb;

CREATE TABLE usuarios (
  id_usuarios INT NOT NULL AUTO_INCREMENT,
  password VARCHAR(45) NOT NULL,
  username VARCHAR(45) NOT NULL,
  PRIMARY KEY (id_usuarios),
  UNIQUE INDEX username_UNIQUE (username ASC)
);

INSERT INTO usuarios (username, password)
VALUES ('juanrojas', '1234');