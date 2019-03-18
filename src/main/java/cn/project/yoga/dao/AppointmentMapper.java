package cn.project.yoga.dao;

import cn.project.yoga.pojo.Appointment;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

public interface AppointmentMapper {


    @Select("select * from appointment where t_id = #{teacherId} and start_time between #{date1} and #{date2}")
    List<Appointment> selappointmentbyteacherId2(@Param("teacherId") Integer teacherId, @Param("date1") Date date1,@Param("date2") Date date2);
}
