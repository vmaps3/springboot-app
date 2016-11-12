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
页面UI easyui
