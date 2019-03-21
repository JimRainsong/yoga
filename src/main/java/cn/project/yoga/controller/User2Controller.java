package cn.project.yoga.controller;

import cn.project.yoga.pojo.Attention;
import cn.project.yoga.pojo.Course;
import cn.project.yoga.pojo.Venue;
import cn.project.yoga.service.UserService;
import cn.project.yoga.vo.*;
import cn.project.yoga.utils.Attributes;
import cn.project.yoga.utils.LayUiDataUtil;
import cn.project.yoga.vo.OrderCoachVo;
import cn.project.yoga.vo.SelfCourseVo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user2")
public class User2Controller {

    @Autowired
    private UserService userService;

    @RequestMapping("/orderCoach")
    @ResponseBody
    public String orderCoach(OrderCoachVo orderCoachVo){
        System.out.println("=============="+orderCoachVo.getBeginTime());
        return userService.orderCoach(orderCoachVo);
    }

    @RequestMapping("/selMySelfCourse")
    @ResponseBody
    public List<SelfCourseVo> selMySelfCourse(){
        return userService.selectMySelfCourse1();
    }

    @RequestMapping("/addVenueAttention")
    @ResponseBody
    public String addAttention(@RequestParam(value = "followId") Integer followId){
        return null;
    }


    @RequestMapping()
    @ResponseBody
    public LayUiDataUtil selMyCourse(){
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        Integer uId = (Integer) session.getAttribute("uId");

        List<Course> courses = userService.selCourseByUid(uId);

        LayUiDataUtil layUiDataUtil = LayUiDataUtil.ok();
        layUiDataUtil.setData(courses);

        return LayUiDataUtil.ok();
    }

    @RequestMapping("/venueSpeak")
    @ResponseBody
    public List<VenueTalk> venueSpeak(){
        return userService.venueSpeak();
    }

    @RequestMapping("/teacherSpeak")
    @ResponseBody
    public List<teacherTalk> teacherSpeak(){
        return userService.teacherSpeak();
    }

    @RequestMapping("/stuSpeak")
    @ResponseBody
    public List<stuTalk> stuSpeak(){
        return userService.stuSpeak();
    }

    @RequestMapping("/allCourse")
    @ResponseBody
    public List<allCourseVo> allCourse(Integer venueId){
        return userService.allCourse(venueId);
    }

    @RequestMapping("/addCourse")
    @ResponseBody
    public String addCourse(Integer venueId,Integer teacherId,Integer courseId){
        return userService.addCourse(courseId);
    }
    @RequestMapping("/mycourse")
    @ResponseBody
    public List<MyCourseVo> myCourse(){
        return userService.selMyCouse();
    }
}
