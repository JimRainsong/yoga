package cn.project.yoga.controller.viewcontroller;

import cn.project.yoga.pojo.TeacherInfo;
import cn.project.yoga.pojo.Venue;
import cn.project.yoga.service.TeacherService;
import cn.project.yoga.utils.Attributes;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/teacher")
public class TeacherViewController {
    @Autowired
    private TeacherService teacherService;

    /**
     * 以下自己写的
     */
    @RequestMapping("/index")
    public String index() {
        return "teacher/index";
    }

    @RequestMapping("/page2")
    public ModelAndView page2() {
        ModelAndView modelAndView = new ModelAndView();
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {
            Session session = subject.getSession();
            TeacherInfo info = (TeacherInfo) session.getAttribute(Attributes.CURRENT_USER);
            modelAndView.addObject("info", info);
            modelAndView.setViewName("teacher/page2");
        } else {
            modelAndView.setViewName("teacher/login");
        }
        return modelAndView;
    }

    @RequestMapping("/loginPage")
    public String loginAndRegister() {
        return "teacher/login";
    }

    @RequestMapping("/postPage")
    public String postPage() {
        return "teacher/post";
    }

    @RequestMapping("/teacherInfo")
    public ModelAndView teacherInfo() {
        ModelAndView modelAndView = new ModelAndView();
        TeacherInfo info = (TeacherInfo) SecurityUtils.getSubject().getSession().getAttribute(Attributes.CURRENT_USER);
        if (info == null) {
            modelAndView.setViewName("teacher/register");
        } else {
            modelAndView.setViewName("teacher/teacherInfo");
            modelAndView.addObject("info", info);
        }
        return modelAndView;
    }

    @RequestMapping("/venue")
    public ModelAndView venuePage2() {
        ModelAndView modelAndView = new ModelAndView();
        Session session = SecurityUtils.getSubject().getSession();
        TeacherInfo currentUser = (TeacherInfo) (session.getAttribute(Attributes.CURRENT_USER));
        if (currentUser == null) {
            modelAndView.setViewName("teacher/register");
        } else {
            Venue venue = teacherService.selectMyVenueByCurrentUserId2(currentUser.gettId());
            modelAndView.setViewName("teacher/venue");
            modelAndView.addObject("venue", venue);
        }
        return modelAndView;
    }

    /**
     * 以上是自己写的
     */
    @RequestMapping("/registerPage")
    public String register() {
        return "teacher/register";
    }

    //
    @RequestMapping("/message")
    public String info() {
        Subject subject = SecurityUtils.getSubject();
        ModelAndView modelAndView = new ModelAndView();
        if (!subject.isAuthenticated()) {
            modelAndView.setViewName("teacher/unlogined");
            return "teacher/unlogined";
        }
        return "teacher/message";
    }
//    @RequestMapping("/info")
//    public String info() {
//        return "teacher/g1";
//    }

    /*
    * 教练管理页面*/
    @RequestMapping("/mteacher")
    public String Mteacher4() {
        return "manager/hsn/teacher";
    }

    @RequestMapping("/teadetail")
    public String TeaDetail4(HttpServletRequest request, HttpSession session) {
        int teacherId = Integer.parseInt(request.getParameter("teacherId"));
        session.setAttribute("teacherId", teacherId);
        return "manager/hsn/mdetail";
    }

    @RequestMapping("/steacher")
    public String Steacher4(HttpServletRequest request, HttpSession session) {
        session.setAttribute("teacherName", request.getParameter("teacherName"));
        session.setAttribute("teacherSex", request.getParameter("teacherSex"));
        session.setAttribute("teacherPhone", request.getParameter("teacherPhone"));
        session.setAttribute("teacherQq", request.getParameter("teacherQq"));
        return "manager/hsn/steacher";
    }

}
