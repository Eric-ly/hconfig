
先启动server
http://localhost:9001/config-server-dev.properties
后启动client
http://localhost:8888/hi

client :curl -X POST http://localhost:8888/refresh 更新