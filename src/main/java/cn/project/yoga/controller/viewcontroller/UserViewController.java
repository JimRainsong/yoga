package cn.project.yoga.controller.viewcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserViewController {
    @RequestMapping("/index")
    public String index() {
        return "user/index";
    }

    @RequestMapping("/loginandregist")
    public String login() {
        return "user/login";
    }

    @RequestMapping("/user")
    public String user() {
        return "user/user";
    }

    @RequestMapping("/info")
    public String userInfo1() {
        return "myinfo_old";
    }

    @RequestMapping("/mymoney")
    public String myMoney() {
        return "user/myMoney";
    }

    @RequestMapping("/tuser")
    public String Tuser4(){
        return "manager/hsn/users";
    }
    /*
    * 跳转到查询页*/
    @RequestMapping("/susers")
    public String Susers4(HttpServletRequest request,HttpSession session){
        session.setAttribute("netName",request.getParameter("netName"));
        session.setAttribute("sex",request.getParameter("sex"));
        session.setAttribute("phoneNumber",request.getParameter("phoneNumber"));
        session.setAttribute("qq",request.getParameter("qq"));
        return "manager/hsn/susers";
    }

    /*
     * 跳转到学员详情页*/
    @RequestMapping("/userdetail")
    public String userdetail4(HttpServletRequest request, HttpSession session) {
        int uId = Integer.parseInt(request.getParameter("uId"));
        session.setAttribute("uId", uId);
        return "manager/hsn/userdetail";
    }

    /*
    * 跳转到订单页面*/
    @RequestMapping("/userorder")
    public String userOrder4(){
        return "manager/hsn/userorder";
    }

    /*
    * 跳转到订单查询页*/
    @RequestMapping("/sorder")
    public String Sorder4(HttpServletRequest request,HttpSession session){
        session.setAttribute("transcationType",request.getParameter("transcationType"));
        session.setAttribute("time",request.getParameter("time"));
        session.setAttribute("venueName",request.getParameter("venueName"));
        return "manager/hsn/sorder";
    }

}
