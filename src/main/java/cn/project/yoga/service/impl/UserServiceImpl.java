package cn.project.yoga.service.impl;

import cn.project.yoga.dao.UserMapper;
import cn.project.yoga.dao.VenueMapper;
import cn.project.yoga.pojo.*;
import cn.project.yoga.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private VenueMapper venueMapper;

    @Override
    public User selectUserByUserName(String userName) {
        return userMapper.selectUserByUserName4(userName);
    }

    /**
     * 修改用户信息
     * @author zjn
     * @param user
     * @return  int 影响行数
     */
    @Override
    public String updateUserInfo(User user) {
        int row = userMapper.updateUserInfo4(user);
        if (row==1){
            return "修改状态成功";
        }
        return "修改状态失败";
    }

    /**
     * 查询我的场馆
     * @param user_id
     * @return
     */
    @Override
    public List<Venue> selectMyVenue4(int user_id) {
        List<Venue> venues=venueMapper.selectMyVenue4(user_id);
        return venues;
    }

    @Override
    public String buyVipCard(int user_id, int vip_type_id, int venue_id) {
        return null;
    }

    @Override
    public List<Myself_course> selectMySelfCourse(int user_id) {
        return null;
    }

    @Override
    public List<My_course> selectMyCourse(int user_id) {
        return null;
    }

    @Override
    public List<Attention> selectAllAttention() {
        return null;
    }

    @Override
    public List<Course> venueCourse(int venue_id) {
        return null;
    }

    @Override
    public String intoCourse(int user_id, int course_id,int venue_id) {
        //1.判断是不是该场馆会员，如果不是，返回‘您还不是此场馆会员’
        Vip_record vip_record=userMapper.queryVip(user_id,venue_id);
        if (vip_record==null){
            return "您还不是该场馆会员，无法预约";
        }
        //2.向我的课程表中插入用户id和课程id


        return null;
    }

    @Override
    public String orderSelfCourse(int user_id, int teacher_id, int venue_id) {
        return null;
    }
}
