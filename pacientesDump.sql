-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: localhost    Database: vin-plan
-- ------------------------------------------------------
-- Server version	8.0.21

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
-- Table structure for table `dias`
--

DROP TABLE IF EXISTS `dias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dias` (
  `id` int NOT NULL AUTO_INCREMENT,
  `Dia` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dias`
--

LOCK TABLES `dias` WRITE;
/*!40000 ALTER TABLE `dias` DISABLE KEYS */;
INSERT INTO `dias` VALUES (1,'Domingo'),(2,'Lunes'),(3,'Martes'),(4,'Miercoles'),(5,'Jueves'),(6,'Viernes'),(7,'Sabado');
/*!40000 ALTER TABLE `dias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `horarios`
--

DROP TABLE IF EXISTS `horarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `horarios` (
  `id` int NOT NULL AUTO_INCREMENT,
  `horaApertura` time NOT NULL,
  `horaCierre` time NOT NULL,
  `maximoAforo` int NOT NULL,
  `Servicio_idServicio` int DEFAULT NULL,
  `Vinicola_idVinicola` int DEFAULT NULL,
  `Dias_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `Horarios_Dias` (`Dias_id`),
  KEY `Horas_Servicio` (`Servicio_idServicio`),
  KEY `Horas_Vinicola` (`Vinicola_idVinicola`),
  CONSTRAINT `Horarios_Dias` FOREIGN KEY (`Dias_id`) REFERENCES `dias` (`id`),
  CONSTRAINT `Horas_Servicio` FOREIGN KEY (`Servicio_idServicio`) REFERENCES `servicio` (`id`),
  CONSTRAINT `Horas_Vinicola` FOREIGN KEY (`Vinicola_idVinicola`) REFERENCES `vinicola` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `horarios`
--

LOCK TABLES `horarios` WRITE;
/*!40000 ALTER TABLE `horarios` DISABLE KEYS */;
INSERT INTO `horarios` VALUES (31,'08:00:00','20:00:00',10,12,13,2),(32,'08:00:00','20:00:00',10,12,13,2);
/*!40000 ALTER TABLE `horarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `punto_turistico`
--

DROP TABLE IF EXISTS `punto_turistico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `punto_turistico` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `direccion` varchar(100) NOT NULL,
  `Vinicola_idVinicola` int NOT NULL,
  `activo` tinyint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `Punto_Turistico_Vinicola` (`Vinicola_idVinicola`),
  CONSTRAINT `Punto_Turistico_Vinicola` FOREIGN KEY (`Vinicola_idVinicola`) REFERENCES `vinicola` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `punto_turistico`
--

LOCK TABLES `punto_turistico` WRITE;
/*!40000 ALTER TABLE `punto_turistico` DISABLE KEYS */;
INSERT INTO `punto_turistico` VALUES (37,'kiosco','una direccion kiosco',14,0);
/*!40000 ALTER TABLE `punto_turistico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `question`
--

DROP TABLE IF EXISTS `question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `question` (
  `id` int NOT NULL AUTO_INCREMENT,
  `text` varchar(1000) NOT NULL,
  `updated` timestamp NOT NULL,
  `question_type_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `question_question_type` (`question_type_id`),
  CONSTRAINT `question_question_type` FOREIGN KEY (`question_type_id`) REFERENCES `question_type` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question`
--

LOCK TABLES `question` WRITE;
/*!40000 ALTER TABLE `question` DISABLE KEYS */;
INSERT INTO `question` VALUES (22,'textoModificado','2020-12-04 01:20:00',1),(23,'test','2020-12-04 01:06:00',1),(24,'¿Como estas?','2020-12-17 22:00:35',2),(25,'¿Como estas?','2020-12-17 22:01:07',2),(26,'1','2020-12-17 22:27:54',2),(27,'¿Como estas?','2020-12-17 22:28:29',1),(29,'Pregunta','2020-12-17 23:48:09',2),(30,'Pregunta 2','2020-12-17 23:49:02',2),(31,'NUEVA PREGUNTA','2020-12-18 00:28:01',2);
/*!40000 ALTER TABLE `question` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `question_BEFORE_INSERT` BEFORE INSERT ON `question` FOR EACH ROW BEGIN
SET new.updated := now();
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `question_BEFORE_UPDATE` BEFORE UPDATE ON `question` FOR EACH ROW BEGIN
SET new.updated := now();
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `question_order`
--

DROP TABLE IF EXISTS `question_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `question_order` (
  `question_id` int NOT NULL,
  `survey_id` int NOT NULL,
  `order` int NOT NULL,
  PRIMARY KEY (`question_id`,`survey_id`),
  UNIQUE KEY `question_order_ak_1` (`survey_id`,`question_id`),
  CONSTRAINT `question_order_question` FOREIGN KEY (`question_id`) REFERENCES `question` (`id`) ON DELETE CASCADE,
  CONSTRAINT `question_order_survey` FOREIGN KEY (`survey_id`) REFERENCES `survey` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question_order`
--

LOCK TABLES `question_order` WRITE;
/*!40000 ALTER TABLE `question_order` DISABLE KEYS */;
INSERT INTO `question_order` VALUES (22,22,1),(23,22,1),(26,42,0),(27,42,1);
/*!40000 ALTER TABLE `question_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `question_type`
--

DROP TABLE IF EXISTS `question_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `question_type` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question_type`
--

LOCK TABLES `question_type` WRITE;
/*!40000 ALTER TABLE `question_type` DISABLE KEYS */;
INSERT INTO `question_type` VALUES (1,'test'),(2,'test');
/*!40000 ALTER TABLE `question_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reservacionespesifica`
--

DROP TABLE IF EXISTS `reservacionespesifica`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reservacionespesifica` (
  `id` int NOT NULL AUTO_INCREMENT,
  `Fecha` date NOT NULL,
  `cantidad_personas` int NOT NULL,
  `total` double(9,2) NOT NULL,
  `especificaciones` varchar(500) NOT NULL,
  `codigo_confirmacion` varchar(50) DEFAULT NULL,
  `Status_idStatus` int NOT NULL,
  `last_update` timestamp NOT NULL,
  `Horarios_id` int DEFAULT NULL,
  `Usuario_id` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `codigo_confirmacion_UNIQUE` (`codigo_confirmacion`),
  KEY `ReservacionEspesifica_Horarios` (`Horarios_id`),
  KEY `ReservacionEspesifica_Usuario` (`Usuario_id`),
  KEY `Reservacion_Status` (`Status_idStatus`),
  CONSTRAINT `Reservacion_Status` FOREIGN KEY (`Status_idStatus`) REFERENCES `status` (`id`),
  CONSTRAINT `ReservacionEspesifica_Horarios` FOREIGN KEY (`Horarios_id`) REFERENCES `horarios` (`id`),
  CONSTRAINT `ReservacionEspesifica_Usuario` FOREIGN KEY (`Usuario_id`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservacionespesifica`
--

LOCK TABLES `reservacionespesifica` WRITE;
/*!40000 ALTER TABLE `reservacionespesifica` DISABLE KEYS */;
INSERT INTO `reservacionespesifica` VALUES (27,'2020-12-14',3,10.00,' patata','4d3cdbbb-3e52-11eb-a0b4-d8cb8a',1,'2020-12-14 08:00:00',31,17),(28,'2020-12-14',1,10.00,'wenas','2c7d39c3-3e53-11eb-a0b4-d8cb8a',1,'2020-12-14 08:00:00',31,17),(29,'2020-12-14',1,10.00,' 11','618b421c-3e53-11eb-a0b4-d8cb8a',1,'2020-12-14 08:00:00',31,17),(30,'2020-12-14',1,10.00,' wqe','f4c736bf-3e58-11eb-a0b4-d8cb8a',1,'2020-12-14 08:00:00',31,17),(31,'2020-12-14',1,10.00,' wqe','f4c74802-3e58-11eb-a0b4-d8cb8a',1,'2020-12-14 08:00:00',31,17),(32,'2020-12-14',1,10.00,' ESPECIFICACION','68ab66e5-3f1d-11eb-8119-d8cb8a',1,'2020-12-15 08:00:00',31,17),(33,'2020-11-30',3,10.00,' prueba carlos','aa3507c5-4006-11eb-9a8c-040e3c',1,'2020-12-16 06:00:00',32,17),(34,'2020-11-30',2,10.00,' descripcion 2','c4fbbd40-4007-11eb-9a8c-040e3c',1,'2020-12-16 06:00:00',31,17);
/*!40000 ALTER TABLE `reservacionespesifica` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `response`
--

DROP TABLE IF EXISTS `response`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `response` (
  `survey_response_id` int NOT NULL,
  `question_id` int NOT NULL,
  `user_id` int NOT NULL,
  `answer` varchar(1000) NOT NULL,
  PRIMARY KEY (`survey_response_id`,`question_id`,`user_id`),
  KEY `response_question` (`question_id`),
  KEY `response_respondent` (`user_id`),
  CONSTRAINT `response_question` FOREIGN KEY (`question_id`) REFERENCES `question` (`id`) ON DELETE CASCADE,
  CONSTRAINT `response_respondent` FOREIGN KEY (`user_id`) REFERENCES `usuario` (`id`) ON DELETE CASCADE,
  CONSTRAINT `response_survey_response` FOREIGN KEY (`survey_response_id`) REFERENCES `survey_response` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `response`
--

LOCK TABLES `response` WRITE;
/*!40000 ALTER TABLE `response` DISABLE KEYS */;
/*!40000 ALTER TABLE `response` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `response_choice`
--

DROP TABLE IF EXISTS `response_choice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `response_choice` (
  `id` int NOT NULL AUTO_INCREMENT,
  `question_id` int NOT NULL,
  `text` varchar(1000) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `response_choice_question` (`question_id`),
  CONSTRAINT `response_choice_question` FOREIGN KEY (`question_id`) REFERENCES `question` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `response_choice`
--

LOCK TABLES `response_choice` WRITE;
/*!40000 ALTER TABLE `response_choice` DISABLE KEYS */;
INSERT INTO `response_choice` VALUES (40,22,'no'),(41,23,'si'),(42,23,'no'),(43,24,'\"Bien\"'),(44,24,'\"Mal\"'),(45,24,'\"Regular\"'),(46,24,'\"\"'),(47,25,'\"Bien\"'),(48,25,'\"Mal\"'),(49,25,'\"Regular\"'),(50,25,'\"\"'),(51,26,'\"1\"'),(52,26,'\"1\"'),(53,26,'\"1\"'),(54,26,'\"\"'),(55,27,'si'),(56,27,'no'),(57,29,'\"Respuesta 1\"'),(58,29,'\"Respuesta 2\"'),(59,29,'\"Respuesta 3\"'),(60,29,'\"Respuesta 4\"'),(61,30,'\"1\"'),(62,30,'\"2\"'),(63,30,'\"3\"'),(64,30,'\"4\"'),(65,31,'\"OPCION 1\"'),(66,31,'\"OPCION 2\"'),(67,31,'\"OPCION 3\"'),(68,31,'\"OPCION 4\"');
/*!40000 ALTER TABLE `response_choice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles` (
  `id` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(50) NOT NULL,
  `Description` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'Vinicola','Es poseedor de una vinicola'),(2,'Turista','Este usuario es un turista/cliente'),(3,'Administrador','Es una administrador de la pagina');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `servicio`
--

DROP TABLE IF EXISTS `servicio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `servicio` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) NOT NULL,
  `tipo` varchar(50) NOT NULL,
  `costo` double(9,2) NOT NULL,
  `descripcion` varchar(500) NOT NULL,
  `Vinicola_idVinicola` int NOT NULL,
  `last_update` timestamp NOT NULL,
  `activo` tinyint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `Servicio_Copy_of_Vinicola` (`Vinicola_idVinicola`),
  CONSTRAINT `Servicio_Copy_of_Vinicola` FOREIGN KEY (`Vinicola_idVinicola`) REFERENCES `vinicola` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `servicio`
--

LOCK TABLES `servicio` WRITE;
/*!40000 ALTER TABLE `servicio` DISABLE KEYS */;
INSERT INTO `servicio` VALUES (12,'SERVICIO3','CAMINATA',10.00,'UN SERVICIO',13,'2020-12-16 20:27:41',0),(13,'SERVICIO2','CAMINATA',10.00,'UN SERVICIO',13,'2020-12-14 08:00:00',0),(14,'SERVICIO3','CAMINATA',10.00,'UN SERVICIO',13,'2020-12-14 08:00:00',0),(15,'SERVICIO4','CAMINATA',10.00,'UN SERVICIO',13,'2020-12-14 08:00:00',0),(16,'Servicio 12','Servicioz',1200.00,'asdasdas',13,'2020-12-16 23:06:01',0),(17,'1','1',123.00,'1',13,'2020-12-16 06:00:00',0),(18,'Bodas','Boda',12300.00,'Bodas',13,'2020-12-16 06:00:00',0),(19,'Servicio 4','asdasd',1111.00,'asdasd',13,'2020-12-17 00:19:23',0),(20,'Servicio 5','Playita',5000.00,'Servicio cinco',13,'2020-12-17 20:30:47',0),(21,'Servicio','Caminata',100.00,'Es un servicio',9,'2020-12-17 08:00:00',1),(22,'UN TOUR AL ATARDECER','TOUR',100.00,'DESCRIPCION DE SERVICIO',14,'2020-12-17 08:00:00',1);
/*!40000 ALTER TABLE `servicio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `status`
--

DROP TABLE IF EXISTS `status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `status` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `status`
--

LOCK TABLES `status` WRITE;
/*!40000 ALTER TABLE `status` DISABLE KEYS */;
INSERT INTO `status` VALUES (1,'EnEspera'),(2,'Cancelado'),(3,'Aceptado');
/*!40000 ALTER TABLE `status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `survey`
--

DROP TABLE IF EXISTS `survey`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `survey` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `description` varchar(1000) DEFAULT NULL,
  `updated` timestamp NOT NULL,
  `Vinicola_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `survey_Vinicola` (`Vinicola_id`),
  CONSTRAINT `survey_Vinicola` FOREIGN KEY (`Vinicola_id`) REFERENCES `vinicola` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `survey`
--

LOCK TABLES `survey` WRITE;
/*!40000 ALTER TABLE `survey` DISABLE KEYS */;
INSERT INTO `survey` VALUES (22,'EncuestaTest','test33','2020-12-04 01:05:43',NULL),(42,'Satisfaccion','12312','2020-12-17 22:24:56',13);
/*!40000 ALTER TABLE `survey` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `survey_BEFORE_INSERT` BEFORE INSERT ON `survey` FOR EACH ROW BEGIN
	SET new.updated := now();
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `survey_BEFORE_UPDATE` BEFORE UPDATE ON `survey` FOR EACH ROW BEGIN
SET new.updated := now();
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `survey_response`
--

DROP TABLE IF EXISTS `survey_response`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `survey_response` (
  `id` int NOT NULL AUTO_INCREMENT,
  `survey_id` int NOT NULL,
  `user_id` int NOT NULL,
  `updated` timestamp NOT NULL,
  PRIMARY KEY (`id`),
  KEY `survey_response_survey` (`survey_id`),
  KEY `survey_response_respondent` (`user_id`),
  CONSTRAINT `survey_response_respondent` FOREIGN KEY (`user_id`) REFERENCES `usuario` (`id`) ON DELETE CASCADE,
  CONSTRAINT `survey_response_survey` FOREIGN KEY (`survey_id`) REFERENCES `survey` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `survey_response`
--

LOCK TABLES `survey_response` WRITE;
/*!40000 ALTER TABLE `survey_response` DISABLE KEYS */;
/*!40000 ALTER TABLE `survey_response` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_usuario`
--

DROP TABLE IF EXISTS `tipo_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipo_usuario` (
  `id` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(50) NOT NULL,
  `Description` varchar(1000) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_usuario`
--

LOCK TABLES `tipo_usuario` WRITE;
/*!40000 ALTER TABLE `tipo_usuario` DISABLE KEYS */;
INSERT INTO `tipo_usuario` VALUES (1,'Conocedor','Conocerdor de vino'),(2,'Turista enologico','Viaja por el vino'),(3,'Turista regular','Viaja, vino no es su prioridad'),(4,'Catador','Es probador de vinos');
/*!40000 ALTER TABLE `tipo_usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tokens`
--

DROP TABLE IF EXISTS `tokens`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tokens` (
  `id` int NOT NULL AUTO_INCREMENT,
  `token` varchar(100) NOT NULL,
  `Usuario_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `Tokens_Usuario` (`Usuario_id`),
  CONSTRAINT `Tokens_Usuario` FOREIGN KEY (`Usuario_id`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tokens`
--

LOCK TABLES `tokens` WRITE;
/*!40000 ALTER TABLE `tokens` DISABLE KEYS */;
INSERT INTO `tokens` VALUES (5,'29322cb7-ec0f-40e0-9391-c36b5a5ab897',14),(6,'c95dc798-4958-471f-86d8-a1a2b6697bdd',15),(7,'577afce1-91fa-40e3-aab7-99683f9330d4',16),(8,'dce50bec-734e-407c-a42f-59aa6ee04a4d',17),(9,'011e588b-9ec5-4a9a-9a65-76004cd8b85a',18),(10,'bd2057fc-afb7-479d-bf4f-6bed77f52b48',19),(11,'fca25675-0676-4799-b9b4-974984962bc0',20),(12,'57496a95-5903-408f-9181-8c8e64cf0693',21),(13,'b8591018-9d0f-4a4e-8ce2-c7a2e1cbb3f1',22);
/*!40000 ALTER TABLE `tokens` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_roles`
--

DROP TABLE IF EXISTS `user_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_roles` (
  `usuario_id` int NOT NULL,
  `roles_id` int NOT NULL,
  PRIMARY KEY (`usuario_id`,`roles_id`),
  KEY `User_Roles_Roles` (`roles_id`),
  CONSTRAINT `User_Roles_Roles` FOREIGN KEY (`roles_id`) REFERENCES `roles` (`id`),
  CONSTRAINT `User_Roles_Usuario` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_roles`
--

LOCK TABLES `user_roles` WRITE;
/*!40000 ALTER TABLE `user_roles` DISABLE KEYS */;
INSERT INTO `user_roles` VALUES (14,1),(15,1),(16,1),(18,1),(19,1),(22,1),(17,2),(20,2),(21,2);
/*!40000 ALTER TABLE `user_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `id` int NOT NULL AUTO_INCREMENT,
  `Username` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `lastname` varchar(50) NOT NULL,
  `hashed_password` varchar(100) NOT NULL,
  `email` varchar(254) NOT NULL,
  `gender` varchar(10) NOT NULL,
  `birthday` date NOT NULL,
  `number_visits` int NOT NULL DEFAULT '0',
  `knowledge_level` varchar(20) DEFAULT NULL,
  `Google` varchar(255) DEFAULT NULL,
  `Facebook` varchar(255) DEFAULT NULL,
  `activo` tinyint NOT NULL DEFAULT '0',
  `Tipo_usuario_id` int NOT NULL,
  `Vinicola_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`),
  KEY `Usuario_Tipo_usuario` (`Tipo_usuario_id`),
  KEY `Usuario_Vinicola` (`Vinicola_id`),
  CONSTRAINT `Usuario_Tipo_usuario` FOREIGN KEY (`Tipo_usuario_id`) REFERENCES `tipo_usuario` (`id`),
  CONSTRAINT `Usuario_Vinicola` FOREIGN KEY (`Vinicola_id`) REFERENCES `vinicola` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (14,'paco','paco','cc','$2a$31$UBdF882xeEltt4oQDdWct.wyDqLCfZarsD2wex5MsPnuZgwW8YxEq','eri_acg@hotmail.com','Hombre','1999-11-10',0,NULL,NULL,NULL,1,1,9),(15,'patata','patata','Xpotato','$2a$31$yXwTA.cdobd3.H1HjJtFTenapxWLdn652kVlK8EyNC8kt.jL..9e2','eri.acg@gmail.com','Hombre','1999-11-10',0,NULL,NULL,NULL,1,1,10),(16,'fer','de la cruz','Ramirez','$2a$31$rJ3IssvG/f6x/AbB3uryWe9pHjTtHK4/ETXfWrbzRP2sebd8/iqEq','nc14302061560302@gmail.com','Hombre','2000-04-14',0,NULL,NULL,NULL,1,1,11),(17,'Fernando','Antonio','Xpotato','$2a$31$5DMxsbNRBQcHvQ9o50uSMOK363C/032scuNLjpgN9cGYjLeEOM2s.','fdlcr1157@gmail.com','Hombre','1998-09-02',0,NULL,NULL,NULL,1,1,NULL),(18,'eri','eri','cg','$2a$31$yCx2ZA6pnVP7DdqIFNhrvOfGsyN5mM6DqsU7yWcYn85tD.4FGHmPi','eriadlai.campos@cetys.edu.mx','Hombre','1999-11-10',0,NULL,NULL,NULL,1,1,12),(19,'Bob','FERNANDO','CRUZ','$2a$31$KYBXojguHDiPErADT0g.S.WdAIbQEwA1uz5TA1MTiVUwlfa8MPOMe','fernando.delacruz@cetys.edu.mx','HOMBRE','2020-08-04',0,NULL,NULL,NULL,1,1,13),(20,'bere','bere','gonzales','$2a$31$9n8/xEn6y4Mn0lw8GhC3QeLSvvCE7x6xCH09bcfNXL1b4q.TYy6hq','jessicaberegar@gmail.com','Mujer','1998-10-10',0,NULL,NULL,NULL,1,1,NULL),(21,'usuario','gabriela','gabriela','$2a$31$7crU0rJ9Z/kX01tT52Af0OpO5ZRK4kT.v9Dvhs9TAmGUqZlqTbNf6','gabriella.echegaray@cetys.edu.mx','Mujer','1999-11-10',0,NULL,NULL,NULL,1,1,NULL),(22,'usuario2','jorge','magdaleno','$2a$31$xGhb8eLRUU36mN0V3wVr/uQ4ALBRJIzN6iNByA8lLl8Az73E6VVDa','jorge.magdaleno@cetys.edu.mx','Hombre','1999-12-10',0,NULL,NULL,NULL,1,1,14);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vinicola`
--

DROP TABLE IF EXISTS `vinicola`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vinicola` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `logo` varchar(100) DEFAULT NULL,
  `direccion` varchar(100) NOT NULL,
  `codigoPost` int NOT NULL,
  `activo` tinyint NOT NULL,
  `Descripcion` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vinicola`
--

LOCK TABLES `vinicola` WRITE;
/*!40000 ALTER TABLE `vinicola` DISABLE KEYS */;
INSERT INTO `vinicola` VALUES (9,'PACO','LOGO','DIRECCION DE PACO',2222,0,'DESCRIPCION DE PACO VINICOLA'),(10,'X-VINICOLA','PATATA','DIRECCION DE PATATA',123123,0,'SOY UNA PATATA'),(11,'VINICOLA OSO Y PANTERA','LOGO','ENRIQUE SEGOVIANO',22430,0,'ESTA CHIDA MIAU'),(12,'VINICOLA OP','LOGO','VIVO AQUI',222,0,'MI CASITA SISISI'),(13,'PANTERA VINICOLA','LOGO','DIRECCION DE NUEVA VINICOLA',123123,0,'UNA VINICOLA DE PRUEBA'),(14,'VINICOLA DE JORGE','LOGO','DIRECCION DE VINICOLA',223344,0,'DESCRIPCION DE LA VINICOLA');
/*!40000 ALTER TABLE `vinicola` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'vin-plan'
--
/*!50003 DROP PROCEDURE IF EXISTS `crearestatus` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `crearestatus`(nombrestatus text)
BEGIN
	insert into status (nombre) values (nombrestatus);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `crearOrdenes` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `crearOrdenes`(surveyID int,questionText varchar(100),questionType int , respuestasjson json)
BEGIN
declare preguntaID int;
declare erro int default 0;
declare lastID int;
declare j varchar(1000);
declare indx int default 0;
declare orden int default (select count(*) from question_order where survey_id=surveyid );
start transaction;
if(exists(select id from survey where id=surveyID)) then 
		if(questionText is not null) then 
				insert into question (text,question_type_id) values (questionText,questionType);
                set lastID = (select last_insert_id() from question limit 1);
				insert into question_order (question_id,survey_id,`order`) values (lastID,surveyID,orden);
                  select 'insertado a questions';
					if(questionType=1) then
						insert into response_choice(question_id,text) values (lastID,'si'),(lastID,'no');
                        select 'insertado a response choice';
                    end if;
					if(questionType=2) then
						repeat
						set j=json_extract(respuestasjson, CONCAT("$[", indx, "].respuestasOpcion"));
                        select j;
                        select indx;
                        insert into response_choice(question_id,text) values (lastID,j);
                        set indx= indx +1;
                        UNTIL indx = JSON_LENGTH(respuestasjson)
                        end repeat;
					end if;
					else
					set erro=1;
		end if;
		else
        set erro=1;
end if;
if (erro =0) then 
	commit;
else
	rollback;
end if;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `crearPuntoTuristico` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `crearPuntoTuristico`(nombre varchar(50),direccion varchar(100), usuarioId int)
BEGIN
	Declare vinicolaId int default (select u.Vinicola_id from usuario u where u.id=usuarioId);
    DECLARE err int default 0;
	DECLARE CONTINUE HANDLER FOR sqlexception set err=1;
    start transaction;
    if vinicolaId is not null then
		insert into punto_turistico(nombre,direccion,Vinicola_idVinicola,activo) values(nombre,direccion,vinicolaId,0);
		
		
		if(select exists(select u.id from usuario u where u.id=usuarioId))=1 then
			select usuarioId;
			update usuario u set u.Vinicola_id=vinicolaId where u.id=usuarioId;
		end if;
		
		if err=1 then
			select "No se pudo crear el punto turístico";
			rollback;
		else 
			select "Se creó el punto turístico exitosamente";
			commit;
		end if;
	else 
		select "La vinicola no existe";
        rollback;
	end if;
    
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `CrearQuestionType` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `CrearQuestionType`(nam varchar(30))
BEGIN
start transaction;
insert into question_type (name) values (nam);
commit;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `crearreservacionesespecificas` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `crearreservacionesespecificas`(fechaR date, cantidadpers int, especificacion varchar(500), horario int, usuario int)
BEGIN
    Declare totalServicio double(9,2) default (select costo from servicio s join horarios h on s.id = h.Servicio_idServicio where h.id = horario);
    Declare dia int default (select d.id from dias d join horarios h on d.id = h.dias_id where h.id = horario);
    Declare buscaridHora int default (select h.id from horarios h where h.id = horario);
    Declare buscaridUser int default (select u.id from usuario u where u.id = usuario);
    ##QUERY NO TOMA EN CUENTA LAS FECHAS EN LA QUE SE REALIZA LA RESERVACION, SACA LA CANTIDAD TOTAL DE PERSONAS EN TODO EL TIEMPO.
    ##REVISAR RETRIEVEHORARIO PARA LA SOLUCION.
   Declare countReservasCantPers int default ifnull((select sum(cantidad_personas) from reservacionespesifica where horarios_id = horario and status_idstatus != 2), 0);
   ##=======================================================================================================================================
    Declare countServAforo int default (select maximoAforo from horarios h where h.id = horario);
	Declare codigo_confirm varchar(30);
    set countReservasCantPers = countReservasCantPers + cantidadpers;
	select "antes loop";
	validar:loop
		set codigo_confirm = (SELECT LEFT(UUID(),30));
		if (select not exists (select codigo_confirmacion from reservacionespesifica where codigo_confirmacion=codigo_confirm))
			then
				leave validar;
			end if;
    end loop;
    start transaction;
		select fechaR;
        select dia;
        select buscaridHora;
        select buscaridUser;
        select countReservasCantPers;
        select countServAforo;
		if (dia = dayofweek(fechaR)) and (buscaridHora is not null) and (buscaridUser is not null) and (countReservasCantPers <= countServAforo) then
			insert into ReservacionEspesifica (fecha, cantidad_personas, total, especificaciones, codigo_confirmacion, status_idStatus, last_update, Horarios_id, Usuario_id) values (fechaR, cantidadpers, totalServicio, especificacion, codigo_confirm, 1, curdate(), horario, usuario);
		   commit;
         
		else
        select "HUBO ROLLBACK";
			rollback;
           
		end if;
    
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `CrearRespuesta` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `CrearRespuesta`(Survey_IdEntry int, User_IdEntry int, question_idEntry int, answerEntry varchar(1000))
BEGIN

declare LastID int;
declare erro int default 0;
start transaction;

	if(exists(select id from survey where id = Survey_IdEntry)) then
		if(exists(select id from Usuario where id = User_IdEntry)) then
			if(exists(select id from question where id = question_IdEntry)) then
				
                insert into survey_response (survey_id, user_id) values (Survey_IdEntry,User_IdEntry);
				set LastID = (SELECT LAST_INSERT_ID());
				insert into response values (LastId,question_idEntry,User_IdEntry);
                
                else
                set erro = 1;
			end if;
            
            else
			set erro = 1;
		end if;
        
        else
		set erro = 1;
    end if;

	if erro = 0 then
		commit;
        else
        rollback;
	end if;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `crearRol` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `crearRol`(nombre varchar(50), descripcion varchar(1000))
BEGIN
	DECLARE err int default 0;
	DECLARE CONTINUE HANDLER FOR sqlexception set err=1;

    if(select not exists(select r.id from roles r where r.Name= nombre)) then
		start transaction;
        insert into roles(Name, Description) values(nombre,descripcion);
        
        select "Se creo exitosamente el rol";
        
        commit;
	else 
		select "Error al crear rol";
		rollback;
    end if;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `crearservicios` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `crearservicios`(nombreServ varchar(30), tipoServ varchar(50), costoServ double(9,2), descrip varchar(500), Vinicolaid int)
BEGIN
    Declare vinicola_id int default (select vinicola_id from usuario where id = Vinicolaid);
    Declare buscarid int default (select id from vinicola where id = vinicola_id);

    start transaction;
    if buscarid is not null then
        insert into Servicio (nombre, tipo, costo, descripcion, Vinicola_idVinicola, last_update, activo) values (nombreServ, tipoServ, costoServ, descrip, buscarid, curdate(), 1);
        commit;
    else
        rollback;
    end if;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `CrearSurvey` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `CrearSurvey`(NameEntry varchar(100),DescriptionEntry varchar(1000),idUsuario int)
BEGIN

declare idVinicola int default (select vinicola_id from usuario where id=idUsuario ) ;
start transaction;
if(idVinicola  = -1) 
	then
	insert into survey (name,description) values(NameEntry,DescriptionEntry);
	else
	insert into survey (name,description,vinicola_id) values(NameEntry,DescriptionEntry,idVinicola);
end if;
commit;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `crearTipoUsuario` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `crearTipoUsuario`(nombre varchar(50),descripcion varchar(1000))
BEGIN
	DECLARE err int default 0;
	DECLARE CONTINUE HANDLER FOR sqlexception set err=1;

    if(select not exists(select t.id from tipo_usuario t where t.Name= nombre)) then
		start transaction;
        insert into tipo_usuario(Name, Description) values(nombre,descripcion);
        
        select "Se creo exitosamente el tipo de usuario";
        
        commit;
	else 
		select "Error al crear tipo usuario";
		rollback;
    end if;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `crearToken` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `crearToken`(token varchar(100), usuarioId int)
BEGIN
	DECLARE err int default 0;
	DECLARE CONTINUE HANDLER FOR sqlexception set err=1;
    
    start transaction;
		insert into tokens(token,Usuario_id) values(token,usuarioId);
        
	if err=1 then
		select "Error al crear token de usuario";
        rollback;
	else 
		select "Se creo el token";
		commit;

		
    end if;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `crearUsuarios` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `crearUsuarios`(userName varchar(50),nombre varchar(50),lastName varchar(50),hashed_password varchar(100),email varchar(254), gender varchar(10), birthday date, knowledgeLevel varchar(20), Google varchar(255),Facebook varchar(255),tipoUsuario varchar(20), rol_usuario varchar(50), token varchar(100))
BEGIN
	DECLARE user_tipo_usuario int default (select t.id from tipo_usuario t where t.Name=tipoUsuario);
    DECLARE user_role int default (select r.id from roles r where r.Name=rol_usuario);
	DECLARE usuarioId int default 0;

    DECLARE err int default 0;
    DECLARE CONTINUE HANDLER FOR sqlexception set err=1;
    Start transaction;    
    
	select user_tipo_usuario;
    if user_role is null then
		set err=1;
	end if;
    
		insert into usuario
        (Username, name,lastname, hashed_password, email,gender, birthday, number_visits, knowledge_level,Google, Facebook,activo,Tipo_usuario_id) values
		(userName,nombre,lastName,hashed_password,email,gender,birthday,0,knowledgeLevel,Google, Facebook,0,user_tipo_usuario);
		set usuarioId= last_insert_id();

        if err=1 then
			select "Error al crear usuario";
			rollback;
		else 
			insert into user_roles(usuario_id,roles_id)  values(usuarioId, user_role);
			call crearToken(token, usuarioId);
			select "Se creó el usuario exitosamente";
            commit;
        end if;
	

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `crearVinicola` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `crearVinicola`(nombre varchar(50), logo varchar(100),direccion varchar(100), codigoPost int,descripcion varchar(500), usuarioId int)
BEGIN
    Declare vinicolaId int default 0;
	DECLARE err int default 0;
    
    start transaction;
	if(select exists(select u.id from usuario u where u.id=usuarioId))=1 then
		insert into vinicola(nombre,logo,direccion,codigoPost,activo,Descripcion) values(nombre,logo,direccion,codigoPost,0,descripcion);
		set vinicolaId = (select max(id) from vinicola);
		update usuario u set u.Vinicola_id=vinicolaId where u.id=usuarioId;
		if err=1 then
			select "No se pudo crear la vinícola";
			rollback;
		else 
			select "Se creó la vinícola exitosamente";
			commit;
		end if;
    else 
		select "No existe el usuario";
        rollback;
    end if;
    

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `EliminarEncuesta` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `EliminarEncuesta`(Encuesta_IdEntry int)
BEGIN
DELETE FROM survey WHERE id =Encuesta_IdEntry ;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `EliminarHorarios` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `EliminarHorarios`(idH int)
BEGIN
declare buscar int default(select id from horarios where id=idH);
start transaction;
if buscar is not null
then
update reservacionespesifica set Horarios_id = null where Horarios_id=idH;
delete from horarios where id=idH;
commit;
else
rollback;
end if;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `eliminarPregunta` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `eliminarPregunta`(surveyID int ,questionID int )
BEGIN
delete from question where id=(select question_id from question_order where survey_id=surveyID limit 1);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `eliminarPuntoTuristico` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `eliminarPuntoTuristico`(idPunto int)
BEGIN
	DECLARE err int default 0;
    DECLARE CONTINUE HANDLER FOR sqlexception set err=1;
	start transaction;
    if (select exists(select p.id from punto_turistico p where p.id=idPunto)) then
			delete from punto_turistico where id=idPunto;
		if err=1 then
			select "No fue posible realizar la eliminación";
			rollback;
		else 
			select "Se eliminio exitosamente el punto turistico";
			commit;
		end if;
    else
		select "El punto turistico no existe";
    end if;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `EliminarReservacion` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `EliminarReservacion`(idR int)
BEGIN
	declare buscar int default(select id from reservacionespesifica where id=idR);
    
	start transaction;
	if buscar is not null then
		update reservacionespecifica set status_idStatus = 2;
		commit;
	else
		rollback;
	end if;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `eliminarResponseChoice` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `eliminarResponseChoice`(questionID int,responseID int)
BEGIN
delete from response_choice where id=responseID and question_id=questionID;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `eliminarRol` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `eliminarRol`(idRol int)
BEGIN
	DECLARE err int default 0;
    DECLARE CONTINUE HANDLER FOR sqlexception set err=1;
	start transaction;
	delete from roles where id=idRol;
    
	if err=1 then
		select "No fue posible realizar la eliminación";
		rollback;
	else 
		select "Se eliminio exitosamente el rol";
		commit;
	end if;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `eliminarServicio` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `eliminarServicio`(idServ int)
BEGIN
	declare buscar int default(select id from servicio where id=idServ);
    
	start transaction;
	if buscar is not null then
		update servicio set activo = 0 where id=idServ;
		commit;
	else
		rollback;
	end if;	
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `eliminarstatus` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `eliminarstatus`(idstatus int)
BEGIN
	Declare buscaridStatus int default (select id from status where id = idstatus);
    
    if buscaridStatus is not null then
		delete from status where id = idstatus;
        commit;
	else
		rollback;
    end if;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `eliminarToken` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `eliminarToken`(idToken int)
BEGIN
	DECLARE err int default 0;
    DECLARE CONTINUE HANDLER FOR sqlexception set err=1;
	start transaction;
    if (select exists(select t.id from tokens t where t.id=idToken)) then
			delete from tokens where id=idToken;
		if err=1 then
			select "No fue posible realizar la eliminación";
			rollback;
		else 
			select "Se eliminio exitosamente el Token";
			commit;
		end if;
    else
		select "El token no existe";
    end if;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `eliminarUsuario` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `eliminarUsuario`(idUsuario int)
BEGIN
	DECLARE err int default 0;
    DECLARE CONTINUE HANDLER FOR sqlexception set err=1;
	start transaction;
	delete from usuario where id=idUsuario;
    
	if err=1 then
		select "No fue posible realizar la eliminación";
		rollback;
	else 
		select "Se eliminio exitosamente el usuario";
		commit;
	end if;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `eliminarVinicola` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `eliminarVinicola`(idVinicola int)
BEGIN
	DECLARE err int default 0;
    DECLARE CONTINUE HANDLER FOR sqlexception set err=1;
	start transaction;
	delete from vinicola where id=idVinicola;
    
	if err=1 then
		select "No fue posible realizar la eliminación";
		rollback;
	else 
		select "Se eliminio exitosamente el vinicola";
		commit;
	end if;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `horario` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `horario`(horaApertura time, horaCierre time, maxAforo int, servicio varchar(30), vinicola int, dias varchar(20))
BEGIN
	Declare buscaridServicio int default (select id from Servicio where nombre = servicio);
    Declare buscaridVinicola int default (select vinicola_id from usuario where id = vinicola);
    Declare buscaridDias int default (select id from Dias where Dia= dias);
    
    start transaction;
    if buscaridServicio is not null && buscaridVinicola is not null && buscaridDias is not null then
		insert into horarios (horaApertura, horaCierre, maximoAforo, servicio_idServicio, vinicola_idVinicola, Dias_id) values (horaApertura, horaCierre, maxAforo,  buscaridServicio, buscaridVinicola , buscaridDias);
        commit;
	else
		rollback;
    end if;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `ModificarHorarios` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `ModificarHorarios`(idH int,EditHrA time, EditHrC time, EditMax int)
BEGIN
start transaction;

##=====================================================================
if EditHrA is not null
then
update horarios set horaApertura = EditHrA where id=idH;
commit;
else
rollback;
end if;
##=====================================================================
if EditHrC is not null
then
update horarios set horaCierre = EditHrC where id=idH;
commit;
else
rollback;
end if;
##=====================================================================
if EditMax is not null
then
update horarios set maximoAforo = EditMax where id=idH;
commit;
else
rollback;
end if;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `modificarPregunta` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `modificarPregunta`(texto varchar(1000),questionID int)
BEGIN
start transaction;
update question set text = texto where id = questionID ;
commit;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `modificarPuntoTuristico` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `modificarPuntoTuristico`(puntoTuristicoId int,nombre varchar(50), direccion varchar(100),idVinicola int, activo int)
BEGIN
	DECLARE err int default 0;
    DECLARE CONTINUE HANDLER FOR sqlexception set err=1;
    Start transaction;
			
		if(select exists(select v.id from vinicola v where v.id=idVinicola)) then
			update punto_turistico p set p.nombre=nombre,
			p.direccion=direccion,
			p.Vinicola_idVinicola=idVinicola,
			p.activo=activo
			where p.id=puntoTuristicoId;
		end if;
        
         if err=1 then
			select "No fue posible realizar la modificación";
            rollback;
		else 
			select "Modificación exitosa";
            commit;
		end if;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `ModificarReservacion` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `ModificarReservacion`(idR int, EditFechaI timestamp, EditCant int, EditTotal double(9,2),EditEspec varchar(500),EditConfi varchar(50),EditFechaF timestamp)
BEGIN
start transaction;
##=====================================================================
if EditFechaI is not null
then
update reservacionespesifica set fechainicio = EditFechaI where id=idR;
commit;
else
rollback;
end if;
##=====================================================================
if EditCant is not null
then
update reservacionespesifica set cantidad_personas = EditCant where id=idR;
commit;
else
rollback;
end if;
##=====================================================================
if EditTotal is not null
then
update reservacionespesifica set total = EditTotal where id=idR;
commit;
else
rollback;
end if;
##=====================================================================
if EditEspec is not null
then
update reservacionespesifica set especificaciones = EditEspec where id=idR;
commit;
else
rollback;
end if;
##=====================================================================
if EditConfi is not null
then
update reservacionespesifica set codigo_confirmacion = EditConfi where id=idR;
commit;
else
rollback;
end if;
if EditFechaF is not null
then
update reservacionespesifica set last_update = EditFechaF where id=idR;
commit;
else
rollback;
end if;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `ModificarResponseChoice` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `ModificarResponseChoice`(choiceId int,nam varchar(1000))
BEGIN
start transaction;
update response_choice set text = nam where id = choiceId;
commit;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `modificarRoles` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `modificarRoles`(rolId int,nombre varchar(50),descripcion varchar(1000))
BEGIN
	DECLARE err int default 0;
    DECLARE CONTINUE HANDLER FOR sqlexception set err=1;
    Start transaction;   
    
	update roles r set r.Name=nombre,
        r.Description=descripcion
        where r.id=rolId;
        
        if err=1 then
			select "No fue posible realizar la modificación";
            rollback;
		else 
			select "Modificación exitosa";
            commit;
		end if;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `ModificarServicio` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `ModificarServicio`(IdServicio int, EditNombre varchar(30), EditTipo varchar(50), EditCosto double(9,2),EditDescripcion varchar(500), EditUpdate timestamp, act tinyint)
BEGIN
start transaction;
##=====================================================================
if EditNombre is not null
then
update servicio set nombre = EditNombre where id=IdServicio;
commit;
else
rollback;
end if;
##=====================================================================
if EditTipo is not null
then
update servicio set tipo = EditTipo where id=IdServicio;
commit;
else
rollback;
end if;
##=====================================================================
if EditCosto is not null
then
update servicio set costo = EditCosto where id=IdServicio;
commit;
else
rollback;
end if;
##=====================================================================
if EditDescripcion is not null
then
update servicio set Descripcion = EditDescripcion where id=IdServicio;
commit;
else
rollback;
end if;

##=====================================================================
if EditUpdate is not null
then
update servicio set last_update = EditUpdate where id=IdServicio;
commit;
else
rollback;
end if;
##=====================================================================
##=====================================================================
if act is not null
then
update servicio set activo = act where id=IdServicio;
commit;
else
rollback;
end if;
##=====================================================================
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `ModificarStatus` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `ModificarStatus`(idStatus int,EditNombre varchar(20))
BEGIN
start transaction;
##=====================================================================
if EditNombre is not null
then
update status set nombre = EditNombre where id=IdStatus;
commit;
else
rollback;
end if;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `modificarTipoDeUsuario` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `modificarTipoDeUsuario`(tipoUsuarioId int,nombre varchar(50),descripcion varchar(1000))
BEGIN
	DECLARE err int default 0;
    DECLARE CONTINUE HANDLER FOR sqlexception set err=1;
    Start transaction;   
    
	update tipo_usuario t set t.Name=nombre,
        t.Description=descripcion
        where t.id=tipoUsuarioId;
        
        if err=1 then
			select "No fue posible realizar la modificación";
            rollback;
		else 
			select "Modificación exitosa";
            commit;
		end if;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `modificarToken` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `modificarToken`( usuarioId int,token varchar(100))
BEGIN
	DECLARE err int default 0;
    DECLARE CONTINUE HANDLER FOR sqlexception set err=1;
    Start transaction;   
    
	update tokens t set t.token=token
        where t.Usuario_id=usuarioId;
        
        if err=1 then
			select "No fue posible realizar la modificación";
            rollback;
		else 
			select "Modificación exitosa";
            commit;
		end if;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `modificarUsuario` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `modificarUsuario`(usuarioId int, userName varchar(50),nombre varchar(50),lastName varchar(50),hashed_password varchar(100),email varchar(254), gender varchar(10), birthday date, knowledgeLevel varchar(20), Google varchar(255),Facebook varchar(255),tipoUsuario varchar(20))
BEGIN
	
    DECLARE user_tipo_usuario int default (select t.id from tipo_usuario t where t.Name=tipoUsuario);
    DECLARE user_role int default (select r.id from roles r where r.Name=rol_usuario);
    DECLARE err int default 0;
    DECLARE CONTINUE HANDLER FOR sqlexception set err=1;
    Start transaction;    

	update usuario u set u.Username=userName,
        u.name=nombre,
        u.lastname=lastname,
        u.hashed_password=hashed_password,
        u.email=email,
        u.gender=gender,
        u.birthday=birthday,
        u.knowledge_level=knowledgeLevel,
        u.Google=Google,
        u.Facebook=Facebook,
        u.Tipo_usuario_id=user_tipo_usuario
        where u.id=usuarioId;
        

        if err=1 then
			select "No fue posible realizar la modificación";
            rollback;
		else 
			select "Modificación exitosa";
            commit;
		end if;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `modificarVinicola` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `modificarVinicola`(vinicolaId int, nombre varchar(50), logo varchar(100), direccion varchar(100), codigoPost int, descripcion text)
BEGIN
	DECLARE err int default 0;
    DECLARE CONTINUE HANDLER FOR sqlexception set err=1;
    Start transaction;    
    
    	update vinicola v set v.nombre=nombre,
        v.logo=logo,
        v.direccion=direccion,
        v.codigoPost=codigoPost,
        v.Descripcion=descripcion
        where v.id=vinicolaId;
        
         if err=1 then
			select "No fue posible realizar la modificación";
            rollback;
		else 
			select "Modificación exitosa";
            commit;
		end if;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `retrieveHorario` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `retrieveHorario`(fechaEntry date,idServicio int, idVinicola int)
BEGIN

declare done int default 0;
declare idcur int;
declare cur cursor for 
        select id from horarios 
        where servicio_idServicio = idServicio 
        and vinicola_idVinicola = idVinicola 
        and dias_id = dayofweek(FechaEntry);
    declare continue handler for not found set done = 1;
SET SQL_SAFE_UPDATES=0;
drop table if exists tempable;
create temporary table tempable(id int,horaApertura time, horaCierre time, maximoAforo int, Servicio_idServicio int, Vinicola_idVinicola int, Dias_id int, EspaciosDisponibles int);

insert into tempable (id,horaApertura, horaCierre, maximoAforo, Servicio_idServicio, Vinicola_idVinicola, Dias_id, EspaciosDisponibles)
    (select h.*, ifnull(h.maximoAforo-sum(r.cantidad_personas),h.maximoAforo) as EspaciosDisponibles
        from horarios h 
            join dias d on d.id=h.Dias_id 
            left join reservacionespesifica r on 
            r.Horarios_id=h.id
            where d.id=dayofweek(FechaEntry) 
                and (h.maximoAforo-r.cantidad_personas>0 or r.id is null) 
                and (h.Vinicola_idVinicola = idVinicola) 
                and (h.Servicio_idServicio = idServicio )
                and (r.fecha=FechaEntry)
            group by h.id);
select * from tempable;
open cur;
    fillDisponibilidad: LOOP
        fetch cur into idcur;
        if done = 1 then 
            leave fillDisponibilidad;
        end if;
		
        if(idcur not in (select id from tempable)) then 
            insert into tempable (id,horaApertura, horaCierre, maximoAforo, Servicio_idServicio, Vinicola_idVinicola, Dias_id, EspaciosDisponibles) 
            (select *,maximoAforo from horarios 
            where servicio_idServicio = idServicio 
            and vinicola_idVinicola = idVinicola 
            and dias_id = dayofweek(FechaEntry)
            and id = idcur);
            select * from tempable;
        end if;
end loop fillDisponibilidad;
close cur;

delete from tempable where EspaciosDisponibles <= 0;

if ((select count(id) from tempable) != 0) then
    select * from tempable;
    else
     insert into tempable (id,horaApertura, horaCierre, maximoAforo, Servicio_idServicio, Vinicola_idVinicola, Dias_id, EspaciosDisponibles) 
    values (1,null,null,0,idServicio,idVinicola,1,1);
    select * from tempable;
end if;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `retrieveHorarioVin` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `retrieveHorarioVin`(idServ int, idUser int)
BEGIN
    Declare bidVin int default (select Vinicola_id from usuario where id = idUser);
    Declare bidServ int default (select id from servicio where id = idServ);

    if bidVin is not null and bidServ is not null then
        select h.*, ifnull(h.maximoAforo-sum(r.cantidad_personas),h.maximoAforo) as EspaciosDisponibles
        from horarios h 
            join dias d on d.id=h.Dias_id 
            left join reservacionespesifica r on 
            r.Horarios_id=h.id where Servicio_idServicio = bidServ and Vinicola_idVinicola = bidVin
            group by h.id;
    end if;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `retrievePreguntas` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `retrievePreguntas`(id int)
BEGIN
	select q.id,q.text,q.updated,q.question_type_id from question_order qo 
join question q on qo.question_id=q.id
join survey s on s.id=qo.survey_id
where s.id=id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `retrievePuntoTuristico` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `retrievePuntoTuristico`(iduser int)
BEGIN
    Declare bidVin int default (select Vinicola_id from usuario where id = iduser);

    if bidVin is not null then
        select * from Punto_Turistico where Vinicola_idVinicola = bidVin;
    end if;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `retrievePuntoTuristicoVin` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `retrievePuntoTuristicoVin`(idUser int)
BEGIN
  Declare idVin int default (select Vinicola_id from usuario where id = idUser);
   select * from punto_turistico where Vinicola_idVinicola = idVin;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `retrieveReservasUsuarios` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `retrieveReservasUsuarios`(iduser int)
BEGIN
    select * from reservacionespesifica
    where Usuario_id = idUser;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `retrieveReservasVinicola` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `retrieveReservasVinicola`(iduser int, idservicio int)
BEGIN
	Declare idVin int default (select Vinicola_id from usuario where id = idUser);
    
	select rs.* from reservacionespesifica rs 
	join horarios h on h.id=rs.horarios_id
	join servicio s on h.Servicio_idServicio = s.id
	where h.Vinicola_idVinicola=idVin AND s.id=idservicio;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `retrieveServicio` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `retrieveServicio`(nombreVin varchar(30))
BEGIN
	SELECT * 
    FROM Servicio s 
    LEFT JOIN vinicola v on s.Vinicola_idVinicola = v.id 
    where v.nombre = nombreVin;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `retrieveServicioVinicola` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `retrieveServicioVinicola`(idUser int)
BEGIN
    Declare idVin int default (select Vinicola_id from usuario where id = idUser);
    select * from servicio where Vinicola_idVinicola = idVin and activo=1;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `retrieveSurvey` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `retrieveSurvey`(idUsuario int)
BEGIN
	declare idVinicola int default (select vinicola_id from usuario where id=idUsuario ) ;
	select s.name,s.description,s.id,s.updated,s.vinicola_id from survey s where vinicola_id=idVinicola;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `retrieveToken` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `retrieveToken`(nombTok varchar(255))
BEGIN
	select * from tokens where token = nombTok;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `retrieveVinicola` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `retrieveVinicola`(nVinicola varchar(30))
BEGIN
select * from vinicola where nombre like CONCAT('%', nVinicola, '%');
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `retriveRol` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `retriveRol`(nomRol varchar(30))
BEGIN
select * from roles where Name like '%nomRol%' LIMIT 1;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-22 13:31:02
