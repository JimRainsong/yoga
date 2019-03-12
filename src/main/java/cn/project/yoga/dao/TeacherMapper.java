package cn.project.yoga.dao;

import cn.project.yoga.pojo.Teacher;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface TeacherMapper {
    int deleteByPrimaryKey(Integer teacherId);

    int insert(Teacher record);

    int insertSelective(Teacher record);

    Teacher selectByPrimaryKey(Integer teacherId);

    int updateByPrimaryKeySelective(Teacher record);

    int updateByPrimaryKey(Teacher record);

    @Insert("insert into teacher (user_id) values((select user_id from user where user_name=#{username})) ")
    int insert_userid_teacher2(@Param("username") String username);

    /** zjl
     * 根据名字动态模糊查询,所有未认证的教练信息*/
    @Select("<script>"+
            "select * from teacher"+
            "<where>"+
            "<if test='teacherName !=null and  \"\"!=teacherName'>" +
            "and teacher_name like '%' #{teacherName} '%'"+
            "</if>"+
            "and if_auth !=0"+
            "</where>" +
            "</script>")
    List<Teacher> selAllTeacherByName4_1(@Param("currentPage") Integer currentPage,@Param("pageSize") Integer pageSize,@Param("teacherName") String teacherName);

    /** zjl
     * 根据教练的id , 修改教练的认证信息
     * */
    @Update("update teacher set if_auth =#{val} where teacher_id=#{teacherId}")
    int updateTeacherIf_authById(@Param("teacherId") Integer teacherId,@Param("val") Integer val);
}