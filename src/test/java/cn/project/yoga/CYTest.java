package cn.project.yoga;

import cn.project.yoga.dao.*;
import cn.project.yoga.pojo.Ad;
import cn.project.yoga.pojo.Teacher;
import cn.project.yoga.pojo.User;
import cn.project.yoga.pojo.Venue_teacher;
import cn.project.yoga.pojo.Vip_type;
import cn.project.yoga.service.VenueService;
import cn.project.yoga.vo.CourseVo;
import com.github.pagehelper.PageInfo;
import javafx.scene.input.DataFormat;
import org.apache.shiro.SecurityUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.xml.crypto.Data;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    @Autowired
    private  Venue_commentMapper venueCommentMapper;
   /* @Autowired
    private VenueService venueService;*/

   @Autowired
   private AdMapper adMapper;
    @Test
    public void contextLoads() {
        System.out.println(venueCommentMapper.selComent("好评",17,1,10));
    }
}
