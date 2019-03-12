package cn.project.yoga.service.impl;

import cn.project.yoga.dao.MomentMapper;
import cn.project.yoga.dao.UserMapper;
import cn.project.yoga.pojo.Moment;
import cn.project.yoga.pojo.User;
import cn.project.yoga.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private MomentMapper momentMapper;

    @Override
    public User selectUserByUserName2(String userName) {
        return userMapper.selectUserByUserName2(userName);
    }

    @Override
    public List<Moment> allMoments2() {
        return momentMapper.allMoments2();
    }
}
