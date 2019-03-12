package cn.project.yoga.service;

import cn.project.yoga.pojo.Moment;
import cn.project.yoga.pojo.User;

import java.util.List;

public interface UserService {
    User selectUserByUserName2(String userName);

    List<Moment> allMoments2();
}
