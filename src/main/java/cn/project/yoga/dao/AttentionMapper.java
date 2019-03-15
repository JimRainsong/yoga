package cn.project.yoga.dao;

import cn.project.yoga.pojo.Attention;
import cn.project.yoga.pojo.User_info;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AttentionMapper {
    int deleteByPrimaryKey(Integer attentionId);

    int insert(Attention record);

    int insertSelective(Attention record);

    Attention selectByPrimaryKey(Integer attentionId);

    int updateByPrimaryKeySelective(Attention record);

    int updateByPrimaryKey(Attention record);

    /**
     * 查询对该场馆的的关注
     * 场馆-cjm
     * @param currentPage
     * @param pageSize
     * @param venueId
     * @return
     */
    @Select("SELECT user_info.* from user_info LEFT JOIN attention ON attention.user_id= user_info.user_id WHERE attention.follow_id=#{venueId} and attention.flag=0")
    List<User_info> selShowattention(Integer currentPage, Integer pageSize, Integer venueId);
}