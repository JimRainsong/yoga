package cn.project.yoga.service.impl;

import cn.project.yoga.dao.AppointmentMapper;
import cn.project.yoga.dao.TeacherMapper;
import cn.project.yoga.dao.UserMapper;
import cn.project.yoga.pojo.TeaMoment;
import cn.project.yoga.pojo.Appointment;
import cn.project.yoga.pojo.User;
import cn.project.yoga.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private TeacherMapper teacherMapper;

    @Autowired
    private AppointmentMapper appointmentMapper;

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



    //查看所有  当前老师id 的 appointment  预约信息
    @Override
    public List<Appointment> selappointmentbyTeacherId2(Integer teacherId, Date date1, Date date2) {
        return appointmentMapper.selappointmentbyteacherId2(teacherId,date1,date2);
    }



}
