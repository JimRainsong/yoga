package cn.project.yoga.controller;

import cn.project.yoga.pojo.User_info;
import cn.project.yoga.service.ManagerService;
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

    /*获取会员信息*/
    @RequestMapping("/getmenbersmessage")
    @ResponseBody
    public Map<String,Object> menbers(@RequestParam(value = "page",defaultValue = "1",required = false)Integer currentPage,
                                      @RequestParam(value = "rows",defaultValue = "5",required = false)Integer pageSize){
        System.out.println("后台获取分页信息:"+currentPage+"大小:"+pageSize);
        List<User_info> listInfo = managerService.listUserInfo(currentPage,pageSize);
        for (User_info user_info : listInfo) {
            System.out.println("获取数据"+user_info);
        }
        PageInfo pageinfo = new PageInfo(listInfo);
        Map<String,Object> map = new HashMap<>();
        map.put("rows",listInfo);
        map.put("total",pageinfo.getTotal());
        return map;
    }
}
