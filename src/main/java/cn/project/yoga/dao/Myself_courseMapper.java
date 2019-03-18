package cn.project.yoga.dao;

import cn.project.yoga.pojo.Myself_course;
import org.apache.ibatis.annotations.Update;

public interface Myself_courseMapper {
    int deleteByPrimaryKey(Integer myselfCourseId);

    int insert(Myself_course record);

    int insertSelective(Myself_course record);

    Myself_course selectByPrimaryKey(Integer myselfCourseId);

    int updateByPrimaryKeySelective(Myself_course record);

    int updateByPrimaryKey(Myself_course record);

    @Update("update myself_course set state = 0 where myself_course_id = #{0}")
    int acceptCoursebyId(Integer id);

    @Update("update myself_course set state = 2 where myself_course_id = #{0}")
    int refuseCoursebyId(Integer id);
}