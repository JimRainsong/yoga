package cn.project.yoga.controller;

import cn.project.yoga.pojo.Ad;
import cn.project.yoga.pojo.User;
import cn.project.yoga.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 修改用户信息
     * @author zjn
     * @param user
     * @return 字符串，更新成功/失败
     */
    @RequestMapping("/update")
    @ResponseBody
    public String updateInfo(User user){
       String state = userService.updateUserInfo1(user);
       return state;
    }
    @RequestMapping("/lookAd")
    @ResponseBody
    public List<Ad> lookAd(){
        List<Ad> ad=userService.selectAd();
        return ad;
    }

}
