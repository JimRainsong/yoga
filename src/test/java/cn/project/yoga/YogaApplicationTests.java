package cn.project.yoga;

import cn.project.yoga.dao.UserMapper;
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
    private UserService userService;
    @Autowired
    private VenueService venueService;
    @Autowired
    private UserMapper userMapper;

    @Test
    public void contextLoads() {
        Date d1 = new Date(20048L);
        Date d2 = new Date(20048L);
        System.out.println(d2.compareTo(d1));
    }
}
