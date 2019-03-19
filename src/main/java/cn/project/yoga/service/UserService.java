package cn.project.yoga.service;

import cn.project.yoga.pojo.*;
import cn.project.yoga.vo.MyVenueVo;
import cn.project.yoga.utils.ResultUtil;

import java.util.Collection;
import java.util.List;

public interface UserService {
    /**
     * 通过用户名查密码
     * @param userName
     * @return
     */
    User selectUserByUserName(String userName);

    /**
     * 更新用户信息是否可查看
     * @param user
     * @return
     */
    String updateUserInfo1(User_info user);

    /**
     * 查询我的场馆
     * @param
     * @return 场馆的集合
     */
    List<MyVenueVo> selectMyVenue1();

    /**
     *购买会员卡
     * @param user_id 用户id
     * @param venue_id 场馆id
     * @param vip_type_id  会员卡类型id
     * @return  返回状态，购买成功、失败
     */
    String buyVipCard1(int user_id,int vip_type_id,int venue_id);

    /**
     * 查询我的私教
     * @param user_id
     * @return
     */
    List<Myself_course> selectMySelfCourse1(int user_id);


    /**
     * 查询我报名的课程
     * @param user_id
     * @return
     */
    List<My_course> selectMyCourse1(int user_id);

    /**
     * 查询所有的（前十条）广告
     * @return 广告集合
     */
    List<Attention> selectAllAttention1();

    /**
     * 查询场馆的所有课程，开课时间必须是现在的时间之后
     * @return 课程的集合
     */
    List<Course> venueCourse1(int venue_id);


    /**
     * 报名课程
     * @param user_id
     * @param course_id
     * @return 状态：是否进入该课程成功
     */
    String intoCourse1(int user_id,int course_id,int venue_id);


    /**
     * 预约私教
     * @param user_id
     * @param teacher_id
     * @return 状态，是否预约成功
     */
    String orderSelfCourse1(int user_id,int teacher_id,int venue_id);

    /**
     * 注册用户 by 崔宇
     *
     */
    int addUser(User user);

    List<Ad> selectAd();

    int insert_userid_user(String username);

    List<StuMoment> allMoments2();

    /**
     * 查询用户的网名
     * @param userName
     * @return
     */
    String selectUserNetName(String userName);

    /**
     * 查询个人信息 zjn
     * @return
     */
    User_info selectMyInfo();

    /** zjl
     * 根据用户名,查id
     * */
    int getUserGoods4_1(String uname);

    String recharge(Integer money);

    String updateImg(String source);





    /**
     * 根据学员ID查询信息*/
    public User_info SelUserById(int uId);

    /**
     * 动态查询学员*/
    public List<User_info> shearch(String netName,String sex,String phoneNumber,String qq,Integer currentPage,Integer pageSize);

    /**
     * 根据ID软删除学员*/
    public int DelUserById4(int uId);

    /**
     * 根据当前登录的账号去查询此账号关注的人的信息
     */
    Collection<? extends Detail> selectMyFollowedStuByCurrentUserId2(Integer currentUserId);

    /**
     * 根据“用户id”查找一个学员
     * @param userId
     * @return
     */
    User_info selectUserByUserId2(Integer userId);

    Attention hasIfollowedThis2(Integer currentUserId, Integer userId);

    ResultUtil doFollow2(Integer currentUser, Integer targetUserId);

    ResultUtil cancleFollow2(Integer currentUser, Integer targetUserId);

    List<StuMoment> onlyFollowedMoments2(Integer currentUserId);

    /**
     * 查询所有可加入场馆
     * @return
     */
    List<Venue> selectAllVenue();

    Venue lookVenueDetails(Integer venueId);

    List<Vip_type> selShowVipType(Integer venueId);

    Vip_type selVipTypeById(Integer vipTypeId);

    String openVip(Integer venueId, Integer vipTypeId);

    List<Teacher> selAllTeacher();

    Teacher selTeacherByTid(Integer teacherId);
}
