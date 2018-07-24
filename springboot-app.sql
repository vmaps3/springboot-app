-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        5.7.11-log - MySQL Community Server (GPL)
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  9.3.0.4984
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 导出 springboot-app 的数据库结构
CREATE DATABASE IF NOT EXISTS `springboot-app` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `springboot-app`;


-- 导出  表 springboot-app.system_dict 结构
CREATE TABLE IF NOT EXISTS `system_dict` (
  `id` varchar(50) NOT NULL,
  `code` varchar(50) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `type` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  springboot-app.system_dict 的数据：~2 rows (大约)
DELETE FROM `system_dict`;
/*!40000 ALTER TABLE `system_dict` DISABLE KEYS */;
INSERT INTO `system_dict` (`id`, `code`, `name`, `type`) VALUES
	('0e05c0f2-a0bc-4b75-8240-7500c9879a04', '2', '按钮', '1'),
	('a4c4df86-d72e-4cea-b90e-753440faf6f2', '1', '菜单', '1');
/*!40000 ALTER TABLE `system_dict` ENABLE KEYS */;


-- 导出  表 springboot-app.system_resources 结构
CREATE TABLE IF NOT EXISTS `system_resources` (
  `id` varchar(50) NOT NULL,
  `pid` varchar(50) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `url` varchar(100) DEFAULT NULL,
  `type` varchar(50) DEFAULT NULL,
  `sort` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  springboot-app.system_resources 的数据：~24 rows (大约)
DELETE FROM `system_resources`;
/*!40000 ALTER TABLE `system_resources` DISABLE KEYS */;
INSERT INTO `system_resources` (`id`, `pid`, `name`, `url`, `type`, `sort`) VALUES
	('0cf26ffd-88e9-42ca-91fb-374359e12f82', 'a9b97767-54ff-4477-a81a-274d6e2b5ce9', '菜单管理', '/system/resources/list.html', '1', '3'),
	('0ff729fc-a43c-4a5c-a2bf-07fbeefa2520', '13fd01f1-20d8-49fd-9630-6fb7f8539920', '删除', '/system/dict/delete', '2', NULL),
	('1', '0', '菜单', '/', '1', NULL),
	('1115d196-fd3a-4ca1-99c8-5452bae30c8f', '0cf26ffd-88e9-42ca-91fb-374359e12f82', '增加', '/system/resources/add', '2', NULL),
	('13fd01f1-20d8-49fd-9630-6fb7f8539920', 'a9b97767-54ff-4477-a81a-274d6e2b5ce9', '字典管理', '/system/dict/list.html', '1', '4'),
	('21e9a57d-b7a2-45b0-8359-cc21d636c0fa', '0cf26ffd-88e9-42ca-91fb-374359e12f82', '更改', '/system/resources/update', '2', NULL),
	('2b56b958-3b0d-46d4-8988-d7c5ae1d804b', 'a9b97767-54ff-4477-a81a-274d6e2b5ce9', '用户管理', '/system/user/list.html', '1', '1'),
	('32680760-3ad2-4ac5-bd2f-fca4917d8f74', '2b56b958-3b0d-46d4-8988-d7c5ae1d804b', '更改', '/system/user/update', '2', NULL),
	('51745327-1978-48ab-aa19-6986a3f628d7', 'c56d6e95-5515-492b-866a-b8555e7b647c', '添加', '/system/role/add', '2', NULL),
	('63efc666-ee88-45f7-bdad-2b019c19eb1d', '0cf26ffd-88e9-42ca-91fb-374359e12f82', '列表', '/system/resources/list', '2', NULL),
	('652b3c26-5085-4739-94db-ebbbb1397acf', '2b56b958-3b0d-46d4-8988-d7c5ae1d804b', '添加', '/system/user/add', '2', NULL),
	('8d1d2815-d011-4da9-a66e-573a5f056f62', '13fd01f1-20d8-49fd-9630-6fb7f8539920', '添加', '/system/dict/add', '2', NULL),
	('8fec88df-50c5-4a5e-800e-621d203f7a55', 'c56d6e95-5515-492b-866a-b8555e7b647c', '删除', '/system/role/delete', '2', NULL),
	('93400178-2c2f-47de-9b30-5d126b33e197', '2b56b958-3b0d-46d4-8988-d7c5ae1d804b', '列表', '/system/user/list', '2', NULL),
	('9ee4dade-b3af-4664-82c8-4d712f231db4', '2b56b958-3b0d-46d4-8988-d7c5ae1d804b', '删除', '/system/user/delete', '2', NULL),
	('a9b97767-54ff-4477-a81a-274d6e2b5ce9', '1', '系统管理', '/', '1', '1'),
	('c01620cd-4845-4a4a-a72f-1524b3c54d24', '13fd01f1-20d8-49fd-9630-6fb7f8539920', '更改', '/system/dict/update', '2', NULL),
	('c56d6e95-5515-492b-866a-b8555e7b647c', 'a9b97767-54ff-4477-a81a-274d6e2b5ce9', '角色管理', '/system/role/list.html', '1', '2'),
	('c65e7c94-a3c1-43b7-a8c7-94e1d693f0b5', 'c56d6e95-5515-492b-866a-b8555e7b647c', '更改', '/system/role/update', '2', NULL),
	('ea7a58c3-74d2-45c1-8b66-974cd82d1fbd', '13fd01f1-20d8-49fd-9630-6fb7f8539920', '列表', '/system/dict/list', '2', NULL),
	('ecb6527f-0548-40f7-b92e-6719ff3f9556', '0cf26ffd-88e9-42ca-91fb-374359e12f82', '删除', '/system/resources/delete', '2', NULL),
	('f0e5351e-7291-4d41-87c2-3ebfc5388d7c', 'c56d6e95-5515-492b-866a-b8555e7b647c', '列表', '/system/role/list', '2', NULL);
/*!40000 ALTER TABLE `system_resources` ENABLE KEYS */;


-- 导出  表 springboot-app.system_role 结构
CREATE TABLE IF NOT EXISTS `system_role` (
  `id` varchar(50) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `pid` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  springboot-app.system_role 的数据：~1 rows (大约)
DELETE FROM `system_role`;
/*!40000 ALTER TABLE `system_role` DISABLE KEYS */;
INSERT INTO `system_role` (`id`, `name`, `pid`) VALUES
	('1', '机构', '0'),
	('bcb12482-905b-43a2-a92d-6a556bfdd239', '2221111155500', '1'),
	('f9127759-1116-4159-adcf-98dbe1d77576', 'JAVA', '1');
/*!40000 ALTER TABLE `system_role` ENABLE KEYS */;


-- 导出  表 springboot-app.system_role_resources 结构
CREATE TABLE IF NOT EXISTS `system_role_resources` (
  `id` varchar(50) NOT NULL,
  `role_id` varchar(50) DEFAULT NULL,
  `resources_id` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  springboot-app.system_role_resources 的数据：~26 rows (大约)
DELETE FROM `system_role_resources`;
/*!40000 ALTER TABLE `system_role_resources` DISABLE KEYS */;
INSERT INTO `system_role_resources` (`id`, `role_id`, `resources_id`) VALUES
	('03f8a7b6-259b-4a68-88de-863b0cd39aa2', 'f9127759-1116-4159-adcf-98dbe1d77576', 'f0e5351e-7291-4d41-87c2-3ebfc5388d7c'),
	('08dca17c-2e85-4dac-8b20-5b5d2f54960d', 'f9127759-1116-4159-adcf-98dbe1d77576', 'ecb6527f-0548-40f7-b92e-6719ff3f9556'),
	('0eb0e908-8879-4179-8c8d-9653a7db6dba', 'f9127759-1116-4159-adcf-98dbe1d77576', '3b3b3284-eaab-48a5-a5e5-5da4e2c490af'),
	('20fd841d-09a8-4ff7-a949-e4a7805d81ed', 'f9127759-1116-4159-adcf-98dbe1d77576', '8fec88df-50c5-4a5e-800e-621d203f7a55'),
	('295ed62c-9b8d-4947-a40a-520e9e994a46', 'f9127759-1116-4159-adcf-98dbe1d77576', '8d1d2815-d011-4da9-a66e-573a5f056f62'),
	('373a2648-9255-4351-8a6a-12e7b9bc7f37', 'f9127759-1116-4159-adcf-98dbe1d77576', '21e9a57d-b7a2-45b0-8359-cc21d636c0fa'),
	('41fb9d85-2562-4ba0-b516-42d74a6f02f3', 'f9127759-1116-4159-adcf-98dbe1d77576', '2b56b958-3b0d-46d4-8988-d7c5ae1d804b'),
	('45f7153d-6b65-4d46-b525-a4a2948b4d3c', 'f9127759-1116-4159-adcf-98dbe1d77576', '32680760-3ad2-4ac5-bd2f-fca4917d8f74'),
	('46423c93-9738-4539-ac71-2e376d0b02d1', 'f9127759-1116-4159-adcf-98dbe1d77576', '9ee4dade-b3af-4664-82c8-4d712f231db4'),
	('49e8bad4-6606-4581-80ca-a119c572c9f7', 'f9127759-1116-4159-adcf-98dbe1d77576', '1'),
	('51032c26-a8d7-4e55-8ce1-bdcbbc255821', 'bcb12482-905b-43a2-a92d-6a556bfdd239', '93400178-2c2f-47de-9b30-5d126b33e197'),
	('6a25a693-982b-4c2a-af50-d1638bad98c9', 'bcb12482-905b-43a2-a92d-6a556bfdd239', '51745327-1978-48ab-aa19-6986a3f628d7'),
	('6af16f5c-d29f-46c3-9e6a-285abc1b7b22', 'f9127759-1116-4159-adcf-98dbe1d77576', 'a9b97767-54ff-4477-a81a-274d6e2b5ce9'),
	('7f39940c-61af-46ed-bc76-992fcfcb0be6', 'f9127759-1116-4159-adcf-98dbe1d77576', 'c01620cd-4845-4a4a-a72f-1524b3c54d24'),
	('92e75dfb-bcb8-4cd0-948f-4afcc1e4390a', 'f9127759-1116-4159-adcf-98dbe1d77576', '1115d196-fd3a-4ca1-99c8-5452bae30c8f'),
	('a0f22475-8032-47e2-98ca-ff2d73a65a35', 'bcb12482-905b-43a2-a92d-6a556bfdd239', '652b3c26-5085-4739-94db-ebbbb1397acf'),
	('a2e489d2-91d9-407b-80a0-8d3c7de6f16c', 'f9127759-1116-4159-adcf-98dbe1d77576', 'ea7a58c3-74d2-45c1-8b66-974cd82d1fbd'),
	('a7d622c2-34c3-4490-9cd8-40ee872e794a', 'bcb12482-905b-43a2-a92d-6a556bfdd239', '9ee4dade-b3af-4664-82c8-4d712f231db4'),
	('ab287dae-7270-46c0-bdc3-5013f6e4f017', 'f9127759-1116-4159-adcf-98dbe1d77576', '0cf26ffd-88e9-42ca-91fb-374359e12f82'),
	('b1e80a42-bd51-422f-95fc-30484c823875', 'f9127759-1116-4159-adcf-98dbe1d77576', '652b3c26-5085-4739-94db-ebbbb1397acf'),
	('b50fa82e-2e63-416e-959a-54d0e43acedc', 'f9127759-1116-4159-adcf-98dbe1d77576', 'c56d6e95-5515-492b-866a-b8555e7b647c'),
	('b6bbcfe4-fbc5-4784-a460-7f4708782875', 'bcb12482-905b-43a2-a92d-6a556bfdd239', '32680760-3ad2-4ac5-bd2f-fca4917d8f74'),
	('c7a4cf9c-666c-4ab2-aeca-51851a606589', 'f9127759-1116-4159-adcf-98dbe1d77576', 'c65e7c94-a3c1-43b7-a8c7-94e1d693f0b5'),
	('cccebee8-132d-430b-b82f-68c00d30faa3', 'f9127759-1116-4159-adcf-98dbe1d77576', '00e70775-e85e-4e81-b24b-a4c442acf877'),
	('d870a5f6-a45b-40c9-ae3b-d5ee5f7fcceb', 'f9127759-1116-4159-adcf-98dbe1d77576', '0ff729fc-a43c-4a5c-a2bf-07fbeefa2520'),
	('e6fa68cd-4ebe-49ec-a14d-3eaa453ecb9d', 'f9127759-1116-4159-adcf-98dbe1d77576', '51745327-1978-48ab-aa19-6986a3f628d7'),
	('e91a0404-0bc9-4fd8-87fa-d5727639695d', 'f9127759-1116-4159-adcf-98dbe1d77576', '13fd01f1-20d8-49fd-9630-6fb7f8539920'),
	('ea2eff08-4ce8-42bf-b332-1e27720cbaaa', 'f9127759-1116-4159-adcf-98dbe1d77576', '63efc666-ee88-45f7-bdad-2b019c19eb1d'),
	('fc993c58-b394-46ec-a61f-9545c9a7b286', 'f9127759-1116-4159-adcf-98dbe1d77576', '93400178-2c2f-47de-9b30-5d126b33e197');
/*!40000 ALTER TABLE `system_role_resources` ENABLE KEYS */;


-- 导出  表 springboot-app.system_user 结构
CREATE TABLE IF NOT EXISTS `system_user` (
  `id` varchar(50) NOT NULL,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  springboot-app.system_user 的数据：~2 rows (大约)
DELETE FROM `system_user`;
/*!40000 ALTER TABLE `system_user` DISABLE KEYS */;
INSERT INTO `system_user` (`id`, `username`, `password`) VALUES
	('62619962-c88c-4530-b424-ced43b30e1ea', 'wangsong', '532da1c5da9fb86bf61b2a63487f300c'),
	('eb660da6-240b-4c18-a38f-8dff316a5044', '123123', '4297f44b13955235245b2497399d7a93');
/*!40000 ALTER TABLE `system_user` ENABLE KEYS */;


-- 导出  表 springboot-app.system_user_role 结构
CREATE TABLE IF NOT EXISTS `system_user_role` (
  `id` varchar(50) NOT NULL,
  `user_id` varchar(50) DEFAULT NULL,
  `role_id` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  springboot-app.system_user_role 的数据：~2 rows (大约)
DELETE FROM `system_user_role`;
/*!40000 ALTER TABLE `system_user_role` DISABLE KEYS */;
INSERT INTO `system_user_role` (`id`, `user_id`, `role_id`) VALUES
	('6cffbc6b-cd38-449f-8bf9-15c10749d765', 'eb660da6-240b-4c18-a38f-8dff316a5044', 'f9127759-1116-4159-adcf-98dbe1d77576'),
	('9996cc28-57c0-4679-92a3-630257d00464', '62619962-c88c-4530-b424-ced43b30e1ea', 'f9127759-1116-4159-adcf-98dbe1d77576'),
	('c4b16c58-ee68-4b65-a49d-b12c9d82862d', 'eb660da6-240b-4c18-a38f-8dff316a5044', 'bcb12482-905b-43a2-a92d-6a556bfdd239');
/*!40000 ALTER TABLE `system_user_role` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
