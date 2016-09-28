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
DROP DATABASE IF EXISTS `spring-app`;
CREATE DATABASE IF NOT EXISTS `spring-app` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `spring-app`;


-- 导出  表 spring-app.sys_dict 结构
DROP TABLE IF EXISTS `sys_dict`;
CREATE TABLE IF NOT EXISTS `sys_dict` (
  `id` varchar(50) NOT NULL,
  `code` varchar(50) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `type` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  spring-app.sys_dict 的数据：~2 rows (大约)
/*!40000 ALTER TABLE `sys_dict` DISABLE KEYS */;
INSERT INTO `sys_dict` (`id`, `code`, `name`, `type`) VALUES
	('0e05c0f2-a0bc-4b75-8240-7500c9879a04', '2', '按钮', '1'),
	('a4c4df86-d72e-4cea-b90e-753440faf6f2', '1', '菜单', '1');
/*!40000 ALTER TABLE `sys_dict` ENABLE KEYS */;


-- 导出  表 spring-app.sys_resources 结构
DROP TABLE IF EXISTS `sys_resources`;
CREATE TABLE IF NOT EXISTS `sys_resources` (
  `id` varchar(50) NOT NULL,
  `pid` varchar(50) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `url` varchar(50) DEFAULT NULL,
  `type` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  spring-app.sys_resources 的数据：~7 rows (大约)
/*!40000 ALTER TABLE `sys_resources` DISABLE KEYS */;
INSERT INTO `sys_resources` (`id`, `pid`, `name`, `url`, `type`) VALUES
	('0cf26ffd-88e9-42ca-91fb-374359e12f82', 'a9b97767-54ff-4477-a81a-274d6e2b5ce9', '菜单管理', '/sys/resources/toList.do', '1'),
	('1', '', '菜单', '/', '1'),
	('13fd01f1-20d8-49fd-9630-6fb7f8539920', 'a9b97767-54ff-4477-a81a-274d6e2b5ce9', '字典管理', '/sys/dict/toList.do', '1'),
	('2b56b958-3b0d-46d4-8988-d7c5ae1d804b', 'a9b97767-54ff-4477-a81a-274d6e2b5ce9', '用户管理', '/sys/user/toList.do', '1'),
	('652b3c26-5085-4739-94db-ebbbb1397acf', '2b56b958-3b0d-46d4-8988-d7c5ae1d804b', '添加', '/sys/user/toAdd', '2'),
	('a9b97767-54ff-4477-a81a-274d6e2b5ce9', '1', '系统管理', '/', '1'),
	('c56d6e95-5515-492b-866a-b8555e7b647c', 'a9b97767-54ff-4477-a81a-274d6e2b5ce9', '角色管理', '/sys/role/toList.do', '1');
/*!40000 ALTER TABLE `sys_resources` ENABLE KEYS */;


-- 导出  表 spring-app.sys_role 结构
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE IF NOT EXISTS `sys_role` (
  `id` varchar(50) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  spring-app.sys_role 的数据：~2 rows (大约)
/*!40000 ALTER TABLE `sys_role` DISABLE KEYS */;
INSERT INTO `sys_role` (`id`, `name`) VALUES
	('f9127759-1116-4159-adcf-98dbe1d77576', '软件工程师');
/*!40000 ALTER TABLE `sys_role` ENABLE KEYS */;


-- 导出  表 spring-app.sys_role_resources 结构
DROP TABLE IF EXISTS `sys_role_resources`;
CREATE TABLE IF NOT EXISTS `sys_role_resources` (
  `id` varchar(50) NOT NULL,
  `role_id` varchar(50) DEFAULT NULL,
  `resources_id` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  spring-app.sys_role_resources 的数据：~7 rows (大约)
/*!40000 ALTER TABLE `sys_role_resources` DISABLE KEYS */;
INSERT INTO `sys_role_resources` (`id`, `role_id`, `resources_id`) VALUES
	('47db8090-c0a0-44eb-a7dd-20ef870fb508', 'f9127759-1116-4159-adcf-98dbe1d77576', 'c56d6e95-5515-492b-866a-b8555e7b647c'),
	('5ba8d4af-3acf-493e-854b-64b1c0e30080', 'f9127759-1116-4159-adcf-98dbe1d77576', '0cf26ffd-88e9-42ca-91fb-374359e12f82'),
	('6ef3b3df-a888-4b13-97d6-7f72641d6ca0', 'f9127759-1116-4159-adcf-98dbe1d77576', '652b3c26-5085-4739-94db-ebbbb1397acf'),
	('7ecd0d84-fb23-430b-a2c4-90d3c94fe7a7', 'f9127759-1116-4159-adcf-98dbe1d77576', '1'),
	('82b3d05d-7f59-47f1-a3a7-01495b9bcf23', 'f9127759-1116-4159-adcf-98dbe1d77576', '13fd01f1-20d8-49fd-9630-6fb7f8539920'),
	('bdf5b84c-1749-4752-bee4-f6849506bced', 'f9127759-1116-4159-adcf-98dbe1d77576', 'a9b97767-54ff-4477-a81a-274d6e2b5ce9'),
	('dd6e071b-a9e5-456a-b521-6d0724a50d75', 'f9127759-1116-4159-adcf-98dbe1d77576', '2b56b958-3b0d-46d4-8988-d7c5ae1d804b');
/*!40000 ALTER TABLE `sys_role_resources` ENABLE KEYS */;


-- 导出  表 spring-app.sys_user 结构
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE IF NOT EXISTS `sys_user` (
  `id` varchar(50) NOT NULL,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  spring-app.sys_user 的数据：~2 rows (大约)
/*!40000 ALTER TABLE `sys_user` DISABLE KEYS */;
INSERT INTO `sys_user` (`id`, `username`, `password`) VALUES
	('62619962-c88c-4530-b424-ced43b30e1ea', 'wangsong', '532da1c5da9fb86bf61b2a63487f300c');
/*!40000 ALTER TABLE `sys_user` ENABLE KEYS */;


-- 导出  表 spring-app.sys_user_role 结构
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE IF NOT EXISTS `sys_user_role` (
  `id` varchar(50) NOT NULL,
  `user_id` varchar(50) DEFAULT NULL,
  `role_id` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  spring-app.sys_user_role 的数据：~3 rows (大约)
/*!40000 ALTER TABLE `sys_user_role` DISABLE KEYS */;
INSERT INTO `sys_user_role` (`id`, `user_id`, `role_id`) VALUES
	('5b6e768a-088a-472a-a005-7122de1f92ff', '62619962-c88c-4530-b424-ced43b30e1ea', 'f9127759-1116-4159-adcf-98dbe1d77576');
/*!40000 ALTER TABLE `sys_user_role` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
