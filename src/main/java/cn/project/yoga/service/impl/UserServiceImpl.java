package cn.project.yoga.service.impl;

import cn.project.yoga.dao.UserMapper;
import cn.project.yoga.pojo.User;
import cn.project.yoga.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectUserByUserName(String userName) {
        return null;
    }

    /*@Override
    public User selectUserByUserName(String userName) {
        return userMapper.selectUserByUserName(userName);
    }*/

}
