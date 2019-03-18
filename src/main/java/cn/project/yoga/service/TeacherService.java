package cn.project.yoga.service;

import cn.project.yoga.pojo.TeaMoment;
import cn.project.yoga.pojo.Appointment;
import cn.project.yoga.pojo.User;

import java.util.Date;
import java.util.List;

public interface TeacherService {


    //注册 插入user信息
    int insertUser(User user1);

    //通过username查到 其在user表中的id  并将此id插入teacher表的user_id
    int insert_userid_teacher2(String username);


    int updateIfauthById4_1(Integer teacherId, Integer val);




    Double selectBalanceByTeacherName2(String name);

    List<TeaMoment> allMoments2();

    String selectTeacherNameByTeacherId2(Integer teacherId);



    //查看所有的当前老师teahcerid 的 appointment  预约信息
    List<Appointment> selappointmentbyTeacherId2(Integer teacherId, Date date1, Date date2);
}
