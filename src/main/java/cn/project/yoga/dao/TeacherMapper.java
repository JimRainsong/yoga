package cn.project.yoga.dao;

import cn.project.yoga.pojo.*;
import cn.project.yoga.vo.TeacherVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


import java.util.Collection;
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

    /**
     * 通过登录用户名查询教练对象
     *
     * @param userName
     * @return
     */
    @Select("select * from teacherInfo where user_name=#{userName}")
    TeacherInfo selectSingleTeacherByUserName(String userName);

    /**
     * 分页查询所有教练信息
     */
    @Select("select * from teacher where flag=0")
    public List<Teacher> showTea4(Integer currentPage, Integer pageSize);

    /**
     * 软删除教练
     */
    @Update("update teacher set flag=1 where teacher_id=#{teacherId}")
    public int DelTea4(int teacherId);

    /**
     * 根据ID查教练信息
     */
    @Select("select * from teacher where teacher_id=#{teacherId} and flag=0")
    public Teacher SelTeaById4(int teacherId);


    /**
     * 更新教练信息
     */
    @Update("update teacher set teacher_name=#{netName},teacher_phone=#{phone},teacher_qq=#{qq},teacher_idnum=#{idNum},real_name=#{realName},teacher_sex=#{sex},auth_info=#{authInfo} where teacher_id=#{tId}")
    int updateTeacher2(TeacherVo vo);

    /**
     * 教练端发布动态
     */
    @Insert("insert into friends(user_id,f_detail,f_time) values(#{id},#{detail},#{time})")
    int postNewMoment2(Moment moment);

    /**
     * 根据当前登录的教练的uid查询所在场馆
     */
    @Select("select v.* from venue v,venue_teacher t where v.venue_id=t.venue_id and t.teacher_id=#{tId}")
    Venue selectMyVenueByCurrentUserId2(Integer tId);

    /*
     * 动态查询教练*/
    @Select("<script>" +
            "  select * from teacher" +
            " <where>" +
            " <if test='teachername != null and teachername!=\"\" '>" +
            "  and teacher_name like concat('%', #{teachername}, '%')" +
            " </if>" +
            " <if test='teacherSex != null and teacherSex!=\"\" '>" +
            "  and teacher_sex like concat('%', #{teacherSex}, '%')" +
            " </if>" +
            "<if test='teacherPhone !=null and teacherPhone !=\"\" '>" +
            "and teacher_phone = #{teacherPhone}" +
            "</if>" +
            "<if test='teacherQq !=null and teacherQq!=\"\" '>" +
            "and teacher_qq = #{teacherQq}" +
            "</if>" +
            " </where>" +
            " </script>")
    public List<Teacher> shearch(@Param("teachername") String teachername, @Param("teacherSex") String teacherSex,
                                 @Param("teacherPhone") String teacherPhone, @Param("teacherQq") String teacherQq, Integer currentPage, Integer pageSize);

    /**
     * 注册后绑定用户_角色 id
     */
    @Insert("insert into user_role(user_id,role_id) values((select user_id from user where user_name=#{username}),2)")
    int connectRoleIdAndUserId2(String username);

    /**
     * 用来查当前登录用户所关注的其他人
     */
    @Select("SELECT t.* FROM `teacher_detail` t WHERE t.user_id IN (SELECT follow_id FROM attention WHERE user_id=#{0})")
    Collection<? extends Detail> selectMyFollowedTeaByCurrentUserId2(Integer currentUserId);


    /**
     * 根据登录id查询教练
     *
     * @param userId
     * @return
     */
    @Select("select * from teacherInfo where u_id=#{userId}")
    TeacherInfo selectTeacherByItsUserId2(Integer userId);

    /**
     * 查找自己已关注的教练动态
     *
     * @param currentUserId
     * @return
     */
    @Select("select * from moments_tea where id in (select follow_id from attention where user_id=#{currentUserId})")
    List<TeaMoment> onlyFollowedallMoments2(Integer currentUserId);
}