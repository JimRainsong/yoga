package cn.project.yoga.controller.viewcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserViewController {
    @RequestMapping("/index")
    public String login() {
        return "user/index";
    }
}
