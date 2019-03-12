package cn.project.yoga.service.impl;

import cn.project.yoga.dao.VenueMapper;
import cn.project.yoga.pojo.Venue;
import cn.project.yoga.service.VenueService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class VenueServiceImpl implements VenueService {
    @Autowired
    private VenueMapper venueMapper;
    @Override
    public List<Venue> selectAllVenue4() {
        return venueMapper.selectAllVenue4();
    }
}
