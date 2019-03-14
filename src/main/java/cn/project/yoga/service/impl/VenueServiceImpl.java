package cn.project.yoga.service.impl;

import cn.project.yoga.dao.AttentionMapper;
import cn.project.yoga.dao.SelstudentMapper;
import cn.project.yoga.dao.VenueMapper;
import cn.project.yoga.dao.Vip_typeMapper;
import cn.project.yoga.pojo.*;
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
    @Autowired
    private Vip_typeMapper vip_typeMapper;
    @Autowired
    private AttentionMapper attentionMapper;

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

    @Override
    public List<Vip_type> selShowVipType(Integer currentPage, Integer pageSize, Integer venueId) {
        List<Vip_type>vip_types=vip_typeMapper.selShowVipType(currentPage,pageSize,venueId);
        return vip_types;
    }

    @Override
    public List<User_info> selShowattention(Integer currentPage, Integer pageSize, Integer venueId) {
        Venue venue=venueMapper.selectByPrimaryKey(venueId);
        System.out.println(venue.getUserId());
        List<User_info> attentions=attentionMapper.selShowattention(currentPage,pageSize,venue.getUserId());
        return attentions;
    }
}
