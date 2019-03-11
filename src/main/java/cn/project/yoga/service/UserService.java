package cn.project.yoga.service;

import cn.project.yoga.pojo.User;

public interface UserService {
    /**
     * 通过用户名查密码
     * @param userName
     * @return
     */
    User selectUserByUserName(String userName);

    /**
     * 更新用户信息是否可查看
     * @param user
     * @return
     */
    String updateUserInfo(User user);
}
