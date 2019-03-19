package cn.project.yoga.dao;

import cn.project.yoga.pojo.Venue_comment;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface Venue_commentMapper {
    int deleteByPrimaryKey(Integer commentId);

    int insert(Venue_comment record);

    int insertSelective(Venue_comment record);

    Venue_comment selectByPrimaryKey(Integer commentId);

    int updateByPrimaryKeySelective(Venue_comment record);

    int updateByPrimaryKey(Venue_comment record);

    @Select("<script>"+
            "SELECT comment_id,venue_id,u_id as uId,comment,comment_type,flag FROM venue_comment" +
            "<where>"+
            "flag=0 and venue_id=#{venueId}"+
            "<if test='commentType !=null and  \"\"!=commentType'>" +
            "and comment_type = #{commentType}"+
            "</if>"+
            "</where>" +
            "</script>")
    @Results({
            @Result(column="uId",property="userInfo",
                    one=@One(select="cn.project.yoga.dao.User_infoMapper.SelUserById")
            )
    })
    List<Venue_comment> selComent(@Param("commentType") String commentType, @Param("venueId") Integer venueId,@Param("currentPage")Integer currentPage,@Param("pageSize")Integer pageSize);
}