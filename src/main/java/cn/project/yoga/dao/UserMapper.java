package cn.project.yoga.dao;

import cn.project.yoga.pojo.Friends;
import cn.project.yoga.pojo.User;
import cn.project.yoga.pojo.Vip_record;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    /**
     * 根据用户名查找用户对象,参数：用户名
     */
    @Select("select * from user where user_name=#{userName}")
    User selectUserByUserName2(String userName);

    /**
     * 查看所有朋友圈动态（无视是否关注）
     */
    @Select("select * from friends")
    List<Friends> allFriends2();

    @Select("select * from user where user_name=#{0} and flag=0")
    User selectUserByUserName(String userName);

    /**
     * 修改个人信息
     * @param user
     * @return
     */
    @Update("update user set phone_number=#{phoneNumber} where user_id=#{0}")
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
    Vip_record queryVip1(@Param("user_id") int user_id, @Param("venue_id") int venue_id);
}