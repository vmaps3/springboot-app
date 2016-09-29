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
	('0ff729fc-a43c-4a5c-a2bf-07fbeefa2520', '13fd01f1-20d8-49fd-9630-6fb7f8539920', '删除', '/sys/dict/delete', '2'),
	('1', '', '菜单', '/', '1'),
	('1115d196-fd3a-4ca1-99c8-5452bae30c8f', '0cf26ffd-88e9-42ca-91fb-374359e12f82', '增加', '/sys/resources/add', '2'),
	('13fd01f1-20d8-49fd-9630-6fb7f8539920', 'a9b97767-54ff-4477-a81a-274d6e2b5ce9', '字典管理', '/sys/dict/toList.do', '1'),
	('21e9a57d-b7a2-45b0-8359-cc21d636c0fa', '0cf26ffd-88e9-42ca-91fb-374359e12f82', '更改', '/sys/resources/update', '2'),
	('2b56b958-3b0d-46d4-8988-d7c5ae1d804b', 'a9b97767-54ff-4477-a81a-274d6e2b5ce9', '用户管理', '/sys/user/toList.do', '1'),
	('32680760-3ad2-4ac5-bd2f-fca4917d8f74', '2b56b958-3b0d-46d4-8988-d7c5ae1d804b', '更改', '/sys/user/update', '2'),
	('51745327-1978-48ab-aa19-6986a3f628d7', 'c56d6e95-5515-492b-866a-b8555e7b647c', '添加', '/sys/role/add', '2'),
	('63efc666-ee88-45f7-bdad-2b019c19eb1d', '0cf26ffd-88e9-42ca-91fb-374359e12f82', '列表', '/sys/resources/list', '2'),
	('652b3c26-5085-4739-94db-ebbbb1397acf', '2b56b958-3b0d-46d4-8988-d7c5ae1d804b', '添加', '/sys/user/add', '2'),
	('8d1d2815-d011-4da9-a66e-573a5f056f62', '13fd01f1-20d8-49fd-9630-6fb7f8539920', '添加', '/sys/dict/add', '2'),
	('8fec88df-50c5-4a5e-800e-621d203f7a55', 'c56d6e95-5515-492b-866a-b8555e7b647c', '删除', '/sys/role/delete', '2'),
	('93400178-2c2f-47de-9b30-5d126b33e197', '2b56b958-3b0d-46d4-8988-d7c5ae1d804b', '列表', '/sys/user/list', '2'),
	('9ee4dade-b3af-4664-82c8-4d712f231db4', '2b56b958-3b0d-46d4-8988-d7c5ae1d804b', '删除', '/sys/user/delete', '2'),
	('a9b97767-54ff-4477-a81a-274d6e2b5ce9', '1', '系统管理', '/', '1'),
	('c01620cd-4845-4a4a-a72f-1524b3c54d24', '13fd01f1-20d8-49fd-9630-6fb7f8539920', '更改', '/sys/dict/update', '2'),
	('c56d6e95-5515-492b-866a-b8555e7b647c', 'a9b97767-54ff-4477-a81a-274d6e2b5ce9', '角色管理', '/sys/role/toList.do', '1'),
	('c65e7c94-a3c1-43b7-a8c7-94e1d693f0b5', 'c56d6e95-5515-492b-866a-b8555e7b647c', '更改', '/sys/role/update', '2'),
	('ea7a58c3-74d2-45c1-8b66-974cd82d1fbd', '13fd01f1-20d8-49fd-9630-6fb7f8539920', '列表', '/sys/dict/list', '2'),
	('ecb6527f-0548-40f7-b92e-6719ff3f9556', '0cf26ffd-88e9-42ca-91fb-374359e12f82', '删除', '/sys/resources/delete', '2'),
	('f0e5351e-7291-4d41-87c2-3ebfc5388d7c', 'c56d6e95-5515-492b-866a-b8555e7b647c', '列表', '/sys/role/list', '2');
/*!40000 ALTER TABLE `sys_resources` ENABLE KEYS */;


