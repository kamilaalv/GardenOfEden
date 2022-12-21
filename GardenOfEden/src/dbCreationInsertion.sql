CREATE SCHEMA `eden` ;

CREATE TABLE `eden`.`inventory` (
  `ItemId` INT(5) NOT NULL,
  `Name` VARCHAR(45) NOT NULL,
  `Quantity` INT(11) NOT NULL DEFAULT 40,
  `DateBought` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`ItemId`),
  UNIQUE INDEX `ItemId_UNIQUE` (`ItemId` ASC));

INSERT INTO `eden`.`inventory` (`ItemId`, `Name`, `Quantity`) VALUES ('100', 'Rose', '100');
INSERT INTO `eden`.`inventory` (`ItemId`, `Name`, `Quantity`) VALUES ('101', 'Tulip', '70');
INSERT INTO `eden`.`inventory` (`ItemId`, `Name`, `Quantity`) VALUES ('102', 'Daffodil', '40');
INSERT INTO `eden`.`inventory` (`ItemId`, `Name`, `Quantity`) VALUES ('103', 'Hyacinth', '40');
INSERT INTO `eden`.`inventory` (`ItemId`, `Name`, `Quantity`) VALUES ('105', 'Lilac', '40');
INSERT INTO `eden`.`inventory` (`ItemId`, `Name`, `Quantity`) VALUES ('106', 'Peony', '70');
INSERT INTO `eden`.`inventory` (`ItemId`, `Name`, `Quantity`) VALUES ('107', 'Daisy', '40');
INSERT INTO `eden`.`inventory` (`ItemId`, `Name`, `Quantity`) VALUES ('108', 'Lily', '40');
--INSERT INTO `eden`.`inventory` (`ItemId`, `Name`, `Quantity`) VALUES ('109', 'Baby\'s Breath', '150'); 
--there is no error in mysql, i put it in comment for now. uncomment it before running the script
INSERT INTO `eden`.`inventory` (`ItemId`, `Name`, `Quantity`) VALUES ('110', 'Freesia', '40');
INSERT INTO `eden`.`inventory` (`ItemId`, `Name`, `Quantity`) VALUES ('111', 'Chrysanthemum', '40');
INSERT INTO `eden`.`inventory` (`ItemId`, `Name`, `Quantity`) VALUES ('112', 'Gladiolus', '50');

CREATE TABLE `eden`.`jewelry_inventory` (
  `JName` VARCHAR(20) NOT NULL,
  `Quanttity` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`JName`),
  UNIQUE INDEX `Name_UNIQUE` (`JName` ASC));

INSERT INTO `eden`.`jewelry_inventory` (`JName`, `Quanttity`) VALUES ('Earings', '30');
INSERT INTO `eden`.`jewelry_inventory` (`JName`, `Quanttity`) VALUES ('Bracelet', '30');
INSERT INTO `eden`.`jewelry_inventory` (`JName`, `Quanttity`) VALUES ('Necklace', '35');
INSERT INTO `eden`.`jewelry_inventory` (`JName`, `Quanttity`) VALUES ('Headwear', '35');

CREATE TABLE `eden`.`users` (
  `Uname` VARCHAR(20) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `money` DOUBLE NOT NULL DEFAULT 0,
  PRIMARY KEY (`Uname`),
  UNIQUE INDEX `Uname_UNIQUE` (`Uname` ASC));

INSERT INTO `eden`.`users` (`Uname`, `password`, `money`) VALUES ('admin', 'password', '1000');

COMMIT;