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
    @RequestMapping("/venueIndex")
    public String venueIndex() {
        return "venue/venueIndex";
    }
    @RequestMapping("/student")
    public String student() {
        return "venue/student";
    }
    @RequestMapping("/atention")
    public String atention() {
        return "venue/atention";
    }
    @RequestMapping("/vipType")
    public String vipType() {
        return "venue/vipType";
    }
}
