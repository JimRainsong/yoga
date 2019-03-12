package cn.project.yoga.controller;


import cn.project.yoga.pojo.Venue;
import cn.project.yoga.service.ManagerService;
import cn.project.yoga.utils.ManagerUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/manager")
public class ManagerController {


    @Autowired
    private ManagerService managerService;

    /*场馆分页查询数据*/
    @RequestMapping("/selallvenues")
    @ResponseBody
    public Map<String,Object> allvenues4_1(@RequestParam(value = "page",defaultValue = "1",required = false)Integer currentPage,@RequestParam(value = "rows"
            ,defaultValue = "10",required = false)Integer
            pageSize){
        System.out.println("获取数据-"+currentPage+"----"+pageSize);

        List<Venue> listvenues4_1 = managerService.selAllVenues4_1(currentPage,pageSize);
        for (Venue venue : listvenues4_1) {
            System.out.println("获取查询数据:"+venue);
        }
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

}
