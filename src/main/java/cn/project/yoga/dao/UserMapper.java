package cn.project.yoga.dao;

import cn.project.yoga.pojo.User;

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
    User selectUserByUserName4(String userName);

    /**
     * 修改个人信息
     * @param user
     * @return
     */
    @Update("update user set phone_number=#{phoneNumber}, where user_id=#{}")
    int updateUserInfo4(User user);

    /**
     * 修改个人信息状态
     * @param state
     * @return  影响行数
      */
    @Update("update user set info_state=#{0}")
    int updateInfostate(String state);
}