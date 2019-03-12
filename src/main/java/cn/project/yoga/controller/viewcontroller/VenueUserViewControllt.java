package cn.project.yoga.controller.viewcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/venueUser")
public class VenueUserViewControllt {
    @RequestMapping("/login")
    public String login() {
        return "user/cyz/login";
    }
    @RequestMapping("/register")
    public String register() {
        return "user/cyz/register";
    }
}
