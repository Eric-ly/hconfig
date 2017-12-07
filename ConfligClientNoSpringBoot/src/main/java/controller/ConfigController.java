package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ConfigController {

    @RequestMapping("/hello")
    @ResponseBody
    public String cloudDemo(){
        return "hello ";
    }
}
