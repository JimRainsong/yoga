package cn.project.yoga.service.impl;

import cn.project.yoga.dao.AppointmentMapper;
import cn.project.yoga.dao.Myself_courseMapper;
import cn.project.yoga.dao.TeacherMapper;
import cn.project.yoga.dao.UserMapper;
import cn.project.yoga.pojo.TeaMoment;
import cn.project.yoga.pojo.Appointment;
import cn.project.yoga.pojo.User;
import cn.project.yoga.pojo.*;
import cn.project.yoga.service.TeacherService;
import cn.project.yoga.utils.Attributes;
import cn.project.yoga.utils.FilePathUtil;
import cn.project.yoga.utils.ResultUtil;
import cn.project.yoga.utils.UpLoadFileUtil;
import cn.project.yoga.vo.TeacherVo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Collection;
import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private TeacherMapper teacherMapper;

    @Autowired
    private AppointmentMapper appointmentMapper;

    @Autowired
    private Myself_courseMapper myself_courseMapper;

    @Override
    public int insertUser(User user1) {
        return userMapper.insert(user1);
    }

    @Override
    public int insert_userid_teacher2(String username) {
        return teacherMapper.insert_userid_teacher2(username);
    }

    /**
     * zjl
     * 根据教练id,更新教练的认证信息
     */
    @Override
    public int updateIfauthById4_1(Integer teacherId, Integer val) {
        return teacherMapper.updateTeacherIf_authById(teacherId, val);
    }

    @Override
    public Double selectBalanceByTeacherName2(String name) {
        return teacherMapper.selectBalanceByTeacherName2(name);
    }

    @Override
    public List<TeaMoment> allMoments2() {
        return teacherMapper.allMoments2();
    }

    @Override
    public String selectTeacherNameByTeacherId2(Integer teacherId) {
        return teacherMapper.selectTeacherNameByTeacherId2(teacherId);
    }

    @Override
    public TeacherInfo selectSingleTeacherByUserName2(String userName) {
        return teacherMapper.selectSingleTeacherByUserName(userName);
    }

    @Override
    public List<Teacher> showTea4(Integer currentPage, Integer pageSize) {
        List<Teacher> teachers = teacherMapper.showTea4(currentPage, pageSize);
        return teachers;
    }

    @Override
    public int DelTea4(int teacherId) {
        int row = teacherMapper.DelTea4(teacherId);
        return row;
    }

    @Override
    public Teacher SelTeaById4(int teacherId) {
        Teacher teacher = teacherMapper.SelTeaById4(teacherId);
        return teacher;
    }


    @Override
    public ResultUtil updateTeacher2(TeacherVo vo) {
        Session session = SecurityUtils.getSubject().getSession();
        Integer tId = ((TeacherInfo) session.getAttribute(Attributes.CURRENT_USER)).gettId();
        if (tId == null) {
            return ResultUtil.error("更新失败，请尝试重新登录");
        } else {
            vo.settId(tId);
        }
        int row = teacherMapper.updateTeacher2(vo);
        if (row > 0) {
            return ResultUtil.ok("更新成功");
        } else {
            return ResultUtil.error("更新失败");
        }
    }

    @Override
    public ResultUtil postNewMoment2(String content) {
        Moment moment = new TeaMoment();
        moment.setDetail(content);
        moment.setTime(new Date(System.currentTimeMillis()));
        TeacherInfo currentUser = ((TeacherInfo) SecurityUtils.getSubject().getSession().getAttribute(Attributes.CURRENT_USER));
        if (currentUser == null) {
            return ResultUtil.error("请尝试重新登录");
        } else {
            moment.setId(currentUser.getuId());
        }
        int row = teacherMapper.postNewMoment2(moment);
        if (row > 0) {
            return ResultUtil.ok("发布成功");
        } else {
            return ResultUtil.error("发布失败，请稍后再试");
        }
    }

    @Override
    public Venue selectMyVenueByCurrentUserId2(Integer tId) {
        return teacherMapper.selectMyVenueByCurrentUserId2(tId);
    }

    @Override
    public ResultUtil uploadHeadImg2(MultipartFile file, HttpServletRequest request) {
        Session session = SecurityUtils.getSubject().getSession();
        TeacherInfo teacherInfo = (TeacherInfo) session.getAttribute(Attributes.CURRENT_USER);
        Integer currentUserId = teacherInfo.getuId();
        String src = UpLoadFileUtil.upLoadFile(request, file, "head_imgs");
        int row = teacherMapper.updateTeacherImg(currentUserId, src);
        if (row < 1) {
            return ResultUtil.error("上传失败");
        }
        return ResultUtil.ok("上传成功");
    }

    @Override
    public int connectRoleIdAndUserId2(String username) {
        return teacherMapper.connectRoleIdAndUserId2(username);
    }

    @Override
    public Collection<? extends Detail> selectMyFollowedTeaByCurrentUserId2(Integer currentUserId) {
        return teacherMapper.selectMyFollowedTeaByCurrentUserId2(currentUserId);
    }

    /*
    接受 课程邀请
     */
    @Override
    public int acceptcourse2(Integer id) {
        int count = myself_courseMapper.acceptCoursebyId(id);
        return count;
    }
    /*
    拒绝课程邀请
     */

    @Override
    public int refusecourse2(Integer id) {
        int count = myself_courseMapper.refuseCoursebyId(id);
        return count;

    }

    //查看所有  当前老师id 的 appointment  预约信息
    @Override
    public List<Appointment> selappointmentbyTeacherId2(Integer teacherId, Date date1, Date date2) {
        return appointmentMapper.selappointmentbyteacherId2(teacherId, date1, date2);
    }


    @Override
    public TeacherInfo selectTeacherByItsUserId2(Integer userId) {
        return teacherMapper.selectTeacherByItsUserId2(userId);
    }

    @Override
    public List<TeaMoment> onlyFollowedallMoments2(Integer currentUserId) {
        return teacherMapper.onlyFollowedallMoments2(currentUserId);
    }

    @Override
    public ResultUtil fetchMoneyByCurrentUserId2(Integer currentUserId) {
        Double balance = teacherMapper.selectBalanceByCurrentUserId2(currentUserId);
        if (balance <= (0)) {
            return ResultUtil.error("没有余额了");
        } else {
            int row = teacherMapper.fetchMoneyByUserId2(currentUserId);
            if (row > 0) {
                return ResultUtil.ok("提款成功！");
            }
        }
        return ResultUtil.error("操作失败");
    }

    @Override
    public int conflict2(Integer id) {
        Date start = myself_courseMapper.selectStart(id);
        Date end = myself_courseMapper.selectEnd(id);
        return myself_courseMapper.conflict(start, end);
    }

    @Override
    public List<Appointment> findclist2(Integer id) {
        Date start = myself_courseMapper.selectStart(id);
        Date end = myself_courseMapper.selectEnd(id);

        return appointmentMapper.findclist2(id, start, end);
    }
}
