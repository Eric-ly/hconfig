
Spring cloud config 搭建  及 老版Spring 集成 spring cloud config 项目

项目说明：

github:https://github.com/Eric-ly/hconfig

github的配置文件地址：https://github.com/Eric-ly/hconfig-properties

cloudeureka： spring boot的应用注册中心

ConfligClientNoSpringBoot： 非spring boot 应用 使用 应用配置中心

hconfigclient：spring boot的 应用配置中心的 客户端

hconfigserver：spring boot的 应用配置中心的服务端



使用说明：

1.启动 应用注册中心

（1）入口类：EurekaServerApplication    IDE debug 或者用命令

（2）配置：

    server.port=8761
    eureka.instance.hostname=localhost



2.启动 配置中心的服务端

（1）入口类：ConfigServerApplication

（2)配置：

端口：

    spring.application.name=config-server
    server.port=9001

gitlab ：来源

    spring.cloud.config.server.git.uri=https://github.com/Eric-ly/hconfig-properties.git
    spring.cloud.config.server.git.searchPaths=configRepo
    spring.cloud.config.server.git.username=
    spring.cloud.config.server.git.password=

    spring.cloud.config.server.git.basedir=src/main/resource/config
    # //加载到ConfigServer项目所在的本地目录的位置， 可以不用配置

消息总线，用来自动热更新，配置的是mq的地址，需要自己启

    #   添加cloud bus 消息总线，配合webhook 实现 所有client的消息热更新
    spring.rabbitmq.host=localhost
    spring.rabbitmq.port=5672
    spring.rabbitmq.username=guest
    spring.rabbitmq.password=guest
    ## 刷新时，关闭安全验证
    management.security.enabled=false
    ## 开启消息跟踪
    spring.cloud.bus.trace.enabled=true


注册中心：

    #注册中心地址
    eureka.client.serviceUrl.defaultZone=http://localhost:8761/eureka/



3.启动 非spring boot的 ConfligClientNoSpringBoot

（1）配置 应用名

cloud-config-context.properties

    spring.application.name=config-client

（2）IDE添加tomcat，然后启动

（3）测试

http://localhost:8888/hello

结果：   配置文件都读取到了

    search-pproperties : collection :{{engine}} demo: {{solr}} ||| wosb-properties: demo : {{ a}} name: {{ wosb }} path: {{ /}} single value : test?{{ abcdegggg }}



4.spring boot的 配置中新 客户端（ 自动热更新）hconfigclient

（1）入口类 entryApplication

（2）配置：

（1）  应用名+  配置中心的 服务端

    spring.application.name=config-client
    spring.cloud.config.label=master
    spring.cloud.config.profile=dev
    spring.cloud.config.uri= http://localhost:9001/
    server.port=8888

（2）

    #注册中心地址
    eureka.client.serviceUrl.defaultZone=http://localhost:8761/eureka/

（3）

    ## 刷新时，关闭安全验证
    management.security.enabled=false
    ## 开启消息跟踪
    spring.cloud.bus.trace.enabled=true

    spring.rabbitmq.host=localhost
    spring.rabbitmq.port=5672
    spring.rabbitmq.username=guest
    spring.rabbitmq.password=guest

（4） 测试

    (提交代码触发post请求给bus/refresh ----server端接收到请求并发送给Spring Cloud Bus
    ----Spring Cloud bus接到消息并通知给其它客户端 ----其它客户端接收到通知，请求Server端获取最新配置
    ----全部客户端均获取到最新的配置)




-------
congfig server

先启动server
http://localhost:9001/config-server-dev.properties
后启动client
http://localhost:8888/hi

client :curl -X POST http://localhost:8888/refresh 更新

cloud bus 消息总线
(1) client 发送，curl -X POST http://localhost:8888/bus/refresh
(2)改进
(提交代码触发post请求给bus/refresh ----server端接收到请求并发送给Spring Cloud Bus
----Spring Cloud bus接到消息并通知给其它客户端 ----其它客户端接收到通知，请求Server端获取最新配置
----全部客户端均获取到最新的配置)
