
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
