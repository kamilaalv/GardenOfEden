CREATE SCHEMA `eden` ;

CREATE TABLE `eden`.`inventory` (
  `ItemId` INT(5) NOT NULL,
  `Name` VARCHAR(45) NOT NULL,
  `Quantity` INT(11) NOT NULL DEFAULT 40,
  `DateBought` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `inventorycol` VARCHAR(45) NULL,
  PRIMARY KEY (`ItemId`),
  UNIQUE INDEX `ItemId_UNIQUE` (`ItemId` ASC));

  --not finished