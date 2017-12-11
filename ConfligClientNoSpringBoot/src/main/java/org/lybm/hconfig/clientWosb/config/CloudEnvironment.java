package org.lybm.hconfig.clientWosb.config;

import org.springframework.cloud.config.client.ConfigClientProperties;
import org.springframework.cloud.config.client.ConfigServicePropertySourceLocator;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.ResourcePropertySource;
import org.springframework.web.context.support.StandardServletEnvironment;

import java.io.IOException;

public class CloudEnvironment extends StandardServletEnvironment {

    @Override
    protected void customizePropertySources(MutablePropertySources propertySources) {
        super.customizePropertySources(propertySources);
        try {
            PropertySource<?> resource = initConfigResourcePropertySourceLocator();
            propertySources.addLast(resource);

            PropertySource<?> source = initConfigServicePropertySourceLocator(this);
            propertySources.addLast(source);


        } catch (

                Exception ex) {
            logger.warn("failed to initialize cloud config environment", ex);
        }
    }
    private PropertySource<?> initConfigServicePropertySourceLocator(Environment environment) {

        ConfigClientProperties configClientProperties = new ConfigClientProperties(environment);
        configClientProperties.setUri("http://localhost:9001/");
        configClientProperties.setName("config-client");
        configClientProperties.setProfile("dev");
        configClientProperties.setLabel("master");
//        configClientProperties.setEnabled(true);

        logger.debug("will load the client configuration-------"+configClientProperties);

        ConfigServicePropertySourceLocator configServicePropertySourceLocator =
                new ConfigServicePropertySourceLocator(configClientProperties);

        return configServicePropertySourceLocator.locate(environment);
    }

    private PropertySource<?> initConfigResourcePropertySourceLocator() {


        logger.debug("will load the client configuration-- config resource-----");

        EncodedResource er = new EncodedResource(new ClassPathResource("cloud-Config-Context.xml"));
        ResourcePropertySource rps = null;
        try {
            rps = new ResourcePropertySource(er);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rps;
    }
}
