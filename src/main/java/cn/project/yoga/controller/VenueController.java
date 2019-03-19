package cn.project.yoga.controller;

import cn.project.yoga.pojo.*;
import cn.project.yoga.service.VenueService;
import cn.project.yoga.utils.Attributes;
import cn.project.yoga.utils.LayUiDataUtil;
import cn.project.yoga.vo.CourseVo;
import cn.project.yoga.vo.TeacherTypeVo;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.*;

@Controller
@RequestMapping("/venueDate")
public class VenueController {
     @Autowired
     private VenueService venueService;

    /*
     *场馆测试
     */

    @RequestMapping("/uploadVenueDatas")
    public LayUiDataUtil updata(@RequestBody Venue venue) {
        System.out.println(venue.getVenueName());
        System.out.println(venue.getVenueAddress());
        return LayUiDataUtil.ok(venue);
    }
        /*
         *所有学员展示
         * 分页
         * 场馆-陈家明
         */
        @RequestMapping("/studentDatas")
        @ResponseBody
        public Map<String, Object> getStudentDatas(@RequestParam(value = "page",defaultValue = "1",required = false)Integer currentPage,
                                                    @RequestParam(value = "rows",defaultValue = "10",required = false)Integer pageSize) {
            Subject subject = SecurityUtils.getSubject();
            Session session = subject.getSession();
             Venue venue = (Venue) session.getAttribute(Attributes.CURRENT_USER);
             List<Selstudent> list = venueService.findStudents(1,10,venue.getVenueId());
            PageInfo pageInfo = new PageInfo(list);
            Map<String,Object> result = new HashMap<String,Object>();
            result.put("code",200);
            result.put("msg","");
            result.put("count",pageInfo.getTotal());
            result.put("data",list);
            System.out.println(list.get(0).getNetName());
            return result;
        }

