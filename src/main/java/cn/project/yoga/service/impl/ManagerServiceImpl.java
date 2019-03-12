package cn.project.yoga.service.impl;


import cn.project.yoga.dao.TeacherMapper;
import cn.project.yoga.dao.VenueMapper;
import cn.project.yoga.pojo.Teacher;
import cn.project.yoga.pojo.Venue;
import cn.project.yoga.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    private VenueMapper venueMapper;

    @Autowired
    private TeacherMapper teacherMapper;
    /*查询场馆信息表所有数据*/
    @Override
    public List<Venue> selAllVenues4_1(Integer currentPage,Integer pageSize,String venueName) {

        return venueMapper.selAllVenues4_1(currentPage,pageSize,venueName);
    }

    /*根据场馆id,更改认证信息*/
    @Override
    public int upVenueApprove(Integer venueId, Integer val) {
        return venueMapper.upApproveByvenueId(venueId,val);
    }

    /** zjl
     * 根据教练名字,模糊查询所有未认证教练*/
    @Override
    public List<Teacher> selAllTeacherByapprove(Integer currentPage, Integer pageSize, String teacherName) {
        return teacherMapper.selAllTeacherByName4_1(currentPage,pageSize,teacherName);
    }
}
