package cn.project.yoga.service;

import cn.project.yoga.pojo.User_info;

import java.util.List;

public interface ManagerService {

    public List<User_info> listUserInfo(Integer currentPage, Integer pageSize);


}
