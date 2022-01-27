SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema keeper
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema keeper
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `attackDB` DEFAULT CHARACTER SET utf8 COLLATE utf8_bin ;
USE `attackDB` ;

-- -----------------------------------------------------
-- Table `attackDB`.`ip`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `attackDB`.`ip` ;

CREATE TABLE IF NOT EXISTS `attackDB`.`ip` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `ip` TEXT NOT NULL,
  `connection_date` TEXT NOT NULL,
  PRIMARY KEY (`id`));