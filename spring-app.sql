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
DELETE FROM `sys_dict`;
/*!40000 ALTER TABLE `sys_dict` DISABLE KEYS */;
INSERT INTO `sys_dict` (`id`, `code`, `name`, `type`) VALUES
	('0e05c0f2-a0bc-4b75-8240-7500c9879a04', '2', '按钮', '1'),
	('a4c4df86-d72e-4cea-b90e-753440faf6f2', '1', '菜单', '1');
/*!40000 ALTER TABLE `sys_dict` ENABLE KEYS */;


-- 导出  表 spring-app.sys_log 结构
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE IF NOT EXISTS `sys_log` (
  `id` varchar(50) NOT NULL,
  `url` varchar(100) DEFAULT NULL,
  `parameter` varchar(50) DEFAULT NULL,
  `remote_addr` varchar(50) DEFAULT NULL,
  `agent` varchar(500) DEFAULT NULL,
  `user_id` varchar(50) DEFAULT NULL,
  `begin_time` datetime DEFAULT NULL,
  `end_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  spring-app.sys_log 的数据：~54 rows (大约)
DELETE FROM `sys_log`;
/*!40000 ALTER TABLE `sys_log` DISABLE KEYS */;
INSERT INTO `sys_log` (`id`, `url`, `parameter`, `remote_addr`, `agent`, `user_id`, `begin_time`, `end_time`) VALUES
	('007497f6-d4b0-46d2-8296-487b7b261b3c', 'http://127.0.0.1:8081/spring-app/sys/resources/findMapListByType.do', '{}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2693.2 Safari/537.36', '62619962-c88c-4530-b424-ced43b30e1ea', '2016-10-07 14:41:45', '2016-10-07 14:41:45'),
	('00f5a139-e836-4796-9bfe-6da3862f6594', 'http://127.0.0.1:8081/spring-app/sys/resources/findMapListByType.do', '{}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2693.2 Safari/537.36', '62619962-c88c-4530-b424-ced43b30e1ea', '2016-10-07 14:19:57', '2016-10-07 14:19:57'),
	('00fc3e58-8b7e-4c94-afad-45a6a740ed08', 'http://127.0.0.1:8081/spring-app/sys/role/delete.do', '{"id":["ead8c256-7918-4696-a9b2-0b30ba75e178"]}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2693.2 Safari/537.36', '62619962-c88c-4530-b424-ced43b30e1ea', '2016-10-07 15:18:24', '2016-10-07 15:18:24'),
	('0186108b-8ea4-457b-9572-fae187e777b0', 'http://127.0.0.1:8081/spring-app/static/jquery-easyui-1.5/themes/icon.css', '{}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2693.2 Safari/537.36', NULL, '2016-10-07 15:09:06', '2016-10-07 15:09:06'),
	('074b8d0a-1e28-44df-a3f2-a01232e76562', 'http://127.0.0.1:8081/spring-app/login.do', '{"username":["wangsong"],"password":["wangsong"]}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2693.2 Safari/537.36', '62619962-c88c-4530-b424-ced43b30e1ea', '2016-10-07 14:19:56', '2016-10-07 14:19:57'),
	('09f762a3-0e08-4dc0-945b-ac17b57b577d', 'http://127.0.0.1:8081/spring-app/', '{}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2693.2 Safari/537.36', '62619962-c88c-4530-b424-ced43b30e1ea', '2016-10-07 13:52:51', '2016-10-07 13:52:51'),
	('0a8dbd7c-b7e6-4490-b6e1-f7dc10b41aec', 'http://127.0.0.1:8081/spring-app/static/jquery-easyui-1.5/locale/easyui-lang-zh_CN.js', '{}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2693.2 Safari/537.36', '62619962-c88c-4530-b424-ced43b30e1ea', '2016-10-07 15:07:03', '2016-10-07 15:07:03'),
	('0cc39943-1b6c-4aaa-a59b-4f5f682b949e', 'http://127.0.0.1:8081/spring-app/sys/log/toList.do', '{}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2693.2 Safari/537.36', '62619962-c88c-4530-b424-ced43b30e1ea', '2016-10-07 15:07:04', '2016-10-07 15:07:04'),
	('0e6ea2aa-fe2b-4fe7-a144-d284c5a04830', 'http://127.0.0.1:8081/spring-app/sys/user/list.do', '{"page":["1"],"rows":["10"]}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2693.2 Safari/537.36', '62619962-c88c-4530-b424-ced43b30e1ea', '2016-10-07 15:18:17', '2016-10-07 15:18:17'),
	('10d07946-db0c-47b6-b199-e8802a2426a6', 'http://127.0.0.1:8081/spring-app/static/jquery-easyui-1.5/themes/icon.css', '{}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2693.2 Safari/537.36', '62619962-c88c-4530-b424-ced43b30e1ea', '2016-10-07 15:04:34', '2016-10-07 15:04:34'),
	('11924da2-2737-487d-bbbf-222fb3312223', 'http://127.0.0.1:8081/spring-app/static/jquery-easyui-1.5/jquery.min.js', '{}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2693.2 Safari/537.36', '62619962-c88c-4530-b424-ced43b30e1ea', '2016-10-07 15:04:34', '2016-10-07 15:04:34'),
	('11a379a0-776e-4953-9558-7693f734d185', 'http://127.0.0.1:8081/spring-app/static/jquery-easyui-1.5/themes/default/easyui.css', '{}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2693.2 Safari/537.36', '62619962-c88c-4530-b424-ced43b30e1ea', '2016-10-07 15:21:13', '2016-10-07 15:21:13'),
	('149d395b-c037-4af0-9c6e-08a08209410a', 'http://127.0.0.1:8081/spring-app/static/jquery-easyui-1.5/themes/icon.css', '{}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2693.2 Safari/537.36', '62619962-c88c-4530-b424-ced43b30e1ea', '2016-10-07 15:07:03', '2016-10-07 15:07:03'),
	('21608a69-f142-47c8-90e6-8d7a3e1334e7', 'http://127.0.0.1:8081/spring-app/static/jquery-easyui-1.5/themes/icon.css', '{}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2693.2 Safari/537.36', NULL, '2016-10-07 14:41:40', '2016-10-07 14:41:40'),
	('230d9e3e-7c02-485f-9f23-398ddb15f931', 'http://127.0.0.1:8081/spring-app/static/jquery-easyui-1.5/jquery.min.js', '{}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2693.2 Safari/537.36', NULL, '2016-10-07 14:19:54', '2016-10-07 14:19:54'),
	('295ebb59-3fa1-4c42-8861-119425b758cb', 'http://127.0.0.1:8081/spring-app/login.do', '{"username":["wangsong"],"password":["wangsong"]}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2693.2 Safari/537.36', '62619962-c88c-4530-b424-ced43b30e1ea', '2016-10-07 13:55:56', '2016-10-07 13:55:56'),
	('2a533ae2-19ca-4f3d-8cb4-f71cba40a66a', 'http://127.0.0.1:8081/spring-app/login.do', '{"username":["wangsong"],"password":["wangsong"]}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2693.2 Safari/537.36', '62619962-c88c-4530-b424-ced43b30e1ea', '2016-10-07 13:52:50', '2016-10-07 13:52:51'),
	('2b0bca0b-fe97-4d85-9bb6-3b2f69dc1806', 'http://127.0.0.1:8081/spring-app/static/jquery-easyui-1.5/jquery.easyui.min.js', '{}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2693.2 Safari/537.36', '62619962-c88c-4530-b424-ced43b30e1ea', '2016-10-07 15:04:34', '2016-10-07 15:04:34'),
	('2c8180cb-a29a-418c-8ae2-c51fbb70fb33', 'http://127.0.0.1:8081/spring-app/static/jquery-easyui-1.5/themes/icon.css', '{}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2693.2 Safari/537.36', NULL, '2016-10-07 14:19:54', '2016-10-07 14:19:54'),
	('2cc2721f-92c1-4da3-bebf-8214dc1b53e3', 'http://127.0.0.1:8081/spring-app/sys/resources/findMapListByType.do', '{}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2693.2 Safari/537.36', '62619962-c88c-4530-b424-ced43b30e1ea', '2016-10-07 15:21:13', '2016-10-07 15:21:13'),
	('2ead6d1d-b410-4e23-9b32-194d2772fa3f', 'http://127.0.0.1:8081/spring-app/sys/log/toList.do', '{}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2693.2 Safari/537.36', '62619962-c88c-4530-b424-ced43b30e1ea', '2016-10-07 14:16:57', '2016-10-07 14:16:58'),
	('2ed34fe4-6d63-4dc5-9066-38624f612047', 'http://127.0.0.1:8081/spring-app/sys/resources/findMapListByType.do', '{}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2693.2 Safari/537.36', '62619962-c88c-4530-b424-ced43b30e1ea', '2016-10-07 15:06:21', '2016-10-07 15:06:21'),
	('2fff4f65-3d20-4a26-ab61-24ebb7fd3641', 'http://127.0.0.1:8081/spring-app/sys/resources/list.do', '{}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2693.2 Safari/537.36', '62619962-c88c-4530-b424-ced43b30e1ea', '2016-10-07 15:18:15', '2016-10-07 15:18:15'),
	('305d96c5-e4b4-4e16-b9d6-80207850b0ff', 'http://127.0.0.1:8081/spring-app/sys/log/list.do', '{"page":["1"],"rows":["10"]}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2693.2 Safari/537.36', '62619962-c88c-4530-b424-ced43b30e1ea', '2016-10-07 14:41:50', '2016-10-07 14:41:50'),
	('322d85cb-fdbb-43de-ae2f-d08d0c5bcd73', 'http://127.0.0.1:8081/spring-app/logout.do', '{}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2693.2 Safari/537.36', NULL, '2016-10-07 14:16:48', '2016-10-07 14:16:48'),
	('32d51633-f086-49f9-bd9f-53a1cdb6df61', 'http://127.0.0.1:8081/spring-app/sys/log/list.do', '{"page":["2"],"rows":["10"]}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2693.2 Safari/537.36', '62619962-c88c-4530-b424-ced43b30e1ea', '2016-10-07 14:20:01', '2016-10-07 14:20:01'),
	('331f8677-18bb-4381-8d4d-a492d45afd8c', 'http://127.0.0.1:8081/spring-app/static/jquery-easyui-1.5/locale/easyui-lang-zh_CN.js', '{}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2693.2 Safari/537.36', NULL, '2016-10-07 14:19:54', '2016-10-07 14:19:54'),
	('34bf8892-1d76-4683-afd1-df51439dd65c', 'http://127.0.0.1:8081/spring-app/sys/user/list.do', '{"page":["1"],"rows":["10"]}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2693.2 Safari/537.36', '62619962-c88c-4530-b424-ced43b30e1ea', '2016-10-07 15:18:21', '2016-10-07 15:18:21'),
	('3a01a4ee-d9e1-4304-8307-64ac6cfe5748', 'http://127.0.0.1:8081/spring-app/static/jquery-easyui-1.5/locale/easyui-lang-zh_CN.js', '{}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2693.2 Safari/537.36', NULL, '2016-10-07 14:41:40', '2016-10-07 14:41:40'),
	('3e35158c-ceff-4769-a603-3268239f6318', 'http://127.0.0.1:8081/spring-app/', '{}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2693.2 Safari/537.36', NULL, '2016-10-07 13:55:51', '2016-10-07 13:55:51'),
	('401275c4-4690-43b4-ba4e-cc0c1d9def48', 'http://127.0.0.1:8081/spring-app/logout.do', '{}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2693.2 Safari/537.36', NULL, '2016-10-07 14:15:21', '2016-10-07 14:15:21'),
	('433718d6-121e-4811-a195-1ef8a44d8eb2', 'http://127.0.0.1:8081/spring-app/sys/user/delete.do', '{"id":["f09b5fb6-50a8-4263-9b41-ba34cfb4c69d"]}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2693.2 Safari/537.36', '62619962-c88c-4530-b424-ced43b30e1ea', '2016-10-07 15:18:20', '2016-10-07 15:18:21'),
	('43487490-73ec-4885-8258-20efdf8e858e', 'http://127.0.0.1:8081/spring-app/sys/log/list.do', '{"page":["1"],"rows":["50"]}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2693.2 Safari/537.36', '62619962-c88c-4530-b424-ced43b30e1ea', '2016-10-07 14:20:04', '2016-10-07 14:20:04'),
	('44e3c00b-cadd-46ef-b68c-2e80a141e736', 'http://127.0.0.1:8081/spring-app/sys/role/toList.do', '{}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2693.2 Safari/537.36', '62619962-c88c-4530-b424-ced43b30e1ea', '2016-10-07 15:18:24', '2016-10-07 15:18:24'),
	('459f5bfe-a19e-4ba9-9b41-2bfcc8acdb14', 'http://127.0.0.1:8081/spring-app/sys/log/toList.do', '{}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2693.2 Safari/537.36', '62619962-c88c-4530-b424-ced43b30e1ea', '2016-10-07 15:09:10', '2016-10-07 15:09:10'),
	('46625e97-4c62-42e8-9742-e96928f12823', 'http://127.0.0.1:8081/spring-app/static/jquery-easyui-1.5/jquery.min.js', '{}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2693.2 Safari/537.36', NULL, '2016-10-07 14:41:40', '2016-10-07 14:41:40'),
	('47614f3b-4e38-4633-b608-bba501db02f2', 'http://127.0.0.1:8081/spring-app/sys/role/toList.do', '{}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2693.2 Safari/537.36', '62619962-c88c-4530-b424-ced43b30e1ea', '2016-10-07 15:18:16', '2016-10-07 15:18:16'),
	('48b80317-d475-4567-acc2-4f2c42ec4114', 'http://127.0.0.1:8081/spring-app/', '{}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2693.2 Safari/537.36', '62619962-c88c-4530-b424-ced43b30e1ea', '2016-10-07 15:21:13', '2016-10-07 15:21:13'),
	('4bc89151-c2d6-41dc-ab8c-810bd5c29cea', 'http://127.0.0.1:8081/spring-app/sys/role/list.do', '{"page":["1"],"rows":["10"]}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2693.2 Safari/537.36', '62619962-c88c-4530-b424-ced43b30e1ea', '2016-10-07 13:56:01', '2016-10-07 13:56:01'),
	('4bef0786-400e-4eb1-b71a-c4368e8e6e25', 'http://127.0.0.1:8081/spring-app/login.do', '{"username":["wangsong"],"password":["wangsong"]}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2693.2 Safari/537.36', '62619962-c88c-4530-b424-ced43b30e1ea', '2016-10-07 14:15:27', '2016-10-07 14:15:27'),
	('51056b32-db27-42ba-ab0e-997e9727cc82', 'http://127.0.0.1:8081/spring-app/static/jquery-easyui-1.5/jquery.easyui.min.js', '{}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2693.2 Safari/537.36', '62619962-c88c-4530-b424-ced43b30e1ea', '2016-10-07 15:07:03', '2016-10-07 15:07:03'),
	('52361d65-ad76-4a35-b3d7-19da019e6893', 'http://127.0.0.1:8081/spring-app/sys/user/toList.do', '{}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2693.2 Safari/537.36', '62619962-c88c-4530-b424-ced43b30e1ea', '2016-10-07 15:18:21', '2016-10-07 15:18:21'),
	('53de2040-fd27-44a9-91cf-aa3858c0f5ef', 'http://127.0.0.1:8081/spring-app/static/jquery-easyui-1.5/themes/default/easyui.css', '{}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2693.2 Safari/537.36', NULL, '2016-10-07 14:19:54', '2016-10-07 14:19:54'),
	('5551a0f2-7af1-44e5-a028-7f8afdf2f5d2', 'http://127.0.0.1:8081/spring-app/sys/role/list.do', '{"page":["1"],"rows":["10"]}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2693.2 Safari/537.36', '62619962-c88c-4530-b424-ced43b30e1ea', '2016-10-07 15:18:16', '2016-10-07 15:18:16'),
	('56e8ae6f-6791-44a3-8e5c-26e0ec01e017', 'http://127.0.0.1:8081/spring-app/sys/log/list.do', '{"page":["1"],"rows":["10"]}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2693.2 Safari/537.36', '62619962-c88c-4530-b424-ced43b30e1ea', '2016-10-07 14:56:20', '2016-10-07 14:57:43'),
	('58795d47-bbb9-46f8-9457-152858b16a4c', 'http://127.0.0.1:8081/spring-app/static/jquery-easyui-1.5/jquery.min.js', '{}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2693.2 Safari/537.36', NULL, '2016-10-07 15:09:06', '2016-10-07 15:09:06'),
	('5b1e5418-8188-4d80-99c0-53e3bd244989', 'http://127.0.0.1:8081/spring-app/sys/role/list.do', '{"page":["1"],"rows":["10"]}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2693.2 Safari/537.36', '62619962-c88c-4530-b424-ced43b30e1ea', '2016-10-07 15:18:25', '2016-10-07 15:18:25'),
	('62319239-d18f-4b2b-91c6-1900d0634887', 'http://127.0.0.1:8081/spring-app/sys/log/list.do', '{"page":["1"],"rows":["10"]}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2693.2 Safari/537.36', '62619962-c88c-4530-b424-ced43b30e1ea', '2016-10-07 15:07:05', '2016-10-07 15:07:05'),
	('630ca9a4-da66-40ca-ad12-46d8271a1d3e', 'http://127.0.0.1:8081/spring-app/', '{}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2693.2 Safari/537.36', NULL, '2016-10-07 14:41:39', '2016-10-07 14:41:39'),
	('6330d23d-2ba0-48b9-82dc-78f8fd6644bf', 'http://127.0.0.1:8081/spring-app/sys/resources/toList.do', '{}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2693.2 Safari/537.36', '62619962-c88c-4530-b424-ced43b30e1ea', '2016-10-07 15:18:15', '2016-10-07 15:18:15'),
	('63dc7e58-f9a4-4814-9b21-834224a29c7f', 'http://127.0.0.1:8081/spring-app/static/jquery-easyui-1.5/locale/easyui-lang-zh_CN.js', '{}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2693.2 Safari/537.36', '62619962-c88c-4530-b424-ced43b30e1ea', '2016-10-07 15:06:21', '2016-10-07 15:06:21'),
	('656a471d-6e33-4162-bb20-647eca4b333f', 'http://127.0.0.1:8081/spring-app/sys/log/list.do', '{"page":["1"],"rows":["10"]}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2693.2 Safari/537.36', '62619962-c88c-4530-b424-ced43b30e1ea', '2016-10-07 14:19:58', '2016-10-07 14:19:58'),
	('677f566a-0b51-45e1-9034-fd3274f30838', 'http://127.0.0.1:8081/spring-app/static/jquery-easyui-1.5/themes/icon.css', '{}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2693.2 Safari/537.36', '62619962-c88c-4530-b424-ced43b30e1ea', '2016-10-07 15:06:21', '2016-10-07 15:06:21'),
	('68810798-297c-4260-ad8e-c9846c16db8a', 'http://127.0.0.1:8081/spring-app/login.do', '{"username":["wangsong"],"password":["wangsong"]}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2693.2 Safari/537.36', '62619962-c88c-4530-b424-ced43b30e1ea', '2016-10-07 14:16:56', '2016-10-07 14:16:56'),
	('69cb9747-13b9-431e-9d29-150b10fb8b1b', 'http://127.0.0.1:8081/spring-app/sys/dict/list.do', '{"page":["1"],"rows":["10"]}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2693.2 Safari/537.36', '62619962-c88c-4530-b424-ced43b30e1ea', '2016-10-07 15:18:14', '2016-10-07 15:18:14'),
	('69fa7e42-0350-4e21-9c0f-882f5ba7b4d7', 'http://127.0.0.1:8081/spring-app/static/jquery-easyui-1.5/jquery.min.js', '{}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2693.2 Safari/537.36', '62619962-c88c-4530-b424-ced43b30e1ea', '2016-10-07 15:07:03', '2016-10-07 15:07:03'),
	('6c3a555b-ab21-428a-9662-e12e787d047b', 'http://127.0.0.1:8081/spring-app/sys/role/list.do', '{"page":["1"],"rows":["10"]}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2693.2 Safari/537.36', '62619962-c88c-4530-b424-ced43b30e1ea', '2016-10-07 14:16:37', '2016-10-07 14:16:37'),
	('6c955f61-0d99-45b7-8ebf-fbe25f67df84', 'http://127.0.0.1:8081/spring-app/static/jquery-easyui-1.5/jquery.min.js', '{}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2693.2 Safari/537.36', '62619962-c88c-4530-b424-ced43b30e1ea', '2016-10-07 15:06:21', '2016-10-07 15:06:21'),
	('6d30cc55-b70d-4e8c-816f-7f93491f6e7c', 'http://127.0.0.1:8081/spring-app/sys/log/toList.do', '{}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2693.2 Safari/537.36', '62619962-c88c-4530-b424-ced43b30e1ea', '2016-10-07 14:19:58', '2016-10-07 14:19:58'),
	('713a9a1d-54f8-4f56-b13e-ca6c3dbeeb79', 'http://127.0.0.1:8081/spring-app/sys/log/toList.do', '{}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2693.2 Safari/537.36', '62619962-c88c-4530-b424-ced43b30e1ea', '2016-10-07 14:17:50', '2016-10-07 14:17:50'),
	('722386cf-c213-49af-bf42-fbfe02190236', 'http://127.0.0.1:8081/spring-app/sys/resources/findMapListByType.do', '{}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2693.2 Safari/537.36', NULL, '2016-10-07 14:41:40', '2016-10-07 14:41:40'),
	('727b17cc-2556-4773-99b7-d2b90476d18d', 'http://127.0.0.1:8081/spring-app/static/jquery-easyui-1.5/locale/easyui-lang-zh_CN.js', '{}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2693.2 Safari/537.36', NULL, '2016-10-07 15:09:06', '2016-10-07 15:09:06'),
	('75a60c12-e265-460e-a973-15b11d00cb2e', 'http://127.0.0.1:8081/spring-app/login.do', '{}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2693.2 Safari/537.36', NULL, '2016-10-07 14:19:53', '2016-10-07 14:19:53'),
	('77861f35-9a96-4282-9116-7150a9a741de', 'http://127.0.0.1:8081/spring-app/static/jquery-easyui-1.5/themes/default/easyui.css', '{}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2693.2 Safari/537.36', NULL, '2016-10-07 15:09:06', '2016-10-07 15:09:06'),
	('77a03436-d6f2-4ce9-b518-894968f0b60d', 'http://127.0.0.1:8081/spring-app/sys/log/toList.do', '{}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2693.2 Safari/537.36', '62619962-c88c-4530-b424-ced43b30e1ea', '2016-10-07 14:55:51', '2016-10-07 14:55:51'),
	('7af2fc22-b14e-4aef-97ba-7ae0663c3fdb', 'http://127.0.0.1:8081/spring-app/sys/role/list.do', '{"page":["1"],"rows":["10"]}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2693.2 Safari/537.36', '62619962-c88c-4530-b424-ced43b30e1ea', '2016-10-07 13:56:00', '2016-10-07 13:56:00'),
	('7c88d586-25c1-420b-abc4-b9eaced50a00', 'http://127.0.0.1:8081/spring-app/static/jquery-easyui-1.5/jquery.easyui.min.js', '{}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2693.2 Safari/537.36', NULL, '2016-10-07 14:19:54', '2016-10-07 14:19:54'),
	('7ed21cdd-023a-47b5-beed-34292805ac1c', 'http://127.0.0.1:8081/spring-app/static/jquery-easyui-1.5/jquery.easyui.min.js', '{}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2693.2 Safari/537.36', NULL, '2016-10-07 14:41:40', '2016-10-07 14:41:40'),
	('7f274068-295e-456d-867e-07c6a41b6171', 'http://127.0.0.1:8081/spring-app/', '{}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2693.2 Safari/537.36', '62619962-c88c-4530-b424-ced43b30e1ea', '2016-10-07 15:09:08', '2016-10-07 15:09:08'),
	('8060711c-dc7e-4a1f-825d-0e0ead6c0cbd', 'http://127.0.0.1:8081/spring-app/', '{}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2693.2 Safari/537.36', '62619962-c88c-4530-b424-ced43b30e1ea', '2016-10-07 15:06:21', '2016-10-07 15:06:21'),
	('833b9000-1210-4e66-94aa-9c243ddfdeb7', 'http://127.0.0.1:8081/spring-app/sys/resources/findMapListByType.do', '{}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2693.2 Safari/537.36', '62619962-c88c-4530-b424-ced43b30e1ea', '2016-10-07 15:07:03', '2016-10-07 15:07:03'),
	('85cafe6c-7efc-40c5-bb25-55dcd89ae9b6', 'http://127.0.0.1:8081/spring-app/login.do', '{}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2693.2 Safari/537.36', NULL, '2016-10-07 13:49:36', '2016-10-07 13:49:36'),
	('890d9d8d-c17b-4470-994f-99a90ea0a645', 'http://127.0.0.1:8081/spring-app/sys/log/list.do', '{"page":["1"],"rows":["10"]}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2693.2 Safari/537.36', '62619962-c88c-4530-b424-ced43b30e1ea', '2016-10-07 14:57:46', '2016-10-07 14:58:22'),
	('8d78032f-8443-4bfc-a690-0da2cf5acc23', 'http://127.0.0.1:8081/spring-app/logout.do', '{}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2693.2 Safari/537.36', NULL, '2016-10-07 13:55:55', '2016-10-07 13:55:55'),
	('8f3d491f-266c-4c0a-9f62-c6627afd4668', 'http://127.0.0.1:8081/spring-app/', '{}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2693.2 Safari/537.36', '62619962-c88c-4530-b424-ced43b30e1ea', '2016-10-07 15:07:03', '2016-10-07 15:07:03'),
	('90bdc39d-12ee-479d-a723-eb0cbd426d80', 'http://127.0.0.1:8081/spring-app/static/jquery-easyui-1.5/locale/easyui-lang-zh_CN.js', '{}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2693.2 Safari/537.36', '62619962-c88c-4530-b424-ced43b30e1ea', '2016-10-07 15:04:34', '2016-10-07 15:04:34'),
	('94bfdd90-881f-46d6-a5b6-0f5efe259283', 'http://127.0.0.1:8081/spring-app/sys/dict/toList.do', '{}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2693.2 Safari/537.36', '62619962-c88c-4530-b424-ced43b30e1ea', '2016-10-07 15:18:14', '2016-10-07 15:18:14'),
	('95beefb3-d22a-4bd3-8a1f-f744e6727fe9', 'http://127.0.0.1:8081/spring-app/login.do', '{"username":["wangsong"],"password":["wangsong"]}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2693.2 Safari/537.36', '62619962-c88c-4530-b424-ced43b30e1ea', '2016-10-07 15:09:08', '2016-10-07 15:09:08'),
	('96083871-3d76-4bd0-837d-4d38f2c0491b', 'http://127.0.0.1:8081/spring-app/', '{}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2693.2 Safari/537.36', '62619962-c88c-4530-b424-ced43b30e1ea', '2016-10-07 15:04:34', '2016-10-07 15:04:34'),
	('974afdbb-32fe-4245-aca0-3fc2c5c6a6f3', 'http://127.0.0.1:8081/spring-app/sys/log/list.do', '{"page":["1"],"rows":["10"]}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2693.2 Safari/537.36', '62619962-c88c-4530-b424-ced43b30e1ea', '2016-10-07 14:55:51', '2016-10-07 14:55:51'),
	('98914d95-4963-4987-91a3-cf0f054270ca', 'http://127.0.0.1:8081/spring-app/static/jquery-easyui-1.5/themes/default/easyui.css', '{}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2693.2 Safari/537.36', NULL, '2016-10-07 14:41:40', '2016-10-07 14:41:40'),
	('9f89bebb-0479-4d20-9752-6315ff1eb3d1', 'http://127.0.0.1:8081/spring-app/static/jquery-easyui-1.5/themes/default/easyui.css', '{}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2693.2 Safari/537.36', '62619962-c88c-4530-b424-ced43b30e1ea', '2016-10-07 15:07:03', '2016-10-07 15:07:03'),
	('a0931449-b38f-4575-a00c-dbe890088cd1', 'http://127.0.0.1:8081/spring-app/static/jquery-easyui-1.5/locale/easyui-lang-zh_CN.js', '{}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2693.2 Safari/537.36', '62619962-c88c-4530-b424-ced43b30e1ea', '2016-10-07 15:21:13', '2016-10-07 15:21:13'),
	('a0a20728-3328-4fb1-8f6b-ad48983bdc0e', 'http://127.0.0.1:8081/spring-app/static/jquery-easyui-1.5/themes/default/easyui.css', '{}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2693.2 Safari/537.36', '62619962-c88c-4530-b424-ced43b30e1ea', '2016-10-07 15:04:34', '2016-10-07 15:04:34'),
	('a4c2fdea-2227-4801-9280-3b8b3263399c', 'http://127.0.0.1:8081/spring-app/sys/log/list.do', '{"page":["1"],"rows":["10"]}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2693.2 Safari/537.36', '62619962-c88c-4530-b424-ced43b30e1ea', '2016-10-07 15:06:23', '2016-10-07 15:06:33'),
	('a7dc57f6-592e-46f9-869a-bf2af5dc3492', 'http://127.0.0.1:8081/spring-app/static/jquery-easyui-1.5/jquery.easyui.min.js', '{}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2693.2 Safari/537.36', NULL, '2016-10-07 15:09:06', '2016-10-07 15:09:06'),
	('ac8e8528-eddb-4b33-a03d-f3418c05d8e2', 'http://127.0.0.1:8081/spring-app/sys/log/list.do', '{"page":["2"],"rows":["20"]}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2693.2 Safari/537.36', '62619962-c88c-4530-b424-ced43b30e1ea', '2016-10-07 14:20:09', '2016-10-07 14:20:09'),
	('acb22867-f7a6-4029-bc0d-1a13a86d0148', 'http://127.0.0.1:8081/spring-app/sys/resources/findMapListByType.do', '{}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2693.2 Safari/537.36', '62619962-c88c-4530-b424-ced43b30e1ea', '2016-10-07 15:04:35', '2016-10-07 15:04:35'),
	('acd34e59-5b45-4808-a054-378223d54eab', 'http://127.0.0.1:8081/spring-app/', '{}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2693.2 Safari/537.36', '62619962-c88c-4530-b424-ced43b30e1ea', '2016-10-07 14:41:44', '2016-10-07 14:41:44'),
	('aed53ab8-d43e-4d73-98a3-45be951795f6', 'http://127.0.0.1:8081/spring-app/sys/log/list.do', '{"page":["10"],"rows":["10"]}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2693.2 Safari/537.36', '62619962-c88c-4530-b424-ced43b30e1ea', '2016-10-07 15:09:17', '2016-10-07 15:09:17'),
	('aef6d369-fb15-47a5-af6a-ec15a5ee6786', 'http://127.0.0.1:8081/spring-app/login.do', '{"username":["wangsong"],"password":["wangsong"]}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2693.2 Safari/537.36', '62619962-c88c-4530-b424-ced43b30e1ea', '2016-10-07 14:41:44', '2016-10-07 14:41:44'),
	('b90364a9-6367-43c1-b82c-1734aff231ab', 'http://127.0.0.1:8081/spring-app/', '{}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2693.2 Safari/537.36', '62619962-c88c-4530-b424-ced43b30e1ea', '2016-10-07 14:16:56', '2016-10-07 14:16:56'),
	('bb305e55-89f8-47b4-9c05-96f4ad45e687', 'http://127.0.0.1:8081/spring-app/sys/log/list.do', '{"page":["1"],"rows":["20"]}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2693.2 Safari/537.36', '62619962-c88c-4530-b424-ced43b30e1ea', '2016-10-07 14:20:15', '2016-10-07 14:20:15'),
	('c531bcf2-2795-41dc-8059-b3b1f041223d', 'http://127.0.0.1:8081/spring-app/sys/resources/findMapListByType.do', '{}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2693.2 Safari/537.36', '62619962-c88c-4530-b424-ced43b30e1ea', '2016-10-07 15:09:08', '2016-10-07 15:09:08'),
	('c53e1227-13a8-4a1d-bfeb-b13c751707cc', 'http://127.0.0.1:8081/spring-app/sys/log/list.do', '{"page":["3"],"rows":["10"]}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2693.2 Safari/537.36', '62619962-c88c-4530-b424-ced43b30e1ea', '2016-10-07 14:20:02', '2016-10-07 14:20:02'),
	('c5c53513-83ff-4106-a302-d07ec104177e', 'http://127.0.0.1:8081/spring-app/', '{}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2693.2 Safari/537.36', '62619962-c88c-4530-b424-ced43b30e1ea', '2016-10-07 13:55:57', '2016-10-07 13:55:57'),
	('c688bcf9-b128-4ba1-a700-cf9f6f0ebe90', 'http://127.0.0.1:8081/spring-app/sys/log/list.do', '{"page":["4"],"rows":["10"]}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2693.2 Safari/537.36', '62619962-c88c-4530-b424-ced43b30e1ea', '2016-10-07 14:20:02', '2016-10-07 14:20:02'),
	('c8986cf1-7ff9-4e37-b8f9-95f8ba25396a', 'http://127.0.0.1:8081/spring-app/sys/role/list.do', '{"page":["1"],"rows":["10"]}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2693.2 Safari/537.36', '62619962-c88c-4530-b424-ced43b30e1ea', '2016-10-07 13:55:57', '2016-10-07 13:55:58'),
	('c8aa26a1-19d0-41e8-98d7-fa6477e9dc01', 'http://127.0.0.1:8081/spring-app/sys/role/toAdd.do', '{}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2693.2 Safari/537.36', '62619962-c88c-4530-b424-ced43b30e1ea', '2016-10-07 13:56:00', '2016-10-07 13:56:00'),
	('cbf69720-83f8-4f52-84e3-edf13a7d9418', 'http://127.0.0.1:8081/spring-app/static/jquery-easyui-1.5/jquery.min.js', '{}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2693.2 Safari/537.36', '62619962-c88c-4530-b424-ced43b30e1ea', '2016-10-07 15:21:13', '2016-10-07 15:21:13'),
	('cda44322-7df9-49c2-b341-b0439d019acd', 'http://127.0.0.1:8081/spring-app/static/jquery-easyui-1.5/jquery.easyui.min.js', '{}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2693.2 Safari/537.36', '62619962-c88c-4530-b424-ced43b30e1ea', '2016-10-07 15:21:13', '2016-10-07 15:21:13'),
	('ce34c183-dda2-4781-afc4-ad803330da55', 'http://127.0.0.1:8081/spring-app/', '{}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2693.2 Safari/537.36', '62619962-c88c-4530-b424-ced43b30e1ea', '2016-10-07 14:15:27', '2016-10-07 14:15:27'),
	('cec7950e-194c-4651-ba4a-32c1363203ef', 'http://127.0.0.1:8081/spring-app/sys/role/list.do', '{"page":["1"],"rows":["10"]}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2693.2 Safari/537.36', '62619962-c88c-4530-b424-ced43b30e1ea', '2016-10-07 14:16:45', '2016-10-07 14:16:45'),
	('cf0fbaa0-0bd5-4e25-a7e1-6066e6df9f05', 'http://127.0.0.1:8081/spring-app/sys/log/toList.do', '{}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2693.2 Safari/537.36', '62619962-c88c-4530-b424-ced43b30e1ea', '2016-10-07 15:06:22', '2016-10-07 15:06:22'),
	('d17472fa-34de-4715-a5ba-599a885cf1a5', 'http://127.0.0.1:8081/spring-app/logout.do', '{}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2693.2 Safari/537.36', NULL, '2016-10-07 14:41:43', '2016-10-07 14:41:43'),
	('d681e213-139a-45c7-9c77-18001f1af78b', 'http://127.0.0.1:8081/spring-app/sys/log/list.do', '{"page":["1"],"rows":["10"]}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2693.2 Safari/537.36', '62619962-c88c-4530-b424-ced43b30e1ea', '2016-10-07 15:09:10', '2016-10-07 15:09:10'),
	('d76a1185-e347-4681-b50c-adebdd84fa98', 'http://127.0.0.1:8081/spring-app/static/jquery-easyui-1.5/themes/default/easyui.css', '{}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2693.2 Safari/537.36', '62619962-c88c-4530-b424-ced43b30e1ea', '2016-10-07 15:06:21', '2016-10-07 15:06:21'),
	('d892752f-5f55-4d42-8dfa-878a307c575c', 'http://127.0.0.1:8081/spring-app/static/jquery-easyui-1.5/themes/icon.css', '{}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2693.2 Safari/537.36', '62619962-c88c-4530-b424-ced43b30e1ea', '2016-10-07 15:21:13', '2016-10-07 15:21:13'),
	('db013535-0b5e-4dd4-9793-eb9581e33403', 'http://127.0.0.1:8081/spring-app/sys/resources/findMapListByType.do', '{}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2693.2 Safari/537.36', '62619962-c88c-4530-b424-ced43b30e1ea', '2016-10-07 14:55:46', '2016-10-07 14:55:46'),
	('dde2299a-36ef-49ba-86a9-4acfb82d5dd1', 'http://127.0.0.1:8081/spring-app/sys/log/toList.do', '{}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2693.2 Safari/537.36', '62619962-c88c-4530-b424-ced43b30e1ea', '2016-10-07 14:41:50', '2016-10-07 14:41:50'),
	('e17259e1-aae4-4640-b158-58091f29cee5', 'http://127.0.0.1:8081/spring-app/login.do', '{}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2693.2 Safari/537.36', NULL, '2016-10-07 15:09:05', '2016-10-07 15:09:05'),
	('e31e5b04-b01d-4587-a61e-6f9493a8be92', 'http://127.0.0.1:8081/spring-app/sys/log/toList.do', '{}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2693.2 Safari/537.36', '62619962-c88c-4530-b424-ced43b30e1ea', '2016-10-07 14:42:24', '2016-10-07 14:42:24'),
	('e38ccc73-a614-41d7-b0ba-a5b7f7182de8', 'http://127.0.0.1:8081/spring-app/sys/log/toList.do', '{}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2693.2 Safari/537.36', '62619962-c88c-4530-b424-ced43b30e1ea', '2016-10-07 15:04:36', '2016-10-07 15:04:37'),
	('e966f461-c8e4-4eea-8c63-2324f8c68471', 'http://127.0.0.1:8081/spring-app/login.do', '{"username":["wangsong"],"password":["wangsong"]}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2693.2 Safari/537.36', '62619962-c88c-4530-b424-ced43b30e1ea', '2016-10-07 14:55:44', '2016-10-07 14:55:45'),
	('ead43049-3905-4fc7-bd9b-fa740cdacb87', 'http://127.0.0.1:8081/spring-app/sys/log/list.do', '{"page":["1"],"rows":["10"]}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2693.2 Safari/537.36', '62619962-c88c-4530-b424-ced43b30e1ea', '2016-10-07 14:17:51', '2016-10-07 14:17:51'),
	('f45be869-0b1c-44c8-bff8-8658ed70d2c7', 'http://127.0.0.1:8081/spring-app/static/jquery-easyui-1.5/jquery.easyui.min.js', '{}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2693.2 Safari/537.36', '62619962-c88c-4530-b424-ced43b30e1ea', '2016-10-07 15:06:21', '2016-10-07 15:06:21'),
	('f599e81a-7266-402b-a588-40ed712cef54', 'http://127.0.0.1:8081/spring-app/', '{}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2693.2 Safari/537.36', '62619962-c88c-4530-b424-ced43b30e1ea', '2016-10-07 14:19:57', '2016-10-07 14:19:57'),
	('f5b3e5df-4b2f-4a54-af5e-8ad4573ab7d4', 'http://127.0.0.1:8081/spring-app/sys/user/toList.do', '{}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2693.2 Safari/537.36', '62619962-c88c-4530-b424-ced43b30e1ea', '2016-10-07 15:18:17', '2016-10-07 15:18:17'),
	('f653c8f8-7f0b-4f77-9dad-f81b9c688727', 'http://127.0.0.1:8081/spring-app/sys/log/list.do', '{"page":["1"],"rows":["20"]}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2693.2 Safari/537.36', '62619962-c88c-4530-b424-ced43b30e1ea', '2016-10-07 14:20:07', '2016-10-07 14:20:07'),
	('faaf6e31-d8f2-436e-b5e6-5402fb5ec25b', 'http://127.0.0.1:8081/spring-app/', '{}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2693.2 Safari/537.36', '62619962-c88c-4530-b424-ced43b30e1ea', '2016-10-07 14:55:45', '2016-10-07 14:55:45'),
	('fc485b15-6b52-427d-8d20-44882a608adc', 'http://127.0.0.1:8081/spring-app/sys/log/list.do', '{"page":["1"],"rows":["10"]}', '127.0.0.1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2693.2 Safari/537.36', '62619962-c88c-4530-b424-ced43b30e1ea', '2016-10-07 14:16:58', '2016-10-07 14:16:58');
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
DELETE FROM `sys_resources`;
/*!40000 ALTER TABLE `sys_resources` DISABLE KEYS */;
INSERT INTO `sys_resources` (`id`, `pid`, `name`, `url`, `type`, `sort`) VALUES
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
DELETE FROM `sys_role`;
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

-- 正在导出表  spring-app.sys_role_resources 的数据：~26 rows (大约)
DELETE FROM `sys_role_resources`;
/*!40000 ALTER TABLE `sys_role_resources` DISABLE KEYS */;
INSERT INTO `sys_role_resources` (`id`, `role_id`, `resources_id`) VALUES
	('0143536a-4554-4910-8b4b-1d6f5e18faea', 'f9127759-1116-4159-adcf-98dbe1d77576', 'ecb6527f-0548-40f7-b92e-6719ff3f9556'),
	('0eef1947-b791-4283-aa5a-2460feda0eea', 'f9127759-1116-4159-adcf-98dbe1d77576', '8d1d2815-d011-4da9-a66e-573a5f056f62'),
	('1535e8b8-d6ee-40fc-9308-f55d6380725a', 'f9127759-1116-4159-adcf-98dbe1d77576', '51745327-1978-48ab-aa19-6986a3f628d7'),
	('17bc9d69-274a-414f-8552-e3fee117a9f9', 'f9127759-1116-4159-adcf-98dbe1d77576', '93400178-2c2f-47de-9b30-5d126b33e197'),
	('1c30cbfd-2738-4ca3-94c4-2643884d6671', 'f9127759-1116-4159-adcf-98dbe1d77576', 'c01620cd-4845-4a4a-a72f-1524b3c54d24'),
	('2245334f-42f7-4461-b003-0a15c8ce47aa', 'f9127759-1116-4159-adcf-98dbe1d77576', '21e9a57d-b7a2-45b0-8359-cc21d636c0fa'),
	('2625a9e8-df54-4b3c-99e9-06e548b5d1fe', 'f9127759-1116-4159-adcf-98dbe1d77576', '1115d196-fd3a-4ca1-99c8-5452bae30c8f'),
	('2c0dbf43-23a4-41c4-b67d-1efe72d9726d', 'f9127759-1116-4159-adcf-98dbe1d77576', '13fd01f1-20d8-49fd-9630-6fb7f8539920'),
	('3427f060-baf4-4575-abe8-00fde5a3ed65', 'f9127759-1116-4159-adcf-98dbe1d77576', '3445c320-cf85-4990-914d-ce14806c0590'),
	('3bd536ed-92b7-4fd7-90c7-4ef7ab930114', 'f9127759-1116-4159-adcf-98dbe1d77576', '32680760-3ad2-4ac5-bd2f-fca4917d8f74'),
	('5f42b24c-fbb0-4b5e-b66d-1b5655e19786', 'f9127759-1116-4159-adcf-98dbe1d77576', 'ea7a58c3-74d2-45c1-8b66-974cd82d1fbd'),
	('67218117-45d0-49e4-b403-5192d340781e', 'f9127759-1116-4159-adcf-98dbe1d77576', '0ff729fc-a43c-4a5c-a2bf-07fbeefa2520'),
	('752f46bd-5a7d-4584-b558-bb409a9b0265', 'f9127759-1116-4159-adcf-98dbe1d77576', 'c65e7c94-a3c1-43b7-a8c7-94e1d693f0b5'),
	('7cd3204a-f6bb-4326-be23-a31fc2cd1a75', 'f9127759-1116-4159-adcf-98dbe1d77576', 'a9b97767-54ff-4477-a81a-274d6e2b5ce9'),
	('7d41c67d-ae4b-4a28-bea0-2be8a6f19806', 'f9127759-1116-4159-adcf-98dbe1d77576', '8fec88df-50c5-4a5e-800e-621d203f7a55'),
	('7dbc406a-9735-4e94-b045-c9b5252ed615', 'f9127759-1116-4159-adcf-98dbe1d77576', '652b3c26-5085-4739-94db-ebbbb1397acf'),
	('808ea92f-29b6-470a-ab17-be035311ea10', 'f9127759-1116-4159-adcf-98dbe1d77576', '63efc666-ee88-45f7-bdad-2b019c19eb1d'),
	('8954ca88-3a6b-49ac-abe9-f2edb2cfb964', 'f9127759-1116-4159-adcf-98dbe1d77576', '9ee4dade-b3af-4664-82c8-4d712f231db4'),
	('c56060e1-09a7-4721-bcee-3d2b69a01c3d', 'f9127759-1116-4159-adcf-98dbe1d77576', '0cf26ffd-88e9-42ca-91fb-374359e12f82'),
	('c939c4eb-8cb7-4e3b-be06-2bd123b1989f', 'f9127759-1116-4159-adcf-98dbe1d77576', 'c56d6e95-5515-492b-866a-b8555e7b647c'),
	('e6bd78cc-73f7-4783-8400-c18a2afc886a', 'f9127759-1116-4159-adcf-98dbe1d77576', '1'),
	('eb056100-59f0-4e7b-8edf-31bfd9ae98c6', 'f9127759-1116-4159-adcf-98dbe1d77576', '2b56b958-3b0d-46d4-8988-d7c5ae1d804b'),
	('f6b31894-d041-4952-bba5-fcffa2945a59', 'f9127759-1116-4159-adcf-98dbe1d77576', 'f0e5351e-7291-4d41-87c2-3ebfc5388d7c'),
	('f92430a6-0347-4242-bd74-d08cfa39444d', 'f9127759-1116-4159-adcf-98dbe1d77576', '3b3b3284-eaab-48a5-a5e5-5da4e2c490af');
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
DELETE FROM `sys_user`;
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
DELETE FROM `sys_user_role`;
/*!40000 ALTER TABLE `sys_user_role` DISABLE KEYS */;
INSERT INTO `sys_user_role` (`id`, `user_id`, `role_id`) VALUES
	('5b6e768a-088a-472a-a005-7122de1f92ff', '62619962-c88c-4530-b424-ced43b30e1ea', 'f9127759-1116-4159-adcf-98dbe1d77576'),
	('ec9962b4-cc5c-4c78-bf5e-b08d1920f158', 'd40790b5-8d08-4a44-a98d-fd1866e95223', 'f9127759-1116-4159-adcf-98dbe1d77576');
/*!40000 ALTER TABLE `sys_user_role` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
