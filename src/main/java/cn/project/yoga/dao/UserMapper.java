package cn.project.yoga.dao;

import cn.project.yoga.pojo.*;

import org.apache.ibatis.annotations.*;

import java.util.Collection;
import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    @Select("select * from user where user_name=#{userName} and flag=0")
    User selectUserByUserName(String userName);

    /**
     * 修改个人信息
     *
     * @param user
     * @return
     */
    @Update("update user set  phone_number=#{phoneNumber} where user_id=#{0} and flag=0")
    int updateUserInfo1(User user);

    /**
     * 修改个人信息状态
     *
     * @param state
     * @return 影响行数
     */
    @Update("update user set info_state=#{0} and flag=0")
    int updateInfostate1(String state);

    /**
     * 根据场馆id和用户id查询是不是当前场馆的会员
     *
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

    /**
     * 已关注的所有学院动态
     * @param currentUserId
     * @return
     */
    @Select("select * from moments_stu where id in (select follow_id from attention where user_id=#{currentUserId})")
    List<StuMoment> onlyFollowedMoments2(Integer currentUserId);
}