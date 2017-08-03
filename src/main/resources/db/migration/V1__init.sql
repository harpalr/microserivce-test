  CREATE TABLE `store` (
  `store_id` INT NOT NULL AUTO_INCREMENT,
  `store_name` VARCHAR(255) NULL,
  `active` TINYINT(1) NULL DEFAULT 1,
  `created_date` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`store_id`));


CREATE TABLE `product` (
  `product_id` INT(11) NOT NULL AUTO_INCREMENT,
  `sku` VARCHAR(10) NULL,
  `product_name` VARCHAR(255) NULL,
  `price` DECIMAL(10,2) NULL,
  `product_description` TEXT NULL,
  `active` TINYINT(1) NULL DEFAULT 1,
  `created_date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  PRIMARY KEY (`product_id`));


CREATE TABLE `stock` (
  `product_id` INT(11) NOT NULL,
  `store_id` INT(11) NOT NULL,
  `count` int(11) DEFAULT 0,
  `created_date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  UNIQUE KEY `stock_unique_keys` (`product_id`, `store_id`));


CREATE TABLE `customer` (
  `customer_id` INT(11) NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(50) NULL,
  `last_name` VARCHAR(50) NULL,
  `email` VARCHAR(100) NULL,
  `phone` VARCHAR(20) NULL,
  `created_date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  PRIMARY KEY (`customer_id`));


CREATE TABLE `orders` (
  `order_id` INT(11) NOT NULL AUTO_INCREMENT,
  `store_id` INT(11) NOT NULL,
  `customer_id` INT(11) NOT NULL,
  `status` VARCHAR(7) NULL,
  `created_date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  PRIMARY KEY (`order_id`));


  CREATE TABLE `order_detail` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `order_id` INT(11) NOT NULL,
  `product_id` INT(11) NOT NULL,
  `quantity` INT(11) NOT NULL,
  `total_amount` DECIMAL (10,2) NULL DEFAULT 0.00,
  `created_date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`));
