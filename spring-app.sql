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


-- 导出  表 spring-app.sys_log 结构
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE IF NOT EXISTS `sys_log` (
  `id` varchar(50) NOT NULL,
  `url` varchar(500) DEFAULT NULL,
  `parameter` varchar(100) DEFAULT NULL,
  `remote_addr` varchar(50) DEFAULT NULL,
  `agent` varchar(500) DEFAULT NULL,
  `user_id` varchar(50) DEFAULT NULL,
  `begin_time` datetime DEFAULT NULL,
  `end_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  spring-app.sys_log 的数据：~1,210 rows (大约)
/*!40000 ALTER TABLE `sys_log` DISABLE KEYS */;
INSERT INTO `sys_log` (`id`, `url`, `parameter`, `remote_addr`, `agent`, `user_id`, `begin_time`, `end_time`) VALUES
	('02a772bf-292e-4454-bbb9-3a583f42b9e0', 'http://127.0.0.1/spring-app/', '{}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.112 Safari/537.36', '62619962-c88c-4530-b424-ced43b30e1ea', '2016-10-10 16:52:51', '2016-10-10 16:52:51'),
	('0658a8cf-504a-40d2-853c-90d9e682f64b', 'http://127.0.0.1/spring-app/login.do', '{"username":["wangsong"],"password":["wangsong"]}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.112 Safari/537.36', '62619962-c88c-4530-b424-ced43b30e1ea', '2016-10-10 16:57:09', '2016-10-10 16:57:09'),
	('07c00fbd-4883-4f9a-aaae-4c07383cf79f', 'http://127.0.0.1/spring-app/sys/resources/findResourcesEMUByResources.do', '{}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.112 Safari/537.36', '62619962-c88c-4530-b424-ced43b30e1ea', '2016-10-10 16:55:31', '2016-10-10 16:55:31'),
	('1347749f-6969-42e0-9fb3-41acc7988b9c', 'http://127.0.0.1/spring-app/login.do', '{}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.112 Safari/537.36', NULL, '2016-10-10 16:52:49', '2016-10-10 16:52:49'),
	('13e0f931-c822-469f-9f2d-85f6ef9361bf', 'http://127.0.0.1/spring-app/sys/log/toList.do', '{}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.112 Safari/537.36', '62619962-c88c-4530-b424-ced43b30e1ea', '2016-10-10 16:52:52', '2016-10-10 16:52:52'),
	('16b2dfda-ea0e-42ff-a86d-09feaab343de', 'http://127.0.0.1/spring-app/static/jquery-easyui-1.5/locale/easyui-lang-zh_CN.js', '{}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.112 Safari/537.36', '62619962-c88c-4530-b424-ced43b30e1ea', '2016-10-10 16:55:30', '2016-10-10 16:55:30'),
	('1e4d4c8b-b7b9-452f-ab50-a9d5ba8428eb', 'http://127.0.0.1/spring-app/static/jquery-easyui-1.5/jquery.easyui.min.js', '{}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.112 Safari/537.36', NULL, '2016-10-10 16:57:05', '2016-10-10 16:57:05'),
	('269d63d2-f1cb-4ab0-bb9c-f8acac4c0277', 'http://127.0.0.1/spring-app/static/jquery-easyui-1.5/jquery.easyui.min.js', '{}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.112 Safari/537.36', '62619962-c88c-4530-b424-ced43b30e1ea', '2016-10-10 16:55:30', '2016-10-10 16:55:30'),
	('273faed7-4f11-4117-b22b-7eeae814eb9a', 'http://127.0.0.1/spring-app/sys/dict/list.do', '{"page":["1"],"rows":["10"]}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.112 Safari/537.36', '62619962-c88c-4530-b424-ced43b30e1ea', '2016-10-10 16:57:15', '2016-10-10 16:57:15'),
	('2a7d64ac-b902-4389-8557-d144b2d74500', 'http://127.0.0.1/spring-app/static/jquery-easyui-1.5/themes/default/easyui.css', '{}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.112 Safari/537.36', NULL, '2016-10-10 16:57:05', '2016-10-10 16:57:05'),
	('35d66196-4dd4-4921-9387-18f78cba1f8b', 'http://127.0.0.1/spring-app/sys/log/toList.do', '{}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.112 Safari/537.36', '62619962-c88c-4530-b424-ced43b30e1ea', '2016-10-10 16:55:32', '2016-10-10 16:55:32'),
	('38e8d2ee-3df5-44ec-ad61-bff64f6d3ff9', 'http://127.0.0.1/spring-app/static/jquery-easyui-1.5/themes/icon.css', '{}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.112 Safari/537.36', '62619962-c88c-4530-b424-ced43b30e1ea', '2016-10-10 16:55:30', '2016-10-10 16:55:30'),
	('4857afbd-739e-458c-8d51-fcbb7f762b49', 'http://127.0.0.1/spring-app/logout.do', '{}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.112 Safari/537.36', NULL, '2016-10-10 16:57:08', '2016-10-10 16:57:08'),
	('51734112-22a2-4626-8b78-13665e12f49b', 'http://127.0.0.1/spring-app/static/jquery-easyui-1.5/themes/icon.css', '{}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.112 Safari/537.36', NULL, '2016-10-10 16:52:49', '2016-10-10 16:52:49'),
	('64f425cc-96f9-483b-bc12-447e2cd685cb', 'http://127.0.0.1/spring-app/static/jquery-easyui-1.5/jquery.min.js', '{}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.112 Safari/537.36', NULL, '2016-10-10 16:52:49', '2016-10-10 16:52:49'),
	('6fd0ae47-95e7-4ed4-b0c5-513eef31bcdc', 'http://127.0.0.1/spring-app/sys/resources/findResourcesEMUByResources.do', '{}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.112 Safari/537.36', '62619962-c88c-4530-b424-ced43b30e1ea', '2016-10-10 16:52:51', '2016-10-10 16:52:51'),
	('71dc3ea0-d2fe-437c-a202-9fc82ca6e35b', 'http://127.0.0.1/spring-app/', '{}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.112 Safari/537.36', '62619962-c88c-4530-b424-ced43b30e1ea', '2016-10-10 16:57:09', '2016-10-10 16:57:09'),
	('7d67bfbd-c938-4407-855b-783fbbaebe6d', 'http://127.0.0.1/spring-app/sys/resources/findResourcesEMUByResources.do', '{}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.112 Safari/537.36', '62619962-c88c-4530-b424-ced43b30e1ea', '2016-10-10 16:57:09', '2016-10-10 16:57:09'),
	('7d741f7f-bd4d-4250-aa64-3ee9ae6bfd68', 'http://127.0.0.1/spring-app/sys/log/list.do', '{"page":["1"],"rows":["10"]}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.112 Safari/537.36', '62619962-c88c-4530-b424-ced43b30e1ea', '2016-10-10 16:59:01', '2016-10-10 16:59:57'),
	('8ca6985e-0e3d-45a1-8aba-9d860fb586df', 'http://127.0.0.1/spring-app/sys/resources/findResourcesEMUByResources.do', '{}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.112 Safari/537.36', NULL, '2016-10-10 16:57:05', '2016-10-10 16:57:05'),
	('902ee7a6-ceec-425c-ba2d-f15276203fcf', 'http://127.0.0.1/spring-app/sys/dict/toList.do', '{}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.112 Safari/537.36', '62619962-c88c-4530-b424-ced43b30e1ea', '2016-10-10 16:57:15', '2016-10-10 16:57:15'),
	('9600ac09-1382-4a0c-967e-18746e54097e', 'http://127.0.0.1/spring-app/sys/log/list.do', '{"page":["1"],"rows":["10"]}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.112 Safari/537.36', '62619962-c88c-4530-b424-ced43b30e1ea', '2016-10-10 16:52:52', '2016-10-10 16:52:52'),
	('9980e240-59f3-4d3f-9084-21d5f53bfe3d', 'http://127.0.0.1/spring-app/static/jquery-easyui-1.5/jquery.easyui.min.js', '{}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.112 Safari/537.36', NULL, '2016-10-10 16:52:49', '2016-10-10 16:52:49'),
	('a0123579-aae3-496c-9622-8c51ecafcae2', 'http://127.0.0.1/spring-app/sys/log/list.do', '{"page":["1"],"rows":["10"]}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.112 Safari/537.36', '62619962-c88c-4530-b424-ced43b30e1ea', '2016-10-10 16:57:10', '2016-10-10 16:57:10'),
	('a6469a89-ca4b-419e-802c-c1dcfd215fc4', 'http://127.0.0.1/spring-app/sys/log/toList.do', '{}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.112 Safari/537.36', '62619962-c88c-4530-b424-ced43b30e1ea', '2016-10-10 16:57:10', '2016-10-10 16:57:10'),
	('a90f5a59-fc44-41af-b2d1-7ce83b3b11bb', 'http://127.0.0.1/spring-app/login.do', '{"username":["wangsong"],"password":["wangsong"]}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.112 Safari/537.36', '62619962-c88c-4530-b424-ced43b30e1ea', '2016-10-10 16:52:51', '2016-10-10 16:52:51'),
	('ad095d6a-b7f5-4f68-917d-6ae7eb21d325', 'http://127.0.0.1/spring-app/sys/log/list.do', '{"page":["1"],"rows":["10"]}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.112 Safari/537.36', '62619962-c88c-4530-b424-ced43b30e1ea', '2016-10-10 16:55:32', '2016-10-10 16:55:32'),
	('baf8bcda-c639-4938-82f2-ae1a9b6f6a3f', 'http://127.0.0.1/spring-app/static/jquery-easyui-1.5/jquery.min.js', '{}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.112 Safari/537.36', NULL, '2016-10-10 16:57:05', '2016-10-10 16:57:05'),
	('c1290bcf-7b23-4fd6-b90b-579050cb768a', 'http://127.0.0.1/spring-app/static/jquery-easyui-1.5/locale/easyui-lang-zh_CN.js', '{}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.112 Safari/537.36', NULL, '2016-10-10 16:52:49', '2016-10-10 16:52:49'),
	('cc0f290c-9ab9-403d-8d33-7486511fde8c', 'http://127.0.0.1/spring-app/static/jquery-easyui-1.5/locale/easyui-lang-zh_CN.js', '{}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.112 Safari/537.36', NULL, '2016-10-10 16:57:05', '2016-10-10 16:57:05'),
	('d84ac947-c956-41da-8f5d-9bb8f1fadcbe', 'http://127.0.0.1/spring-app/', '{}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.112 Safari/537.36', NULL, '2016-10-10 16:57:04', '2016-10-10 16:57:04'),
	('db5c9ae9-5282-4f36-9e28-20f2ef4a7992', 'http://127.0.0.1/spring-app/static/jquery-easyui-1.5/jquery.min.js', '{}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.112 Safari/537.36', '62619962-c88c-4530-b424-ced43b30e1ea', '2016-10-10 16:55:30', '2016-10-10 16:55:30'),
	('df7525b0-4f87-481b-9ee1-a0db89dddd23', 'http://127.0.0.1/spring-app/sys/log/list.do', '{"page":["1"],"rows":["10"]}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.112 Safari/537.36', '62619962-c88c-4530-b424-ced43b30e1ea', '2016-10-10 16:58:35', '2016-10-10 16:58:45'),
	('e34ce1dd-730d-47e3-9db1-371a5c7a9ddc', 'http://127.0.0.1/spring-app/static/jquery-easyui-1.5/themes/default/easyui.css', '{}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.112 Safari/537.36', '62619962-c88c-4530-b424-ced43b30e1ea', '2016-10-10 16:55:30', '2016-10-10 16:55:30'),
	('e38350b6-1dfc-4221-8a63-687d45c43095', 'http://127.0.0.1/spring-app/sys/log/list.do', '{"page":["1"],"rows":["10"]}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.112 Safari/537.36', '62619962-c88c-4530-b424-ced43b30e1ea', '2016-10-10 17:00:06', '2016-10-10 17:00:11'),
	('e78097ee-e2b8-4e41-8ab4-cc54dfa76f6c', 'http://127.0.0.1/spring-app/sys/log/toList.do', '{}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.112 Safari/537.36', '62619962-c88c-4530-b424-ced43b30e1ea', '2016-10-10 17:00:05', '2016-10-10 17:00:05'),
	('ed5c8c9a-c681-48ba-93eb-0ff253741847', 'http://127.0.0.1/spring-app/static/jquery-easyui-1.5/themes/default/easyui.css', '{}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.112 Safari/537.36', NULL, '2016-10-10 16:52:49', '2016-10-10 16:52:49'),
	('fce1e952-8aa5-477d-842d-e409145c978a', 'http://127.0.0.1/spring-app/', '{}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.112 Safari/537.36', '62619962-c88c-4530-b424-ced43b30e1ea', '2016-10-10 16:55:30', '2016-10-10 16:55:30'),
	('fd6fe524-9c29-43fc-9099-a2fe56aac47b', 'http://127.0.0.1/spring-app/static/jquery-easyui-1.5/themes/icon.css', '{}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.112 Safari/537.36', NULL, '2016-10-10 16:57:05', '2016-10-10 16:57:05');
/*!40000 ALTER TABLE `sys_log` ENABLE KEYS */;


-- 导出  表 spring-app.sys_resources 结构
DROP TABLE IF EXISTS `sys_resources`;
CREATE TABLE IF NOT EXISTS `sys_resources` (
  `id` varchar(50) NOT NULL,
  `pid` varchar(50) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `url` varchar(50) DEFAULT NULL,
  `type` varchar(50) DEFAULT NULL,
  `sort` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  spring-app.sys_resources 的数据：~24 rows (大约)
/*!40000 ALTER TABLE `sys_resources` DISABLE KEYS */;
INSERT INTO `sys_resources` (`id`, `pid`, `name`, `url`, `type`, `sort`) VALUES
	('00e70775-e85e-4e81-b24b-a4c442acf877', '3445c320-cf85-4990-914d-ce14806c0590', '删除', '/sys/log/delete', '2', ''),
	('0cf26ffd-88e9-42ca-91fb-374359e12f82', 'a9b97767-54ff-4477-a81a-274d6e2b5ce9', '菜单管理', '/sys/resources/toList.do', '1', '3'),
	('0ff729fc-a43c-4a5c-a2bf-07fbeefa2520', '13fd01f1-20d8-49fd-9630-6fb7f8539920', '删除', '/sys/dict/delete', '2', NULL),
	('1', '', '菜单', '/', '1', NULL),
	('1115d196-fd3a-4ca1-99c8-5452bae30c8f', '0cf26ffd-88e9-42ca-91fb-374359e12f82', '增加', '/sys/resources/add', '2', NULL),
	('13fd01f1-20d8-49fd-9630-6fb7f8539920', 'a9b97767-54ff-4477-a81a-274d6e2b5ce9', '字典管理', '/sys/dict/toList.do', '1', '4'),
	('21e9a57d-b7a2-45b0-8359-cc21d636c0fa', '0cf26ffd-88e9-42ca-91fb-374359e12f82', '更改', '/sys/resources/update', '2', NULL),
	('2b56b958-3b0d-46d4-8988-d7c5ae1d804b', 'a9b97767-54ff-4477-a81a-274d6e2b5ce9', '用户管理', '/sys/user/toList.do', '1', '1'),
	('32680760-3ad2-4ac5-bd2f-fca4917d8f74', '2b56b958-3b0d-46d4-8988-d7c5ae1d804b', '更改', '/sys/user/update', '2', NULL),
	('3445c320-cf85-4990-914d-ce14806c0590', 'a9b97767-54ff-4477-a81a-274d6e2b5ce9', '日志管理', '/sys/log/toList.do', '1', '5'),
	('3b3b3284-eaab-48a5-a5e5-5da4e2c490af', '3445c320-cf85-4990-914d-ce14806c0590', '查看', '/sys/log/list', '2', ''),
	('51745327-1978-48ab-aa19-6986a3f628d7', 'c56d6e95-5515-492b-866a-b8555e7b647c', '添加', '/sys/role/add', '2', NULL),
	('63efc666-ee88-45f7-bdad-2b019c19eb1d', '0cf26ffd-88e9-42ca-91fb-374359e12f82', '列表', '/sys/resources/list', '2', NULL),
	('652b3c26-5085-4739-94db-ebbbb1397acf', '2b56b958-3b0d-46d4-8988-d7c5ae1d804b', '添加', '/sys/user/add', '2', NULL),
	('8d1d2815-d011-4da9-a66e-573a5f056f62', '13fd01f1-20d8-49fd-9630-6fb7f8539920', '添加', '/sys/dict/add', '2', NULL),
	('8fec88df-50c5-4a5e-800e-621d203f7a55', 'c56d6e95-5515-492b-866a-b8555e7b647c', '删除', '/sys/role/delete', '2', NULL),
	('93400178-2c2f-47de-9b30-5d126b33e197', '2b56b958-3b0d-46d4-8988-d7c5ae1d804b', '列表', '/sys/user/list', '2', NULL),
	('9ee4dade-b3af-4664-82c8-4d712f231db4', '2b56b958-3b0d-46d4-8988-d7c5ae1d804b', '删除', '/sys/user/delete', '2', NULL),
	('a9b97767-54ff-4477-a81a-274d6e2b5ce9', '1', '系统管理', '/', '1', '1'),
	('c01620cd-4845-4a4a-a72f-1524b3c54d24', '13fd01f1-20d8-49fd-9630-6fb7f8539920', '更改', '/sys/dict/update', '2', NULL),
	('c56d6e95-5515-492b-866a-b8555e7b647c', 'a9b97767-54ff-4477-a81a-274d6e2b5ce9', '角色管理', '/sys/role/toList.do', '1', '2'),
	('c65e7c94-a3c1-43b7-a8c7-94e1d693f0b5', 'c56d6e95-5515-492b-866a-b8555e7b647c', '更改', '/sys/role/update', '2', NULL),
	('ea7a58c3-74d2-45c1-8b66-974cd82d1fbd', '13fd01f1-20d8-49fd-9630-6fb7f8539920', '列表', '/sys/dict/list', '2', NULL),
	('ecb6527f-0548-40f7-b92e-6719ff3f9556', '0cf26ffd-88e9-42ca-91fb-374359e12f82', '删除', '/sys/resources/delete', '2', NULL),
	('f0e5351e-7291-4d41-87c2-3ebfc5388d7c', 'c56d6e95-5515-492b-866a-b8555e7b647c', '列表', '/sys/role/list', '2', NULL);
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

-- 正在导出表  spring-app.sys_role_resources 的数据：~24 rows (大约)
/*!40000 ALTER TABLE `sys_role_resources` DISABLE KEYS */;
INSERT INTO `sys_role_resources` (`id`, `role_id`, `resources_id`) VALUES
	('074c7368-2245-42cc-b47f-226dcc9a8de2', 'f9127759-1116-4159-adcf-98dbe1d77576', '8fec88df-50c5-4a5e-800e-621d203f7a55'),
	('0ae9f3bb-250f-4cc5-a275-bc909586c496', 'f9127759-1116-4159-adcf-98dbe1d77576', 'ea7a58c3-74d2-45c1-8b66-974cd82d1fbd'),
	('1c1ce30b-fc4f-4156-a465-67408aff6226', 'f9127759-1116-4159-adcf-98dbe1d77576', 'a9b97767-54ff-4477-a81a-274d6e2b5ce9'),
	('244c35ba-416d-4d3a-987c-99cd961088a9', 'f9127759-1116-4159-adcf-98dbe1d77576', '2b56b958-3b0d-46d4-8988-d7c5ae1d804b'),
	('275139e5-05eb-41c2-8648-e23096545bdf', 'f9127759-1116-4159-adcf-98dbe1d77576', '63efc666-ee88-45f7-bdad-2b019c19eb1d'),
	('280c91f9-330b-41c9-82a7-270d1d4dace9', 'f9127759-1116-4159-adcf-98dbe1d77576', '21e9a57d-b7a2-45b0-8359-cc21d636c0fa'),
	('35af5a8f-490b-43da-ad1a-4a124934fabb', 'f9127759-1116-4159-adcf-98dbe1d77576', '32680760-3ad2-4ac5-bd2f-fca4917d8f74'),
	('369f4214-2223-4f16-b7b4-6341c6da6e06', 'f9127759-1116-4159-adcf-98dbe1d77576', '0cf26ffd-88e9-42ca-91fb-374359e12f82'),
	('41a633a5-bc5a-4a6c-a84b-3d6b2d0c9499', 'f9127759-1116-4159-adcf-98dbe1d77576', 'c56d6e95-5515-492b-866a-b8555e7b647c'),
	('6b71aed8-79df-4631-a899-7e2d76169e05', 'f9127759-1116-4159-adcf-98dbe1d77576', 'f0e5351e-7291-4d41-87c2-3ebfc5388d7c'),
	('6dc86997-7d73-410f-94a0-c0336c40f47d', 'f9127759-1116-4159-adcf-98dbe1d77576', '3b3b3284-eaab-48a5-a5e5-5da4e2c490af'),
	('73359fa7-1333-4cb9-ac6b-2961b9750bda', 'f9127759-1116-4159-adcf-98dbe1d77576', '8d1d2815-d011-4da9-a66e-573a5f056f62'),
	('81b9e68b-b301-40ea-b02e-a60ed15b5570', 'f9127759-1116-4159-adcf-98dbe1d77576', 'c65e7c94-a3c1-43b7-a8c7-94e1d693f0b5'),
	('82d4e8f5-d3a4-4e03-af08-f8b706dda31d', 'f9127759-1116-4159-adcf-98dbe1d77576', '1'),
	('8e78b2db-73e6-4ad3-b6bf-1e4c8333f71c', 'f9127759-1116-4159-adcf-98dbe1d77576', '0ff729fc-a43c-4a5c-a2bf-07fbeefa2520'),
	('a9cd0bdb-8cfc-421b-9786-982272090eca', 'f9127759-1116-4159-adcf-98dbe1d77576', '13fd01f1-20d8-49fd-9630-6fb7f8539920'),
	('ac74002c-848a-4396-aeba-741a69839214', 'f9127759-1116-4159-adcf-98dbe1d77576', 'ecb6527f-0548-40f7-b92e-6719ff3f9556'),
	('b61ff187-d40b-44ba-99d5-d1815e165306', 'f9127759-1116-4159-adcf-98dbe1d77576', '9ee4dade-b3af-4664-82c8-4d712f231db4'),
	('bdf71833-cc58-4216-9d9e-e52124f02234', 'f9127759-1116-4159-adcf-98dbe1d77576', '3445c320-cf85-4990-914d-ce14806c0590'),
	('c29fb5c4-1434-4ee3-8c40-e8c35286ef54', 'f9127759-1116-4159-adcf-98dbe1d77576', '00e70775-e85e-4e81-b24b-a4c442acf877'),
	('e3910034-bc1e-4aaf-8ffe-a3fe2b30e441', 'f9127759-1116-4159-adcf-98dbe1d77576', 'c01620cd-4845-4a4a-a72f-1524b3c54d24'),
	('e8d23e6c-9981-4ec5-b700-3f3e922a368b', 'f9127759-1116-4159-adcf-98dbe1d77576', '1115d196-fd3a-4ca1-99c8-5452bae30c8f'),
	('ea8603aa-430e-45c7-a95d-7f6c36fc2c2f', 'f9127759-1116-4159-adcf-98dbe1d77576', '652b3c26-5085-4739-94db-ebbbb1397acf'),
	('ebdbb730-b4bb-46a7-bd7e-f570cabb50a4', 'f9127759-1116-4159-adcf-98dbe1d77576', '51745327-1978-48ab-aa19-6986a3f628d7'),
	('f6e0afc6-415f-42ed-8a18-6a2fe5b98669', 'f9127759-1116-4159-adcf-98dbe1d77576', '93400178-2c2f-47de-9b30-5d126b33e197');
/*!40000 ALTER TABLE `sys_role_resources` ENABLE KEYS */;


-- 导出  表 spring-app.sys_user 结构
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE IF NOT EXISTS `sys_user` (
  `id` varchar(50) NOT NULL,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  spring-app.sys_user 的数据：~3 rows (大约)
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

-- 正在导出表  spring-app.sys_user_role 的数据：~4 rows (大约)
/*!40000 ALTER TABLE `sys_user_role` DISABLE KEYS */;
INSERT INTO `sys_user_role` (`id`, `user_id`, `role_id`) VALUES
	('5b6e768a-088a-472a-a005-7122de1f92ff', '62619962-c88c-4530-b424-ced43b30e1ea', 'f9127759-1116-4159-adcf-98dbe1d77576');
/*!40000 ALTER TABLE `sys_user_role` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
