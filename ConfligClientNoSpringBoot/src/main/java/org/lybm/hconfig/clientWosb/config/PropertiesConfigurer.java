package org.lybm.hconfig.clientWosb.config;

import org.lybm.hconfig.clientWosb.model.DemoPropertiesWosb;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

//@Configuration
//@EnableConfigurationProperties({DemoPropertiesWosb.class})
public class PropertiesConfigurer {
//    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
