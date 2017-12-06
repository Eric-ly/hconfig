package entry;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableDiscoveryClient  //激活eureka中的DiscoveryClient实现
public class entryApplication {
    public static void main(String[] args) {
        SpringApplication.run(entryApplication.class, args);
    }

    @Value("${test}")
    String foo;
    @RequestMapping(value = "/hi")
    public String hi(){
        return foo;
    }
    @RequestMapping(value = "/")
    public String hello(){
        return "hello world";
    }
}