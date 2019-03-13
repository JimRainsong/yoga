package cn.project.yoga.dao;

import cn.project.yoga.pojo.Selstudent;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SelstudentMapper {
    int insert(Selstudent record);

    int insertSelective(Selstudent record);
    /*
    * 展示所有学员
    *场馆-陈家明
    * */
    @Select("select * from selstudent where venueId = #{venueId} and flag=0")
    List<Selstudent> selectStudentByvenueId(Integer currentPage, Integer pageSize,Integer venueId);
}