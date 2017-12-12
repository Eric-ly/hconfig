package org.lybm.hconfig.clientWosb.controller;

import org.lybm.hconfig.clientWosb.model.SearchProperties;
import org.lybm.hconfig.clientWosb.model.WosbProperties;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class BaseController {

    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(BaseController.class);

    //一个properties的注入
    @Autowired
    private WosbProperties wosbProperties;

    @Autowired
    private SearchProperties searchProperties;

    //单独一个字段的获取
    @Value("${xxx:x}")
    private String test;

    @Autowired
    Environment env;

    @RequestMapping("/hello")
    @ResponseBody
    public String helloConfig(){
        logger.debug( "test :"+wosbProperties.getTest() +"--demo :"+wosbProperties.getDemo() );

        String search = "search-pproperties "+":    collection :{{"+ searchProperties.getCollection() +"}}    demo:   {{"+searchProperties.getDemo()+"}}";
        String wosb ="\n  |||    wosb-properties:    "+"demo    : {{  "+wosbProperties.getDemo() +"}}  name:  {{ "+wosbProperties.getName()+" }}   path: {{   "+wosbProperties.getPaht() +"}}";
        String singleValue = " single value : test："+ "{{ "+test+"  }} ";
        return search + wosb +singleValue;
    }

    @RequestMapping("/wosbValue")
    public void valueTest(){
        logger.debug(test);
    }
}
