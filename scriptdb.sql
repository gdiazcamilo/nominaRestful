-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema nominadb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema nominadb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `nominadb` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `nominadb` ;

-- -----------------------------------------------------
-- Table `nominadb`.`empleados`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `nominadb`.`empleados` (
  `idempleados` INT NOT NULL AUTO_INCREMENT,
  `cedula` VARCHAR(45) NULL,
  `nombre` VARCHAR(45) NULL,
  `departamento` VARCHAR(45) NULL,
  `puesto` VARCHAR(45) NULL,
  `salario` DECIMAL NULL,
  `nominaid` INT NOT NULL,
  PRIMARY KEY (`idempleados`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `nominadb`.`tipoTransaccion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `nominadb`.`tipoTransaccion` (
  `idtipoTransaccion` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  `dependeSalario` BIT NULL,
  `Estado` BIT NULL,
  `codigo` VARCHAR(45) NULL,
  PRIMARY KEY (`idtipoTransaccion`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `nominadb`.`tipoDeduccion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `nominadb`.`tipoDeduccion` (
  `idtipoDeduccion` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  `dependeSalario` BIT NULL,
  `Estado` BIT NULL,
  PRIMARY KEY (`idtipoDeduccion`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `nominadb`.`nomina`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `nominadb`.`nomina` (
  `idnomina` INT NOT NULL AUTO_INCREMENT,
  `fechaPago` DATETIME NULL,
  `estado` INT NULL,
  PRIMARY KEY (`idnomina`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `nominadb`.`transactions`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `nominadb`.`transactions` (
  `idtransactions` INT NOT NULL AUTO_INCREMENT,
  `empladoid` INT NULL,
  `tipoTransaccion` INT NULL,
  `fecha` DATETIME NULL,
  `monto` DECIMAL NULL,
  `estado` BIT NULL,
  `nominaid` INT NULL,
  PRIMARY KEY (`idtransactions`),
  INDEX `trx_tipotrx_idx` (`tipoTransaccion` ASC),
  INDEX `trx_empleado_idx` (`empladoid` ASC),
  INDEX `nomina_transaccion_idx` (`nominaid` ASC),
  CONSTRAINT `trx_tipotrx`
    FOREIGN KEY (`tipoTransaccion`)
    REFERENCES `nominadb`.`tipoTransaccion` (`idtipoTransaccion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `trx_empleado`
    FOREIGN KEY (`empladoid`)
    REFERENCES `nominadb`.`empleados` (`idempleados`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `nomina_transaccion`
    FOREIGN KEY (`nominaid`)
    REFERENCES `nominadb`.`nomina` (`idnomina`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `nominadb`.`asientosContables`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `nominadb`.`asientosContables` (
  `idasientosContables` INT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(45) NULL,
  `cuenta` VARCHAR(45) NULL,
  `tipoMovimiento` VARCHAR(45) NULL,
  `fecha` DATETIME NULL,
  `monto` DECIMAL NULL,
  `estado` BIT NULL,
  `trasaccionId` INT NULL,
  PRIMARY KEY (`idasientosContables`),
  INDEX `transaccion_asiento_idx` (`trasaccionId` ASC),
  CONSTRAINT `transaccion_asiento`
    FOREIGN KEY (`trasaccionId`)
    REFERENCES `nominadb`.`transactions` (`idtransactions`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