 /*
     *所有教练展示
     * 分页
     * 场馆-cy
     */
    @RequestMapping("/teacherDatas")
    @ResponseBody
    public Map<String, Object> getTeacherData(@RequestParam(value = "teype")Integer teype,
                                              @RequestParam(value = "page",defaultValue = "1",required = false)Integer currentPage,
                                              @RequestParam(value = "rows",defaultValue = "2",required = false)Integer pageSize,
                                              @RequestParam(value = "teacherName")String teacherName,
                                              @RequestParam(value = "teacherSex")String teacherSex) {
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        Venue venue = (Venue) session.getAttribute(Attributes.CURRENT_USER);
        TeacherTypeVo teacherTypeVo=new TeacherTypeVo();
        Teacher teacher=new Teacher();
        teacher.setTeacherName(teacherName);
        teacher.setTeacherSex(teacherSex);
        teacherTypeVo.setVid(venue.getVenueId());
        teacherTypeVo.setTeype(teype);
        List<Venue_teacher> list = (List<Venue_teacher>) venueService.findTeachers(currentPage,pageSize,teacherTypeVo,teacher);
        PageInfo pageInfo = new PageInfo(list);
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("code",200);
        result.put("msg","");
        result.put("count",pageInfo.getTotal());
        result.put("data",list);
        return result;
    }
    /*
     *该场馆所有vip类型展示
     * 分页
     * 场馆-cjm
     */
    @RequestMapping("/showVipDatas")
    @ResponseBody
    public Map<String, Object> showVipType(@RequestParam(value = "page",defaultValue = "1",required = false)Integer currentPage,
                                       @RequestParam(value = "rows",defaultValue = "10",required = false)Integer pageSize) {
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        Venue venue = (Venue) session.getAttribute(Attributes.CURRENT_USER);
        List<Vip_type> list = venueService.selShowVipType(currentPage,pageSize,venue.getVenueId());
        PageInfo pageInfo = new PageInfo(list);
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("code",200);
        result.put("msg","");
        result.put("count",pageInfo.getTotal());
        result.put("data",list);
        return result;

    }
    /*
     *展示所有关注该场馆的用户
     * 场馆-cjm
     */
    @RequestMapping("/atentionDatas")
    @ResponseBody
    public Map<String, Object> showattentionDatas(@RequestParam(value = "page",defaultValue = "1",required = false)Integer currentPage,
                                                  @RequestParam(value = "rows",defaultValue = "10",required = false)Integer pageSize) {
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        Venue venue = (Venue) session.getAttribute(Attributes.CURRENT_USER);
        List<User_info> list = venueService.selShowattention(currentPage,pageSize,venue.getVenueId());
        PageInfo pageInfo = new PageInfo(list);
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("code",200);
        result.put("msg","");
        result.put("count",pageInfo.getTotal());
        result.put("data",list);
        return result;
    }
    /**课程
     *@RequestMapping("/courseDatas")
     *@ResponseBody
     */
    @RequestMapping("/courseDatas")
    @ResponseBody
    public Map<String, Object> showCourse(@RequestParam(value = "page",defaultValue = "1",required = false)Integer currentPage,
                                          @RequestParam(value = "rows",defaultValue = "10",required = false)Integer pageSize,
                                          @RequestParam(value = "tname")String teacherName,
                                          @RequestParam(value = "cname")String cname,
                                          @RequestParam(value = "maxtime")Date maxtime,
                                          @RequestParam(value = "mintime")Date mintime
                                          ) {
      Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        Venue venue = (Venue) session.getAttribute(Attributes.CURRENT_USER);
        List<Course> list =null;
        CourseVo courseVo=new CourseVo(venue.getVenueId(),teacherName,cname,maxtime,mintime);
        list = venueService.selCourse(currentPage,pageSize,courseVo);
        for (Course course:list) {
            System.out.println(course);
        }
        System.out.println(list);
        PageInfo pageInfo = new PageInfo(list);
        List<Course> courses= pageInfo.getList();
        for (int i=0;i<courses.size();i++) {
            Date date=new Date();
            Course course=courses.get(i);
            if (!date.before(course.getStartTime())){
                if (date.before(course.getOverTime())){
                    course.setCourseState("正在上课");
                }else {
                    course.setCourseState("今日课程已结束");
                }
            }else {
                    course.setCourseState("课程尚未开始");
            }
            courses.set(i,course);
            System.out.println(course);
        }
        pageInfo.setList(list);
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("code",200);
        result.put("msg","");
        result.put("count",pageInfo.getTotal());
        result.put("data",list);
        return result;
    }
    /**
     *添加课程
     *
     */
     @RequestMapping("/addCourse")
     @ResponseBody
     public LayUiDataUtil addCourse(@RequestBody Course course){
         Subject subject = SecurityUtils.getSubject();
         Session session = subject.getSession();
         Venue venue = (Venue) session.getAttribute(Attributes.CURRENT_USER);
         course.setVenueId(venue.getVenueId());
         if (!course.getStartTime().before(course.getOverTime())){
                 return LayUiDataUtil.error("课程时间有误");
         }
         if (venueService.findStartTimeByCourse(course.getStartTime(),course.getVenueId(),course.getTeacher().getTeacherId())){
                 return LayUiDataUtil.error("请检查时间段");
         }
         int result=venueService.addCourse(course);
         if (result>0){
                 return LayUiDataUtil.error("添加成功");
     }
                 return LayUiDataUtil.error("添加失败");
     }

    /**
     *删除课程
     *
     */
    @RequestMapping("/removeCourse")
    @ResponseBody
    public LayUiDataUtil removeCourse(@RequestBody Course course){
        int result=venueService.removeCourse(course.getCourseId());
        if (result>0){
            return LayUiDataUtil.error("删除成功");
        }
        return LayUiDataUtil.error("删除失败");
    }
    /*
     *添加广告
     * 场馆-cjm
     */
    @RequestMapping("/uploadAdDatas")
    @ResponseBody
    public LayUiDataUtil uploadAds(@RequestBody Ad ad) {
        System.out.println(ad);
        if (venueService.findAdByName(ad.getAdTitle())){
            return LayUiDataUtil.error("此标题已存在，如果想继续添加请与管理员联系");
        }
        if (venueService.venueUploadAds(ad)>0){
             return LayUiDataUtil.ok("广告添加成功");
        }
        return LayUiDataUtil.error("广告添加失败");
     }

