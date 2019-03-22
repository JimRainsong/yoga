package cn.project.yoga.dao;

import cn.project.yoga.pojo.Friends;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface FriendsMapper {
    int deleteByPrimaryKey(Integer fId);

    int insert(Friends record);

    int insertSelective(Friends record);

    Friends selectByPrimaryKey(Integer fId);

    int updateByPrimaryKeySelective(Friends record);

    int updateByPrimaryKey(Friends record);

    @Select("SELECT * FROM friends WHERE user_id=#{uId} AND flag = 0 ORDER BY f_id DESC")
    List<Friends> selFriends(Integer uId);
}