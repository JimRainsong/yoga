package cn.project.yoga.controller.viewcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/venueUser")
public class VenueUserViewControllt {
    @RequestMapping("/login")
    public String login() {
        return "venue/login";
    }
    @RequestMapping("/register")
    public String register() {
        return "venue/register";
    }
}