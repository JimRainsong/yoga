package cn.project.yoga;

import cn.project.yoga.dao.CourseMapper;
import cn.project.yoga.dao.TeacherMapper;
import cn.project.yoga.dao.Venue_teacherMapper;
import cn.project.yoga.dao.Vip_typeMapper;
import cn.project.yoga.pojo.Teacher;
import cn.project.yoga.pojo.Venue_teacher;
import cn.project.yoga.pojo.Vip_type;
import cn.project.yoga.service.VenueService;
import cn.project.yoga.vo.CourseVo;
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

    @Autowired
    private CourseMapper courseMapper;
   /* @Autowired
    private VenueService venueService;*/

    @Test
    public void contextLoads() {
       CourseVo courseVo=new CourseVo(1,null,null,null,null);
        System.out.println(courseMapper.selCourse(courseVo,1,1));
    }

}
