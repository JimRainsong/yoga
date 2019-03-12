package cn.project.yoga.dao;

import cn.project.yoga.pojo.Moment;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MomentMapper {
    public List<Moment> selectMomentsByCurrentUserId2(Integer currentUserId);

    @Select("select * from moments")
    public List<Moment> allMoments2();
}
