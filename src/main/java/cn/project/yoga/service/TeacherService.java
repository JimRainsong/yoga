package cn.project.yoga.service;

import cn.project.yoga.pojo.Appointment;
import cn.project.yoga.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface TeacherService {


    //注册 插入user信息
    int insertUser(User user1);

    //通过username查到 其在user表中的id  并将此id插入teacher表的user_id
    int insert_userid_teacher2(String username);


    int updateIfauthById4_1(Integer teacherId,Integer val);

    //查看所有的 appointment  预约信息
    List<Appointment> selappointmentbyTeachername(String name);

    Double selectBalanceByTeacherName2(String name);
}
