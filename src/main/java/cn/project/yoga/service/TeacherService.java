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




    Double selectBalanceByTeacherName2(String name);

    //通过用户名来获取 user表中 userid
    Integer selUserIdByUsername2(String userName);

    //通过user表中的userId 查询出 teacher表中 的teacher_id （因为以后后面的所有表都关联的是这个teacher_id）
    Integer selTeacherIdByUserId2(Integer userId);

    //查看所有的当前老师teahcerid 的 appointment  预约信息
    List<Appointment> selappointmentbyTeacherId2(Integer teacherId);
}
