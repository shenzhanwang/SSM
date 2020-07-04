# SSM
Spring boot,Mybatis的整合总是很麻烦，在此提供一个已经整合好三大框架的包，可以直接下载导入Myeclipse使用，项目基于Maven做依赖管理。项目基于Mysql自带的Sakila数据库实现了MIS系统中常用的多个功能，运行前请安装好Mysql5.6。

其中包含的内容如下：

1.Spring boot 2.1.6,Mybatis3.2.2的整合；

2.前端框架采用https://adminlte.io ，后台的分页使用Mybatis的插件pagehelper实现；

3.数据库使用Mysql中自带的sakila数据库，使用前，请将application.properties中的spring.datasource.ssm.password中的数据库密码设置为自己的；

4.实现了sakila中的单表的增删改查和跨表查询，跨表查询包括了Mybatis的1-N和N-1双向映射；

5.不再使用作业自动调度框架Quartz实现作业调度，使用spring框架自带的调度器进行作业调度，简化了配置；

6.json插件使用阿里的开源fastjson工具,注意低版本的fastjson与swagger不兼容，这里有坑；

7.包含了一个文件上传的功能，可上传单个或多个文件；

8.包含了数据表导出为Excel下载的功能，包含了解析Excel内容的API，使用POI实现；

9.包含了带验证码的登录功能以及登录权限验证的拦截器, **登录用户名tom，密码1234**, **用户表在staff中，可自行添加**  ；

