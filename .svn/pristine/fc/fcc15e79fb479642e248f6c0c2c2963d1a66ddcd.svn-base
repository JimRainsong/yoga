package cn.project.yoga.dao;

import cn.project.yoga.pojo.User;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    @Select("select user_id,user_name,password from user where user_name=#{userName} and flag=0")
    User selectUserByUserName(String userName);
}