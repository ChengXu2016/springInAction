package tacos.controller;

import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author chengxu
 * @version 1.0.0
 * @Description
 * @ClassName HomeController.java
 * @createTime 2023/07/17 22:19
 */
//@Controller
public class HomeController {


    @GetMapping("/")
    public String home() {
        return "home";
    }
}
