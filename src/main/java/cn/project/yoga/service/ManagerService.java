package cn.project.yoga.service;

import cn.project.yoga.pojo.Ad;
import cn.project.yoga.pojo.Teacher;
import cn.project.yoga.pojo.Venue;
import java.util.List;

public interface ManagerService {

    List<Venue> selAllVenues4_1(Integer currentPage,Integer pageSize,String venueName);

    int upVenueApprove(Integer venueId, Integer val);

    List<Teacher> selAllTeacherByapprove(Integer currentPage, Integer pageSize, String teacherName);

    List<Ad> selAllAdBylimit(Integer currentPage, Integer pageSize, Integer datas,String adtitle);

    int updateAdByAdid(Integer daId, Integer val);

    List<Ad> getadthree();
}
