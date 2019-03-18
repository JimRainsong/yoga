package cn.project.yoga.controller.viewcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

    @RequestMapping("/ad")
    public String ceshi4_2(){return "manager/adheadhtml";}

    @RequestMapping("/tvenue")
    public String Tvenue(){
        return "manager/hsn/Mvenue";
    }

    @RequestMapping("/venuedetail")
    public String VenueDetail4(HttpServletRequest request, HttpSession session){
        session.setAttribute("venueId",Integer.parseInt(request.getParameter("venueId")));
        return "manager/hsn/vendetail";
    }

    @RequestMapping("/sell")
    public  String sell(){return "manager/sellgoods";}

    @RequestMapping("/getad")
    public  String getad(){return "manager/sellgoods";}

    @RequestMapping("/goodsadmin")
    public  String goodsadmin(){return "manager/goodsoperation";}
}