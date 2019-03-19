package cn.project.yoga.dao;

import cn.project.yoga.pojo.Venue_teacher;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface Venue_teacherMapper {
    int deleteByPrimaryKey(Integer venueTeacherId);

    int insert(Venue_teacher record);

    int insertSelective(Venue_teacher record);

    Venue_teacher selectByPrimaryKey(Integer venueTeacherId);

    int updateByPrimaryKeySelective(Venue_teacher record);

    int updateByPrimaryKey(Venue_teacher record);

    /*
     * cy
     * 根据教练状态与id查找教练
     *
     * @param currentPage
     * @param pageSize
     * @param vid
     * @param teype
     * @return
     */
    @Select("<script>"+
            "select venue_teacher_id,venue_id,teacher_state,vt.flag,vt.teacher_id as teacherId from venue_teacher as vt,teacher as t " +
            "<where>"+
            "vt.teacher_id=t.teacher_id " +
            "<if test='venue_teacher.teacher.teacherName !=null and  \"\"!=venue_teacher.teacher.teacherName'>" +
            "and teacher_name like '%' #{venue_teacher.teacher.teacherName} '%'"+
            "</if>"+
            "<if test='venue_teacher.teacher.teacherSex !=null and  \"\"!=venue_teacher.teacher.teacherSex'>" +
            "and teacher_name = #{venue_teacher.teacher.teacherSex} "+
            "</if>"+
            "</where>" +
            "and t.flag=0 and teacher_state=#{venue_teacher.teacherState} and venue_id =#{venue_teacher.venueId}"+
            "</script>")
    @Results({

            @Result(column="teacherId",property="teacher",
                    one=@One(select="cn.project.yoga.dao.TeacherMapper.selByTeacherId")
            )
    })
    List<Venue_teacher> selectTeachers(@Param("venue_teacher")Venue_teacher venue_teacher,@Param("currentPage")Integer currentPage,@Param("pageSize")Integer pageSize);
    /**/

}