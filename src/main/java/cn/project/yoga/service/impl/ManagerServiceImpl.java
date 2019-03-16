package cn.project.yoga.service.impl;


import cn.project.yoga.dao.AdMapper;
import cn.project.yoga.dao.TeacherMapper;
import cn.project.yoga.dao.VenueMapper;
import cn.project.yoga.pojo.Ad;
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

    @Autowired
    private AdMapper adMapper;

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

    /** zjl
     * 根据已认证和未认证的参数,分页和模糊查询*/
    @Override
    public List<Ad> selAllAdBylimit(Integer currentPage, Integer pageSize, Integer datas,String adtitle) {
        return adMapper.selAllAdBylimitAndPage(currentPage,pageSize,datas,adtitle);
    }

    /**  zjl
     * 根据广告id,更改广告认证
     * */
    @Override
    public int updateAdByAdid(Integer daId, Integer val) {
        return adMapper.updateStateByAdid(daId,val);
    }

    /** zjl
     * 获取广告最新的三条
     * */
    @Override
    public List<Ad> getadthree() {
        return adMapper.selthreeads();
    }
}
