package cn.project.yoga.dao;

import cn.project.yoga.pojo.Goods;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface GoodsMapper {
    int deleteByPrimaryKey(Integer gId);

    int insert(Goods record);

    int insertSelective(Goods record);

    Goods selectByPrimaryKey(Integer gId);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);

    /**  zjl 分页+模糊+动态sql 查询商品全部信息
     * */
    @Select("<script>"+
    "select * from goods"+
            "<where>"+
            "flag =0 "+
            "<if test='type ==0'>"+
            "and g_type='器械'"+
            "</if>"+
            "<if test='type==1'>"+
            "and g_type='食品'"+
            "</if>"+
            "<if test='goodsName !=null and \"\"!=goodsName'>"+
            "and g_name like '%' #{goodsName} '%'"+
            "</if>"+
            "</where>"+
            "</script>"
    )
    List<Goods> limitSelAllGoods(@Param("currentPage") Integer currentPage,@Param("pageSize") Integer pageSize,@Param("type") Integer type,@Param("goodsName") String goodsName);

    /** zjl
     *  根据商品id 删除商品 ,设falg 为1
     * */
    @Update("update goods set flag =1 where g_id=#{0}")
    int deletegoodsByGid4_1(Integer gId);
}