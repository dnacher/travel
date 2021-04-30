-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: travel
-- ------------------------------------------------------
-- Server version	8.0.17

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
-- Table structure for table `airport`
--

DROP TABLE IF EXISTS `airport`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `airport` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(65) DEFAULT NULL,
  `country` varchar(65) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `airport`
--

LOCK TABLES `airport` WRITE;
/*!40000 ALTER TABLE `airport` DISABLE KEYS */;
INSERT INTO `airport` VALUES (1,'Aeropuerto internacional de Carrasco','Uruguay'),(2,'Aeropuerto de Ezeiza','Argentina'),(3,'Aeropuerto internacional Jorge Newbery','Argentina'),(4,' Aeropuerto de Barcelona–El Prat','España'),(5,' Aeropuerto Internacional de Pekín-Capital','China'),(6,'Aeropuerto Internacional de Los Ángeles','Estados Unidos'),(7,'Aeropuerto de Roma-Fiumicino','Italia'),(8,'Aeropuerto de Londres-Gatwick','Inglaterra'),(9,'Aeropuerto de Sídney','Australia'),(10,'Aeropuerto Internacional Chhatrapati Shivaji','India'),(11,'Aeropuerto Internacional de São Paulo-Guarulhos','Brasil'),(12,'Aeropuerto Internacional Benito Juárez','Mexico'),(13,'Aeropuerto de Frankfurt','Alemania');
/*!40000 ALTER TABLE `airport` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flight`
--

DROP TABLE IF EXISTS `flight`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `flight` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `airport_id_departure` int(11) DEFAULT NULL,
  `airport_id_arrival` int(11) DEFAULT NULL,
  `departure_date` datetime DEFAULT NULL,
  `arrival_date` datetime DEFAULT NULL,
  `airline` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `flight_airport_destination_idx` (`airport_id_arrival`),
  KEY `flight_airport_origin_idx` (`airport_id_departure`),
  CONSTRAINT `flight_airport_arrival` FOREIGN KEY (`airport_id_arrival`) REFERENCES `airport` (`id`),
  CONSTRAINT `flight_airport_departure` FOREIGN KEY (`airport_id_departure`) REFERENCES `airport` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flight`
--

LOCK TABLES `flight` WRITE;
/*!40000 ALTER TABLE `flight` DISABLE KEYS */;
INSERT INTO `flight` VALUES (1,1,2,'2021-04-20 12:16:38','2021-04-20 12:56:38',NULL),(2,1,4,'2021-04-20 12:16:38','2021-04-21 06:56:38',NULL),(3,1,6,'2021-04-20 10:16:38','2021-04-21 04:20:38',NULL),(4,1,6,'2021-04-20 10:16:38','2021-04-21 04:20:38','American Airlines'),(5,6,1,'2021-04-20 10:16:38','2021-04-21 04:20:38','American Airlines'),(6,2,1,'2021-04-20 10:16:38','2021-04-21 04:20:38','American Airlines'),(7,4,1,'2021-04-20 10:16:38','2021-04-21 04:20:38','American Airlines'),(8,1,1,'2021-04-27 21:00:00','2021-04-29 21:00:00','Test'),(10,2,1,'2021-04-08 21:00:00','2021-04-21 21:00:00','Test'),(11,2,1,'2021-04-27 21:00:00','2021-04-26 21:00:00',NULL),(12,1,2,'2021-04-27 21:00:00','2021-04-26 21:00:00','Test'),(13,2,4,'2021-04-26 21:00:00','2021-04-26 21:00:00','Test'),(14,2,4,'2021-04-26 21:00:00','2021-04-27 21:00:00','Test'),(15,2,1,'2021-04-27 21:00:00','2021-04-27 21:00:00',NULL),(16,2,3,'2021-04-26 21:00:00','2021-04-26 21:00:00','Test');
/*!40000 ALTER TABLE `flight` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flight_travel`
--

DROP TABLE IF EXISTS `flight_travel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `flight_travel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `flight_id` int(11) DEFAULT NULL,
  `travel_id` int(11) DEFAULT NULL,
  `flight_code` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `flight_travel_flight_id_idx` (`flight_id`),
  KEY `flight_travel_travel_id_idx` (`travel_id`),
  CONSTRAINT `flight_travel_flight_id` FOREIGN KEY (`flight_id`) REFERENCES `flight` (`id`),
  CONSTRAINT `flight_travel_travel_id` FOREIGN KEY (`travel_id`) REFERENCES `travel` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flight_travel`
--

LOCK TABLES `flight_travel` WRITE;
/*!40000 ALTER TABLE `flight_travel` DISABLE KEYS */;
INSERT INTO `flight_travel` VALUES (1,1,2,NULL),(2,6,2,NULL),(3,2,3,NULL),(4,7,3,NULL),(5,2,4,NULL),(6,7,4,NULL),(7,3,7,NULL);
/*!40000 ALTER TABLE `flight_travel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `travel`
--

DROP TABLE IF EXISTS `travel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `travel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `passenger_name` varchar(105) DEFAULT NULL,
  `passenger_birth_date` date DEFAULT NULL,
  `passport` varchar(105) DEFAULT NULL,
  `email` varchar(85) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `travel`
--

LOCK TABLES `travel` WRITE;
/*!40000 ALTER TABLE `travel` DISABLE KEYS */;
INSERT INTO `travel` VALUES (2,'John Doe','1984-08-29','AXD-38456','john.doe@email.com'),(3,'John Doe','1984-08-29','AXD-38456','john.doe@email.com'),(4,'Martin Beckham','1980-04-16','MGD-38386','john.doe@email.com'),(5,'Daniel Nacher','2021-04-13','asd','danielnacher@gmail.com'),(6,'Daniel Nacher','2021-04-13','asd','danielnacher@gmail.com'),(7,'Daniel Nacher','2021-04-13','HADES','danielnacher@gmail.com');
/*!40000 ALTER TABLE `travel` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-04-30 10:20:18
