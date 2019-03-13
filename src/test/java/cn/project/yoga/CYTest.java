package cn.project.yoga;

import cn.project.yoga.dao.Vip_typeMapper;
import cn.project.yoga.pojo.Vip_type;
import cn.project.yoga.service.VenueService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CYTest {

    @Autowired
    private Vip_typeMapper vipTypeMapper;

    @Autowired
    private VenueService venueService;

    @Test
    public void contextLoads() {

        System.out.println(venueService.getVenueDataByVenueId(1).getVenueName());
    }

}
