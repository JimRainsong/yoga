package cn.project.yoga.service.impl;

import cn.project.yoga.dao.AdMapper;
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

    @Autowired
    private AdMapper adMapper;

    /**
     * 通过用户名查密码
     * @param userName
     * @return
     */
    @Override
    public User selectUserByUserName(String userName) {
        return userMapper.selectUserByUserName(userName);
    }

    /**
     * 修改用户信息
     * @author zjn
     * @param user
     * @return  int 影响行数
     */
    @Override
    public String updateUserInfo1(User user) {
        int row = userMapper.updateUserInfo1(user);
        if (row==1){
            return "修改信息成功";
        }
        return "修改信息失败";
    }

    /**
     * 查询我的场馆
     * @param user_id
     * @return
     */
    @Override
    public List<Venue> selectMyVenue1(int user_id) {
        List<Venue> venues=venueMapper.selectMyVen1(user_id);
        return venues;
    }

    /**
     *购买会员卡
     * @param user_id 用户id
     * @param venue_id 场馆id
     * @param vip_type_id  会员卡类型id
     * @return  返回状态，购买成功、失败
     */
    @Override
    public String buyVipCard1(int user_id, int vip_type_id, int venue_id) {
        return null;
    }

    /**
     * 查询我的私教
     * @param user_id
     * @return
     */
    @Override
    public List<Myself_course> selectMySelfCourse1(int user_id) {
        return null;
    }

    /**
     * 查询我报名的课程
     * @param user_id
     * @return
     */
    @Override
    public List<My_course> selectMyCourse1(int user_id) {
        return null;
    }

    /**
     * 查询所有的（前十条）广告
     * @return 广告集合
     */
    @Override
    public List<Attention> selectAllAttention1() {
        return null;
    }

    /**
     * 查询场馆的所有课程，开课时间必须是现在的时间之后
     * @return 课程的集合
     */
    @Override
    public List<Course> venueCourse1(int venue_id) {
        return null;
    }

    /**
     * 报名课程
     * @param user_id
     * @param course_id
     * @return 状态：是否进入该课程成功
     */
    @Override
    public String intoCourse1(int user_id, int course_id,int venue_id) {
        //1.判断是不是该场馆会员，如果不是，返回‘您还不是此场馆会员’
        Vip_record vip_record=userMapper.queryVip1(user_id,venue_id);
        if (vip_record==null){
            return "您还不是该场馆会员，无法预约";
        }
        //2.向我的课程表中插入用户id和课程id


        return "预约成功，请等待教练确认";
    }


    /**
     * 预约私教
     * @param user_id
     * @param teacher_id
     * @return 状态，是否预约成功
     */
    @Override
    public String orderSelfCourse1(int user_id, int teacher_id, int venue_id) {
        return null;
    }

    /**
     * 添加关注
     * @param user_id
     * @param other_user_id
     * @return
     */
    @Override
    public String foucusOnOthers(int user_id, int other_user_id) {
        int row = userMapper.insertIntoAttention(user_id,other_user_id);
        if (row==0){
            return "关注失败";
        }
        return "关注成功";
    }

    @Override
    public List<Ad> selectAd() {
        List<Ad> ad=adMapper.selectAllAd1();
        return ad;
    }
}
