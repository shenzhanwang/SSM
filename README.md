# SSM
SpringMVC,Mybatis,Spring三大框架的整合总是很麻烦，在此提供一个已经整合好三大框架的包，可以直接下载导入Myeclipse使用，项目基于Maven做依赖管理。项目基于Mysql自带的Sakila数据库实现了MIS系统中常用的多个功能，运行前请安装好Mysql。

其中包含的内容如下：

1.SpringMVC4.0.4,Mybatis3.2.2,Spring4.0.4三大框架的整合；

2.前端框架集成了Bootstrap3.3.5，Jquery1.12.3,集成了Bootstrap插件Bootgrid数据表格实现分页，使用Bootstrap的datetimepicker插件实现日期时间选择，后台的分页使用Mybatis的插件pagehelper实现；

3.数据库使用Mysql中自带的sakila数据库，使用前，请将SSM\src\main\resources\conf中的spring-mybatis.xml中的数据库密码设置为自己的；

4.实现了sakila中的单表的增删改查和跨表查询，跨表查询包括了Mybatis的1-N和N-1双向映射；

5.集成了作业自动调度框架Quartz 2.2.2实现作业调度；

6.json插件使用阿里的开源fastjson工具；

7.包含了一个文件上传的功能；

8.包含了数据表导出为Excel下载的功能，包含了解析Excel内容的API，使用POI实现；

9.包含了带验证码的登录功能以及登录权限验证的拦截器；

10.要使用Struts2+hibernate+spring的整合，[点击这里进入](https://github.com/shenzhanwang/SSH_maven)  

访问入口：http://localhost:8080/SSM/login

效果图：

 ![alt text](https://github.com/shenzhanwang/SSM/blob/master/%E6%88%AA%E5%9B%BE/1.png)
 
 ![alt text](https://github.com/shenzhanwang/SSM/blob/master/%E6%88%AA%E5%9B%BE/2.png)

### 附录：个人作品索引目录（持续更新）

#### 基础篇:职业化，从做好OA系统开始
1. [SpringMVC,Mybatis,Spring三大框架的整合实现增删改查](https://gitee.com/shenzhanwang/SSM)
2. [Struts2,Hibernate,Spring三大框架的整合实现增删改查](https://gitee.com/shenzhanwang/S2SH)
3. [Spring,SpringMVC和Hibernate的整合实现增删改查](https://gitee.com/shenzhanwang/SSH)
4. [Spring平台整合activiti工作流引擎实现OA开发](https://gitee.com/shenzhanwang/Spring-activiti)
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
14. Spring框架的session模块实现集中式session管理（未开源）
15. [Spring整合websocket实现即时通讯](https://gitee.com/shenzhanwang/Spring-websocket)
16. 使用Spring boot整合mybatis,rabbitmq,redis,mongodb实现增删改查（未开源）
17. [Spring MVC整合FastDFS客户端实现文件上传](https://gitee.com/shenzhanwang/Spring-fastdfs)
18. 23种设计模式，源码、注释、使用场景（未开源）
19. 使用ETL工具Kettle的实例（未开源）
20. Git指南和分支管理策略（未开源）
#### 高级篇：架构之美
21. [搭建zookeeper集群提供目录服务](https://gitee.com/shenzhanwang/zookeeperjiqundajian)
22. 使用ubuntu+apache+SVN+SVNadmin+maven+Nexus+Hudson搭建持续集成环境（未开源）
23. 使用jenkins+centos+git+maven搭建持续集成环境自动化部署分布式服务（未开源）
24. Spring框架整合dubbo框架实现分布式服务治理（SOA架构）（未开源）
25. Spring框架整合dubbox实现微服务架构（MSA架构）（未开源）
26. 使用Spring Cloud实现微服务架构（MSA架构）（未开源）
27. 使用FastDFS搭建分布式文件系统（高可用、负载均衡）（未开源）
28. 搭建高可用nginx集群和Tomcat负载均衡（未开源）
29. 搭建可扩展的ActiveMQ高可用集群（未开源）
30. 实现Mysql数据库的主从复制、读写分离、分表分库、负载均衡和高可用（未开源）
31. 搭建高可用redis集群实现分布式缓存（未开源）
32. [Spring整合SolrJ实现全文检索](https://gitee.com/shenzhanwang/Spring-solr)
#### 特别篇：分布式事务和并发控制
33. 基于可靠消息最终一致性实现分布式事务（activeMQ）（未开源）
34. 使用TCC框架实现分布式事务（dubbo版）（未开源）
35. 使用TCC框架实现分布式事务（Spring Cloud版）（未开源）
36. 决战高并发：数据库锁机制和事务隔离级别的使用（未开源）
37. 决战高并发：Java多线程编程实例（未开源）
38. 决战高并发：使用netty实现高性能NIO通信（未开源）

### 捐赠区
![输入图片说明](https://images.gitee.com/uploads/images/2018/0719/154323_12a5c89c_1110335.jpeg "mm_facetoface_collect_qrcode_1531986023521.jpg")

