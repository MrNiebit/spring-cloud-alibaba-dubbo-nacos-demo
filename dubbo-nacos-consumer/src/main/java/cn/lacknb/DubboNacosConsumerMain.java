
package cn.lacknb;

import cn.lacknb.common.HelloService;
import org.apache.dubbo.config.annotation.Reference;
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

    @Reference(version = "${dubbo.service.version}")
    private HelloService helloService;

    @GetMapping("/rpc")
    public String rpcInvoke () {
        return helloService.hello("rpc调用 。。");
    }

//    @Bean
//    public ApplicationRunner runner () {
//        return new ApplicationRunner() {
//            @Override
//            public void run(ApplicationArguments args) throws Exception {
//                System.out.println(helloService.hello("consumer"));
//            }
//        };
//    }


}
