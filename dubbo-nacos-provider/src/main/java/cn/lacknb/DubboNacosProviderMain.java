
package cn.lacknb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * <h2>服务提供者</h2>
 * @author niebaohua
 * date 2021/6/3
 */
@SpringBootApplication
@EnableDiscoveryClient
public class DubboNacosProviderMain {

    public static void main(String[] args) {
        SpringApplication.run(DubboNacosProviderMain.class, args);
    }

}
