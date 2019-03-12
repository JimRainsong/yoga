package cn.project.yoga.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/venueUser")
public class VenueUserControllt {

    @RequestMapping("/loginVenue")
    public String login() {
        return "user/cyz/login";
    }

    @RequestMapping("/registerVenue")
    public String register() {
        return "user/cyz/login";
    }

}
