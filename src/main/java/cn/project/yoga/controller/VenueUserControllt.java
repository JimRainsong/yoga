package cn.project.yoga.controller;

import cn.project.yoga.pojo.User;
import cn.project.yoga.pojo.Venue;
import cn.project.yoga.service.UserService;
import cn.project.yoga.service.VenueService;
import cn.project.yoga.utils.LayUiDataUtil;
import cn.project.yoga.utils.Md5Encoder;
import cn.project.yoga.utils.RegexUtil;
import cn.project.yoga.vo.LoginVo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/venueUserDate")
public class VenueUserControllt {

    @Autowired
    private UserService userService;

    @Autowired
    private VenueService venueService;

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
    @ResponseBody
    public LayUiDataUtil register(User user,String password1) {
        System.out.println(password1);
        if (!RegexUtil.isUsername(user.getUserName())){
            return LayUiDataUtil.error("用户名格式有误");
        }
        if (userService.selectUserByUserName(user.getUserName()) != null) {
            return LayUiDataUtil.error("该账户已存在");
        }
        if (!user.getPassword().equals(password1)){
            return LayUiDataUtil.error("两次输入密码不一致");
        }
        if (!RegexUtil.isPassword(password1)){
            return LayUiDataUtil.error("密码格式有误");
        }
            try {

                int num = userService.addUser(user);
                if (num > 0) {
                    user.setPassword(Md5Encoder.md5Encode(user.getUserName(),user.getPassword()));
                    user = userService.selectUserByUserName(user.getUserName());
                    if (user != null) {
                        Venue venue = new Venue();
                        venue.setUserId(user.getUserId());
                        venue.setAuthState(1);
                        int vnum = venueService.addVenue(venue);
                        if (vnum > 0) {
                            return LayUiDataUtil.ok("注册成功");
                        }
                    }
                    return LayUiDataUtil.error("注册失败");
                }
            } catch (Exception e) {
                return LayUiDataUtil.error("注册异常");
            }
            return LayUiDataUtil.error("注册异常");
        }

}
