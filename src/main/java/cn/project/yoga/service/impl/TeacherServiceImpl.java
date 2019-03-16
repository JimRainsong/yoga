package cn.project.yoga.service.impl;

import cn.project.yoga.dao.TeacherMapper;
import cn.project.yoga.dao.UserMapper;
import cn.project.yoga.pojo.TeaMoment;
import cn.project.yoga.pojo.TeacherInfo;
import cn.project.yoga.pojo.Teacher;
import cn.project.yoga.pojo.User;
import cn.project.yoga.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return teacherMapper.insert_userid_teacher2(username);
    }

    /**
     * zjl
     * 根据教练id,更新教练的认证信息
     */
    @Override
    public int updateIfauthById4_1(Integer teacherId, Integer val) {
        return teacherMapper.updateTeacherIf_authById(teacherId, val);
    }

    @Override
    public Double selectBalanceByTeacherName2(String name) {
        return teacherMapper.selectBalanceByTeacherName2(name);
    }

    @Override
    public List<TeaMoment> allMoments2() {
        return teacherMapper.allMoments2();
    }

    @Override
    public String selectTeacherNameByTeacherId2(Integer teacherId) {
        return teacherMapper.selectTeacherNameByTeacherId2(teacherId);
    }

    @Override
    public TeacherInfo selectSingleTeacherByUserName2(String userName) {
        return teacherMapper.selectSingleTeacherByUserName(userName);
    }

    @Override
    public List<Teacher> showTea4(Integer currentPage,Integer pageSize) {
        List<Teacher> teachers=teacherMapper.showTea4(currentPage,pageSize);
        return teachers;
    }

    @Override
    public int DelTea4(int teacherId) {
        int row=teacherMapper.DelTea4(teacherId);
        return row;
    }

    @Override
    public Teacher SelTeaById4(int teacherId) {
        Teacher teacher=teacherMapper.SelTeaById4(teacherId);
        return teacher;
    }

    @Override
    public int SelCountTea4() {
        int totalpage=teacherMapper.SelCountTea4();
        return totalpage;
    }

    @Override
    public List<Teacher> shearch(String teachername, String teacherSex,String teacherPhone, String teacherQq) {
        List<Teacher> teachers=teacherMapper.shearch(teachername,teacherSex,teacherPhone,teacherQq);
        return teachers;
    }


}
