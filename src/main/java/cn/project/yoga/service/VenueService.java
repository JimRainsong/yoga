package cn.project.yoga.service;



import cn.project.yoga.pojo.Venue;


public interface VenueService {

    /**
     *添加新场馆 by 崔宇
     *
     *
     */
    int addVenue(Venue venue);

    Venue getVenueDataByVenueId(Integer venueId);
}
