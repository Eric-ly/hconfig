package org.lybm.hconfig.clientWosb.config;

import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.web.context.support.XmlWebApplicationContext;

public class CustomWebApplicationContext extends XmlWebApplicationContext {
        @Override
        protected ConfigurableEnvironment createEnvironment() {
            System.out.println("-------- loaded my CustomWebApplicationContext context");
            return new CloudEnvironment();
        }
}
