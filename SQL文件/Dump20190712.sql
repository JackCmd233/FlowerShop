-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: shop
-- ------------------------------------------------------
-- Server version	5.7.20-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `ausertable`
--

DROP TABLE IF EXISTS `ausertable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ausertable` (
  `aname` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `apwd` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`aname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ausertable`
--

LOCK TABLES `ausertable` WRITE;
/*!40000 ALTER TABLE `ausertable` DISABLE KEYS */;
INSERT INTO `ausertable` VALUES ('admin','admin');
/*!40000 ALTER TABLE `ausertable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `busertable`
--

DROP TABLE IF EXISTS `busertable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `busertable` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bemail` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `bpwd` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `bemail_UNIQUE` (`bemail`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `busertable`
--

LOCK TABLES `busertable` WRITE;
/*!40000 ALTER TABLE `busertable` DISABLE KEYS */;
INSERT INTO `busertable` VALUES (5,'15697404559','123456'),(7,'123@qq.com','123456'),(8,'1','123456');
/*!40000 ALTER TABLE `busertable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `carttable`
--

DROP TABLE IF EXISTS `carttable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `carttable` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `busertable_id` int(11) NOT NULL,
  `goodstable_id` int(11) NOT NULL,
  `shoppingnum` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `bid` (`busertable_id`),
  KEY `gno` (`goodstable_id`),
  CONSTRAINT `bid` FOREIGN KEY (`busertable_id`) REFERENCES `busertable` (`id`),
  CONSTRAINT `gno` FOREIGN KEY (`goodstable_id`) REFERENCES `goodstable` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carttable`
--

LOCK TABLES `carttable` WRITE;
/*!40000 ALTER TABLE `carttable` DISABLE KEYS */;
/*!40000 ALTER TABLE `carttable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `focustable`
--

DROP TABLE IF EXISTS `focustable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `focustable` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `goodstable_id` int(11) NOT NULL,
  `busertable_id` int(11) NOT NULL,
  `focustime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `gno1` (`goodstable_id`),
  KEY `bid1` (`busertable_id`),
  CONSTRAINT `bid1` FOREIGN KEY (`busertable_id`) REFERENCES `busertable` (`id`),
  CONSTRAINT `gno1` FOREIGN KEY (`goodstable_id`) REFERENCES `goodstable` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `focustable`
--

LOCK TABLES `focustable` WRITE;
/*!40000 ALTER TABLE `focustable` DISABLE KEYS */;
/*!40000 ALTER TABLE `focustable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `goodstable`
--

DROP TABLE IF EXISTS `goodstable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `goodstable` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `gname` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `goprice` double DEFAULT NULL,
  `grprice` double DEFAULT NULL,
  `gstore` int(11) DEFAULT NULL,
  `gpicture` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `goodstype_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `typeid` (`goodstype_id`),
  CONSTRAINT `typeid` FOREIGN KEY (`goodstype_id`) REFERENCES `goodstype` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `goodstable`
--

LOCK TABLES `goodstable` WRITE;
/*!40000 ALTER TABLE `goodstable` DISABLE KEYS */;
INSERT INTO `goodstable` VALUES (14,'百合',15,12,107,'20190619185307617.jpg',15),(15,'栀子花',15,10,43,'20190619185316783.jpg',15),(18,'玫瑰',35,30,157,'20190619185326643.jpg',15),(19,'风信子',45,36,53,'20190619185336910.jpg',17),(20,'永生花1',56,55,38,'20190619185243804.jpg',18),(21,'花篮1',198,168,55,'20190624214411734.jpg',19),(22,'仙人球',36,30,64,'20190624214500931.jpg',17),(23,'igg',20,10,17,'20190625101128883.jpg',19);
/*!40000 ALTER TABLE `goodstable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `goodstype`
--

DROP TABLE IF EXISTS `goodstype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `goodstype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `typename` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `goodstype`
--

LOCK TABLES `goodstype` WRITE;
/*!40000 ALTER TABLE `goodstype` DISABLE KEYS */;
INSERT INTO `goodstype` VALUES (15,'鲜花'),(17,'盆栽'),(18,'永生花'),(19,'开业花篮');
/*!40000 ALTER TABLE `goodstype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `noticetable`
--

DROP TABLE IF EXISTS `noticetable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `noticetable` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ntitle` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ncontent` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ntime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `noticetable`
--

LOCK TABLES `noticetable` WRITE;
/*!40000 ALTER TABLE `noticetable` DISABLE KEYS */;
INSERT INTO `noticetable` VALUES (4,'2019国庆节大促销','所有鲜花打八折','2019-06-18 17:45:35'),(5,'情人节促销','我们为您准备浪漫，您准备好了吗？','2019-06-23 21:17:58');
/*!40000 ALTER TABLE `noticetable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orderbasetable`
--

DROP TABLE IF EXISTS `orderbasetable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orderbasetable` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `busertable_id` int(11) NOT NULL,
  `amount` double NOT NULL,
  `status` tinyint(4) NOT NULL,
  `orderdate` datetime NOT NULL,
  `adress` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  KEY `bid2` (`busertable_id`),
  CONSTRAINT `bid2` FOREIGN KEY (`busertable_id`) REFERENCES `busertable` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderbasetable`
--

LOCK TABLES `orderbasetable` WRITE;
/*!40000 ALTER TABLE `orderbasetable` DISABLE KEYS */;
/*!40000 ALTER TABLE `orderbasetable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orderdetail`
--

DROP TABLE IF EXISTS `orderdetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orderdetail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `orderbasetable_id` int(11) NOT NULL,
  `goodstable_id` int(11) NOT NULL,
  `shoppingnum` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `odsn` (`orderbasetable_id`),
  KEY `gno3` (`goodstable_id`),
  CONSTRAINT `gno3` FOREIGN KEY (`goodstable_id`) REFERENCES `goodstable` (`id`),
  CONSTRAINT `odsn` FOREIGN KEY (`orderbasetable_id`) REFERENCES `orderbasetable` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderdetail`
--

LOCK TABLES `orderdetail` WRITE;
/*!40000 ALTER TABLE `orderdetail` DISABLE KEYS */;
/*!40000 ALTER TABLE `orderdetail` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-07-12 10:20:24
