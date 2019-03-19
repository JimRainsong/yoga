package cn.project.yoga.controller;

import cn.project.yoga.pojo.TeacherInfo;
import cn.project.yoga.pojo.User;
import cn.project.yoga.pojo.Venue;
import cn.project.yoga.service.UserService;
import cn.project.yoga.service.VenueService;
import cn.project.yoga.utils.Attributes;
import cn.project.yoga.utils.LayUiDataUtil;
import cn.project.yoga.utils.Md5Encoder;
import cn.project.yoga.utils.RegexUtil;
import cn.project.yoga.vo.LoginVo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/venueUserDate")
public class VenueUserControllt {

    @Autowired
    private UserService userService;

    @Autowired
    private VenueService venueService;
    /*
     *场馆登录
     */
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
                Session session = SecurityUtils.getSubject().getSession();
                User user = userService.selectUserByUserName(vo.getUserName());
                System.out.println(user.getUserId()+"注册用户是查询用户Id");
                Venue venue=venueService.selvenueByUserId(user);
                System.out.println(venue.getVenueId()+"场馆用户是查询用户Id");
                session.setAttribute(Attributes.CURRENT_USER, venue);
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
    /*
     *场馆注册
     */
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
                user.setPassword(Md5Encoder.md5Encode(user.getUserName(),user.getPassword()));
                User users = userService.selectUserByUserName(user.getUserName());
                if (users == null) {
                    int num = userService.addUser(user);
                    if (num > 0) {
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
    /*
     *场馆详情
     */
    @RequestMapping("/venueData/{venueId}")
    @ResponseBody
    public LayUiDataUtil getVenueData(@PathVariable("venueId") Integer venueId) {
        Venue venue=null;
          try{
           venue=venueService.getVenueDataByVenueId(venueId);
          }catch (Exception e){
            return LayUiDataUtil.error();
          }
          LayUiDataUtil layUiDataUtil=new LayUiDataUtil();
          if (venue!=null){
           layUiDataUtil.setData(venue);
          }else {
            return LayUiDataUtil.error();
          }
          return layUiDataUtil;
    }
}