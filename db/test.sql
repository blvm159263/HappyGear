-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema happygear
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema happygear
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `happygear` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `happygear` ;

-- -----------------------------------------------------
-- Table `happygear`.`tbl_brand`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `happygear`.`tbl_brand` (
  `brand_id` BIGINT NOT NULL AUTO_INCREMENT,
  `brand_name` VARCHAR(100) CHARACTER SET 'utf8mb3' NULL DEFAULT NULL,
  `status` TINYINT(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`brand_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `happygear`.`tbl_category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `happygear`.`tbl_category` (
  `category_id` BIGINT NOT NULL AUTO_INCREMENT,
  `category_name` VARCHAR(100) CHARACTER SET 'utf8mb3' NOT NULL,
  `status` TINYINT(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`category_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `happygear`.`tbl_role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `happygear`.`tbl_role` (
  `role_id` INT NOT NULL AUTO_INCREMENT,
  `role_name` VARCHAR(50) CHARACTER SET 'utf8mb3' NOT NULL,
  `status` TINYINT(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`role_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `happygear`.`tbl_user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `happygear`.`tbl_user` (
  `user_name` VARCHAR(100) CHARACTER SET 'utf8mb3' NOT NULL,
  `full_name` VARCHAR(50) CHARACTER SET 'utf8mb3' NOT NULL,
  `password` VARCHAR(150) CHARACTER SET 'utf8mb3' NOT NULL,
  `address` VARCHAR(150) CHARACTER SET 'utf8mb3' NOT NULL,
  `email` VARCHAR(100) CHARACTER SET 'utf8mb3' NOT NULL,
  `phone_number` VARCHAR(100) CHARACTER SET 'utf8mb3' NOT NULL,
  `role_id` INT NULL DEFAULT NULL,
  `gender` TINYINT(1) NOT NULL,
  `status` TINYINT(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`user_name`),
  INDEX `role_id` (`role_id` ASC) VISIBLE,
  CONSTRAINT `tbl_user_ibfk_1`
    FOREIGN KEY (`role_id`)
    REFERENCES `happygear`.`tbl_role` (`role_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `happygear`.`tbl_product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `happygear`.`tbl_product` (
  `product_id` BIGINT NOT NULL AUTO_INCREMENT,
  `product_name` VARCHAR(100) CHARACTER SET 'utf8mb3' NOT NULL,
  `price` DOUBLE NULL DEFAULT NULL,
  `quantity` INT NULL DEFAULT NULL,
  `insurance_info` VARCHAR(500) CHARACTER SET 'utf8mb3' NOT NULL,
  `status` TINYINT(1) NOT NULL DEFAULT '1',
  `category_id` BIGINT NOT NULL,
  `brand_id` BIGINT NOT NULL,
  PRIMARY KEY (`product_id`),
  UNIQUE INDEX `product_id` (`product_id` ASC) VISIBLE,
  INDEX `category_id` (`category_id` ASC) VISIBLE,
  INDEX `brand_id` (`brand_id` ASC) VISIBLE,
  CONSTRAINT `tbl_product_ibfk_1`
    FOREIGN KEY (`category_id`)
    REFERENCES `happygear`.`tbl_category` (`category_id`),
  CONSTRAINT `tbl_product_ibfk_2`
    FOREIGN KEY (`brand_id`)
    REFERENCES `happygear`.`tbl_brand` (`brand_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `happygear`.`tbl_comment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `happygear`.`tbl_comment` (
  `comment_id` BIGINT NOT NULL AUTO_INCREMENT,
  `content` VARCHAR(1000) CHARACTER SET 'utf8mb3' NULL DEFAULT NULL,
  `user_name` VARCHAR(100) CHARACTER SET 'utf8mb3' NOT NULL,
  `product_id` BIGINT NOT NULL,
  PRIMARY KEY (`comment_id`),
  INDEX `user_name` (`user_name` ASC) VISIBLE,
  INDEX `product_id` (`product_id` ASC) VISIBLE,
  CONSTRAINT `tbl_comment_ibfk_1`
    FOREIGN KEY (`user_name`)
    REFERENCES `happygear`.`tbl_user` (`user_name`),
  CONSTRAINT `tbl_comment_ibfk_2`
    FOREIGN KEY (`product_id`)
    REFERENCES `happygear`.`tbl_product` (`product_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `happygear`.`tbl_order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `happygear`.`tbl_order` (
  `order_id` BIGINT NOT NULL AUTO_INCREMENT,
  `user_name` VARCHAR(100) CHARACTER SET 'utf8mb3' NOT NULL,
  `date` DATE NULL DEFAULT NULL,
  `total` DOUBLE NULL DEFAULT NULL,
  `status` INT NOT NULL DEFAULT '0',
  PRIMARY KEY (`order_id`),
  INDEX `user_name` (`user_name` ASC) VISIBLE,
  CONSTRAINT `tbl_order_ibfk_1`
    FOREIGN KEY (`user_name`)
    REFERENCES `happygear`.`tbl_user` (`user_name`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `happygear`.`tbl_order_detail`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `happygear`.`tbl_order_detail` (
  `detail_id` BIGINT NOT NULL AUTO_INCREMENT,
  `order_id` BIGINT NOT NULL,
  `price` DOUBLE NULL DEFAULT NULL,
  `quantity` INT NULL DEFAULT NULL,
  `status` TINYINT(1) NOT NULL DEFAULT '1',
  `product_id` BIGINT NOT NULL,
  PRIMARY KEY (`detail_id`),
  INDEX `order_id` (`order_id` ASC) VISIBLE,
  INDEX `product_id` (`product_id` ASC) VISIBLE,
  CONSTRAINT `tbl_order_detail_ibfk_1`
    FOREIGN KEY (`order_id`)
    REFERENCES `happygear`.`tbl_order` (`order_id`),
  CONSTRAINT `tbl_order_detail_ibfk_2`
    FOREIGN KEY (`product_id`)
    REFERENCES `happygear`.`tbl_product` (`product_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `happygear`.`tbl_product_description`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `happygear`.`tbl_product_description` (
  `product_id` BIGINT NOT NULL AUTO_INCREMENT,
  `category_id` BIGINT NOT NULL,
  `keycap` VARCHAR(50) NULL DEFAULT NULL,
  `switch` VARCHAR(50) NULL DEFAULT NULL,
  `type_keyboard` VARCHAR(50) NULL DEFAULT NULL,
  `connect` VARCHAR(50) NULL DEFAULT NULL,
  `led` VARCHAR(50) NULL DEFAULT NULL,
  `freigh` VARCHAR(50) NULL DEFAULT NULL,
  `item_dimensions` VARCHAR(50) NULL DEFAULT NULL,
  `cpu` VARCHAR(50) NULL DEFAULT NULL,
  `ram` VARCHAR(50) NULL DEFAULT NULL,
  `operating_system` VARCHAR(50) NULL DEFAULT NULL,
  `battery` VARCHAR(50) NULL DEFAULT NULL,
  `hard_disk` VARCHAR(50) NULL DEFAULT NULL,
  `graphic_card` VARCHAR(50) NULL DEFAULT NULL,
  `key_board` VARCHAR(50) NULL DEFAULT NULL,
  `audio` VARCHAR(50) NULL DEFAULT NULL,
  `wifi` VARCHAR(50) NULL DEFAULT NULL,
  `bluetooth` VARCHAR(50) NULL DEFAULT NULL,
  `color` VARCHAR(50) NULL DEFAULT NULL,
  `frame_rate` VARCHAR(50) NULL DEFAULT NULL,
  `screen_size` VARCHAR(50) NULL DEFAULT NULL,
  `screen_type` VARCHAR(50) NULL DEFAULT NULL,
  UNIQUE INDEX `product_id` (`product_id` ASC) VISIBLE,
  INDEX `category_id` (`category_id` ASC) VISIBLE,
  PRIMARY KEY (`product_id`),
  CONSTRAINT `tbl_product_description_ibfk_1`
    FOREIGN KEY (`product_id`)
    REFERENCES `happygear`.`tbl_product` (`product_id`),
  CONSTRAINT `tbl_product_description_ibfk_2`
    FOREIGN KEY (`category_id`)
    REFERENCES `happygear`.`tbl_category` (`category_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `happygear`.`tbl_product_picture`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `happygear`.`tbl_product_picture` (
  `picture_id` BIGINT NOT NULL AUTO_INCREMENT,
  `picture_url` VARCHAR(300) CHARACTER SET 'utf8mb3' NULL DEFAULT NULL,
  `product_id` BIGINT NOT NULL,
  `status` TINYINT(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`picture_id`),
  INDEX `product_id` (`product_id` ASC) VISIBLE,
  CONSTRAINT `tbl_product_picture_ibfk_1`
    FOREIGN KEY (`product_id`)
    REFERENCES `happygear`.`tbl_product` (`product_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
