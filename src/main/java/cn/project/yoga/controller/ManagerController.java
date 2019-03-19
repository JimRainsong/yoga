package cn.project.yoga.controller;


import cn.project.yoga.pojo.*;
import cn.project.yoga.service.ManagerService;
import cn.project.yoga.service.TeacherService;
import cn.project.yoga.service.UserService;
import cn.project.yoga.service.VenueService;
import cn.project.yoga.utils.ManagerUtil;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.SecurityUtils;
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
    private UserService userService;


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



    /**
     * 分页,模糊查询所有商品信息
     */
    @RequestMapping("/getallgoods")
    @ResponseBody
    public Map<String,Object> allGoodsLimit(@RequestParam(value = "page",defaultValue = "1",required = false)Integer currentPage,@RequestParam(value = "rows"
            ,defaultValue = "10",required = false)Integer
            pageSize,Integer type,String goodsName){
        System.out.println("测试获取前端传参:+"+type+"名字:"+goodsName);
        List<Goods> listgoods = managerService.limitAllGoods4_1(currentPage,pageSize,type,goodsName);
        PageInfo pageinfogoods = new PageInfo(listgoods);
        Map<String,Object> goodsmap = new HashMap<>();
        goodsmap.put("rows",listgoods);
        goodsmap.put("total",pageinfogoods.getTotal());
        return goodsmap;
    }

    /**
     * 获取订单表的信息
     */
    @RequestMapping("/getmygoods")
    @ResponseBody
    public List<Myorder> listmyorder(){
        //String username  = (String) SecurityUtils.getSubject().getPrincipal();/*shiro 里面获取用户名*/
        //测试用
        String uname ="朱俊陇(测试用)";
        int uid = userService.getUserGoods4_1(uname);
        List<Myorder> listorder = managerService.selAllOrderByuid4_1(uid);
        for (Myorder myorder : listorder) {
            myorder.setgName(managerService.selGnameByGid4_1(myorder.getGoodsId()));
        }
        return listorder;
    }

    @RequestMapping("/deletegoods")
    @ResponseBody
    public  ManagerUtil deletegoods(Integer gId){
        int result = managerService.deletegoodsByGid4_1(gId);
        if (result >0){
            return ManagerUtil.ok("删除成功");
        }
        return ManagerUtil.error("删除失败");
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
    public Map<String,Object> ShearchVenue4(@RequestParam(value = "page",defaultValue = "1",required = false)Integer currentPage,
                                            @RequestParam(value = "rows",defaultValue = "10",required = false)Integer pageSize,HttpServletRequest request,HttpSession session){
        String venname= (String) session.getAttribute("venname");
        String addrass= (String) session.getAttribute("addrass");
        String phone= (String) session.getAttribute("phone");
        String qq= (String) session.getAttribute("qq");

        List<Venue>list=service.shearch(venname,addrass,phone,qq,currentPage,pageSize);

        PageInfo pageInfo = new PageInfo(list);
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("code",200);
        result.put("msg","");
        result.put("count",pageInfo.getTotal());
        result.put("data",list);
        return result;
    }

}
