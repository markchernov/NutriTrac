-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema foodtracdb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `foodtracdb` ;

-- -----------------------------------------------------
-- Schema foodtracdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `foodtracdb` DEFAULT CHARACTER SET utf8 ;
SHOW WARNINGS;
USE `foodtracdb` ;

-- -----------------------------------------------------
-- Table `food`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `food` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `food` (
  `ndbno` INT NOT NULL,
  `name` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`ndbno`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `nutrient`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `nutrient` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `nutrient` (
  `nutrient_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `group` VARCHAR(45) NULL,
  `unit_` VARCHAR(45) NULL,
  `value` VARCHAR(45) NULL,
  `ndbno` INT NULL,
  PRIMARY KEY (`nutrient_id`),
  CONSTRAINT `FK_nutrient_food`
    FOREIGN KEY (`ndbno`)
    REFERENCES `food` (`ndbno`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;
CREATE INDEX `FK_nutrient_food_idx` ON `nutrient` (`ndbno` ASC);

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `measures`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `measures` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `measures` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `label` VARCHAR(140) NULL,
  `eqv` FLOAT NULL,
  `qty` FLOAT NULL,
  `value` VARCHAR(45) NULL,
  `ndbno_id` INT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK_measures_foodId`
    FOREIGN KEY (`ndbno_id`)
    REFERENCES `food` (`ndbno`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;
CREATE INDEX `FK_measures_foodId_idx` ON `measures` (`ndbno_id` ASC);

SHOW WARNINGS;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
