package cn.project.yoga.dao;

import cn.project.yoga.pojo.Goods;
import org.apache.ibatis.annotations.Insert;
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

    /** zjl
     *  更改商品信息,包括图片
     *
     * */
    @Update("update goods set g_name=#{goods.gName},g_price=#{goods.gPrice},g_descrption=#{goods.gDescrption},g_img=#{goodsImgPath},g_stock=#{goods.gStock},g_type=#{goods.gType} where g_id=#{goods.gId}")
    int updategoods4_1(@Param("goods") Goods goods,@Param("goodsImgPath") String goodsImgPath);

    /** zjl
     *      添加商品
     * */
    @Insert("insert into goods(g_name,g_price,g_descrption,g_img,g_stock,g_type) values(#{gName1},#{gPrice1},#{gDescrption1},#{imgFile},#{gStock1},#{gtype1})")
    int addgoods4_1(@Param("gName1") String gName1,@Param("gPrice1") Integer gPrice1, @Param("gStock1")Integer gStock1,@Param("gDescrption1") String gDescrption1,@Param("gtype1")String gtype1,@Param("imgFile") String imgFile);

    /** zjl
     * 获取所有商品类型
     * */
    @Select("select distinct g_type from goods")
    List<String> selAllGoodsType4_1();
}