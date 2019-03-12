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

    /** zjl
     * 查询所有未认证的场馆*/
    @Select("select * from venue where auth_state !=0")
    List<Venue> selAllVenues4_1(@Param("currentPage") Integer currentPage, @Param("pageSize") Integer pageSize);

    /** zjl
     * 根据场馆id 更改认证状态
     * */
    @Update("update venue set auth_state =#{val} where venue_id =#{venueId}")
    int upApproveByvenueId(@Param("venueId") Integer venueId, @Param("val") Integer val);

    List<Venue> selectMyVen1(int user_id);
}