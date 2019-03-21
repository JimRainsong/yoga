package cn.project.yoga.controller;

import cn.project.yoga.pojo.Attention;
import cn.project.yoga.pojo.Course;
import cn.project.yoga.pojo.Venue;
import cn.project.yoga.service.UserService;
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

    @RequestMapping("/addAttention")
    @ResponseBody
    public LayUiDataUtil addAttention(@RequestParam(value = "followId") Integer followId){
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        Integer uId = (Integer) session.getAttribute("uId");

        Attention attention=new Attention();
        attention.setFollowId(followId);
        attention.setUserId(uId);

        int num=userService.addAttention(attention);
        if (num>0){
            return LayUiDataUtil.ok(attention);
        }
            return LayUiDataUtil.error("关注失败");
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
}
