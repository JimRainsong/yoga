package cn.project.yoga.dao;

import cn.project.yoga.pojo.User_info;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface User_infoMapper {
    int deleteByPrimaryKey(Integer uId);

    int insert(User_info record);

    int insertSelective(User_info record);

    User_info selectByPrimaryKey(Integer uId);

    int updateByPrimaryKeySelective(User_info record);

    int updateByPrimaryKey(User_info record);

    @Select("select * from user_info where user_id=#{0}")
    User_info selectByUserId(Integer userId);

    @Update("update user_info set balance=balance+#{balance},level=#{level},score=score+#{score},total_money=total_money+#{balance} where user_id=#{userId}")
    int recharge(User_info user_info);

    @Update("update user_info set head_img=#{source} where user_id=#{user_id}")
    int updateHeadImg(@Param("source") String source,@Param("user_id") Integer user_id);
}