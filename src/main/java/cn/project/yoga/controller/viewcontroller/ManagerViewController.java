package cn.project.yoga.controller.viewcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/manager")
public class ManagerViewController {

    @RequestMapping("/boos")
    public String ok(){
        return "manager/mvenues";
    }

    @RequestMapping("/manage")
    public String l(){
        return "manager/managerhtml";
    }

    @RequestMapping("/ve")
    public String ceshi4_1(){return "manager/venueapproveandteacher";}
}
