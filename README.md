# springboot-app

## 系统介绍

- springboot-app 是J2EE基础开发平台，架构设计包括（动静分离），技术栈包括（SpringBoot、MyBatis、Shiro、easyui），业务模块包括：用户管理，角色管理、权限管理，字典管理。

## 业务功能

- 1.用户管理：用户是系统操作者，该功能主要完成系统用户配置。
- 2.角色管理：角色菜单权限分配。
- 3.菜单管理：配置系统菜单，操作权限，按钮权限标识等。
- 4.字典管理：对系统中经常使用的一些较为固定的数据进行维护，如：是否、男女、类别、级别等。

## 技术栈

- 核心 springboot 
- MVC springmvc 
- ORM mybatis 
- 权限 shiro 
- 连接池 druid
- 页面UI easyui
- 构建 maven
- 容器 tomcat
- 数据库 mysql


##部署

- 1.导入数据库脚本springboot-app.sql
- 2.安装nginx配置参考nginx.txt
- 3.启动sprtingboot-app-service位置com.wangsong.Application
- 4.访问nginx端口/sprtingboot-app-html

## 预览

![](http://git.oschina.net/uploads/images/2016/1116/164543_5571d631_420150.png "登录")
![](http://git.oschina.net/uploads/images/2016/1116/164618_99cd6105_420150.png "角色权限树")
![](http://git.oschina.net/uploads/images/2016/1116/164633_6dd5c2e9_420150.png "权限右键操作树")

## qq交流群

- 74745979