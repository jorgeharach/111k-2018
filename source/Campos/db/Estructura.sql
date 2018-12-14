-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: campos
-- ------------------------------------------------------
-- Server version	5.7.23

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `campo`
--

DROP TABLE IF EXISTS `campo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `campo` (
  `CAM_ID` int(11) NOT NULL AUTO_INCREMENT,
  `CAM_NOMBRE` varchar(45) NOT NULL,
  `CAM_ID_ESTADO` int(11) NOT NULL,
  PRIMARY KEY (`CAM_ID`),
  UNIQUE KEY `CAM_NOMBRE_UNIQUE` (`CAM_NOMBRE`),
  KEY `FK_CAMPO_ESTADO_CAMPO_idx` (`CAM_ID_ESTADO`),
  CONSTRAINT `FK_CAMPO_ESTADO_CAMPO` FOREIGN KEY (`CAM_ID_ESTADO`) REFERENCES `estado_campo` (`ESC_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1 COMMENT='Almacena los distintos Campos gestionados por el sistema';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `estado_campo`
--

DROP TABLE IF EXISTS `estado_campo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `estado_campo` (
  `ESC_ID` int(11) NOT NULL AUTO_INCREMENT,
  `ESC_NOMBRE` varchar(45) NOT NULL,
  `ESC_DESCRIPCION` mediumtext,
  PRIMARY KEY (`ESC_ID`),
  UNIQUE KEY `ESC_NOMBRE_UNIQUE` (`ESC_NOMBRE`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1 COMMENT='Representa los estados posibles de los campos';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `lote`
--

DROP TABLE IF EXISTS `lote`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `lote` (
  `LOT_ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `LOT_NRO_LOTE` int(10) unsigned NOT NULL,
  `LOT_ID_CAMPO` int(11) NOT NULL,
  `LOT_SUPERFICIE` double NOT NULL,
  `LOT_TIPO_SUELO` int(10) unsigned NOT NULL,
  PRIMARY KEY (`LOT_ID`),
  KEY `FK_LOTE_CAMPO_idx` (`LOT_ID_CAMPO`),
  KEY `FK_LOTE_TIPO_SUELO_idx` (`LOT_TIPO_SUELO`),
  CONSTRAINT `FK_LOTE_CAMPO` FOREIGN KEY (`LOT_ID_CAMPO`) REFERENCES `campo` (`CAM_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_LOTE_TIPO_SUELO` FOREIGN KEY (`LOT_TIPO_SUELO`) REFERENCES `tipo_suelo` (`TIS_NUMERO`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1 COMMENT='Representa los distintos lotes que forman parte de los campos gestionados por el sistema';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tipo_suelo`
--

DROP TABLE IF EXISTS `tipo_suelo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tipo_suelo` (
  `TIS_NUMERO` int(10) unsigned NOT NULL,
  `TIS_DESCRIPCION` varchar(45) NOT NULL,
  PRIMARY KEY (`TIS_NUMERO`),
  UNIQUE KEY `TIS_NOMBRE_UNIQUE` (`TIS_DESCRIPCION`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Los distintos tipos de suelo, tipificados a nivel nacional';
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-12-14  1:49:42
