package entry.controller;

import entry.model.DemoProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Properties;

@RestController
@EnableAutoConfiguration
@RefreshScope
public class configController {
    //取配置文件中的值
    @Value("${test}")

    private String profile;

    @Value("${classpath:config-client-dev.properties}")
    private Properties pro;

    @RequestMapping("/profile")
    public String getProfile(){
        return profile;
    }

    @RequestMapping("/pro")
    public Properties getPro(){
        return pro;
    }

    @Autowired
    private DemoProperties properties;

    @Autowired
    Environment env;

    @RequestMapping("/wosb")
    @ResponseBody
    public void helloConfig(){
        String a = properties.getTest();
        System.out.println(a);
    }

}
