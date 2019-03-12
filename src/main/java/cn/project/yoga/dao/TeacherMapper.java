package cn.project.yoga.dao;

import cn.project.yoga.pojo.Teacher;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

public interface TeacherMapper {
    int deleteByPrimaryKey(Integer teacherId);

    int insert(Teacher record);

    int insertSelective(Teacher record);

    Teacher selectByPrimaryKey(Integer teacherId);

    int updateByPrimaryKeySelective(Teacher record);

    int updateByPrimaryKey(Teacher record);

    @Insert("insert into teacher (user_id) values((select user_id from user where user_name=#{username})) ")
    int insert_userid_teacher2(@Param("username") String username);
}