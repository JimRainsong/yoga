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
        return userMapper.selectUserByUserName4(userName);
    }

    /**
     * 修改用户信息
     * @author zjn
     * @param user
     * @return  int 影响行数
     */
    @Override
    public String updateUserInfo(User user) {
        int row = userMapper.updateUserInfo4(user);
        if (row==1){
            return "修改状态成功";
        }
        return "修改状态失败";
    }
}
