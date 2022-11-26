package com.assignmentDemo.demo2.service;
import com.assignmentDemo.demo2.model.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SearchResultService {
    @Autowired
    LocationService locationService;
    @Autowired
    HotelService hotelService;
    public Location getLocationByLocationCode(String locationCode){
        return locationService.findByLocationCode(locationCode);
    }

}
