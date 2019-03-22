package cn.project.yoga;

import cn.project.yoga.dao.UserMapper;
import cn.project.yoga.utils.Md5Encoder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class YogaApplicationTests {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void contextLoads() {
        System.out.println(Md5Encoder.md5Encode("coach", "123"));
    }

}
