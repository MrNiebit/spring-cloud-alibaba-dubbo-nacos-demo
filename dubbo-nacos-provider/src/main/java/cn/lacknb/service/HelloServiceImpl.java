
package cn.lacknb.service;

import cn.lacknb.common.HelloService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;

/**
 * <h2>@RefreshScop 动态获取配置中心的值</h2>
 * @author niebaohua
 * date 2021/6/3
 */
@Service(version = "${dubbo.service.version}")
@RefreshScope
public class HelloServiceImpl implements HelloService {

    @Value("${spring.application.name}")
    private String serviceName;

    @Value("${nacos.param.content:参数为空，无法注入}")
    private String nacosConfig;

    @Override
    public String hello(String name) {
        System.out.println(nacosConfig);
        return String.format("[%s] : Hello, %s", serviceName, name);
    }
}
