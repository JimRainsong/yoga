package cn.project.yoga.dao;

import cn.project.yoga.pojo.Course;
import cn.project.yoga.vo.CourseVo;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

public interface CourseMapper {
    int deleteByPrimaryKey(Integer courseId);

    int insert(Course record);

    int insertSelective(Course record);

    Course selectByPrimaryKey(Integer courseId);

    int updateByPrimaryKeySelective(Course record);

    int updateByPrimaryKey(Course record);/*
    c.*,t.teacher_id as teacherId*/


   /*  <if test="vo.begin != null">
                <if test="vo.end != null">
    and e.hiredate between #{vo.begin} and #{vo.end}
                </if>
                <if test="vo.end == null">

    and e.hiredate <![CDATA[ >= ]]> #{vo.begin}
                </if>
            </if>
            <if test="vo.begin == null">
                <if test="vo.end != null">
    and e.hiredate <![CDATA[ <= ]]> #{vo.end}
                </if>
            </if>*/


    @Select("<script>"+
            "select course_id as courseId,venue_id,t.teacher_id as teacherId,start_time,over_time,course_money,course_people,co.flag,course_name from course as co,teacher as t " +
            "<where>"+
            "co.teacher_id=t.teacher_id " +
          "<if test=' courseVo.cname!=null and  \"\"!=courseVo.cname'>" +
            "and course_name like '%' #{courseVo.cname} '%'"+
            "</if>"+
          "<if test=' courseVo.tname!=null and  \"\"!=courseVo.tname'>" +
            "and teacher_name like '%' #{courseVo.tname} '%'"+
            "</if>"+
            "<if test='courseVo.maxTime !=null'>" +
            "<if test='courseVo.minTime !=null '>" +
            "and start_time between #{courseVo.maxTime} and #{courseVo.minTime}"+
            "</if>"+
            "<if test='courseVo.minTime == null'>"+
            "and start_time <![CDATA[ >= ]]> #{courseVo.maxTime}"+
            "</if>"+
            "</if>"+
            "<if test='courseVo.maxTime == null'>"+
            "<if test='courseVo.minTime != null'>"+
            "and start_time <![CDATA[ <= ]]> #{courseVo.minTime}"+
            "</if>"+
            "</if>"+
            "</where>" +
            "and co.flag=0 and venue_id=#{courseVo.vid}"+
            "</script>")
    @Results({
            @Result(column="teacherId",property="teacher",
                    one=@One(select="cn.project.yoga.dao.TeacherMapper.selByTeacherId")
            ),
            @Result(column = "courseId",property = "myCourses",
                    many=@Many(select = "cn.project.yoga.dao.My_courseMapper.selMyCourseByCid")
            ),
            @Result(column = "courseId",property = "courseId"),

    })
    List<Course> selCourse(@Param("courseVo")CourseVo courseVo,@Param("currentPage")Integer currentPage, @Param("pageSize")Integer pageSize);


    @Select("SELECT * FROM course WHERE teacher_id=#{tid} and  venue_id=#{vid} and #{startTime}  between start_time and over_time  ")
    List<Course> selCourseByStartTime(@Param("tid")int tid, @Param("vid") int vid, @Param("startTime") Date startTime);
}