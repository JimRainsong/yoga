package cn.project.yoga.service.impl;

import cn.project.yoga.dao.*;
import cn.project.yoga.pojo.*;
import cn.project.yoga.service.UserService;
import cn.project.yoga.vo.MyVenueVo;
import cn.project.yoga.utils.ResultUtil;
import cn.project.yoga.vo.OrderCoachVo;
import cn.project.yoga.vo.SelfCourseVo;
import cn.project.yoga.vo.TeacherVenueVo;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Collection;
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

    @Autowired
    private TeacherMapper teacherMapper;

    @Autowired
    private AttentionMapper attentionMapper;

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public User selectUserByUserName(String userName) {
        return userMapper.selectUserByUserName(userName);
    }

    /**
     * 修改用户信息
     * @author zjn
     * @param user
     * @return int 影响行数
     * @author zjn
     */
    @Override
    public String updateUserInfo1(User_info user) {

        //查user_id
        String userName = SecurityUtils.getSubject().getPrincipal().toString();
        if (userName == null) {
            return "请先登录";
        }
        int userId = userMapper.selectUserByUserName(userName).getUserId();
        user.setUserId(userId);
        int row = user_infoMapper.updateByPrimaryKeySelective(user);
        if (row == 1) {
            return "修改信息成功";
        }
        return "修改信息失败";
    }

    /**
     * 查询我的场馆
     * @param
     * @return
     */
    @Override
    public List<MyVenueVo> selectMyVenue1() {
        String userName=SecurityUtils.getSubject().getPrincipal().toString();
        int userId=userMapper.selectUserByUserName(userName).getUserId();
        int uId=userMapper.selUidByUserId(userId);

        List<MyVenueVo> list=userMapper.selMyVipRecord(uId,new Date().getTime());
        return list;
    }

    @Override
    public String buyVipCard1(int user_id, int vip_type_id, int venue_id) {
        return null;
    }

    @Override
    public List<SelfCourseVo> selectMySelfCourse1() {
        String userName=SecurityUtils.getSubject().getPrincipal().toString();
        int userId=userMapper.selectUserByUserName(userName).getUserId();
        int uId=userMapper.selUidByUserId(userId);
        return userMapper.selMyselfCourse(uId);
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
        int user_id = userMapper.selectUserByUserName(SecurityUtils.getSubject().getPrincipal().toString()).getUserId();
        int row = user_infoMapper.updateHeadImg(source, user_id);
        if (row == 0) {
            return "上传失败";
        }
        return "上传成功";
    }

    @Override
    public User_info SelUserById(int uId) {
        return user_infoMapper.SelUserById(uId);
    }

    @Override
    public List<User_info> shearch(String netName, String sex, String phoneNumber, String qq, Integer currentPage, Integer pageSize) {

        return user_infoMapper.shearch(netName, sex, phoneNumber, qq, currentPage, pageSize);
    }

    @Override
    public int DelUserById4(int uId) {
        return user_infoMapper.DelUserById4(uId);
    }

    @Override
    public Collection<? extends Detail> selectMyFollowedStuByCurrentUserId2(Integer currentUserId) {
        return userMapper.selectMyFollowedStuByCurrentUserId2(currentUserId);
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
    public List<Vip_type> selShowVipType(Integer venueId) {
        return userMapper.selShowVipType(venueId);
    }

    @Override
    public Vip_type selVipTypeById(Integer vipTypeId) {
        return userMapper.selVipTypeById(vipTypeId);
    }

    @Override
    public String openVip(Integer venueId, Integer vipTypeId) {
        Date date=new Date();
        Timestamp registTime=new Timestamp(date.getTime());


        //SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar=Calendar.getInstance();

        Vip_type vip_type=userMapper.selVipTypeById(vipTypeId);
        String useDate=vip_type.getUseDate();
        if (useDate.equals("一个月") || useDate.equals("月卡")){
            calendar.add(Calendar.MONTH,1);
        }else if (useDate.equals("3个月") || useDate.equals("三个月") || useDate.equals("季卡")){
            calendar.add(Calendar.MONTH,3);
        }else if(useDate.equals("一年") || useDate.equals("一年")){
            calendar.add(Calendar.YEAR,1);
        }
        Date updateTime=calendar.getTime();
        Timestamp updateTime1=new Timestamp(updateTime.getTime());
        Vip_record vip_record=new Vip_record();
        if (SecurityUtils.getSubject().getPrincipal()==null){
            return "请先登录";
        }
        int userId=userMapper.selectUserByUserName(SecurityUtils.getSubject().getPrincipal().toString()).getUserId();
        int u_id=userMapper.selUidByUserId(userId);
        vip_record.setUserId(u_id);
        Vip_type vip_type1=userMapper.selVipTypeById(vipTypeId);

        vip_record.setVipType(vip_type1);
        vip_record.setRegistTime(registTime);
        vip_record.setUpdateTime(updateTime1);

        //是否已经办理过
        Vip_record vip_record1=userMapper.selVipRecord(u_id,venueId,new Date().getTime());

        if (vip_record1!=null){
            return "你已经办理过该场馆的会员";
        }

        int balacce=userMapper.selBalanceByUserId(userId);
        if (balacce<vip_type1.getCardPrice()){
            return "办理失败，余额不足";
        }
        int row1 = userMapper.updateMyMoney(userId,vip_type1.getCardPrice());
        if (row1==0){
            return "办理失败，原因：扣钱失败";
        }
        int row=userMapper.insertVipRecord(vip_record);
        if (row==0){
            return "办理失败";
        }
        return "办理成功";
    }

    @Override
    public List<Teacher> selAllTeacher() {
        return userMapper.selAllCoach();
    }

    @Override
    public Teacher selTeacherByTid(Integer teacherId) {
        return teacherMapper.SelTeaById4(teacherId);
    }

    @Override
    public List<TeacherVenueVo> selTeacherVenue(Integer teacherId) {
        return userMapper.selTeacherVenue(teacherId);
    }



    @Override
    public String orderCoach(OrderCoachVo orderCoachVo) {
        if (orderCoachVo.getVenueId()==0){
            return "请选择场馆";
        }
        Date beginDate=null;
        Date overDate=null;
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try {
            beginDate=simpleDateFormat.parse(orderCoachVo.getBeginTime());
            overDate=simpleDateFormat.parse(orderCoachVo.getOverTime());

        } catch (ParseException e) {
            e.printStackTrace();
        }
        //根据教练查询私教时间

        List<Myself_course> list=userMapper.selTeacherTime(orderCoachVo.getTeacherId(),new Timestamp(beginDate.getTime()),new Timestamp(overDate.getTime()));
        if (list.size()!=0){
            return "教练时间已经被占用";
        }
        int userId=userMapper.selectUserByUserName(SecurityUtils.getSubject().getPrincipal().toString()).getUserId();
        int u_id=userMapper.selUidByUserId(userId);


        int row=userMapper.insertSelfCourse(new Timestamp(beginDate.getTime()),new Timestamp(overDate.getTime()),orderCoachVo.getTeacherId(),orderCoachVo.getVenueId(),u_id);
        if (row==0){
            return "盘他失败";
        }
        return "预约成功，等待教练确认";
    }

    @Override
    public int addAttention(Attention attention) {
        return attentionMapper.insertSelective(attention);
    }

    @Override
    public List<Course> selCourseByUid(Integer uId) {
//        courseMapper.selCourseByUid(uId)
        return null;
    }

   /* @Override
    public Collection<? extends Detail> selectMyFollowedStuByCurrentUserId2(Integer currentUserId) {
        return userMapper.selectMyFollowedStuByCurrentUserId2(currentUserId);
    }*/

    @Override
    public User_info selectUserByUserId2(Integer userId) {
        return userMapper.selectUserByItsUserId2(userId);
    }

    @Override
    public Attention hasIfollowedThis2(Integer currentUserId, Integer userId) {
        return userMapper.hasIfollowedThis2(currentUserId, userId);
    }

    @Override
    public ResultUtil doFollow2(Integer currentUserId, Integer targetUserId) {
        int row = userMapper.doFollow2(currentUserId, targetUserId);
        if (row > 0) {
            return ResultUtil.ok("成功关注");
        } else {
            ResultUtil resultUtil = new ResultUtil();
            resultUtil.setCode(999);
            resultUtil.setMessage("未知错误，请稍后再试");
            return resultUtil;
        }
    }

    @Override
    public ResultUtil cancleFollow2(Integer currentUserId, Integer targetUserId) {
        int row = userMapper.cancleFollow2(currentUserId, targetUserId);
        ResultUtil resultUtil = new ResultUtil();
        if (row > 0) {
            resultUtil.setCode(-1);
            resultUtil.setMessage("已取消关注");
        } else {
            resultUtil = new ResultUtil();
            resultUtil.setCode(999);
            resultUtil.setMessage("未知错误，请稍后再试");
        }
        return resultUtil;
    }

    @Override
    public List<StuMoment> onlyFollowedMoments2(Integer currentUserId) {
        return userMapper.onlyFollowedMoments2(currentUserId);
    }

    @Override
    public int addUser(User user) {
        return userMapper.insert(user);
    }


}
