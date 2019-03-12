package cn.project.yoga.controller;

import cn.project.yoga.utils.Md5Encoder;
import cn.project.yoga.utils.ResultUtil;
import cn.project.yoga.vo.LoginVo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.security.provider.MD5;

@Controller
@RequestMapping("/teacher")
public class TeacherController {

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
                return ResultUtil.error("账号或者密码错误");
            } catch (IncorrectCredentialsException ice) {
                return ResultUtil.error("账号或者密码错误");
            } catch (LockedAccountException lae) {
                return ResultUtil.error("账号已被锁定");
            } catch (AuthenticationException ae) {
                return ResultUtil.error("人品问题，登录失败");
            }
        } else {
            return ResultUtil.error("干哈?!你都已经登陆成功了");
        }
    }







    @RequestMapping("/register")
    @ResponseBody
    public ResultUtil register(LoginVo vo) {

        System.out.println(vo.getUserName());
        System.out.println(vo.getPassword());
        //判断账户是否重复
        String md5password = Md5Encoder.md5Encode(vo.getUserName(), vo.getPassword());
        System.out.println(md5password);
        //判断密码是否符合



        return ResultUtil.ok("成功");

    }















}
//https://github.com/JimRainsong/repository.git

//暴风哭泣
