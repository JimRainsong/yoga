package cn.project.yoga.dao;

import cn.project.yoga.pojo.Vip_record;

public interface Vip_recordMapper {
    //添加会员记录

    int addVipRecord(Vip_record vip_record);

    int deleteByPrimaryKey(Integer vipId);

    int insert(Vip_record record);

    int insertSelective(Vip_record record);

    Vip_record selectByPrimaryKey(Integer vipId);

    int updateByPrimaryKeySelective(Vip_record record);

    int updateByPrimaryKey(Vip_record record);
}