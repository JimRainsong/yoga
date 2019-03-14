package cn.project.yoga;

import cn.project.yoga.dao.TeacherMapper;
import cn.project.yoga.dao.Venue_teacherMapper;
import cn.project.yoga.dao.Vip_typeMapper;
import cn.project.yoga.pojo.Teacher;
import cn.project.yoga.pojo.Venue_teacher;
import cn.project.yoga.pojo.Vip_type;
import cn.project.yoga.service.VenueService;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CYTest {

    @Autowired
    private Vip_typeMapper vipTypeMapper;

    @Autowired
    private VenueService venueService;

    @Autowired
    private Venue_teacherMapper venue_teacherMapper;

    @Autowired
    private TeacherMapper teacherMapper;

   /* @Autowired
    private VenueService venueService;*/

    @Test
    public void contextLoads() {
        /*venue_teacherMapper.selectTeachers(1,1,1,1);*/
        Venue_teacher venue_teacher=new Venue_teacher();
        venue_teacher.setVenueId(8);
        venue_teacher.setTeacherState(0);
        Teacher teacher=new Teacher();
        /*teacher.setTeacherSex("男");*/
        System.out.println(teacher);
        venue_teacher.setTeacher(teacher);
        List<Venue_teacher> list=venue_teacherMapper.selectTeachers(venue_teacher,1,1);
        System.out.println(list);
        /*System.out.println(teacherMapper.selByTeacherId(list.get(0).getTeacherId()));*/
    }

}
