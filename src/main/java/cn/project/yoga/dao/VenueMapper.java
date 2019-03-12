package cn.project.yoga.dao;

import cn.project.yoga.pojo.Venue;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface VenueMapper {
    int deleteByPrimaryKey(Integer venueId);

    int insert(Venue record);

    int insertSelective(Venue record);

    Venue selectByPrimaryKey(Integer venueId);

    int updateByPrimaryKeySelective(Venue record);

    int updateByPrimaryKey(Venue record);

    /*查询场馆信息表所有未认证的信息*/
    @Select("select * from venue where auth_state !=0")
    List<Venue> selAllVenues4_1(@Param("currentPage")Integer currentPage,@Param("pageSize")Integer pageSize);

    /*根据场馆id 更新场馆认证状态*/
    @Update("update venue set auth_state =#{val} where venue_id =#{venueId}")
    int upApproveByvenueId(@Param("venueId") Integer venueId, @Param("val") Integer val);
}