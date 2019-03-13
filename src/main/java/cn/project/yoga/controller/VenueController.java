package cn.project.yoga.controller;

import cn.project.yoga.pojo.*;
import cn.project.yoga.service.VenueService;
import cn.project.yoga.utils.LayUiDataUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public Map<String, Object> getStudentDatas(@RequestParam() Integer venueId,
                                               @RequestParam(value = "page",defaultValue = "1",required = false)Integer currentPage,
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

    @RequestMapping("/showVipDatas")
    @ResponseBody
    public Map<String, Object> showVipType(@RequestParam() Integer venueId,
                                       @RequestParam(value = "page",defaultValue = "1",required = false)Integer currentPage,
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

    @RequestMapping("/atentionDatas")
    @ResponseBody
    public Map<String, Object> showatentionDatas(@RequestParam() Integer venueId,
                                           @RequestParam(value = "page",defaultValue = "1",required = false)Integer currentPage,
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

}
