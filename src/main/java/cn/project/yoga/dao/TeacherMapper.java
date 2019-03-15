package cn.project.yoga.dao;

import cn.project.yoga.pojo.TeaMoment;
import cn.project.yoga.pojo.Teacher;
import cn.project.yoga.pojo.User_info;
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

    /**
     * zjl
     * 根据名字动态模糊查询,所有未认证的教练信息
     */
    @Select("<script>" +
            "select * from teacher" +
            "<where>" +
            "<if test='teacherName !=null and  \"\"!=teacherName'>" +
            "and teacher_name like '%' #{teacherName} '%'" +
            "</if>" +
            "and if_auth !=0" +
            "</where>" +
            "</script>")
    List<Teacher> selAllTeacherByName4_1(@Param("currentPage") Integer currentPage, @Param("pageSize") Integer pageSize, @Param("teacherName") String teacherName);

    /**
     * zjl
     * 根据教练的id , 修改教练的认证信息
     */
    @Update("update teacher set if_auth =#{val} where teacher_id=#{teacherId}")
    int updateTeacherIf_authById(@Param("teacherId") Integer teacherId, @Param("val") Integer val);

    /**
     * 根据用户名来查询账户余额，参数：用户名
     */
    @Select("select teacher_money from teacher where user_id=(select user_id from user where user_name=#{userName})")
    Double selectBalanceByTeacherName2(@Param("userName") String name);

    /**
     * 所有教练的动态
     */
    @Select("select * from moments_tea")
    List<TeaMoment> allMoments2();


    @Select("select * from teacher where teacher_id = #{teacherId} and flag=0")
    Teacher selByTeacherId(Integer teacherId);

    /**
     * 教练id查询教练名称
     *
     * @param teacherId
     * @return
     */
    @Select("select teacher_name from teacher where teacher_id=#{teacherId}")
    String selectTeacherNameByTeacherId2(Integer teacherId);

    /*
     * 分页查询所有教练信息*/
    @Select("select * from teacher where flag=0")
    public List<Teacher> showTea4(Integer currentPage,Integer pageSize);

    /*
     * 软删除教练*/
    @Update("update teacher set flag=1 where teacher_id=#{teacherId}")
    public int DelTea4(int teacherId);

    /*
     * 根据ID查教练信息*/
    @Select("select * from teacher where teacher_id=#{teacherId} and flag=0")
    public Teacher SelTeaById4(int teacherId);

    /*
     * 查询教练表有多少条数据*/
    @Select("SELECT  COUNT(*) FROM teacher WHERE flag=0")
    public int SelCountTea4();

    /*
     * 动态查询学员*/
    @Select("<script>"  +
            "  select * from teacher"+
            " <where>"  +
            " <if test='teachername != null and teachername!=\"\" '>"  +
            "  and teacher_name like concat('%', #{teachername}, '%')"+
            " </if>" +
            " <if test='teacherSex != null and teacherSex!=\"\" '>"  +
            "  and teacher_sex like concat('%', #{teacherSex}, '%')"+
            " </if>" +
            "<if test='teacherPhone !=null and teacherPhone !=\"\" '>" +
            "and teacher_phone = #{teacherPhone}" +
            "</if>" +
            "<if test='teacherQq !=null and teacherQq!=\"\" '>"+
            "and teacher_qq = #{teacherQq}"+
            "</if>" +
            " </where>" +
            " </script>")
    public List<Teacher> shearch(@Param("teachername") String teachername,@Param("teacherSex") String teacherSex,
                                   @Param("teacherPhone") String teacherPhone, @Param("teacherQq") String teacherQq);
}