package org.lybm.hconfig.clientWosb.model;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "wosb")
@Data
public class WosbProperties {
    private String test;
    private String demo;
    private String name;
    private String paht;
}
