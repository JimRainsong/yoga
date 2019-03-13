package cn.project.yoga.controller;

import cn.project.yoga.utils.ResultUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginAndOutController {

    @RequestMapping("/logout")
    @ResponseBody
    public ResultUtil logout() {
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.logout();
            return ResultUtil.ok("成功登出");
        } catch (Exception e) {
            return ResultUtil.error("人品太差了吧，注销都能失败");
        }
    }
}
