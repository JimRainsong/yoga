package cn.project.yoga.controller;

import cn.project.yoga.service.UserService;
import cn.project.yoga.pojo.User;
import cn.project.yoga.service.TeacherService;
import cn.project.yoga.service.UserService;
import cn.project.yoga.utils.Md5Encoder;
import cn.project.yoga.utils.RegexUtil;
import cn.project.yoga.utils.ResultUtil;
import cn.project.yoga.vo.LoginVo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import sun.security.provider.MD5;

import javax.annotation.Resource;

@Controller
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private UserService userService;
    @Autowired
    private TeacherService teacherService;

    @RequestMapping("/login")
    @ResponseBody
    public ResultUtil login(LoginVo vo) {
        Subject subject = SecurityUtils.getSubject();
        if (!subject.isAuthenticated()) {
            UsernamePasswordToken token = new UsernamePasswordToken(vo.getUserName(), vo.getPassword());
            token.setRememberMe(true);
            try {
                subject.login(token);
                return ResultUtil.ok("登陆成功");
            } catch (UnknownAccountException uae) {
                return ResultUtil.error("未知的用户类型");
            } catch (IncorrectCredentialsException ice) {
                return ResultUtil.error("账号或者密码错误");
            } catch (LockedAccountException lae) {
                return ResultUtil.error("账号已被锁定");
            } catch (AuthenticationException ae) {
                return ResultUtil.error("账号或者密码错误");
            } catch (Exception e) {
                return ResultUtil.error("人品问题，登录失败");
            }
        } else {
            return ResultUtil.error("干哈?!你都已经登陆成功了");
        }
    }

    @RequestMapping("/page1")
    public ModelAndView page1() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/teacher/page1");
        //modelAndView.addObject("moments", userService.allMoments2());
        return modelAndView;
    }

//https://github.com/JimRainsong/repository.git


    @RequestMapping("/register")
    @ResponseBody
    public ResultUtil register(@RequestParam(value = "username") String username, @RequestParam(value = "password1") String password1, @RequestParam(value = "password2") String password2) {

        if (!password1.matches(RegexUtil.REGEX_PASSWORD)) {
            return ResultUtil.error("密码格式有误请重新输入");
        }

        if (!password1.equals(password2)) {
            return ResultUtil.error("；两次密码不一致");
        }
        //通过 username在数据库中找 user 判断是否重名

        User user = userService.selectUserByUserName(username);//搜索一个 TeacherService.selectUserbyUserName
        if (user != null) {
            return ResultUtil.error("；用户名已经存在了哦亲亲 请换一个");
        }
        // 进行MD5加密存入数据库 加密次数2次 盐值用户名
        String newpassword = Md5Encoder.md5Encode(username, password1);
        //将user1 插入至数据库(两张表)
        User user1 = new User();
        user1.setUserName(username);
        user1.setPassword(newpassword);
        int i1 = teacherService.insertUser(user1);
        int i2 = teacherService.insert_userid_teacher2(username);
        System.out.println(i1 + i2);
        return ResultUtil.ok("注册成功");

    }
}
//暴风哭泣
