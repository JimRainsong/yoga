package cn.project.yoga.controller.viewcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class CYZTest {
    @RequestMapping("/Demo")
public String demo() {
    return "user/cyz/login";
}
}
