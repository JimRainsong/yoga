package cn.project.yoga.service;

import cn.project.yoga.pojo.*;

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
    String updateUserInfo1(User user);

    /**
     * 查询我的场馆
     * @param user_id
     * @return 场馆的集合
     */
    List<Venue> selectMyVenue1(int user_id);

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



}
