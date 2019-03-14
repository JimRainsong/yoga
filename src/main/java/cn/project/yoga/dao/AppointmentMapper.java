package cn.project.yoga.dao;

import cn.project.yoga.pojo.Appointment;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AppointmentMapper {


    @Select("select * from appointment where t_id = #{0}")
    List<Appointment> selappointmentbyteacherId2(Integer teacherId);
}
