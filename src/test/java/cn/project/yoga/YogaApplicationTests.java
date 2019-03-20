package cn.project.yoga;

import cn.project.yoga.dao.TeacherMapper;
import cn.project.yoga.dao.UserMapper;
import cn.project.yoga.dao.VenueMapper;
import cn.project.yoga.pojo.Selstudent;
import cn.project.yoga.pojo.Teacher;
import cn.project.yoga.pojo.Venue_teacher;
import cn.project.yoga.service.UserService;
import cn.project.yoga.service.VenueService;
import cn.project.yoga.utils.Md5Encoder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class YogaApplicationTests {
    @Autowired
    private TeacherMapper teacherMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private VenueMapper venueMapper;
    @Autowired
    private VenueService venueService;

    @Test
    public void contextLoads() {
        System.out.println(userMapper.hasIfollowedThis2(6, 8));
    }

    @Test
    public void ssa(){
        Venue_teacher venue_teacher=new Venue_teacher();
        venue_teacher.setVenueId(17);
        venue_teacher.setTeacherState(0);
        venue_teacher.setTeacher(new Teacher());
        System.out.println(venue_teacher);
        List<Venue_teacher> result=venueService.selTeacherName(venue_teacher);

    }
}
