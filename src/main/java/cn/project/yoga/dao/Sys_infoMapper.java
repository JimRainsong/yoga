package cn.project.yoga.dao;

import cn.project.yoga.pojo.Sys_info;

public interface Sys_infoMapper {
    int deleteByPrimaryKey(Integer sysInfoId);

    int insert(Sys_info record);

    int insertSelective(Sys_info record);

    Sys_info selectByPrimaryKey(Integer sysInfoId);

    int updateByPrimaryKeySelective(Sys_info record);

    int updateByPrimaryKey(Sys_info record);
}