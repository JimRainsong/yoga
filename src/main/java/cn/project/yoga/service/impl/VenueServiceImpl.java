package cn.project.yoga.service.impl;

import cn.project.yoga.dao.VenueMapper;
import cn.project.yoga.pojo.Venue;
import cn.project.yoga.service.VenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class VenueServiceImpl implements VenueService {
    @Autowired
    private VenueMapper venueMapper;

}
