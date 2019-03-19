package cn.project.yoga.dao;

import cn.project.yoga.pojo.*;

import cn.project.yoga.vo.MyVenueVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.Date;
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
     * @return  影响行数
      */
    @Update("update user set info_state=#{0}")
    int updateInfostate1(String state);

    /**
     * 根据场馆id和用户id查询是不是当前场馆的会员
     * @param user_id
     * @param venue_id
     * @return
     */
    @Select("select * from vip_crcord where user_id=#{0} and venue_id=#{1}")
    Vip_record queryVip1(@Param("user_id") int user_id,@Param("venue_id") int venue_id);

    /**
     * 查看所有的朋友圈动态
     */
    @Select("select * from moments_stu")
    List<StuMoment> allMoments2();

    @Insert("insert into user_info(user_id) values((select user_id from user where user_name=#{0})) ")
    int insertIntoUser(String username);

    @Select("select * from user_info where user_id=#{0}")
    User_info selUserLoveName(Integer userId);

    /**   zjl
     *   根据用户名,查询用户id
     * */
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
}