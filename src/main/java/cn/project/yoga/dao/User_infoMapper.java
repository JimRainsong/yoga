package cn.project.yoga.dao;

import cn.project.yoga.pojo.User_info;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

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

    /*
     *分页 查询学员所有信息*/
    @Select("select * from user_info where flag=0 ")
    public List<User_info> SelUser4(Integer currentPage, Integer pageSize);



    /*
     * 根据学员ID查询信息*/
    @Select("select * from user_info where flag=0 and u_id=#{uId}")
    public User_info SelUserById(int uId);

    /*
     * 动态查询学员*/
    @Select("<script>"  +
            "  select * from user_info"+
            " <where>"  +
            " <if test='netName != null and netName!=\"\" '>"  +
            "  and net_name like concat('%', #{netName}, '%')"+
            " </if>" +
            " <if test='sex != null and sex!=\"\" '>" +
            " and sex like concat('%', #{sex}, '%')" +
            " </if>" +
            "<if test='phoneNumber !=null and phoneNumber !=\"\" '>" +
            "and phone_number = #{phoneNumber}" +
            "</if>" +
            "<if test='qq !=null and qq!=\"\" '>"+
            "and qq = #{qq}"+
            "</if>" +
            " </where>" +
            " </script>")
    public List<User_info> shearch(@Param("netName") String netName, @Param("sex") String sex,
                                   @Param("phoneNumber") String phoneNumber, @Param("qq") String qq,Integer currentPage,Integer pageSize);


    /*
     * 根据ID软删除学员*/
    @Update("update user_info set flag=1 where u_id=#{uId}")
    public int DelUserById4(int uId);

}