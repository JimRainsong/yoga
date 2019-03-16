package cn.project.yoga.controller;


import cn.project.yoga.pojo.Ad;
import cn.project.yoga.pojo.Teacher;
import cn.project.yoga.pojo.Venue;
import cn.project.yoga.service.ManagerService;
import cn.project.yoga.service.TeacherService;
import cn.project.yoga.service.VenueService;
import cn.project.yoga.utils.ManagerUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/manager")
public class ManagerController {


    @Autowired
    private ManagerService managerService;
    @Autowired
    private TeacherService teacherService;

    @Autowired
    private VenueService service;

    /*场馆分页查询数据*/
    @RequestMapping("/selallvenues")
    @ResponseBody
    public Map<String,Object> allvenues4_1(@RequestParam(value = "page",defaultValue = "1",required = false)Integer currentPage,@RequestParam(value = "rows"
            ,defaultValue = "10",required = false)Integer
            pageSize, String venueName){
        List<Venue> listvenues4_1 = managerService.selAllVenues4_1(currentPage,pageSize,venueName);
        PageInfo pageinfo = new PageInfo(listvenues4_1);
        Map<String,Object> map = new HashMap<>();
        map.put("rows",listvenues4_1);
        map.put("total",pageinfo.getTotal());
        return map;
    }


    /*场馆认证*/
    @RequestMapping("/updatevenue")
    @ResponseBody
    public ManagerUtil updatevenue4_1(Integer venueId,Integer val){
        System.out.println("获取前端参数:"+venueId+"认证数据="+val);
        int res = managerService.upVenueApprove(venueId,val);
        if (res >0){
            return ManagerUtil.ok("更改成功");
        }
        return ManagerUtil.error("更改失败");
    }

    /*查询所有未认证的教练信息*/
    @RequestMapping("/selallteacher")
    @ResponseBody
    public Map<String,Object> selAllTeacher(@RequestParam(value = "page",defaultValue = "1",required = false)Integer currentPage,@RequestParam(value = "rows"
            ,defaultValue = "10",required = false)Integer
            pageSize,String teacherName){
       List<Teacher> listteacher = managerService.selAllTeacherByapprove(currentPage,pageSize,teacherName);
        PageInfo pageInfoTwo = new PageInfo(listteacher);
        Map<String,Object> mapTwo = new HashMap<>();
        mapTwo.put("rows",listteacher);
        mapTwo.put("total",pageInfoTwo.getTotal());
        return mapTwo;
    }

    /*更改教练认证信息*/
    @RequestMapping("/updateteacher")
    @ResponseBody
    public ManagerUtil updateTeacher(Integer teacherId,Integer val){
        int result = teacherService.updateIfauthById4_1(teacherId,val);
        if (result >0){
            return ManagerUtil.ok("认证成功");
        }
        return ManagerUtil.error("认证失败");
    }

    /*分页及模糊查询广告*/
    @RequestMapping("/selallad")
    @ResponseBody
    public Map<String,Object> allAdAndLimit(@RequestParam(value = "page",defaultValue = "1",required = false)Integer currentPage,@RequestParam(value = "rows"
            ,defaultValue = "10",required = false)Integer
            pageSize,Integer datas,String adtitles){
        System.out.println("获取数据广告++++++++++++++++++"+adtitles);
        System.out.println("获取数据++++++++++++++++++"+datas);
        List<Ad> listAd = managerService.selAllAdBylimit(currentPage,pageSize,datas,adtitles);
        PageInfo pagefo = new PageInfo(listAd);
        Map<String,Object> admap = new HashMap<>();
        admap.put("rows",listAd);
        admap.put("total",pagefo.getTotal());
        return admap;
    }

    /*认证更新广告*/
    @RequestMapping("/updatead")
    @ResponseBody
    public ManagerUtil updatead(Integer adId,Integer val){
        System.out.println(adId+"daId"+"*****"+val);

        int result = managerService.updateAdByAdid(adId,val);
        if (result >0){
            return ManagerUtil.ok("认证成功");
        }
        return ManagerUtil.error("认证失败");
    }

    /*获取广告表前三个广告的所有数据*/
    @RequestMapping("/getads")
    @ResponseBody
    public Map<String,Object> listad(){
       List<Ad> listad =  managerService.getadthree();
       Map<String,Object> admaps = new HashMap<>();
       admaps.put("rows",listad);
       return admaps;
    }

    /*
     * 查询出所有场馆信息传到前端*/
    @RequestMapping("/showvenues")
    @ResponseBody
    public List<Venue> ShowVenues(HttpServletRequest request){
        int page=Integer.parseInt(request.getParameter("page"));

        int total=service.SelVenNum();
        int totalpage=0;
        if (total/4!=0){
            totalpage=total/4+1;
        }else {
            totalpage=total/4;
        }
        int lim=page*4-4;
        List<Venue> venues =service.selectAllVenue4(lim);
        return venues;
    }

    /*
   删除场馆
    */
    @RequestMapping("/delven")
    public String DelVen4(HttpServletRequest request){
        int venue_id=Integer.parseInt(request.getParameter("venueId"));
        int row=service.DelVen4(venue_id);
        return "manager/hsn/Mvenue";
    }

    @RequestMapping("/venueDetail")
    @ResponseBody
    public Venue VenDetail4(HttpSession session){
        int venueId= (int) session.getAttribute("venueId");
        Venue venue=service.SelVenById4(venueId);
        System.out.println(venue);
        return venue;
    }

    @RequestMapping("/shearch")
    @ResponseBody
    public List<Venue> ShearchVenue4(HttpServletRequest request){
        String venname=request.getParameter("venname");
        String addrass=request.getParameter("addrass");
        String phone=request.getParameter("phone");
        String qq=request.getParameter("qq");
        List<Venue>venues=service.shearch(venname,addrass,phone,qq);
        System.out.println(venues);
        return venues;
    }

}
