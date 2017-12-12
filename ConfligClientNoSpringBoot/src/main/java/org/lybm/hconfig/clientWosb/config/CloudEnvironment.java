package org.lybm.hconfig.clientWosb.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.config.client.ConfigClientProperties;
import org.springframework.cloud.config.client.ConfigServicePropertySourceLocator;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.ResourcePropertySource;
import org.springframework.web.context.support.StandardServletEnvironment;


public class CloudEnvironment extends StandardServletEnvironment {

    Logger logger = LoggerFactory.getLogger(CloudEnvironment.class);

    @Override
    protected void customizePropertySources(MutablePropertySources propertySources) {
        super.customizePropertySources(propertySources);
        try {
            //用来添加应用名到environment中
            propertySources.addLast( initResourcePropertySourceLocator() );
            //添加config Server的配置
            PropertySource<?> source = initConfigServicePropertySourceLocator(this);
            propertySources.addLast(source);
        } catch (Exception ex) {
            logger.warn("failed to initialize cloud config environment", ex);
        }
    }
    private PropertySource<?> initConfigServicePropertySourceLocator(Environment environment) {

        ConfigClientProperties configClientProperties = new ConfigClientProperties(environment);
        configClientProperties.setUri("http://localhost:9001/");
//        configClientProperties.setName("config-client");
        configClientProperties.setProfile("dev");
        configClientProperties.setLabel("master");

        logger.debug("will load the client configuration-------"+configClientProperties);
        ConfigServicePropertySourceLocator configServicePropertySourceLocator =
                new ConfigServicePropertySourceLocator(configClientProperties);

        return configServicePropertySourceLocator.locate(environment);
    }

    private PropertySource<?> initResourcePropertySourceLocator() {

        ResourcePropertySource resourcePropertySource = null;
        try{
            Resource resource = new DefaultResourceLoader(this.getClass().getClassLoader()).getResource("classpath:cloud-config-context.properties");
            resourcePropertySource = new ResourcePropertySource(resource);
        }catch (Exception e){
            logger.error(" 找不到 classpath:cloud-config-context.properties ");
        }
        return resourcePropertySource;
    }

}
