-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema CA2
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema CA2
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `CA2` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `CA2` ;

-- -----------------------------------------------------
-- Table `CA2`.`roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CA2`.`roles` (
  `role_name` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`role_name`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `CA2`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CA2`.`users` (
  `user_name` VARCHAR(25) NOT NULL,
  `user_pass` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`user_name`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `CA2`.`user_roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CA2`.`user_roles` (
  `role_name` VARCHAR(20) NOT NULL,
  `user_name` VARCHAR(25) NOT NULL,
  PRIMARY KEY (`role_name`, `user_name`),
  INDEX `FK_user_roles_user_name` (`user_name` ASC) VISIBLE,
  CONSTRAINT `FK_user_roles_role_name`
    FOREIGN KEY (`role_name`)
    REFERENCES `CA2`.`roles` (`role_name`),
  CONSTRAINT `FK_user_roles_user_name`
    FOREIGN KEY (`user_name`)
    REFERENCES `CA2`.`users` (`user_name`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `CA2`.`restaurant`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CA2`.`restaurant` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `zip` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CA2`.`food`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CA2`.`food` (
  `id` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CA2`.`drink`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CA2`.`drink` (
  `id` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CA2`.`food_menu`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CA2`.`food_menu` (
  `restaurant_id` INT NOT NULL,
  `food_id` INT NOT NULL,
  PRIMARY KEY (`restaurant_id`, `food_id`),
  INDEX `fk_restaurant_has_food_food1_idx` (`food_id` ASC) VISIBLE,
  INDEX `fk_restaurant_has_food_restaurant1_idx` (`restaurant_id` ASC) VISIBLE,
  CONSTRAINT `fk_restaurant_has_food_restaurant1`
    FOREIGN KEY (`restaurant_id`)
    REFERENCES `CA2`.`restaurant` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_restaurant_has_food_food1`
    FOREIGN KEY (`food_id`)
    REFERENCES `CA2`.`food` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CA2`.`drink_menu`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CA2`.`drink_menu` (
  `restaurant_id` INT NOT NULL,
  `drink_id` INT NOT NULL,
  PRIMARY KEY (`restaurant_id`, `drink_id`),
  INDEX `fk_restaurant_has_drink_drink1_idx` (`drink_id` ASC) VISIBLE,
  INDEX `fk_restaurant_has_drink_restaurant1_idx` (`restaurant_id` ASC) VISIBLE,
  CONSTRAINT `fk_restaurant_has_drink_restaurant1`
    FOREIGN KEY (`restaurant_id`)
    REFERENCES `CA2`.`restaurant` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_restaurant_has_drink_drink1`
    FOREIGN KEY (`drink_id`)
    REFERENCES `CA2`.`drink` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
