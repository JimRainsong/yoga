package cn.project.yoga;

import cn.project.yoga.dao.TeacherMapper;
import cn.project.yoga.dao.UserMapper;
import cn.project.yoga.dao.VenueMapper;
import cn.project.yoga.pojo.Selstudent;
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

    @Test
    public void contextLoads() {
        System.out.println(userMapper.hasIfollowedThis2(6, 8));
    }
}
