1、框架组成springboot2.0.1+mybatis3.5.3+dubbo2.6.3+zookeeper3.4.10+seata0.8.1
2、先启动seata0.8.1 ,在bin目录下seata-server.bat -p 8091 -m file
3、再启动dubbo-provider
4、再启动dubbo-consumer，访问http://localhost:8099/test?amount=1