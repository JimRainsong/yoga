package cn.project.yoga.dao;

import cn.project.yoga.pojo.Ad;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AdMapper {
    int deleteByPrimaryKey(Integer adId);

    int insert(Ad record);

    int insertSelective(Ad record);

    Ad selectByPrimaryKey(Integer adId);

    int updateByPrimaryKeySelective(Ad record);

    int updateByPrimaryKey(Ad record);

    @Select("select * from ad where examine=0 and flag=0")
    List<Ad> selectAllAd1();
}