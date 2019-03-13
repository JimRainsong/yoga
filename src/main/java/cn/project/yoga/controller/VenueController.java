package cn.project.yoga.controller;

import cn.project.yoga.pojo.Selstudent;
import cn.project.yoga.pojo.User;
import cn.project.yoga.pojo.User_info;
import cn.project.yoga.pojo.Venue;
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
    public Map<String, Object> getStudentDatas(@PathVariable("venueId") Integer venueId,
                                               @RequestParam(value = "page",defaultValue = "1",required = false)Integer currentPage,
                                               @RequestParam(value = "rows",defaultValue = "5",required = false)Integer pageSize) {
        List<Selstudent> list = venueService.findStudents(1,3,venueId);
        PageInfo pageInfo = new PageInfo(list);
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("rows",list);
        result.put("total",pageInfo.getTotal());
        return result;

    }
}
