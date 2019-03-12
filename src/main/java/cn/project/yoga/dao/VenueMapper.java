package cn.project.yoga.dao;

import cn.project.yoga.pojo.Venue;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface VenueMapper {
    int deleteByPrimaryKey(Integer venueId);

    int insert(Venue record);

    int insertSelective(Venue record);

    Venue selectByPrimaryKey(Integer venueId);

    int updateByPrimaryKeySelective(Venue record);

    int updateByPrimaryKey(Venue record);

    /**
     * 查询所有认证通过的场馆
     * @author zjn
     * @return
     */
    @Select("select * from venue where flag=0 and auth_state=0")
    List<Venue> selectAllVenue4();

    /**
     * 查询所有场馆
     * @author zjn
     * @param user_id
     * @return
     */
    @Select("select * from venue where venue_id in (select venue_id from vip_type where vip_type_id in (select vip_type_id from vip_record where user_id=#{0}))")
    List<Venue> selectMyVenue4(int user_id);
}