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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
    public String uploadAds(HttpServletRequest request, @RequestParam("file")MultipartFile file, @RequestParam("adTitle")String adTitle,@RequestParam("desc")String desc,@RequestParam("mypath")String mypath) {
        String imgname=file.getOriginalFilename();

        System.out.println("图片名："+file);
        if (imgname==null || imgname.equals("")) {
            return "请选择文件";
        }
         //根据当前项目的路径获取到服务器的物理路径
        ServletContext context = request.getServletContext();
        String path = context.getRealPath("/img");
        System.out.println(path);

        //判断当前服务器是否有upload文件夹
        File files = new File(path);
        if(!files.exists()) files.mkdirs();

        //在file文件夹里面创建一个文件对象
        String filename=changeName(file.getOriginalFilename());
        File file2 = new File(path,filename);

        try {
            file.transferTo(file2);
        } catch (IllegalStateException e) {
            e.printStackTrace();
            return "上传失败";
        } catch (IOException e) {

            e.printStackTrace();
            return "上传失败";
        }
        //将路径保存到数据库
        String source="/yoga/img/"+filename;
        Ad ad=new Ad();
        ad.setAdImg(source);
        ad.setAdTitle(adTitle);
        ad.setAdDetails(desc);
        int state=venueService.venueUploadAds(ad);
        if (state==1){
            return "成功提交添加广告申请";
        }else {
            return "提交添加广告申请失败";
        }
     }
    public String changeName(String oldName){
        return UUID.randomUUID()+"_"+oldName;
    }


}
