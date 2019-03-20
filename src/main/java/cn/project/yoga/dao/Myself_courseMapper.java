package cn.project.yoga.dao;

import cn.project.yoga.pojo.Myself_course;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.Date;

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


    @Select("select start from myself_course where myself_course_id = #{0}")
    Date selectStart(Integer id);
    @Select("select end from myself_course where myself_course_id = #{0}")
    Date selectEnd(Integer id);


    @Update("update myself_course set state = '-1' where (start between #{start} and #{end} or end between #{start} and #{end}) and state <> 2")
    int conflict(@Param("start") Date start, @Param("end")Date end);
}