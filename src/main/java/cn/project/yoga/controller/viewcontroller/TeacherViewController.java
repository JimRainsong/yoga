package cn.project.yoga.controller.viewcontroller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @RequestMapping("/page2")
    public String page5() {
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {
            return "teacher/page2";
        } else {
            return "teacher/register";
        }
    }

    @RequestMapping("/loginPage")
    public String loginAndRegister() {
        return "teacher/login";
    }

    @RequestMapping("/postPage")
    public String postPage() {
        return "teacher/post";
    }

    /**
     * 以上是自己写的
     */
    @RequestMapping("/registerPage")
    public String register() {
        return "teacher/register";
    }

    @RequestMapping("/info")
    public String info() {
        return "teacher/g1";
    }


}
