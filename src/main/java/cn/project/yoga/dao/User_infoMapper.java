package cn.project.yoga.dao;

import cn.project.yoga.pojo.User_info;
import cn.project.yoga.pojo.User_infoWithBLOBs;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface User_infoMapper {
    int deleteByPrimaryKey(Integer infoId);

    int insert(User_infoWithBLOBs record);

    int insertSelective(User_infoWithBLOBs record);

    User_infoWithBLOBs selectByPrimaryKey(Integer infoId);

    int updateByPrimaryKeySelective(User_infoWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(User_infoWithBLOBs record);

    int updateByPrimaryKey(User_info record);

    /*获取会员表所有信息*/
    @Select("select * from user_info ")
    List<User_info> findAllMessage(@Param("currentPage") int nowpage, @Param("pageSize")int pageSize);
}