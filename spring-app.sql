-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        5.6.28-log - MySQL Community Server (GPL)
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  9.3.0.4984
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 导出 spring-app 的数据库结构
CREATE DATABASE IF NOT EXISTS `spring-app` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `spring-app`;


-- 导出  表 spring-app.sys_resources 结构
CREATE TABLE IF NOT EXISTS `sys_resources` (
  `id` varchar(50) NOT NULL,
  `pid` varchar(50) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `url` varchar(50) DEFAULT NULL,
  `type` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  spring-app.sys_resources 的数据：~3 rows (大约)
/*!40000 ALTER TABLE `sys_resources` DISABLE KEYS */;
INSERT INTO `sys_resources` (`id`, `pid`, `name`, `url`, `type`) VALUES
	('7d7cadc1-8874-4335-992d-137e23e8f1ff', 'a1a9ad95-cd9f-47b9-93f4-dbc4c3ef79d3', '用户管理', 'sys/user', NULL),
	('a1a9ad95-cd9f-47b9-93f4-dbc4c3ef79d3', 'ddc7e7cf-f6f5-4a1f-b16d-642e10250aaa', '系统管理', '', NULL),
	('ddc7e7cf-f6f5-4a1f-b16d-642e10250aaa', NULL, '', '', NULL);
/*!40000 ALTER TABLE `sys_resources` ENABLE KEYS */;


-- 导出  表 spring-app.sys_role 结构
CREATE TABLE IF NOT EXISTS `sys_role` (
  `id` varchar(50) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  spring-app.sys_role 的数据：~1 rows (大约)
/*!40000 ALTER TABLE `sys_role` DISABLE KEYS */;
INSERT INTO `sys_role` (`id`, `name`) VALUES
	('f9127759-1116-4159-adcf-98dbe1d77576', '软件工程师');
/*!40000 ALTER TABLE `sys_role` ENABLE KEYS */;


-- 导出  表 spring-app.sys_role_resources 结构
CREATE TABLE IF NOT EXISTS `sys_role_resources` (
  `id` varchar(50) NOT NULL,
  `role_id` varchar(50) DEFAULT NULL,
  `resources_id` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  spring-app.sys_role_resources 的数据：~1 rows (大约)
/*!40000 ALTER TABLE `sys_role_resources` DISABLE KEYS */;
INSERT INTO `sys_role_resources` (`id`, `role_id`, `resources_id`) VALUES
	('90659110-5a4a-476a-aa7c-eb6ec6151dcb', 'f9127759-1116-4159-adcf-98dbe1d77576', '7d7cadc1-8874-4335-992d-137e23e8f1ff');
/*!40000 ALTER TABLE `sys_role_resources` ENABLE KEYS */;


-- 导出  表 spring-app.sys_user 结构
CREATE TABLE IF NOT EXISTS `sys_user` (
  `id` varchar(50) NOT NULL,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  spring-app.sys_user 的数据：~1 rows (大约)
/*!40000 ALTER TABLE `sys_user` DISABLE KEYS */;
INSERT INTO `sys_user` (`id`, `username`, `password`) VALUES
	('62619962-c88c-4530-b424-ced43b30e1ea', 'wangsong', 'wangsong');
/*!40000 ALTER TABLE `sys_user` ENABLE KEYS */;


-- 导出  表 spring-app.sys_user_role 结构
CREATE TABLE IF NOT EXISTS `sys_user_role` (
  `id` varchar(50) NOT NULL,
  `user_id` varchar(50) DEFAULT NULL,
  `role_id` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  spring-app.sys_user_role 的数据：~1 rows (大约)
/*!40000 ALTER TABLE `sys_user_role` DISABLE KEYS */;
INSERT INTO `sys_user_role` (`id`, `user_id`, `role_id`) VALUES
	('5b6e768a-088a-472a-a005-7122de1f92ff', '62619962-c88c-4530-b424-ced43b30e1ea', 'f9127759-1116-4159-adcf-98dbe1d77576');
/*!40000 ALTER TABLE `sys_user_role` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
