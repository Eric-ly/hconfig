package org.lybm.hconfig.clientWosb.model;


import org.springframework.boot.context.properties.ConfigurationProperties;
import lombok.Data;

@ConfigurationProperties(   locations = "classpath:config-client-dev.properties" )
@Data
public class DemoProperties {
    private String test;
    private String demo;
    private String demo2;

}
