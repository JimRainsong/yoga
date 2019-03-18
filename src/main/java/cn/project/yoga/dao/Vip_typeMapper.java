package cn.project.yoga.dao;

import cn.project.yoga.pojo.Vip_type;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface Vip_typeMapper {
    int deleteByPrimaryKey(Integer vipTypeId);

    int insert(Vip_type record);

    int insertSelective(Vip_type record);

    Vip_type selectByPrimaryKey(Integer vipTypeId);

    /**
     * 删除该场馆的对应vip类型
     * 场馆-cjm
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Vip_type record);

    int updateByPrimaryKey(Vip_type record);
    /*
     *展示会员卡类型
     * 场馆-cjm
     */
    @Select("select * from vip_type where venue_id=#{venueId} and flag=0")
    public List<Vip_type> selShowVipType(Integer currentPage, Integer pageSize, Integer venueId);
}