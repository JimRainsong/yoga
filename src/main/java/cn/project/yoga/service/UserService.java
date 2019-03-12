package cn.project.yoga.service;

import cn.project.yoga.pojo.User;

public interface UserService {
    User selectUserByUserName(String userName);
}
