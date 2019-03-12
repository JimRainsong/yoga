package cn.project.yoga.service.impl;

import cn.project.yoga.dao.TeacherMapper;
import cn.project.yoga.dao.UserMapper;
import cn.project.yoga.pojo.User;
import cn.project.yoga.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public int insertUser(User user1) {
        return userMapper.insert(user1);
    }

    @Override
    public int insert_userid_teacher2(String username) {
        return  teacherMapper.insert_userid_teacher2(username);
    }

    /** zjl
     * 根据教练id,更新教练的认证信息
     * */
    @Override
    public int updateIfauthById4_1(Integer teacherId, Integer val) {
        return teacherMapper.updateTeacherIf_authById(teacherId,val);
    }


}
