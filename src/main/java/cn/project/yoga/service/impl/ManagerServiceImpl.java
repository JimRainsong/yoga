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


}
