package cn.project.yoga.controller;

import cn.project.yoga.utils.LayUiDataUtil;
import cn.project.yoga.vo.LoginVo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/venueUserDate")
public class VenueUserControllt {

    @RequestMapping("/loginVenue")
    @ResponseBody
    public LayUiDataUtil login(LoginVo vo) {
        System.out.println(vo.getPassword());
        System.out.println(vo.getUserName());
        Subject subject = SecurityUtils.getSubject();
        if (!subject.isAuthenticated()) {
            UsernamePasswordToken token = new UsernamePasswordToken(vo.getUserName(), vo.getPassword());
            token.setRememberMe(true);
            try {
                subject.login(token);
                return LayUiDataUtil.ok("登陆成功");
            } catch (UnknownAccountException uae) {
                return LayUiDataUtil.error("未知的用户类型");
            } catch (IncorrectCredentialsException ice) {
                return LayUiDataUtil.error("账号或者密码错误");
            } catch (LockedAccountException lae) {
                return LayUiDataUtil.error("账号已被锁定");
            } catch (AuthenticationException ae) {
                return LayUiDataUtil.error("账号或者密码错误");
            } catch (Exception e) {
                return LayUiDataUtil.error("人品问题，登录失败");
            }
        } else {
            return LayUiDataUtil.error("干哈?!你都已经登陆成功了");
        }
    }

    @RequestMapping("/registerVenue")
    public String register() {
        return "user/cyz/login";
    }

}
