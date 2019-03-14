package cn.project.yoga.dao;

import cn.project.yoga.pojo.StuMoment;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MomentMapper {
    public List<StuMoment> selectMomentsByCurrentUserId2(Integer currentUserId);

    @Select("select * from moments")
    public List<StuMoment> allMoments2();
}
