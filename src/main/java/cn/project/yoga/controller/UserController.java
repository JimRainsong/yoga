package cn.project.yoga.controller;

import cn.project.yoga.pojo.Ad;
import cn.project.yoga.pojo.User;
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

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;


    @RequestMapping("/login")
    @ResponseBody
    public String login1(LoginVo vo) {
        Subject subject = SecurityUtils.getSubject();
        if (!subject.isAuthenticated()) {
            System.out.println(vo.getUserName());
            UsernamePasswordToken token = new UsernamePasswordToken(vo.getUserName(), vo.getPassword());
            System.out.println(token.getPrincipal().toString());
            token.setRememberMe(true);
            try {
                subject.login(token);
                return "登陆成功";
            } catch (UnknownAccountException uae) {
                return "未知的用户类型";
            } catch (IncorrectCredentialsException ice) {
                return "账号或者密码错误";
            } catch (LockedAccountException lae) {
                return "账号已被锁定";
            } catch (AuthenticationException ae) {
                return "账号或者密码错误";
            } catch (Exception e) {
                return "人品问题，登录失败";
            }
        } else {
            return "干哈?!你都已经登陆成功了";
        }
    }


    @RequestMapping("/register")
    @ResponseBody
    public String register1(@RequestParam(value = "username") String username, @RequestParam(value = "password1") String password1, @RequestParam(value = "password2") String password2) {

        if (!password1.matches(RegexUtil.REGEX_PASSWORD)) {
            return "密码格式有误请重新输入";
        }

        if (!password1.equals(password2)) {
            return "两次密码不一致";
        }
        //通过 username在数据库中找 user 判断是否重名

        User user = userService.selectUserByUserName(username);//搜索一个 TeacherService.selectUserbyUserName
        if (user != null) {
            return "；用户名已经存在了哦亲亲 请换一个";
        }
        // 进行MD5加密存入数据库 加密次数2次 盐值用户名
        String newpassword = Md5Encoder.md5Encode(username, password1);
        //将user1 插入至数据库(两张表)
        User user1 = new User();
        user1.setUserName(username);
        user1.setPassword(newpassword);
        int i1 = userService.addUser(user1);
        int i2 = userService.insert_userid_user(username);
        System.out.println(i1 + i2);
        return "注册成功";
    }

    /**
     * 修改用户信息
     * @author zjn
     * @param user
     * @return 字符串，更新成功/失败
     */
    @RequestMapping("/update")
    @ResponseBody
    public String updateInfo(User user){
       String state = userService.updateUserInfo1(user);
       return state;
    }

    @RequestMapping("/lookAd")
    @ResponseBody
    public List<Ad> lookAd(){
        List<Ad> ad=userService.selectAd();
        return ad;
    }

}
