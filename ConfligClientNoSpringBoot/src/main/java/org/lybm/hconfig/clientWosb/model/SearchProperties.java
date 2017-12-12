package org.lybm.hconfig.clientWosb.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@ConfigurationProperties(prefix = "search")
@Configuration
public class SearchProperties {
    private String collection;
    private String demo;
    private String name;
    private String paht;
}