10.要使用Struts2+hibernate+spring的整合，[点击这里进入](https://github.com/shenzhanwang/SSH_maven)  

11.去掉所有JSP，使用HTML代替，有利于前后端分离;

12.整合日志工具log4j2，较log4j1.x有较大性能提升，支持日志文件输出和控制台输出；

13.整合接口文档swagger2.9.2，入口http://localhost:8080/swagger-ui.html

14.将后台接口REST化，详情参考https://gitee.com/shenzhanwang/Spring-REST

15.添加mybatis的动态SQL的使用

16.访问入口：http://localhost:8080/login

17.要使用传统spring，切换分支到https://gitee.com/shenzhanwang/SSM/tree/master/

18.允许后台接口跨域

19.不再使用spring boot自带的数据源，改为使用alibaba druid数据源管理数据库连接。

效果图：
![输入图片说明](https://images.gitee.com/uploads/images/2019/1114/094648_5adf8483_1110335.gif "s.gif")
![输入图片说明](https://images.gitee.com/uploads/images/2019/1030/191932_ba8c3db7_1110335.png "login.png")
![输入图片说明](https://images.gitee.com/uploads/images/2019/1114/094959_7e77736e_1110335.png "actor0.png")
![输入图片说明](https://images.gitee.com/uploads/images/2019/1114/095008_709381b9_1110335.png "city4.png")
![输入图片说明](https://images.gitee.com/uploads/images/2019/1114/095020_226d39d0_1110335.png "file939.png")
![输入图片说明](https://images.gitee.com/uploads/images/2019/1114/094835_24192f7f_1110335.png "微信截图_20191114093656.png")


### 附录：个人作品索引目录（持续更新）

#### 基础篇:职业化，从做好OA系统开始
1. [Spring boot整合Mybatis实现增删改查（支持多数据源）](https://gitee.com/shenzhanwang/SSM)![输入图片说明](https://img.shields.io/badge/-%E7%B2%BE%E5%93%81-orange.svg "在这里输入图片标题")
2. [Struts2,Hibernate,Spring三大框架的整合实现增删改查](https://gitee.com/shenzhanwang/S2SH)
3. [Spring,SpringMVC和Hibernate的整合实现增删改查](https://gitee.com/shenzhanwang/SSH)
4. [Spring平台整合activiti工作流引擎实现OA开发](https://gitee.com/shenzhanwang/Spring-activiti)![输入图片说明](https://img.shields.io/badge/-%E7%B2%BE%E5%93%81-orange.svg "在这里输入图片标题")
5. [Spring发布与调用REST风格的WebService](https://gitee.com/shenzhanwang/Spring-REST)
6. [Spring整合Apache Shiro框架，实现用户管理和权限控制](https://gitee.com/shenzhanwang/Spring-shiro)
7. [使用Spring security做权限控制](https://gitee.com/shenzhanwang/spring-security-demo)
8. [Spring整合Jasig CAS框架实现单点登录](https://gitee.com/shenzhanwang/Spring-cas-sso)
#### 中级篇：中间件的各种姿势
9. [Spring连接mongoDB数据库实现增删改查](https://gitee.com/shenzhanwang/Spring-mongoDB)
10. [Spring连接Redis实现缓存](https://gitee.com/shenzhanwang/Spring-redis)
11. [Spring连接图存数据库Neo4j实现增删改查](https://gitee.com/shenzhanwang/Spring-neo4j)
12. [Spring平台整合消息队列ActiveMQ实现发布订阅、生产者消费者模型（JMS）](https://gitee.com/shenzhanwang/Spring-activeMQ)
13. [Spring整合消息队列RabbitMQ实现四种消息模式（AMQP）](https://gitee.com/shenzhanwang/Spring-rabbitMQ)
14. [Spring框架的session模块实现集中式session管理](https://gitee.com/shenzhanwang/Spring-session)
15. [Spring整合websocket实现即时通讯](https://gitee.com/shenzhanwang/Spring-websocket)![输入图片说明](https://img.shields.io/badge/-%E7%B2%BE%E5%93%81-orange.svg "在这里输入图片标题")
16. 使用Spring boot整合mybatis,rabbitmq,redis,mongodb实现增删改查 [购买](http://www.vmfaka.net/list/fdxxWOPd4Ds)
17. [Spring MVC整合FastDFS客户端实现文件上传](https://gitee.com/shenzhanwang/Spring-fastdfs)
18. 23种设计模式，源码、注释、使用场景 [购买](http://www.vmfaka.net/list/fdxxX8JbeQs)
19. [使用ETL工具Kettle的实例](https://gitee.com/shenzhanwang/Kettle-demo)
20. Git指南和分支管理策略 [购买](http://www.vmfaka.net/list/fdxxX8KJYHs)
21. 使用数据仓库进行OLAP数据分析（Mysql+Kettle+Zeppelin） [购买](http://www.vmfaka.net/list/fdxxX8Oe47s)
#### 高级篇：架构之美
22. [zookeeper原理、架构、使用场景和可视化](https://gitee.com/shenzhanwang/zookeeper-practice)
23. Spring boot整合Apache dubbo v2.7.5实现分布式服务治理（SOA架构） ![输入图片说明](https://img.shields.io/badge/-%E7%B2%BE%E5%93%81-orange.svg "在这里输入图片标题") [购买](http://www.vmfaka.net/list/fdxxX8RWrss)
>  包含组件Spring boot v2.2.2+Dubbo v2.7.5+Nacos v1.1.1
<a href="https://images.gitee.com/uploads/images/2020/0114/084731_fd0b7a82_1110335.gif" target="_blank">效果图</a>
24. 使用Spring Cloud Alibaba v2.1.0实现微服务架构（MSA架构）![输入图片说明](https://img.shields.io/badge/-%E6%8B%9B%E7%89%8C-yellow.svg)   [购买](http://www.vmfaka.net/list/fdxxX8VwMLs)
>  包含组件Nacos+Feign+Gateway+Ribbon+Sentinel+Zipkin
<a href="https://images.gitee.com/uploads/images/2020/0106/201827_ac61db63_1110335.gif" target="_blank">效果图</a>
25. 使用jenkins+centos+git+maven搭建持续集成环境自动化部署分布式服务 [购买](http://www.vmfaka.net/list/fdxxX8Xbb5s)
26. 使用docker+compose+jenkins+gitlab+spring cloud实现微服务的编排、持续集成和动态扩容 [购买](http://www.vmfaka.net/list/fdxxX91gDDs)
27. 使用FastDFS搭建分布式文件系统（高可用、负载均衡）[购买](http://www.vmfaka.net/list/fdxxX95MwYs)
28. 搭建高可用nginx集群和Tomcat负载均衡 [购买](http://www.vmfaka.net/list/fdxxX99exbs)
29. [搭建ActiveMQ高可用集群](https://gitee.com/shenzhanwang/ActiveMQJiQunDaJian)
30. 实现Mysql数据库的主从复制、读写分离、分表分库、负载均衡和高可用 [购买](http://www.vmfaka.net/list/fdxxX9eo8zs)
31. 搭建高可用redis集群实现分布式缓存 [购买](http://www.vmfaka.net/list/fdxxX9hmRGs)
32. [Spring boot整合Elastic search实现全文检索](https://gitee.com/shenzhanwang/Spring-elastic_search) ![输入图片说明](https://img.shields.io/badge/-%E6%8B%9B%E7%89%8C-yellow.svg "在这里输入图片标题")
#### 特别篇：分布式事务和并发控制
33. 基于可靠消息最终一致性实现分布式事务（activeMQ）[购买](http://www.vmfaka.net/list/fdxxX9kEN9s)
34. Spring boot dubbo整合seata实现分布式事务![输入图片说明](https://img.shields.io/badge/-%E7%B2%BE%E5%93%81-orange.svg "在这里输入图片标题") [购买](http://www.vmfaka.net/list/fdxxX9mmc9s)
> 包含组件nacos v1.1.0 + seata v0.7.1 +spring boot dubbo v2.7.5
<a href="https://images.gitee.com/uploads/images/2020/0119/112233_62a33a77_1110335.gif" target="_blank">效果图</a>
35. Spring cloud alibaba v2.1.0整合seata实现分布式事务 ![输入图片说明](https://img.shields.io/badge/-%E7%B2%BE%E5%93%81-orange.svg "在这里输入图片标题")[购买](http://www.vmfaka.net/list/fdxxX9p9VSs)
> 包含组件nacos v1.1.0 + seata v0.7.1 +spring cloud alibaba v2.1.0
<a href="https://images.gitee.com/uploads/images/2020/0119/134408_ee14a016_1110335.gif" target="_blank">效果图</a>
36. 并发控制：数据库锁机制和事务隔离级别的实现![输入图片说明](https://img.shields.io/badge/-%E7%B2%BE%E5%93%81-orange.svg "在这里输入图片标题") [购买](http://www.vmfaka.net/list/fdxxX9sSSzs)
37. 并发控制：使用redis实现分布式锁  ![输入图片说明](https://img.shields.io/badge/-%E7%B2%BE%E5%93%81-orange.svg "在这里输入图片标题")[购买](http://www.vmfaka.net/list/fdxxX9umfMs)
38. 并发控制：使用zookeeper实现分布式锁 [购买](http://www.vmfaka.net/list/fdxxX9xY6qs)
39. 并发控制：Java多线程编程实例 [购买](http://www.vmfaka.net/list/fdxxX9zaC4s)
40. 并发控制：使用netty实现高性能NIO通信 [购买](http://www.vmfaka.net/list/fdxxX9BOfms)
### 快捷入口
<a href="http://www.vmfaka.net/list/UZvwyHjbu" target="_blank">我的网店</a>

<a href="http://www.vmfaka.net/list/fdxxX9PpS0s" target="_blank">全套大礼包2020年版</a>
