
package cn.lacknb;

import cn.lacknb.common.HelloService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <h2></h2>
 * @author niebaohua
 * date 2021/6/3
 */
@SpringBootApplication
@RestController
public class DubboNacosConsumerMain {

    public static void main(String[] args) {
        SpringApplication.run(DubboNacosConsumerMain.class, args);
    }

    @DubboReference(version = "${dubbo.registry.version}")
    private HelloService helloService;

    @GetMapping("/rpc")
    public String rpcInvoke () {
        return helloService.hello("rpc调用 。。");
    }
}
