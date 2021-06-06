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

nacos data Id 命名格式为：${spring.application.name}-${spring.profiles.active}.${spring.cloud.nacos.file-extension}

${spring.application.name} 为配置文件中配置的实例名

${spring.profiles.active} 为启动的环境类型

${spring.cloud.nacos.file-extension} 文件后缀名

例如: nacos的data Id 为`dubbo-nacos-provider-dev.properties`

此时我们的 `application.properties` 文件中可以配置
```properties
spring.application.name=dubbo-nacos-provider
spring.profiles.active=dev
```

这样配置 就会使nacos中 dubbo-nacos-provider-dev.properties 配置文件生效

![](https://ftp.bmp.ovh/imgs/2021/06/75c899c1341100a3.png)