package cn.project.yoga.dao;

import cn.project.yoga.pojo.*;

import cn.project.yoga.vo.*;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Collection;
import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    @Select("select * from user where user_name=#{userName}")
    User selectUserByUserName(String userName);

    /**
     * 修改个人信息
     *
     * @param user
     * @return
     */
    @Update("update user set  phone_number=#{phoneNumber} where user_id=#{0}")
    int updateUserInfo1(User user);

    /**
     * 修改个人信息状态
     * @param state
     * @return 影响行数
     */
    @Update("update user set info_state=#{0} and flag=0")
    int updateInfostate1(String state);

    /**
     * 根据场馆id和用户id查询是不是当前场馆的会员
     * @param user_id
     * @param venue_id
     * @return
     */
    @Select("select * from vip_crcord where user_id=#{0} and venue_id=#{1} and flag=0")
    Vip_record queryVip1(@Param("user_id") int user_id, @Param("venue_id") int venue_id);

    /**
     * 查看所有的朋友圈动态
     */
    @Select("select * from moments_stu")
    List<StuMoment> allMoments2();

    @Insert("insert into user_info(user_id) values((select user_id from user where user_name=#{0})) ")
    int insertIntoUser(String username);

    @Select("select * from user_info where user_id=#{0}")
    User_info selUserLoveName(Integer userId);

    /**
     * zjl
     * 根据用户名,查询用户id
     */
    @Select("select user_id from user where user_name=#{0} and flag =0")
    int selUserIdByName4_1(String uname);

    /**
     * 查询所有可加入的场馆的图片，名字、地址
     * @return
     */
    @Select("select * from venue where auth_state=0 and flag=0")
    List<Venue> queryVenues();

    @Select("select * from vip_type where venue_id=#{venueId} and flag=0")
    List<Vip_type> selShowVipType(Integer venueId);

    @Select("select * from vip_type where vip_type_id=#{vipTypeId}")
    Vip_type selVipTypeById(Integer vipTypeId);

    @Insert("insert into vip_record values(default,#{vipType.vipTypeId},#{userId},#{updateTime},default,#{registTime})")
    int insertVipRecord(Vip_record vip_record);

    @Update("update user_info set balance=balance-#{cardPrice} where user_id=#{userId}")
    int updateMyMoney(@Param("userId") int userId,@Param("cardPrice") Integer cardPrice);

    @Select("select balance from user_info where user_id=#{0}")
    int selBalanceByUserId(int userId);

    @Select("select * from vip_record where user_id=#{userId} and flag=0 and update_time>#{date} and vip_type_id in(select vip_type_id from vip_type where venue_id=#{venueId})")
    Vip_record selVipRecord(@Param("userId") int userId,@Param("venueId") Integer venueId,@Param("date") Long date);

    @Select("select u_id from user_info where user_id=#{userId}")
    int selUidByUserId(int userId);

    @Select("select * from myvenue where user_id=#{uId} and update_time>#{date}")
    List<MyVenueVo> selMyVipRecord(@Param("uId") int uId,@Param("date") long date);

    @Select("select * from teacher where if_auth=0 and flag=0")
    List<Teacher> selAllCoach();

    /**
     * 用来查当前登录用户所关注的其他人
     */
    @Select("SELECT t.* FROM `user_detail` t WHERE t.user_id IN (SELECT follow_id FROM attention WHERE user_id=#{0})")
    List<Detail> selectMyFollowedStuByCurrentUserId2(Integer currentUserId);

    /**
     * 根据登录的用户id查询学员
     * @param userId
     * @return
     */
    @Select("select * from user_info where user_id=#{userId}")
    User_info selectUserByItsUserId2(Integer userId);

    /**
     * 输入自己当前登录id以及对象的id，看自己是否已经关注了这个人
     * @param currentUserId
     * @param userId
     * @return
     */
    @Select("select * from attention where user_id=#{currentUserId} and follow_id=#{userId}")
    Attention hasIfollowedThis2(Integer currentUserId, Integer userId);

    /**
     * 关注
     * @param currentUserId 当前session中登录的用户id
     * @param targetUserId  目标用户id
     * @return
     */
    @Insert("insert into attention(user_id,follow_id) values(#{currentUserId},#{targetUserId})")
    int doFollow2(Integer currentUserId, Integer targetUserId);

    /**
     * 取关
     * @param currentUserId
     * @param targetUserId
     * @return
     */
    @Delete("delete from attention where user_id=#{currentUserId} and follow_id=#{targetUserId}")
    int cancleFollow2(Integer currentUserId, Integer targetUserId);


    @Select("select user_id from user where user_name=#{0}")
    Integer selUserIdByUserName(String userName);

    /**
     * 已关注的所有学院动态
     * @param currentUserId
     * @return
     */
    @Select("select * from moments_stu where id in (select follow_id from attention where user_id=#{currentUserId})")
    List<StuMoment> onlyFollowedMoments2(Integer currentUserId);

    @Select("select venue.venue_name,venue_teacher.venue_id from venue,venue_teacher where venue.venue_id=venue_teacher.venue_id AND venue_teacher.teacher_id=#{teacherId}")
    List<TeacherVenueVo> selTeacherVenue(Integer teacherId);

    @Select("select * from myself_course where teacher_id=#{teacherId} and ((#{beginTime} between start and end) or (#{overTime} between start and end)) and state=0 and flag=0")
    List<Myself_course> selTeacherTime(@Param("teacherId") int teacherId,@Param("beginTime") Timestamp beginTime,@Param("overTime") Timestamp overTime);



    @Insert("insert into myself_course values(default,#{u_id},#{teacherId},#{venueId},#{beginTime},#{overTime},default,default)")
    int insertSelfCourse(@Param("beginTime") Timestamp beginTime,@Param("overTime") Timestamp overTime,@Param("teacherId") int teacherId,@Param("venueId") int venueId, @Param("u_id") int u_id);

    @Select("select * from selfCourse where u_id=#{uId} ")
    List<SelfCourseVo> selMyselfCourse(int uId);

    @Select("select * from selfCourse where u_id=#{uId} and state=0 order by start desc limit 0,1")
    List<SelfCourseVo> selMyselfCourseII(int uId);

    @Select("select * from venueTalk order by f_time desc")
    List<VenueTalk> venueSpeak();
    @Select("select * from teacherTalk order by f_time desc")
    List<teacherTalk> teacherSpeak();

    @Select("select * from allCourse where  venue_id=#{venueId}")
    List<allCourseVo> allCourse(@Param("timestamp") Timestamp timestamp, @Param("venueId") Integer venueId);

    @Insert("insert into my_course values(default,#{courseId},#{userId},default,default) ")
    int addCourse(@Param("courseId") Integer courseId,@Param("userId") Integer userId);

    @Select("select course_money from course where course_id=#{courseId}")
    int selCourseMoneyByCourseId(Integer courseId);

    @Select("select count(*) from my_course where course_id=#{courseId} and if_cancle=0 and if_finish=0")
    int selCourseCountByCourseId(Integer courseId);

    @Select("select course_people from course where course_id=#{courseId} ")
    int selCanCountByCourseId(Integer courseId);

    @Select("select * from mycourse where user_id=#{u_id}")
    List<MyCourseVo> selMyCourse(int u_id);
}