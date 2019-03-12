package cn.project.yoga.controller.viewcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/teacher")
public class TeacherViewController {
    /**
     * 以下自己写的
     */
    @RequestMapping("/index")
    public String index() {
        return "teacher/index";
    }

    @RequestMapping("/page5")
    public String page5() {
        return "teacher/page5";
    }

    @RequestMapping("/loginAndRegister")
    public String loginAndRegister() {
        return "teacher/loginAndRegister";
    }
    /**
     * 以上是自己写的
     */
    //注册
    @RequestMapping("/reg")
    public String register() {
        return "teacher/register";
    }
}
