package cn.project.yoga.controller.viewcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/venue")
public class VenueViewController {
    @RequestMapping("/teacher")
    public String teacher() {
        return "venue/teacher";
    }

    @RequestMapping("/myteacher")
    public String myteacher() {
        return "venue/myteacher";
    }

    @RequestMapping("/VenueInFo")
    public String venueInFo() {
        return "venue/VenueInFo";
    }


}
