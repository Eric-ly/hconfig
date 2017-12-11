package entry.model;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


/**
 * @author ly
 * configuration
 * configgurationProperties 是用来定位对应的内容的，s会绑定properties中的值，并且支持层级关系
 */
@Configuration
@ConfigurationProperties( )
@Data
public class DemoProperties {
    private String test;
    private String demo;
    private String demo2;

}
