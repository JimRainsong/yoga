package cn.project.yoga.service;


import cn.project.yoga.pojo.Selstudent;
import cn.project.yoga.pojo.VenMoment;
import cn.project.yoga.pojo.Venue;
import cn.project.yoga.pojo.Vip_type;
import cn.project.yoga.pojo.*;
import cn.project.yoga.vo.CourseVo;
import cn.project.yoga.vo.TeacherTypeVo;
import cn.project.yoga.pojo.*;

import java.util.Collection;
import java.util.Date;
import java.util.List;


public interface VenueService {

    /**
     * 添加新场馆 by 崔宇
     */
    int addVenue(Venue venue);

    /**
     * 查询场馆信息_通过场馆id
     * 场馆-崔宇
     */
    Venue getVenueDataByVenueId(Integer venueId);

    /**
     * 查询场馆学员信息_通过场馆id
     * 场馆-陈家明
     */
    List<Selstudent> findStudents(Integer currentPage, Integer pageSize, Integer venueId);

    /**
     * 查询场馆有哪些Vip信息_通过场馆id
     * 场馆-陈家明
     */

    List<Venue_teacher> findTeachers(Integer currentPage, Integer pageSize, TeacherTypeVo teacherTypeVo, Teacher teacher);

    List<Vip_type> selShowVipType(Integer currentPage, Integer pageSize, Integer venueId);

    List<VenMoment> allMoments2();

    /**
     * 查询关注场馆的人_通过场馆id
     * 场馆-陈家明
     */
    List<User_info> selShowattention(Integer currentPage, Integer pageSize, Integer venueId);


    /**
     * 场馆向平台提交广告申请
     * 场馆-陈家明
     *
     * @param ad
     * @return
     */
    int venueUploadAds(Ad ad);




    List<Course> selCourse(Integer currentPage, Integer pageSize, CourseVo courseVo);



    /*
     *查询所有场馆信息
     */

    public List<Venue> SelVen(Integer currentPage, Integer pageSize);

    /*
    软删除场馆
     */
    public int DelVen4(int venue_id);

    /*
     * 根据ID查询场馆*/
    public Venue SelVenById4(int venueId);



    /*
     * 动态查询场馆*/
    public List<Venue> shearch(String venname, String addrass, String phone, String qq, Integer currentPage, Integer pageSize);


    boolean findAdByName(String adTitle);

    /**
     * 删除该场馆的对应vip类型
     * 场馆-cjm
     *
     * @param vip_type
     * @return
     */
    int deleteVipTypeDatas(Vip_type vip_type);

    /**
     * 添加该场馆的vip类型
     * 场馆-cjm
     *
     * @param vip_type
     * @return
     */
    int insertVipTypeDatas(Vip_type vip_type);

    /**
     * 审核场馆教练
     * 场馆-cjm
     *
     * @param venue_teacher
     * @return
     */
    int updataTeacherState(Venue_teacher venue_teacher);

    /**
     * 通过用户Id查询场馆
     * 场馆-cjm
     *
     * @param user
     * @return
     */
    Venue selvenueByUserId(User user);

    /**
     * 根据当前用户id查看自己关注的场馆
     *
     * @param currentUserId
     * @return
     */
    Collection<? extends Detail> selectMyfollowedVenByCurrentUserId2(Integer currentUserId);

    /**
     * 根据“用户id”查找一个场馆
     * @param userId
     * @return
     */
    Venue selectVenueByItsUserId2(Integer userId);

    boolean findStartTimeByCourse(Date startTime,int vid,int tid);

    int addCourse(Course course);

    List<VenMoment> onlyFollowedallMoments2(Integer currentUserId);
}