    /**
     * 随机数
     * @param oldName
     * @return
     */
    public String changeName(String oldName){
        return UUID.randomUUID()+"_"+oldName;
    }



    @RequestMapping("/venueDatas")
    @ResponseBody
    public Map<String, Object> showvenueDatas(@RequestParam(value = "page",defaultValue = "1",required = false)Integer currentPage,
                                                  @RequestParam(value = "rows",defaultValue = "10",required = false)Integer pageSize) {
        List<Venue> list = venueService.SelVen(currentPage,pageSize);
        PageInfo pageInfo = new PageInfo(list);
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("code",200);
        result.put("msg","");
        result.put("count",pageInfo.getTotal());
        result.put("data",list);
        return result;

    }
/*
 * 展示该场馆信息通过场馆id
 * 场馆-cy
 */
    @RequestMapping("/VenueData")
    @ResponseBody
    public LayUiDataUtil showVenueData( ) {
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        Venue venues = (Venue) session.getAttribute(Attributes.CURRENT_USER);
        Venue venue = venueService.SelVenById4(venues.getVenueId());
       if (venue!=null){
           return  LayUiDataUtil.ok(venue);
       }
        return LayUiDataUtil.error(null);
    }

    /**
     * 删除会员卡类型
     * 场馆-cjm
     * @param vipTypeId
     * @return
     */
    @RequestMapping("/deleteVipTypeDatas")
    @ResponseBody
    public LayUiDataUtil deleteVipTypeDatas(@RequestParam() Integer vipTypeId) {
        if (vipTypeId == null) {
            return LayUiDataUtil.error("删除失败，请选择要删除的类型");
        }
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        Venue venue = (Venue) session.getAttribute(Attributes.CURRENT_USER);
        Vip_type vip_type = new Vip_type();
        vip_type.setVenueId(venue.getVenueId());
        vip_type.setVipTypeId(vipTypeId);
        int result = venueService.deleteVipTypeDatas(vip_type);
        if (result != 0 & result == 1) {
            return LayUiDataUtil.ok("删除成功");
        }
        return LayUiDataUtil.error("删除失败");
    }

    @RequestMapping("/insertVipTypeDatas")
    @ResponseBody
    public LayUiDataUtil insertVipTypeDatas(Vip_type vip_type) {
        if (vip_type == null) {
            return LayUiDataUtil.error("添加失败，请输入要添加的会员卡信息");
        }
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        Venue venue = (Venue) session.getAttribute(Attributes.CURRENT_USER);
        vip_type.setVenueId(venue.getVenueId());
        int result = venueService.insertVipTypeDatas(vip_type);
        if (result != 0 & result == 1) {
            return LayUiDataUtil.ok("添加成功");
        }
        return LayUiDataUtil.error("添加失败");
    }

    /**
     * 审核教练
     * 场馆—cjm
     * @param
     * @return
     */
    @RequestMapping("/translateTeacher")
    @ResponseBody
    public LayUiDataUtil translateTeacher(Venue_teacher venue_teacher) {
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        Venue venue = (Venue) session.getAttribute(Attributes.CURRENT_USER);
        venue_teacher.setVenueId(venue.getVenueId());
        int result=venueService.updataTeacherState(venue_teacher);
        if (result!=1){
            return LayUiDataUtil.error("审核失败");
        }
        return LayUiDataUtil.ok("审核成功");
    }

    @RequestMapping("/selTeacher")
    @ResponseBody
    public LayUiDataUtil selTeacher(Venue_teacher venue_teacher,Integer currentPage,Integer pageSize) {
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        Venue venue = (Venue) session.getAttribute(Attributes.CURRENT_USER);
        venue_teacher.setVenueId(venue.getVenueId());
        venue_teacher.setTeacher(new Teacher());
        venue_teacher.setTeacherState(0);
        System.out.println(venue_teacher);
        List<Venue_teacher> result=venueService.selTeacherName(venue_teacher);
        if (result==null){
            return LayUiDataUtil.error("查找在本场馆的教练失败");
        }

        return LayUiDataUtil.ok(result);
    }
}