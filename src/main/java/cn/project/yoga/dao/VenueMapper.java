package cn.project.yoga.dao;

import cn.project.yoga.pojo.VenMoment;
import cn.project.yoga.pojo.Venue;
import cn.project.yoga.pojo.Vip_type;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface VenueMapper {
    int deleteByPrimaryKey(Integer venueId);

    int insert(Venue record);

    int insertSelective(Venue record);

    /**
     * 查找场馆信息
     *
     * @param venueId
     * @return
     */
    Venue selectByPrimaryKey(Integer venueId);

    int updateByPrimaryKeySelective(Venue record);

    int updateByPrimaryKey(Venue record);

    /**
     * zjl    模糊查询
     * 查询所有未认证的场馆
     */
    @Select("<script>" +
            "select * from venue" +
            "<where>" +
            "<if test='venueName !=null and  \"\"!=venueName'>" +
            "and venue_name like '%' #{venueName} '%'" +
            "</if>" +
            "and auth_state !=0" +
            "</where>" +
            "</script>")
    List<Venue> selAllVenues4_1(@Param("currentPage") Integer currentPage, @Param("pageSize") Integer pageSize, @Param("venueName") String venueName);

    /**
     * zjl
     * 根据场馆id 更改认证状态
     */
    @Update("update venue set auth_state =#{val} where venue_id =#{venueId}")
    int upApproveByvenueId(@Param("venueId") Integer venueId, @Param("val") Integer val);

    List<Venue> selectMyVen1(int user_id);

    /**
     * 所有教练的动态
     */
    @Select("select * from moments_ven")
    List<VenMoment> allMoments2();


}