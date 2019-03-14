package cn.project.yoga.service;



import cn.project.yoga.pojo.Selstudent;
import cn.project.yoga.pojo.VenMoment;
import cn.project.yoga.pojo.Venue;
import cn.project.yoga.pojo.Vip_type;
import cn.project.yoga.pojo.*;
import cn.project.yoga.vo.CourseVo;
import cn.project.yoga.vo.TeacherTypeVo;
import cn.project.yoga.pojo.*;

import java.util.List;


public interface VenueService {

    /**
     *添加新场馆 by 崔宇
     */
    int addVenue(Venue venue);
    /**
     *查询场馆信息_通过场馆id
     * 场馆-崔宇
     */
    Venue getVenueDataByVenueId(Integer venueId);
    /**
     *查询场馆学员信息_通过场馆id
     *场馆-陈家明
     */
    List<Selstudent> findStudents(Integer currentPage, Integer pageSize, Integer venueId);
    /**
     *查询场馆有哪些Vip信息_通过场馆id
     *场馆-陈家明
     */

    List<Venue_teacher> findTeachers(Integer currentPage, Integer pageSize, TeacherTypeVo teacherTypeVo,Teacher teacher);

    List<Vip_type> selShowVipType(Integer currentPage, Integer pageSize, Integer venueId);

    List<VenMoment> allMoments2();
    /**
     *查询关注场馆的人_通过场馆id
     *场馆-陈家明
     */
    List<User_info> selShowattention(Integer currentPage, Integer pageSize, Integer venueId);


    /**
     * 场馆向平台提交广告申请
     * 场馆-陈家明
     * @param ad
     * @return
     */
    int venueUploadAds(Ad ad);
    List<Course> selCourse(Integer currentPage, Integer pageSize, CourseVo courseVo);
}
