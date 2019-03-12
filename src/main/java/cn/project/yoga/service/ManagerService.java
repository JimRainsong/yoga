package cn.project.yoga.service;

import cn.project.yoga.pojo.User_info;
import cn.project.yoga.pojo.Venue;

import java.util.List;

public interface ManagerService {


    List<Venue> selAllVenues4_1(Integer currentPage,Integer pageSize);

    int upVenueApprove(Integer venueId, Integer val);
}
