package cn.project.yoga.service.impl;

import cn.project.yoga.dao.*;
import cn.project.yoga.pojo.*;
import cn.project.yoga.dao.AttentionMapper;
import cn.project.yoga.dao.SelstudentMapper;
import cn.project.yoga.dao.VenueMapper;
import cn.project.yoga.dao.Vip_typeMapper;
import cn.project.yoga.service.VenueService;
import cn.project.yoga.vo.CourseVo;
import cn.project.yoga.vo.TeacherTypeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Service
public class VenueServiceImpl implements VenueService {
    @Autowired
    private VenueMapper venueMapper;
    @Autowired
    private SelstudentMapper selstudentMapper;
    @Autowired
    private Vip_typeMapper vip_typeMapper;
    @Autowired
    private AttentionMapper attentionMapper;
    @Autowired
    private Venue_teacherMapper venue_teacherMapper;
    @Autowired
    private TeacherMapper teacherMapper;
    @Autowired
    private AdMapper adMapper;
    @Autowired
    private CourseMapper courseMapper;


    @Override
    public int addVenue(Venue venue) {

        return venueMapper.insertSelective(venue);
    }

    @Override
    public Venue getVenueDataByVenueId(Integer venueId) {
        return venueMapper.selectByPrimaryKey(venueId);
    }

    @Override
    public List<Selstudent> findStudents(Integer currentPage, Integer pageSize, Integer venueId) {
        List<Selstudent> students = selstudentMapper.selectStudentByvenueId(currentPage, pageSize, venueId);


        return students;
    }


    @Override
    public List<Vip_type> selShowVipType(Integer currentPage, Integer pageSize, Integer venueId) {
        List<Vip_type> vip_types = vip_typeMapper.selShowVipType(currentPage, pageSize, venueId);
        return vip_types;
    }

    @Override
    public List<VenMoment> allMoments2() {
        return venueMapper.allMoments2();
    }

    @Override
    public List<User_info> selShowattention(Integer currentPage, Integer pageSize, Integer venueId) {
        Venue venue = venueMapper.selectByPrimaryKey(venueId);
        System.out.println(venue.getUserId());
        List<User_info> attentions = attentionMapper.selShowattention(currentPage, pageSize, venue.getUserId());
        return attentions;
    }

    @Override
    public List<Course> selCourse(Integer currentPage, Integer pageSize, CourseVo courseVo) {
        return courseMapper.selCourse(courseVo, currentPage, pageSize);
    }

    @Override
    public boolean findAdByName(String adTitle) {
        if (adMapper.selAdByAdTitle(adTitle) != null) {
            return true;
        }
        return false;
    }

    @Override
    public int deleteVipTypeDatas(Vip_type vip_type) {

        return vip_typeMapper.updateByPrimaryKeySelective(vip_type);
    }

    @Override
    public int insertVipTypeDatas(Vip_type vip_type) {
        return vip_typeMapper.insertSelective(vip_type);
    }

    @Override
    public int updataTeacherState(Venue_teacher venue_teacher) {

        return venue_teacherMapper.updateByPrimaryKeySelective(venue_teacher);
    }

    @Override
    public boolean findStartTimeByCourse(Date startTime,int vid,int tid) {
       if (courseMapper.selCourseByStartTime(tid,vid,startTime)!=null){
              return true;
       }
        return false;
    }

    @Override
    public int addCourse(Course course) {

        return courseMapper.insertSelective(course);
    }

    @Override
    public int removeCourse(Integer courseId) {
        return courseMapper.removeCourseById(courseId);
    }

    @Override
    public List<VenMoment> onlyFollowedallMoments2(Integer currentUserId) {
        return venueMapper.onlyFollowedMonents2(currentUserId);
    }

    @Override
    public List<Venue_teacher> selTeacherName(Venue_teacher venue_teacher) {
        return venue_teacherMapper.selectTeachers(venue_teacher,1,50);
    }

    @Override
    public Venue selVenueByUserId(User user) {
        return venueMapper.selvenueByUserId(user);
    }


    @Override
    public Collection<? extends Detail> selectMyfollowedVenByCurrentUserId2(Integer currentUserId) {
        return venueMapper.selectMyFollowedVenByCurrentUserId(currentUserId);
    }

    @Override
    public Venue selectVenueByItsUserId2(Integer userId) {
        return venueMapper.selectVenueByItsUserId2(userId);
    }


    @Override
    public List<Venue> SelVen(Integer currentPage, Integer pageSize) {

        return venueMapper.SelVen(currentPage, pageSize);
    }

    @Override
    public int DelVen4(int venue_id) {
        int row = venueMapper.DelVen4(venue_id);
        return row;
    }

    @Override
    public Venue SelVenById4(int venueId) {
        Venue venue = venueMapper.SelVenById4(venueId);
        return venue;
    }


    @Override
    public List<Venue> shearch(String venname, String addrass, String phone, String qq, Integer currentPage, Integer pageSize) {
        List<Venue> venues = venueMapper.shearch(venname, addrass, phone, qq, currentPage, pageSize);
        return venues;
    }

    @Override
    public int venueUploadAds(Ad ad) {
        return adMapper.insertSelective(ad);
    }

    @Override
    public List<Venue_teacher> findTeachers(Integer currentPage, Integer pageSize, TeacherTypeVo teacherTypeVo, Teacher teacher) {
        Venue_teacher venue_teacher = new Venue_teacher();
        venue_teacher.setVenueId(teacherTypeVo.getVid());
        venue_teacher.setTeacherState(teacherTypeVo.getTeype());
        venue_teacher.setTeacher(teacher);
        List<Venue_teacher> teachers = venue_teacherMapper.selectTeachers(venue_teacher, currentPage, pageSize);
        return teachers;
    }
}
