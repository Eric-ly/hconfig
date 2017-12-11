package org.lybm.hconfig.clientWosb.model;


import org.springframework.boot.context.properties.ConfigurationProperties;
import lombok.Data;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties()
@Data
public class DemoPropertiesWosb {
    private String test;
    private String demo;
    private String demo2;

}
