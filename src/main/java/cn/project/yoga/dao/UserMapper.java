package cn.project.yoga.dao;

import cn.project.yoga.pojo.Friends;
import cn.project.yoga.pojo.User;
import org.apache.ibatis.annotations.Select;

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
}