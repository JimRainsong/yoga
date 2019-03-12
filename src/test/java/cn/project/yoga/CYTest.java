package cn.project.yoga;

import cn.project.yoga.dao.Vip_typeMapper;
import cn.project.yoga.pojo.Vip_type;
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

    @Test
    public void contextLoads() {
        Vip_type vipType=new Vip_type();
        vipType.setCardName("测试场馆");
        vipType.setCardInfo("It's a 会员卡");
        vipType.setCardPrice(200);
        System.out.println(vipTypeMapper.insertSelective(vipType));
    }

}
