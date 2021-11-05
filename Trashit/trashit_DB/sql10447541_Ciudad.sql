-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: sql10.freesqldatabase.com    Database: sql10447541
-- ------------------------------------------------------
-- Server version	5.5.62-0ubuntu0.14.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Ciudad`
--

DROP TABLE IF EXISTS `Ciudad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Ciudad` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Descripcion` varchar(200) NOT NULL,
  `ID_Pais` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Ciudad`
--

LOCK TABLES `Ciudad` WRITE;
/*!40000 ALTER TABLE `Ciudad` DISABLE KEYS */;
INSERT INTO `Ciudad` VALUES (1,'Buenos Aires',1),(2,'Capital Federal',1),(3,'Catamarca',1),(4,'Chaco',1),(5,'Chubut',1),(6,'Córdoba',1),(7,'Corrientes',1),(8,'Entre Ríos',1),(9,'Formosa',1),(10,'Jujuy',1),(11,'La Pampa',1),(12,'La Rioja',1),(13,'Mendoza',1),(14,'Misiones',1),(15,'Neuquén',1),(16,'Río Negro',1),(17,'Salta',1),(18,'San Juan',1),(19,'San Luis',1),(20,'Santa Cruz',1),(21,'Santa Fe',1),(22,'Santiago del Estero',1),(23,'Tierra del Fuego',1),(24,'Tucumán',1);
/*!40000 ALTER TABLE `Ciudad` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-11-04 21:25:20
