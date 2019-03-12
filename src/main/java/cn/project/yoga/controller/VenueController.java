package cn.project.yoga.controller;

import cn.project.yoga.pojo.User;
import cn.project.yoga.pojo.Venue;
import cn.project.yoga.service.VenueService;
import cn.project.yoga.utils.LayUiDataUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/venue")
public class VenueController {
     @Autowired
     private VenueService venueService;

    @RequestMapping("/updata")
    @ResponseBody
    public LayUiDataUtil updata(Venue venue){
           System.out.println(venue.getVenueName());
           System.out.println(venue.getVenueAddress());
           LayUiDataUtil layUiDataUtil=new LayUiDataUtil();
           layUiDataUtil.setData(venue);
        return layUiDataUtil;
    }
}
