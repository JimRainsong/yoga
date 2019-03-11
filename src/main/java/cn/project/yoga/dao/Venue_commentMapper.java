package cn.project.yoga.dao;

import cn.project.yoga.pojo.Venue_comment;

public interface Venue_commentMapper {
    int deleteByPrimaryKey(Integer commentId);

    int insert(Venue_comment record);

    int insertSelective(Venue_comment record);

    Venue_comment selectByPrimaryKey(Integer commentId);

    int updateByPrimaryKeySelective(Venue_comment record);

    int updateByPrimaryKey(Venue_comment record);
}