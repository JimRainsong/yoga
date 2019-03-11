package cn.project.yoga.dao;

import cn.project.yoga.pojo.User_info;

public interface User_infoMapper {
    int deleteByPrimaryKey(Integer uId);

    int insert(User_info record);

    int insertSelective(User_info record);

    User_info selectByPrimaryKey(Integer uId);

    int updateByPrimaryKeySelective(User_info record);

    int updateByPrimaryKey(User_info record);
}