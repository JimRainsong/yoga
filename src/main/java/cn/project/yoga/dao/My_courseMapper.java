package cn.project.yoga.dao;

import cn.project.yoga.pojo.My_course;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface My_courseMapper {
    int deleteByPrimaryKey(Integer myCourseId);

    int insert(My_course record);

    int insertSelective(My_course record);

    My_course selectByPrimaryKey(Integer myCourseId);

    int updateByPrimaryKeySelective(My_course record);

    int updateByPrimaryKey(My_course record);

    @Select("SELECT * FROM `my_course` WHERE course_id=#{cid}")
    List<My_course> selMyCourseByCid(int cid);
}