package cn.project.yoga.service;



import cn.project.yoga.pojo.Selstudent;
import cn.project.yoga.pojo.User_info;
import cn.project.yoga.pojo.Venue;

import java.util.List;


public interface VenueService {

    /**
     *添加新场馆 by 崔宇
     */
    int addVenue(Venue venue);
    /*
     *查询场馆信息_通过场馆id
     * 场馆-崔宇
     */
    Venue getVenueDataByVenueId(Integer venueId);
    /*
     *查询场馆学员信息_通过场馆id
     *场馆-陈家明
     */
    List<Selstudent> findStudents(Integer currentPage, Integer pageSize, Integer venueId);
}
