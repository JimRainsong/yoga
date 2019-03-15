package cn.project.yoga.controller;

import cn.project.yoga.pojo.*;
import cn.project.yoga.service.VenueService;
import cn.project.yoga.utils.LayUiDataUtil;
import cn.project.yoga.vo.CourseVo;
import cn.project.yoga.vo.TeacherTypeVo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import javax.websocket.server.PathParam;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/venueDate")
public class VenueController {
     @Autowired
     private VenueService venueService;

    /*
     *场馆测试
     */
    @RequestMapping("/updata")
    @ResponseBody
    public LayUiDataUtil updata(Venue venue){
           System.out.println(venue.getVenueName());
           System.out.println(venue.getVenueAddress());
           LayUiDataUtil layUiDataUtil=new LayUiDataUtil();
           layUiDataUtil.setData(venue);
        return layUiDataUtil;
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
        List<Selstudent> list = venueService.findStudents(1,10,1);
        PageInfo pageInfo = new PageInfo(list);
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("code",200);
        result.put("msg","");
        result.put("count",pageInfo.getTotal());
        result.put("data",list);
//        result.put("rows",list);
//        result.put("total",pageInfo.getTotal());
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
    public Map<String, Object> getTeacherData(@RequestParam(value = "vid")Integer vid,
                                              @RequestParam(value = "teype")Integer teype,
                                              @RequestParam(value = "page",defaultValue = "1",required = false)Integer currentPage,
                                              @RequestParam(value = "rows",defaultValue = "2",required = false)Integer pageSize,
                                              @RequestParam(value = "teacherName")String teacherName,
                                              @RequestParam(value = "teacherSex")String teacherSex) {

        TeacherTypeVo teacherTypeVo=new TeacherTypeVo();
        Teacher teacher=new Teacher();
        teacher.setTeacherName(teacherName);
        teacher.setTeacherSex(teacherSex);
        System.out.println(vid+"================================="+teype);
        teacherTypeVo.setVid(vid);
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
        List<Vip_type> list = venueService.selShowVipType(currentPage,pageSize,1);
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
        List<User_info> list = venueService.selShowattention(currentPage,pageSize,1);
        PageInfo pageInfo = new PageInfo(list);
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("code",200);
        result.put("msg","");
        result.put("count",pageInfo.getTotal());
        result.put("data",list);
        return result;
    }

    @RequestMapping("/courseDatas")
    @ResponseBody
    public Map<String, Object> showCourse(@RequestParam(value = "page",defaultValue = "1",required = false)Integer currentPage,
                                          @RequestParam(value = "rows",defaultValue = "10",required = false)Integer pageSize,
                                          @RequestParam(value = "vid")Integer venueId,
                                          @RequestParam(value = "tname")String teacherName,
                                          @RequestParam(value = "cname")String cname,
                                          @RequestParam(value = "maxtime")Date maxtime,
                                          @RequestParam(value = "mintime")Date mintime
                                          ) {
        List<Course> list =null;
        CourseVo courseVo=new CourseVo(venueId,teacherName,cname,maxtime,mintime);
        list = venueService.selCourse(currentPage,pageSize,courseVo);
        System.out.println(list);
        PageInfo pageInfo = new PageInfo(list);
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("code",200);
        result.put("msg","");
        result.put("count",pageInfo.getTotal());
        result.put("data",list);
        return result;
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

}
