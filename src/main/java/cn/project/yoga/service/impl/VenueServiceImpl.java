package cn.project.yoga.service.impl;

import cn.project.yoga.dao.SelstudentMapper;
import cn.project.yoga.dao.VenueMapper;
import cn.project.yoga.pojo.Selstudent;
import cn.project.yoga.pojo.User_info;
import cn.project.yoga.pojo.Venue;
import cn.project.yoga.pojo.Vip_type;
import cn.project.yoga.service.VenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VenueServiceImpl implements VenueService {
    @Autowired
    private VenueMapper venueMapper;
    @Autowired
    private SelstudentMapper selstudentMapper;


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
            List<Selstudent> students =selstudentMapper.selectStudentByvenueId(currentPage,pageSize,venueId);



        return students;
    }
}
