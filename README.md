#spring-app

##系统介绍
spring-app 是J2EE开发基础平台，使用经典技术组合（Spring、SpringMVC、MyBatis、Shiro、redis、quartz、activiti、easyui），包括核心模块如：角色用户、权限授权、工作流等。

##业务功能
1.用户管理：用户是系统操作者，该功能主要完成系统用户配置。
2.角色管理：角色菜单权限分配。
3.菜单管理：配置系统菜单，操作权限，按钮权限标识等。
4.字典管理：对系统中经常使用的一些较为固定的数据进行维护，如：是否、男女、类别、级别等。
5.日志管理：系统正常操作日志记录和查询；系统异常信息日志记录和查询。

##技术栈
核心 spring 
MVC springmvc 
ORM mybatis 
权限 shiro 
缓存 redis 
定时器 quartz（持久化） 
数据库二级缓存 mybatis-redis 
集群 shiro-redis 
单机 shiro-ehcahce
构建 maven
容器 tomcat
连接池 druid
调度 quartz
工作流 activiti
数据库 mysql
页面UI easyui

##部署方法
1.maven导入
2.运行spring-app.sql
3.更改config.properties
##预览
![](http://b.hiphotos.baidu.com/image/pic/item/9922720e0cf3d7ca4a650d4efb1fbe096b63a972.jpg)
![](http://a.hiphotos.baidu.com/image/pic/item/024f78f0f736afc391cf0d5dba19ebc4b64512c2.jpg)
![](http://a.hiphotos.baidu.com/image/pic/item/72f082025aafa40fabe0f3e5a264034f78f019e7.jpg)
![](http://f.hiphotos.baidu.com/image/pic/item/34fae6cd7b899e51da26082c4ba7d933c8950d59.jpg)
![](http://f.hiphotos.baidu.com/image/pic/item/91ef76c6a7efce1be0fcfaf2a651f3deb48f6536.jpg)