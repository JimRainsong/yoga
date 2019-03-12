package cn.project.yoga.controller.viewcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/venue")
public class VenueViewController {
    @RequestMapping("/demo")
    public String demo() {
        return "venue/Demo";
    }
    @RequestMapping("/register")
    public String other() {
        return "user/cyz/regist";
    }

}
