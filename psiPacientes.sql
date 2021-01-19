-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: pacientes
-- ------------------------------------------------------
-- Server version	8.0.19

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
-- Table structure for table `antecedentesclinicos`
--

DROP TABLE IF EXISTS `antecedentesclinicos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `antecedentesclinicos` (
  `id` int NOT NULL,
  `clienteID` int NOT NULL,
  `enfermedadGrave` varchar(100) NOT NULL,
  `accidentes` varchar(100) NOT NULL,
  `medicamento` varchar(100) NOT NULL,
  `intQuirurgica` varchar(100) NOT NULL,
  `dispAuxiliar` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `clienteID` (`clienteID`),
  CONSTRAINT `antecedentesclinicos_ibfk_1` FOREIGN KEY (`clienteID`) REFERENCES `cliente` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `antecedentesclinicos`
--

LOCK TABLES `antecedentesclinicos` WRITE;
/*!40000 ALTER TABLE `antecedentesclinicos` DISABLE KEYS */;
/*!40000 ALTER TABLE `antecedentesclinicos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `antecedentesfamiliares`
--

DROP TABLE IF EXISTS `antecedentesfamiliares`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `antecedentesfamiliares` (
  `id` int NOT NULL,
  `clienteID` int NOT NULL,
  `psicologia` varchar(100) NOT NULL,
  `psiquiatra` varchar(100) NOT NULL,
  `patologia` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `clienteID` (`clienteID`),
  CONSTRAINT `antecedentesfamiliares_ibfk_1` FOREIGN KEY (`clienteID`) REFERENCES `cliente` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `antecedentesfamiliares`
--

LOCK TABLES `antecedentesfamiliares` WRITE;
/*!40000 ALTER TABLE `antecedentesfamiliares` DISABLE KEYS */;
/*!40000 ALTER TABLE `antecedentesfamiliares` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `edad` int NOT NULL,
  `nacimiento` varchar(50) NOT NULL,
  `escolaridad` varchar(50) NOT NULL,
  `religion` varchar(50) NOT NULL,
  `ocupacion` varchar(50) NOT NULL,
  `actExtra` varchar(50) NOT NULL,
  `direccion` varchar(50) NOT NULL,
  `telefono` varchar(20) NOT NULL,
  `servicio` varchar(50) NOT NULL,
  `asunto` varchar(50) NOT NULL,
  `objetivo` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'Alejandro Alfonso','Magdaleno Baltazar',45,'JDateChooser','Licenciatura','Catolico','Abogado','Natacion','Mariano Azuela #315 Col. Aeropuerto','6462981432','Medios de internet y recomendacion de conocidos','Adiccion al tabaco','Dejar el tabaco'),(2,'Alejandro Fernando','Campos Martinez',17,'12/0/2007','Bachillerato','Ninguna','Estudiante','Beisball','Mariano Azuela #315','6461208876','Por medio de publicidad de redes sociales ','Fumador','Dejar de fumar'),(3,'juan','perez',7,'11/5/2021','Ninguno','alguna','','actividad','casa','523532','me entere de muchas maneras','un asunto','objetivo'),(4,'Juan Pablo','Espinoza Bartolero',33,'16/2/2000','Profesional','Satanico','Esrudiante','Ninguna','La Juarez','6462004321','canalizacion','Adiccion a la marihuana','Dejar la adiccion'),(5,'Mario Alberto','Escobedo Sanchez',13,'4/1/2008','Secundaria','Ninguna','Estudiante','Ninguna','UNa direccion','6461291212','Canalizado','Depresion','Controlar la depresion'),(6,'Mario Alberto','Escobedo Sanchez',13,'4/1/2008','Secundaria','Ninguna','Estudiante','Ninguna','UNa direccion','','Canalizado','Depresion','Controlar la depresion'),(7,'Mario Alberto','',13,'4/1/2008','Secundaria','Ninguna','Estudiante','Ninguna','UNa direccion','','Canalizado','Depresion','Controlar la depresion'),(8,'Juan Jose','Gonzales Estrada',10,'8/1/2021','Primaria','Catolico','Estudiante','Ninguna','Villas 1','123','Familia','Depresion','Controlar la Depresion'),(9,'Juan Jose','Martinez Sanchez',8,'15/1/2021','Bachillerato','algo','algo','algo','algo','12341','algo','algo','algo');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estadomental`
--

DROP TABLE IF EXISTS `estadomental`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `estadomental` (
  `id` int NOT NULL,
  `clienteID` int NOT NULL,
  `percepcionLenguaje` varchar(200) NOT NULL,
  `estadoEmocional` varchar(200) NOT NULL,
  `contactoRealidad` varchar(200) NOT NULL,
  `higienePersonal` varchar(200) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `clienteID` (`clienteID`),
  CONSTRAINT `estadomental_ibfk_1` FOREIGN KEY (`clienteID`) REFERENCES `cliente` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estadomental`
--

LOCK TABLES `estadomental` WRITE;
/*!40000 ALTER TABLE `estadomental` DISABLE KEYS */;
/*!40000 ALTER TABLE `estadomental` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `funcfamiliar`
--

DROP TABLE IF EXISTS `funcfamiliar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `funcfamiliar` (
  `id` int NOT NULL,
  `clienteID` int NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `parentesco` varchar(50) NOT NULL,
  `edad` int NOT NULL,
  `ocupacion` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `clienteID` (`clienteID`),
  CONSTRAINT `funcfamiliar_ibfk_1` FOREIGN KEY (`clienteID`) REFERENCES `cliente` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcfamiliar`
--

LOCK TABLES `funcfamiliar` WRITE;
/*!40000 ALTER TABLE `funcfamiliar` DISABLE KEYS */;
/*!40000 ALTER TABLE `funcfamiliar` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `habitos`
--

DROP TABLE IF EXISTS `habitos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `habitos` (
  `id` int NOT NULL,
  `clienteID` int NOT NULL,
  `dream` varchar(200) NOT NULL,
  `alimenticio` varchar(200) NOT NULL,
  `antPsicologicos` varchar(200) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `clienteID` (`clienteID`),
  CONSTRAINT `habitos_ibfk_1` FOREIGN KEY (`clienteID`) REFERENCES `cliente` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `habitos`
--

LOCK TABLES `habitos` WRITE;
/*!40000 ALTER TABLE `habitos` DISABLE KEYS */;
/*!40000 ALTER TABLE `habitos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `historiasexual`
--

DROP TABLE IF EXISTS `historiasexual`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `historiasexual` (
  `id` int NOT NULL,
  `clienteID` int NOT NULL,
  `abusoSexual` varchar(20) NOT NULL,
  `embarazo` varchar(20) NOT NULL,
  `edad` int NOT NULL,
  `prefSexual` varchar(50) NOT NULL,
  `traumas` varchar(20) NOT NULL,
  `infoTraumas` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `clienteID` (`clienteID`),
  CONSTRAINT `historiasexual_ibfk_1` FOREIGN KEY (`clienteID`) REFERENCES `cliente` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `historiasexual`
--

LOCK TABLES `historiasexual` WRITE;
/*!40000 ALTER TABLE `historiasexual` DISABLE KEYS */;
/*!40000 ALTER TABLE `historiasexual` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `problema`
--

DROP TABLE IF EXISTS `problema`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `problema` (
  `id` int NOT NULL,
  `evolucion` varchar(200) NOT NULL,
  `causas` varchar(200) NOT NULL,
  `acciones` varchar(200) NOT NULL,
  `implicaciones` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `problema`
--

LOCK TABLES `problema` WRITE;
/*!40000 ALTER TABLE `problema` DISABLE KEYS */;
/*!40000 ALTER TABLE `problema` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `redsociales`
--

DROP TABLE IF EXISTS `redsociales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `redsociales` (
  `id` int NOT NULL,
  `clienteID` int NOT NULL,
  `social` varchar(200) NOT NULL,
  `laboral` varchar(200) NOT NULL,
  `vivienda` varchar(200) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `clienteID` (`clienteID`),
  CONSTRAINT `redsociales_ibfk_1` FOREIGN KEY (`clienteID`) REFERENCES `cliente` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `redsociales`
--

LOCK TABLES `redsociales` WRITE;
/*!40000 ALTER TABLE `redsociales` DISABLE KEYS */;
/*!40000 ALTER TABLE `redsociales` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reportesesion`
--

DROP TABLE IF EXISTS `reportesesion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reportesesion` (
  `id` int NOT NULL,
  `clienteID` int NOT NULL,
  `diagnostico` varchar(200) NOT NULL,
  `observaciones` varchar(200) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `clienteID` (`clienteID`),
  CONSTRAINT `reportesesion_ibfk_1` FOREIGN KEY (`clienteID`) REFERENCES `cliente` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reportesesion`
--

LOCK TABLES `reportesesion` WRITE;
/*!40000 ALTER TABLE `reportesesion` DISABLE KEYS */;
/*!40000 ALTER TABLE `reportesesion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (2,'administrador','admin'),(3,'user','12345'),(6,'admin','123'),(7,'admin2','1234');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'pacientes'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-01-19 14:34:54
