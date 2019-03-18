package cn.project.yoga.controller;

import cn.project.yoga.pojo.*;
import cn.project.yoga.service.UserService;
import cn.project.yoga.service.TeacherService;
import cn.project.yoga.service.VenueService;
import cn.project.yoga.utils.Attributes;
import cn.project.yoga.utils.Md5Encoder;
import cn.project.yoga.utils.RegexUtil;
import cn.project.yoga.utils.ResultUtil;
import cn.project.yoga.vo.LoginVo;
import cn.project.yoga.vo.TeacherVo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Controller
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private UserService userService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private VenueService venueService;

    @RequestMapping("/login")
    @ResponseBody
    public ResultUtil login(LoginVo vo) {
        Subject subject = SecurityUtils.getSubject();
        if (!subject.isAuthenticated()) {
            UsernamePasswordToken token = new UsernamePasswordToken(vo.getUserName(), vo.getPassword());
            token.setRememberMe(true);
            try {
                subject.login(token);
                Session session = SecurityUtils.getSubject().getSession();
                session.setAttribute(Attributes.CURRENT_USER, vo.getUserName());
                TeacherInfo teacherInfo = teacherService.selectSingleTeacherByUserName2(vo.getUserName());
                session.setAttribute(Attributes.CURRENT_USER, teacherInfo);
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

    @RequestMapping("/follow")
    public ModelAndView follow() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("teacher/follow");
        Session session = SecurityUtils.getSubject().getSession();
        Integer currentUserId = ((TeacherInfo) (session.getAttribute(Attributes.CURRENT_USER))).getuId();
        List<Detail> details = new ArrayList<>();
        details.addAll(userService.selectMyFollowedStuByCurrentUserId2(currentUserId));
        details.addAll(teacherService.selectMyFollowedTeaByCurrentUserId2(currentUserId));
        details.addAll(venueService.selectMyfollowedVenByCurrentUserId2(currentUserId));
        modelAndView.addObject("details", details);
        return modelAndView;
    }

    @RequestMapping("/page0")
    public ModelAndView page1() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/teacher/page0");
        List<StuMoment> stuMomentList = userService.allMoments2();
        List<TeaMoment> teaMomentList = teacherService.allMoments2();
        List<VenMoment> venMomentList = venueService.allMoments2();
        List<Moment> allMoments = new ArrayList<>();
        allMoments.addAll(stuMomentList);
        allMoments.addAll(teaMomentList);
        allMoments.addAll(venMomentList);
        allMoments.sort(new Comparator<Moment>() {
            @Override
            public int compare(Moment m1, Moment m2) {
                return m2.getTime().compareTo(m1.getTime());
            }
        });
        modelAndView.addObject("moments", allMoments);
        return modelAndView;
    }

    @RequestMapping("/uploadHeadImg")
    @ResponseBody
    public ResultUtil uploadHeadImg2(MultipartFile file) {
        String wholeName = file.getOriginalFilename();
        if (!(wholeName.endsWith(Attributes.JPG_FILE_END_NAME)
                || wholeName.endsWith(Attributes.PNG_FILE_END_NAME)
                || wholeName.endsWith(Attributes.GIF_FILE_END_NAME))) {
            return ResultUtil.error("要上传图片啦!!");
        } else {
            return teacherService.uploadHeadImg2(file);
        }
    }

//https://github.com/JimRainsong/repository.git


    @RequestMapping("/register")
    @ResponseBody
    public ResultUtil register(@RequestParam(value = "userName") String username, @RequestParam(value = "password1") String password1, @RequestParam(value = "password2") String password2) {
        if (username == null || password1 == null || password2 == null) {
            return ResultUtil.error("不能为空");
        }
        if (!password1.matches(RegexUtil.REGEX_PASSWORD)) {
            return ResultUtil.error("密码格式有误请重新输入");
        }

        if (!password1.equals(password2)) {
            return ResultUtil.error("；两次密码不一致");
        }
        //通过 username在数据库中找 user 判断是否重名

        User user = userService.selectUserByUserName(username);
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
        // 然后在用户_角色表中把关联绑定上
        int i3 = teacherService.connectRoleIdAndUserId2(username);
        return ResultUtil.ok("注册成功");
    }

    @RequestMapping("/wallet")
    public ModelAndView wallet() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/teacher/wallet");
        Session session = SecurityUtils.getSubject().getSession();
        Double balance = ((TeacherInfo) session.getAttribute(Attributes.CURRENT_USER)).getBalance();
        modelAndView.addObject("balance", balance);
        return modelAndView;
    }

    @RequestMapping("showteachers")
    @ResponseBody
    public List<Teacher> ShowTea4(HttpServletRequest request) {
        int page = Integer.parseInt(request.getParameter("page"));
        int total = teacherService.SelCountTea4();
        int totalpage = 0;
        if (total / 4 != 0) {
            totalpage = total / 4 + 1;
        } else {
            totalpage = total / 4;
        }
        int lim = page * 4 - 4;
        List<Teacher> teachers = teacherService.showTea4(lim);
        return teachers;
    }

    @RequestMapping("/deltea")
    public String DelTea4(HttpServletRequest request) {
        int teacherId = Integer.parseInt(request.getParameter("teacherId"));
        int row = teacherService.DelTea4(teacherId);
        return "manager/hsn/mteacher";
    }

    @RequestMapping("teaDetail")
    @ResponseBody
    public Teacher TeaDetail4(HttpServletRequest request, HttpSession session) {
        int teacherId = (int) session.getAttribute("teacherId");
        Teacher teacher = teacherService.SelTeaById4(teacherId);
        return teacher;
    }

    @RequestMapping("/updateTeacher")
    @ResponseBody
    public ResultUtil updateTeacher2(TeacherVo vo) {
        return teacherService.updateTeacher2(vo);
    }

    @RequestMapping("/postNewMoment")
    @ResponseBody
    public ResultUtil postNewMoment2(String content) {
        return teacherService.postNewMoment2(content);
    }
}
//暴风哭泣
