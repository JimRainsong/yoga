package cn.project.yoga.dao;

import cn.project.yoga.pojo.*;
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

    /*
     *查询所有场馆信息
     */
    @Select("select * from venue where flag=0")
    public List<Venue> SelVen(Integer currentPage,Integer pageSize);

    /*
    软删除场馆
     */
    @Update("update venue set flag=1 where venue_id=#{venue_id}")
    public int DelVen4(int venue_id);

    /*
     * 根据ID查询场馆*/
    @Select("select * from venue where flag=0 and venue_id=#{venueId}")
    public Venue SelVenById4(int venueId);

    /*
     * 查询场馆数量*/
    @Select("select count(*) from venue where flag=0")
    public int SelVenNum();

    /**
     * 分页查询所有认证通过的场馆
     * @return
     * @author zjn
     */
    @Select("select * from venue where flag=0 and auth_state=0 limit #{lim},4")
    List<Venue> selectAllVenue4(int lim);

    /*
     * 动态查询学员*/
    @Select("<script>" +
            "  select * from venue" +
            " <where>" +
            " <if test='venname != null and venname!=\"\" '>" +
            "  and venue_name like concat('%', #{venname}, '%')" +
            " </if>" +
            " <if test='addrass != null and addrass!=\"\" '>" +
            " and venue_address like concat('%', #{addrass}, '%')" +
            " </if>" +
            "<if test='phone !=null and phone !=\"\" '>" +
            "and venue_phone = #{phone}" +
            "</if>" +
            "<if test='qq !=null and qq!=\"\" '>" +
            "and qq = #{qq}" +
            "</if>" +
            "and auth_state=0" + "\n" +
            "and flag=0" +
            " </where>" +
            " </script>")
    public List<Venue> shearch(@Param("venname") String venname,@Param("addrass") String addrass,
                               @Param("phone") String phone,@Param("qq") String qq,Integer currentPage,Integer pageSize);

    @Select("select * from venue where user_id=#{userId} and flag=0")
    Venue selvenueByUserId(User user);
    /**
     * 用来查当前登录用户所关注的其他人
     */
    @Select("SELECT t.* FROM `venue_detail` t WHERE t.user_id IN (SELECT follow_id FROM attention WHERE user_id=#{0})")
    List<Detail> selectMyFollowedVenByCurrentUserId(Integer currentUserId);
}