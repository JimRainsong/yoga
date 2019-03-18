package cn.project.yoga.service.impl;

import cn.project.yoga.dao.AdMapper;
import cn.project.yoga.dao.UserMapper;
import cn.project.yoga.dao.User_infoMapper;
import cn.project.yoga.dao.VenueMapper;
import cn.project.yoga.pojo.*;
import cn.project.yoga.service.UserService;
import org.apache.shiro.SecurityUtils;
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

    @Autowired
    private User_infoMapper user_infoMapper;

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
    public String updateUserInfo1(User_info user) {

        //查user_id
        String userName= SecurityUtils.getSubject().getPrincipal().toString();
        if (userName==null){
            return "请先登录";
        }
        int userId=userMapper.selectUserByUserName(userName).getUserId();
        user.setUserId(userId);
        int row = user_infoMapper.updateByPrimaryKeySelective(user);
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

    @Override
    public String buyVipCard1(int user_id, int vip_type_id, int venue_id) {
        return null;
    }

    @Override
    public List<Myself_course> selectMySelfCourse1(int user_id) {
        return null;
    }

    @Override
    public List<My_course> selectMyCourse1(int user_id) {
        return null;
    }

    @Override
    public List<Attention> selectAllAttention1() {
        return null;
    }

    @Override
    public List<Course> venueCourse1(int venue_id) {
        return null;
    }

    @Override
    public String intoCourse1(int user_id, int course_id,int venue_id) {
        //1.判断是不是该场馆会员，如果不是，返回‘您还不是此场馆会员’
        Vip_record vip_record=userMapper.queryVip1(user_id,venue_id);
        if (vip_record==null){
            return "您还不是该场馆会员，无法预约";
        }
        //2.向我的课程表中插入用户id和课程id


        return null;
    }

    @Override
    public String orderSelfCourse1(int user_id, int teacher_id, int venue_id) {
        return null;
    }

    @Override
    public List<Ad> selectAd() {
        return adMapper.selectAllAd1();
    }

    @Override
    public int insert_userid_user(String username) {
        return userMapper.insertIntoUser(username);
    }

    @Override
    public List<StuMoment> allMoments2() {
        return userMapper.allMoments2();
    }

    @Override
    public String selectUserNetName(String userName) {
        User user=userMapper.selectUserByUserName(userName);
        User_info user_info=userMapper.selUserLoveName(user.getUserId());
        if (user_info.getNetName()!=null){
            return user_info.getNetName();
        }
        return userName;
}

    @Override
    public User_info selectMyInfo() {
        User user=userMapper.selectUserByUserName(SecurityUtils.getSubject().getPrincipal().toString());
        return user_infoMapper.selectByUserId(user.getUserId());
    }

    /**    zjl   根据用户名  查 id
     * */
    @Override
    public int getUserGoods4_1(String uname) {
        return userMapper.selUserIdByName4_1(uname);
    }

    @Override
    public String recharge(Integer money) {
        int user_id=userMapper.selectUserByUserName(SecurityUtils.getSubject().getPrincipal().toString()).getUserId();
        User_info user_info=new User_info();
        User_info user_info1=user_infoMapper.selectByUserId(user_id);
        user_info.setBalance(money);
        user_info.setUserId(user_id);
        user_info.setLevel((user_info1.getScore()+money)/500);
        System.out.println(user_info1.getScore()+money);
        user_info.setScore(money);
        int row=user_infoMapper.recharge(user_info);
        if (row==0){
            return "充值失败，请联系管理员";
        }
        return "充值成功";
    }

    @Override
    public String updateImg(String source) {
        int user_id=userMapper.selectUserByUserName(SecurityUtils.getSubject().getPrincipal().toString()).getUserId();
        int row = user_infoMapper.updateHeadImg(source,user_id);
        if (row==0){
            return "上传失败";
        }
        return "上传成功";
    }

    @Override
    public List<User_info> SelUser4(int lim) {
        List<User_info> user_infos=user_infoMapper.SelUser4(lim);
        return user_infos;
    }

    @Override
    public int SelUserNum4() {
        int total=user_infoMapper.SelUserNum4();
        return total;
    }

    @Override
    public User_info SelUserById(int uId) {
        return user_infoMapper.SelUserById(uId);
    }

    @Override
    public List<User_info> shearch(String netName,String realName,String phoneNumber,String qq) {

        return user_infoMapper.shearch(netName,realName,phoneNumber,qq);
    }

    @Override
    public int DelUserById4(int uId) {
        return user_infoMapper.DelUserById4(uId);
    }

    @Override
    public List<Venue> selectAllVenue() {
        List<Venue> venues=userMapper.queryVenues();
        return venues;
    }

    @Override
    public Venue lookVenueDetails(Integer venueId) {
        return venueMapper.selectByPrimaryKey(venueId);
    }

    @Override
    public int addUser(User user) {
        return userMapper.insert(user);
    }
}
