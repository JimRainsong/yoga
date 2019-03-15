package cn.project.yoga.service;

import cn.project.yoga.pojo.TeaMoment;
import cn.project.yoga.pojo.TeacherInfo;
import cn.project.yoga.pojo.Teacher;
import cn.project.yoga.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

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

    TeacherInfo selectSingleTeacherByUserName2(String userName);

    /*
     * 分页查询所有教练信息*/
    public List<Teacher> showTea4(int lim);

    /*
     * 软删除教练*/
    public int DelTea4(int teacherId);

    /*
     * 根据ID查教练信息*/
    public Teacher SelTeaById4(int teacherId);

    /*
     * 查询教练表有多少条数据*/
     public int SelCountTea4();
}
