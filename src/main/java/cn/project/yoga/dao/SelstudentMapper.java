package cn.project.yoga.dao;

import cn.project.yoga.pojo.Selstudent;
import cn.project.yoga.pojo.Vip_record;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SelstudentMapper {
    int insert(Selstudent record);

    int insertSelective(Selstudent record);

    /**
     * 模糊查询学生
     * 场馆-cjm
     * @param selstudent
     * @param currentPage
     * @param pageSize
     * @return
     */
    @Select({"<script>",
            "select * from selstudent where flag1=0 and flag2=0 and flag3=0 and venue_id=#{selstudent.venueId}",
            "<if test='selstudent.netName !=null'> and net_name like concat('%','${selstudent.netName}','%')</if>",
            "</script>"})
    List<Selstudent> selStudentByStudentName3(Selstudent selstudent, Integer currentPage, Integer pageSize);

}