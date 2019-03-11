package cn.project.yoga.controller;

import cn.project.yoga.pojo.User_info;
import cn.project.yoga.service.ManagerService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/manager")
public class ManagerController {


    @Autowired
    private ManagerService managerService;


}
