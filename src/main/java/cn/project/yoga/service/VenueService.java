package cn.project.yoga.service;

import cn.project.yoga.pojo.Venue;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface VenueService {
    List<Venue> selectAllVenue1();
}
