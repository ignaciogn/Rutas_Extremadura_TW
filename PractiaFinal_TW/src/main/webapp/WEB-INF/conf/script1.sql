-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: tw
-- ------------------------------------------------------
-- Server version	5.5.5-10.11.2-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `reservas`
--

DROP TABLE IF EXISTS `reservas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reservas` (
  `idUsuario` int(11) NOT NULL,
  `idRuta` int(11) NOT NULL,
  `fechaReserva` date NOT NULL,
  `usuariosM` int(11) NOT NULL,
  PRIMARY KEY (`idUsuario`,`idRuta`,`fechaReserva`),
  KEY `idRuta` (`idRuta`),
  CONSTRAINT `reservas_ibfk_1` FOREIGN KEY (`idUsuario`) REFERENCES `usuarios` (`id`),
  CONSTRAINT `reservas_ibfk_2` FOREIGN KEY (`idRuta`) REFERENCES `rutas` (`idRuta`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservas`
--

LOCK TABLES `reservas` WRITE;
/*!40000 ALTER TABLE `reservas` DISABLE KEYS */;
INSERT INTO `reservas` VALUES (2,2,'2023-04-01',20),(2,6,'2023-04-28',10),(3,7,'2023-04-01',5),(6,2,'2023-05-12',4),(6,6,'2023-06-25',2),(8,5,'2023-04-30',12),(8,8,'2023-08-12',11);
/*!40000 ALTER TABLE `reservas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rutas`
--

DROP TABLE IF EXISTS `rutas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rutas` (
  `idRuta` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `pathImagen` varchar(255) NOT NULL,
  `fechaIncorporacion` date NOT NULL,
  `maximoUsuario` int(11) NOT NULL,
  `dificultad` int(11) NOT NULL,
  `metros` int(11) NOT NULL,
  PRIMARY KEY (`idRuta`,`fechaIncorporacion`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rutas`
--

LOCK TABLES `rutas` WRITE;
/*!40000 ALTER TABLE `rutas` DISABLE KEYS */;
INSERT INTO `rutas` VALUES (2,'Ruta Roja, Castillo y Salto del Gitano','img/monfra.jpg','2022-03-10',30,2,9000),(3,'Circular de la Garganta de los Infiernos del Jerte','img/jerte.jpg','2022-05-17',20,2,16000),(4,'Castañar del Duque, Valle de Ambroz','img/duque.jpg','2023-01-20',25,3,9500),(5,'Las Apreturas del Almonte','img/almonte.jpg','2023-04-20',15,5,18000),(6,'Los Canchos de Ramiro (Cachorrilla)','img/ramiro.jpg','2022-05-17',30,3,11000),(7,'Ruta de las Grullas de Brozas','img/brozas.jpg','2022-09-01',23,2,16000),(8,'Ermita del Salor y Corralás','img/ermita.jpg','2022-09-01',23,1,8000);
/*!40000 ALTER TABLE `rutas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) DEFAULT NULL,
  `apellidos` varchar(50) DEFAULT NULL,
  `email` varchar(50) NOT NULL,
  `username` varchar(10) DEFAULT NULL,
  `password` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (2,'Juan','Pérez','juanperez@gmail.com','juanp','12345'),(3,'María','García','mariagarcia@hotmail.com','mariag','abcde'),(4,'Pedro','Rodríguez','pedrorodriguez@yahoo.com','pedror','qwerty'),(5,'Ana','Martínez','anamartinez@gmail.com','anam','11111'),(6,'Luis','Fernández','luisfernandez@gmail.com','luisf','22222'),(7,'Ignacio','Guerrero Noguera','ignacio@gmail.com','Ignacio','12345'),(8,'a','a','a','a','a');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `valoraciones`
--

DROP TABLE IF EXISTS `valoraciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `valoraciones` (
  `idValoracion` int(11) NOT NULL AUTO_INCREMENT,
  `idUsuario` int(11) NOT NULL,
  `idRuta` int(11) NOT NULL,
  `comentario` text NOT NULL,
  `fechaValoracion` date NOT NULL,
  `valor` int(11) NOT NULL,
  PRIMARY KEY (`idValoracion`),
  KEY `idUsuario` (`idUsuario`),
  KEY `idRuta` (`idRuta`),
  CONSTRAINT `valoraciones_ibfk_1` FOREIGN KEY (`idUsuario`) REFERENCES `usuarios` (`id`),
  CONSTRAINT `valoraciones_ibfk_2` FOREIGN KEY (`idRuta`) REFERENCES `rutas` (`idRuta`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `valoraciones`
--

LOCK TABLES `valoraciones` WRITE;
/*!40000 ALTER TABLE `valoraciones` DISABLE KEYS */;
INSERT INTO `valoraciones` VALUES (1,2,2,'!Muy buena ruta¡','2023-04-27',4),(2,2,5,'Ruta muy dura, bastante larga.','2023-04-27',3),(3,2,3,'Ruta decente','2023-04-27',3),(4,3,8,'Muy buena ruta','2023-04-27',4),(5,3,4,'Ruta muy mala','2023-04-27',1),(6,3,7,'Ruta bastante bonita','2023-04-27',4),(7,6,2,'Ruta muy normal','2023-04-27',2),(8,6,7,'Ruta muy buena','2023-04-27',5),(9,8,2,'!Ruta muy Buena!','2023-04-27',5);
/*!40000 ALTER TABLE `valoraciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'tw'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-04-27 12:20:04
