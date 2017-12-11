package org.lybm.hconfig.clientWosb.controller;

import org.lybm.hconfig.clientWosb.model.DemoPropertiesWosb;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BaseController {

    private static int counter = 0;
    private static final String VIEW_INDEX = "index";
    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(BaseController.class);

    @Autowired
    private DemoPropertiesWosb properties;
    @Value("${test}")
    private String test;

    @Autowired
    Environment env;

    @RequestMapping("/wosb")
    @ResponseBody
    public void helloConfig(){
        logger.debug( "test :"+properties.getTest() +"--demo :"+properties.getDemo() );
        String a = "";
    }

    @RequestMapping("/wosbValue")
    public void valueTest(){
        logger.debug(test);
    }
}
