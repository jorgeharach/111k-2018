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
-- Dumping data for table `estado_campo`
--

LOCK TABLES `estado_campo` WRITE;
/*!40000 ALTER TABLE `estado_campo` DISABLE KEYS */;
INSERT INTO `estado_campo` VALUES (1,'CREADO','Estado para Campos nuevos'),(2,'PARCIALMENTE TRABAJADO','Cuando al menos un lote tiene un proyecto de cultivo vigente'),(3,'COMPLETAMENTE TRABAJADO','Cuando todos los lotes tienen un proyecto de cultivo vigente'),(4,'DESUSO','Cuando ningún lote del campo tiene proyectos de cultivo');
/*!40000 ALTER TABLE `estado_campo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `tipo_suelo`
--

LOCK TABLES `tipo_suelo` WRITE;
/*!40000 ALTER TABLE `tipo_suelo` DISABLE KEYS */;
INSERT INTO `tipo_suelo` VALUES (1,'Tipo I'),(2,'Tipo II'),(3,'Tipo III'),(4,'Tipo IV'),(5,'Tipo V');
/*!40000 ALTER TABLE `tipo_suelo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-12-14  1:50:04
