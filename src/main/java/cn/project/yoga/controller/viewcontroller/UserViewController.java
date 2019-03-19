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
    public String user(){
        return "user/user";
    }

    @RequestMapping("/info")
    public String userInfo1(){
        return "user/myinfo";
    }
    @RequestMapping("/mymoney")
    public String myMoney(){
        return "user/myMoney";
    }

    @RequestMapping("/tuser")
    public String Tuser4(){
        return "manager/hsn/muser";
    }

    /*
     * 跳转到学员详情页*/
    @RequestMapping("/userdetail")
    public String userdetail4(HttpServletRequest request, HttpSession session){
        int uId=Integer.parseInt(request.getParameter("uId"));
        session.setAttribute("uId",uId);
        return "manager/hsn/userdetail";
    }

    @RequestMapping("/selectAllVenue")
    public String allVenue1(){
        return "user/allVenue";
    }

    @RequestMapping("/selectAllCoach")
    public String allCoach(){
        return "user/allCoach";
    }

}
