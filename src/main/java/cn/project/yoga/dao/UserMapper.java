package cn.project.yoga.dao;

import cn.project.yoga.pojo.User;

import cn.project.yoga.pojo.Vip_record;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    @Select("select * from user where userName=#{userName}")
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
    Vip_record queryVip1(@Param("user_id") int user_id,@Param("venue_id") int venue_id);

    /**
     * 关注其他用户
     * @param user_id  自己的id
     * @param other_user_id  其他人的id
     * @return  row 影响行数
     */
    @Insert("insert into attention values(default,#{0},#{1},default)")
    int insertIntoAttention(int user_id, int other_user_id);
}