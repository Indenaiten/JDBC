-- -----------------------------------------------------
-- DROP DATABASE
-- -----------------------------------------------------
DROP DATABASE IF EXISTS ExampleUsers ;

-- -----------------------------------------------------
-- CREATE DATABASE
-- -----------------------------------------------------
CREATE DATABASE ExampleUsers DEFAULT CHARACTER SET utf8;
USE ExampleUsers ;

-- -----------------------------------------------------
-- TABLE users
-- -----------------------------------------------------
CREATE TABLE users(
	id INT NULL AUTO_INCREMENT,
	username VARCHAR(250) NOT NULL,
	name VARCHAR(250) NOT NULL,
	lastname1 VARCHAR(250) NOT NULL,
	lastname2 VARCHAR(250) NOT NULL,
	birthdate DATE NOT NULL,
	active BOOLEAN NOT NULL,
	PRIMARY KEY( id )
) ENGINE = InnoDB;


-- -----------------------------------------------------
-- INSERT USERS
-- -----------------------------------------------------
INSERT INTO users(name, username, lastname1, lastname2, birthdate, active) VALUES
	("pepe19", "Pepe", "Dominguez", "Hernandez", "2000-11-02", 1),
	("luci", "Lucia", "Fernandez", "Lopez", "2000-05-21", 1),
	("sarius", "Sara", "Fernandez", "Estevez", "2000-07-11", 1),
	("sito", "Luis", "Alvarez", "Lopez", "1995-03-30", 1),
	("adri12", "Adrian", "Fernandez", "Lopez", "1996-01-23", 0),
	("nurinu", "Nuria", "Alvarez", "Lopez", "1998-11-02", 1),
	("marquitos", "Marcos", "Arias", "Alvarez", "1998-10-02", 1),
	("micu", "Miguel", "Fernandez", "Lopez", "2001-12-12", 0);
-- -----------------------------------------------------
-- -----------------------------------------------------
-- -----------------------------------------------------