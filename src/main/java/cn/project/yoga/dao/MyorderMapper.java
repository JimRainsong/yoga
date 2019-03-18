package cn.project.yoga.dao;

import cn.project.yoga.pojo.Myorder;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MyorderMapper {
    int deleteByPrimaryKey(Integer orderId);

    int insert(Myorder record);

    int insertSelective(Myorder record);

    Myorder selectByPrimaryKey(Integer orderId);

    int updateByPrimaryKeySelective(Myorder record);

    int updateByPrimaryKey(Myorder record);

    /**     zjl
     * 根据用户id,查询用户订单
     *
     * */
    @Select("select * from myorder where user_id=#{0}")
    List<Myorder> selAllOrderByUserId4_1(int uid);

    /** zjl
     *  根据商品id,查商品名称
     * */
    @Select("select g_name from goods where g_id=#{0}")
    String selGnameBygid4_1(Integer goodsId);
}