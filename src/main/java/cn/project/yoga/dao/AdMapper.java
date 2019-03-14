package cn.project.yoga.dao;

import cn.project.yoga.pojo.Ad;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface AdMapper {
    int deleteByPrimaryKey(Integer adId);

    int insert(Ad record);

    int insertSelective(Ad record);

    Ad selectByPrimaryKey(Integer adId);

    int updateByPrimaryKeySelective(Ad record);

    int updateByPrimaryKey(Ad record);

    /**  zjl
     * 模糊查询 + 分页 + 已认证或者未认证查询
     * */
    @Select("<script>"+
    "select * from ad"+
     "<where>"+
            "<if test='adtitle !=null and \"\"!=adtitle'>"+
            "and ad_title like '%' #{adtitle} '%'"+
            "</if>"+
            "<if test='datas ==0 '>"+
            "and examine=#{datas}"+
            "</if>"+
            "<if test='datas ==1 '>"+
            "and examine=#{datas}"+
            "</if>"+
            "</where>"+
    "</script>")
    List<Ad> selAllAdBylimitAndPage(@Param("currentPage") Integer currentPage, @Param("pageSize") Integer pageSize,@Param("datas") Integer datas, @Param("adtitle") String adtitle);

    /**  zjl
     * 根据广告id , 更改广告认证
     *
     * */
    @Update("update ad set examine =#{val} where ad_id=#{daId}")
    int updateStateByAdid(@Param("daId") Integer daId,@Param("val") Integer val);

    /** zjl
     * 获取最新的三条广告信息
     * */
    @Select("select * from ad ORDER BY ad_time desc limit 0,3")
    List<Ad> selthreeads();
}