## Dubbo、Nacos、Spring Cloud Alibaba

实现了nacos的动态配置、Dubbo远程调用

可以先看Spring Boot Nacos：[https://github.com/MrNiebit/springboot-nacos](https://github.com/MrNiebit/springboot-nacos)


## 注意事项

`spring-cloud-context` 该依赖可以让我们使用bootstrap.yml 或者 bootstrap.properties
由于bootstrap的加载顺序是大于 application文件的，我们可以将一些值设置为变量，在application
配置文件中引用: `${xxx.xxx}`

nacos的配置 要在bootstrap.yml文件中...

```yml
spring:
  cloud:
    nacos:
      config:
        server-addr: ${nacos.ip-address}:${nacos.port}
        # 这里填的是 命名空间的 ID
        namespace: 2ad34e1d-88bf-4ca3-9df8-76a55c1793cc
        group: gitsilence-group
        timeout: 10000
        file-extension: properties
```

nacos data Id 为配置文件的 文件名


![](https://ftp.bmp.ovh/imgs/2021/06/75c899c1341100a3.png)