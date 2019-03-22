package cn.project.yoga.controller;

import cn.project.yoga.pojo.*;
import cn.project.yoga.service.VenueService;
import cn.project.yoga.utils.Attributes;
import cn.project.yoga.utils.LayUiDataUtil;
import cn.project.yoga.utils.ManagerUtil;
import cn.project.yoga.utils.RegexUtil;
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
    @ResponseBody
    public LayUiDataUtil updata(@RequestBody Venue venue) {
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        Venue venue1= (Venue) session.getAttribute(Attributes.CURRENT_USER);
        venue.setVenueId(venue1.getVenueId());
        if (!venue.getVenueAddress().equals("")||venue.getVenueAddress()!=null){
            if (RegexUtil.isFuHao(venue.getVenueAddress())){
            }else{
                return LayUiDataUtil.error("地址数据有误");
            }
        }
        if (!venue.getVenueName().equals("")||venue.getVenueName()!=null){
            if (RegexUtil.isFuHao(venue.getVenueName())){
            }else{
                return LayUiDataUtil.error("场馆名数据有误");
            }
        }
        if (!venue.getQq().equals("")||venue.getQq()!=null){
            if (RegexUtil.isFuHao(venue.getQq())){
            }else{
                return LayUiDataUtil.error("QQ数据有误");
            }
        }
        if (!venue.getVenueDetails().equals("")||venue.getVenueDetails()!=null){
            if (RegexUtil.isFuHao(venue.getVenueDetails())){
            }else{
                return LayUiDataUtil.error("详情数据有误");
            }
        }
        if (!venue.getVenuePhone().equals("")||venue.getVenuePhone()!=null){
            if (RegexUtil.isFuHao(venue.getVenuePhone())){
            }else{
                return LayUiDataUtil.error("联系方式数据有误");
            }
        }
        int num=venueService.updataVenue(venue);
        if (num>0){
            return LayUiDataUtil.ok("提交成功");
        }
        return LayUiDataUtil.error("修改失败");
    }
    /*
     *所有学员展示
     * 分页
     * 场馆-陈家明
     */
    @RequestMapping("/studentDatas")
    @ResponseBody
    public Map<String, Object> getStudentDatas(@RequestParam(value = "netName")String netName,@RequestParam(value = "page",defaultValue = "1",required = false)Integer currentPage,
                                               @RequestParam(value = "rows",defaultValue = "5",required = false)Integer pageSize) {
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        Venue venue = (Venue) session.getAttribute(Attributes.CURRENT_USER);
        Map<String, Object> result = new HashMap<String, Object>();
        if ((int) currentPage != currentPage || (int) pageSize != pageSize) {
            result.put("code", 500);
            result.put("msg", "数据传输有误");
            return result;
        }
        Selstudent selstudent=new Selstudent();
        selstudent.setVenueId(venue.getVenueId());
        selstudent.setNetName(netName);
        List<Selstudent> list =venueService.selStudentByStudentName3(selstudent,currentPage,pageSize);
        PageInfo pageInfo = new PageInfo(list);
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
                                              @RequestParam(value = "rows",defaultValue = "10",required = false)Integer pageSize,
                                              @RequestParam(value = "teacherName")String teacherName,
                                              @RequestParam(value = "teacherSex")String teacherSex) {
        Map<String,Object> result = new HashMap<String,Object>();
        if ((int) currentPage != currentPage || (int) pageSize != pageSize) {
            result.put("code", 500);
            result.put("msg", "数据传输有误");
            return result;
        }
        if(!RegexUtil.isFuHao(teacherName)||!RegexUtil.isFuHao(teacherSex)){
            if (teacherName==""||teacherName.equals(null)){

            }else if (teacherSex==""||teacherSex.equals(null)){

            }else {
                result.put("code", 500);
                result.put("msg", "数据传输有误");
                return result;
            }
        }
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
        Map<String,Object> result = new HashMap<String,Object>();
        if((int)currentPage!=currentPage||(int)pageSize!=pageSize){
            result.put("code",500);
            result.put("msg","数据传输有误");
            return result;
        }
        List<Vip_type> list = venueService.selShowVipType(currentPage,pageSize,venue.getVenueId());
        PageInfo pageInfo = new PageInfo(list);
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
        Map<String,Object> result = new HashMap<String,Object>();
        if((int)currentPage!=currentPage||(int)pageSize!=pageSize){
            result.put("code",500);
            result.put("msg","数据传输有误");
            return result;
        }
        List<User_info> list = venueService.selShowattention(currentPage,pageSize,venue.getUserId());
        PageInfo pageInfo = new PageInfo(list);
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
        Map<String,Object> result = new HashMap<String,Object>();
        if((int)currentPage!=currentPage||(int)pageSize!=pageSize){
            result.put("code",500);
            result.put("msg","数据传输有误");
            return result;
        }

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
        if (!RegexUtil.isFuHao(course.getCourseName())||!RegexUtil.isFuHao(course.getCourseState())){
            return LayUiDataUtil.error("数据格式有误");
        }
        if (!course.getStartTime().before(course.getOverTime())){
            return LayUiDataUtil.error("课程时间有误");
        }
        if (!venueService.findStartTimeByCourse(course.getStartTime(),course.getVenueId(),course.getTeacher().getTeacherId())){
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
    public LayUiDataUtil removeCourse(@RequestParam(value = "courseId")Integer courseId){

        int result=venueService.removeCourse(courseId);
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
        if (!RegexUtil.isNosj(ad.getAdTitle())||!RegexUtil.isNosj(ad.getAdDetails())||!RegexUtil.isNosj(ad.getAdImg())||!RegexUtil.isNosj(ad.getAdTime())){
            return LayUiDataUtil.error("输入数据有误,或为空");
        }
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
    public LayUiDataUtil showVenueData() {
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
    /**
     * 查询展示本场馆教练
     * 场馆
     * @param venue_teacher
     * @param currentPage
     * @param pageSize
     * @return
     */
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
    /*
       查看本场馆评论by cy
     */

    /**
     * 展示评论界面
     * 场馆-cy
     * @param commentType
     * @param currentPage
     * @param pageSize
     * @return
     */
    @RequestMapping("/selMoment")
    @ResponseBody
    public LayUiDataUtil selMoment(@RequestParam(value = "commentType")String commentType,@RequestParam(value = "page",defaultValue = "1",required = false)Integer currentPage,
                                   @RequestParam(value = "rows",defaultValue = "10",required = false)Integer pageSize) {
        if((int)currentPage!=currentPage||(int)pageSize!=pageSize){
            return LayUiDataUtil.error("页面数据传输有误！");
        }
        if (!commentType.equals("")&&!commentType.equals(null)&&!RegexUtil.isFuHao(commentType)){
            return LayUiDataUtil.error("数据传输有误！");
        }
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        Venue venue = (Venue) session.getAttribute(Attributes.CURRENT_USER);
        List<Venue_comment> result=venueService.selComent(commentType,17,currentPage,pageSize);
        if (result==null){
            return LayUiDataUtil.error("无评论");
        }
        return LayUiDataUtil.ok(result);
    }

    @RequestMapping("/selFriends")
    @ResponseBody
    public LayUiDataUtil addFriends(Friends friends){
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        Venue venue = (Venue) session.getAttribute(Attributes.CURRENT_USER);
        friends.setUserId(venue.getUserId());
        friends.setfTime(new Date());
        LayUiDataUtil layUiDataUtil = new LayUiDataUtil();
        int num = -1;
        if (friends.getfDetail().equals("")||friends.getfDetail()==null){
            layUiDataUtil.setCode(200);
        }else{
            if (RegexUtil.isNosj(friends.getfDetail())){
                num = venueService.addFriends(friends);
            }else{
                layUiDataUtil.setCode(500);
                layUiDataUtil.setMsg("数据传输有误");
            }
        }
        List<Friends> list = venueService.selFriends(venue.getUserId());
        layUiDataUtil.setData(list);
        if (num>0){
            layUiDataUtil.setCode(0);
            return layUiDataUtil;
        }else if (num==0){
            layUiDataUtil.setCode(500);
            layUiDataUtil.setMsg("添加失败");
            return layUiDataUtil;
        }else {
            return layUiDataUtil;
        }
    }

    /**
     * 删除会员
     * 场馆-cjm
     * @param vipId
     * @return
     */
    @RequestMapping("/delstudent")
    @ResponseBody
    public LayUiDataUtil delstudent(@RequestParam() Integer vipId) {
        if (vipId == null) {
            return LayUiDataUtil.error("删除失败，请选择要删除的会员");
        }
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        Venue venue = (Venue) session.getAttribute(Attributes.CURRENT_USER);
        Vip_record vip_record=new Vip_record();
        vip_record.setVipId(vipId);
        int result = venueService.deleteStudentDatas(vip_record);
        if (result != 0 & result == 1) {
            return LayUiDataUtil.ok("删除成功");
        }
        return LayUiDataUtil.error("删除失败");
    }

    @RequestMapping("/delMyTeacherData")
    @ResponseBody
    public LayUiDataUtil delMyTeacherData(@RequestParam(value = "teacherId") Integer teacherId) {
        System.out.println(teacherId);
        if (teacherId == null) {
            return LayUiDataUtil.error("删除失败，请选择要删除的会员");
        }
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        Venue venue = (Venue) session.getAttribute(Attributes.CURRENT_USER);
        Venue_teacher venue_teacher=new Venue_teacher();
        venue_teacher.setTeacherId(teacherId);
        venue_teacher.setVenueId(venue.getVenueId());
        int result = venueService.delMyTeacherData(venue_teacher);
        if (result != 0 & result == 1) {
            return LayUiDataUtil.ok("删除成功");
        }
        return LayUiDataUtil.error("删除失败");
    }

    @RequestMapping("/selimg")
    @ResponseBody
    public LayUiDataUtil selimg() {
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        Venue venue = (Venue) session.getAttribute(Attributes.CURRENT_USER);
        System.out.println(venue.getVenueName()+":"+venue.getVenueImg());
        return LayUiDataUtil.ok(venue);
    }
}