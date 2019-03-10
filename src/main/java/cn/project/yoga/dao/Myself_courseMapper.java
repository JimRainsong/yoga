package cn.project.yoga.dao;

import cn.project.yoga.pojo.Myself_course;

public interface Myself_courseMapper {
    int deleteByPrimaryKey(Integer myselfCourseId);

    int insert(Myself_course record);

    int insertSelective(Myself_course record);

    Myself_course selectByPrimaryKey(Integer myselfCourseId);

    int updateByPrimaryKeySelective(Myself_course record);

    int updateByPrimaryKey(Myself_course record);
}