-- 导出  表 spring-app.sys_role 结构
DROP TABLE IF EXISTS `sys_role`;
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
	('0405b5a8-7584-40c8-83a5-a3c220a2783b', 'f9127759-1116-4159-adcf-98dbe1d77576', 'f0e5351e-7291-4d41-87c2-3ebfc5388d7c'),
	('0f58d03e-5c67-4ce5-a4a6-175d3455be79', 'f9127759-1116-4159-adcf-98dbe1d77576', '21e9a57d-b7a2-45b0-8359-cc21d636c0fa'),
	('1c453559-5471-4880-a128-60c3811bd37f', 'f9127759-1116-4159-adcf-98dbe1d77576', '63efc666-ee88-45f7-bdad-2b019c19eb1d'),
	('37edb002-aa8e-487c-9951-5ec25548f506', 'f9127759-1116-4159-adcf-98dbe1d77576', '652b3c26-5085-4739-94db-ebbbb1397acf'),
	('3dc77cc5-399d-4704-9189-813189a3e77d', 'f9127759-1116-4159-adcf-98dbe1d77576', '51745327-1978-48ab-aa19-6986a3f628d7'),
	('4058a954-f1c3-48f3-8770-0f28594dc578', 'f9127759-1116-4159-adcf-98dbe1d77576', '1'),
	('48912cea-745e-4cd4-a9d7-5a9db99a5475', 'f9127759-1116-4159-adcf-98dbe1d77576', '13fd01f1-20d8-49fd-9630-6fb7f8539920'),
	('58153dcc-97d0-4b0c-af92-ba2a6acbca46', 'f9127759-1116-4159-adcf-98dbe1d77576', 'c65e7c94-a3c1-43b7-a8c7-94e1d693f0b5'),
	('59591767-6e52-4f30-8d48-c65b1617c770', 'f9127759-1116-4159-adcf-98dbe1d77576', '0cf26ffd-88e9-42ca-91fb-374359e12f82'),
	('5da79640-9d0f-475e-a92b-605f01b1e311', 'f9127759-1116-4159-adcf-98dbe1d77576', '2b56b958-3b0d-46d4-8988-d7c5ae1d804b'),
	('5ece3f98-b9be-48b6-b0ae-e3a5a1274790', 'f9127759-1116-4159-adcf-98dbe1d77576', 'c56d6e95-5515-492b-866a-b8555e7b647c'),
	('60e8b598-38e6-4eb2-b1f0-7e67388667f6', 'f9127759-1116-4159-adcf-98dbe1d77576', '1115d196-fd3a-4ca1-99c8-5452bae30c8f'),
	('8b9a5e15-b95a-4cbe-bfc5-76acb4a410ae', 'f9127759-1116-4159-adcf-98dbe1d77576', 'a9b97767-54ff-4477-a81a-274d6e2b5ce9'),
	('9ecf0f5b-5eda-4990-ab2b-5484af04a7f1', 'f9127759-1116-4159-adcf-98dbe1d77576', 'c01620cd-4845-4a4a-a72f-1524b3c54d24'),
	('c7e17816-f360-4c17-a677-80c7580eec0a', 'f9127759-1116-4159-adcf-98dbe1d77576', '32680760-3ad2-4ac5-bd2f-fca4917d8f74'),
	('d3e72b42-a845-4001-ac79-af1228aaae00', 'f9127759-1116-4159-adcf-98dbe1d77576', '0ff729fc-a43c-4a5c-a2bf-07fbeefa2520'),
	('e6117127-9ad6-42b3-b5a4-e5520f1981ce', 'f9127759-1116-4159-adcf-98dbe1d77576', '93400178-2c2f-47de-9b30-5d126b33e197'),
	('e7ef2593-7dab-44a3-853e-0409cbcbdad9', 'f9127759-1116-4159-adcf-98dbe1d77576', 'ecb6527f-0548-40f7-b92e-6719ff3f9556'),
	('ed294c3c-e74f-492a-8605-accc0bd7d215', 'f9127759-1116-4159-adcf-98dbe1d77576', 'ea7a58c3-74d2-45c1-8b66-974cd82d1fbd'),
	('f4dd2900-7ba8-425b-9e56-52a87f435735', 'f9127759-1116-4159-adcf-98dbe1d77576', '8d1d2815-d011-4da9-a66e-573a5f056f62'),
	('faf27ab9-e5b4-4d51-a156-8182bb03e983', 'f9127759-1116-4159-adcf-98dbe1d77576', '9ee4dade-b3af-4664-82c8-4d712f231db4'),
	('fdf2ab0f-dfab-4511-b24e-45db9063c164', 'f9127759-1116-4159-adcf-98dbe1d77576', '8fec88df-50c5-4a5e-800e-621d203f7a55');
/*!40000 ALTER TABLE `sys_role_resources` ENABLE KEYS */;


-- 导出  表 spring-app.sys_user 结构
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE IF NOT EXISTS `sys_user` (
  `id` varchar(50) NOT NULL,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  spring-app.sys_user 的数据：~4 rows (大约)
/*!40000 ALTER TABLE `sys_user` DISABLE KEYS */;
INSERT INTO `sys_user` (`id`, `username`, `password`) VALUES
	('62619962-c88c-4530-b424-ced43b30e1ea', 'wangsong', '532da1c5da9fb86bf61b2a63487f300c'),
	('f09b5fb6-50a8-4263-9b41-ba34cfb4c69d', '123123', '4297f44b13955235245b2497399d7a93');
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
	('25abe66c-6ed1-455b-a92b-aba46d1d78bf', 'f09b5fb6-50a8-4263-9b41-ba34cfb4c69d', 'f9127759-1116-4159-adcf-98dbe1d77576'),
	('5b6e768a-088a-472a-a005-7122de1f92ff', '62619962-c88c-4530-b424-ced43b30e1ea', 'f9127759-1116-4159-adcf-98dbe1d77576'),
	('ec9962b4-cc5c-4c78-bf5e-b08d1920f158', 'd40790b5-8d08-4a44-a98d-fd1866e95223', 'f9127759-1116-4159-adcf-98dbe1d77576');
/*!40000 ALTER TABLE `sys_user_role` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
