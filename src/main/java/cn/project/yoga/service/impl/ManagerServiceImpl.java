package cn.project.yoga.service.impl;

import cn.project.yoga.dao.User_infoMapper;
import cn.project.yoga.pojo.User_info;
import cn.project.yoga.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    private User_infoMapper user_infoMapper;

    /*获取用户信息*/
    @Override
    public List<User_info> listUserInfo(Integer currentPage,Integer pageSize) {
        System.out.println("进入查询用户信息service层");
        List<User_info> list =  user_infoMapper.findAllMessage(currentPage,pageSize);
        return list;
    }
}
