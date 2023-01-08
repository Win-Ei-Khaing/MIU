package xing.rujuan.springsecurityjpa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/user")
    public String user(){
        return "user";
    }

//    @GetMapping("/admin")
//    public String admin(){
//        return "admin";
//    }

    @GetMapping("/admin")
    public @ResponseBody
    String admin(){
        return "admin";
    }
}
