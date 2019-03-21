package cn.project.yoga.controller;

import cn.project.yoga.service.UserService;
import cn.project.yoga.vo.OrderCoachVo;
import cn.project.yoga.vo.SelfCourseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
