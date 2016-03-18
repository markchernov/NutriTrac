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
  `id` INT NOT NULL AUTO_INCREMENT,
  `nutrient_id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `grp` VARCHAR(45) NULL,
  `unit` VARCHAR(45) NULL,
  `value` VARCHAR(45) NULL,
  `ndbno` INT NULL,
  PRIMARY KEY (`id`),
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
-- Table `measure`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `measure` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `measure` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `label` VARCHAR(140) NULL,
  `eqv` FLOAT NULL,
  `qty` FLOAT NULL,
  `value` VARCHAR(45) NULL,
  `ndbno_id` INT NULL,
  `nutrient_id` INT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK_measures_foodId`
    FOREIGN KEY (`ndbno_id`)
    REFERENCES `food` (`ndbno`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_measures_nutrientId`
    FOREIGN KEY (`nutrient_id`)
    REFERENCES `nutrient` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;
CREATE INDEX `FK_measures_foodId_idx` ON `measure` (`ndbno_id` ASC);

SHOW WARNINGS;
CREATE INDEX `FK_measures_nutrientId_idx` ON `measure` (`nutrient_id` ASC);

SHOW WARNINGS;

-- -----------------------------------------------------
-- Data for table `food`
-- -----------------------------------------------------
START TRANSACTION;
USE `foodtracdb`;
INSERT INTO `food` (`ndbno`, `name`) VALUES (01225, 'Dulce de Leche');

COMMIT;


-- -----------------------------------------------------
-- Data for table `nutrient`
-- -----------------------------------------------------
START TRANSACTION;
USE `foodtracdb`;
INSERT INTO `nutrient` (`id`, `nutrient_id`, `name`, `grp`, `unit`, `value`, `ndbno`) VALUES (1, 255, 'Water', 'Proximates', 'g', '28.71', 1);
INSERT INTO `nutrient` (`id`, `nutrient_id`, `name`, `grp`, `unit`, `value`, `ndbno`) VALUES (2, 208, 'Energy', 'Proximates', 'kcal', '315', 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `measure`
-- -----------------------------------------------------
START TRANSACTION;
USE `foodtracdb`;
INSERT INTO `measure` (`id`, `label`, `eqv`, `qty`, `value`, `ndbno_id`, `nutrient_id`) VALUES (1, 'tbsp', 19.0, 1.0, '5.45', 1, 1);
INSERT INTO `measure` (`id`, `label`, `eqv`, `qty`, `value`, `ndbno_id`, `nutrient_id`) VALUES (2, 'tbsp', 19.0, 1.0, '60', 1, 2);

COMMIT;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
