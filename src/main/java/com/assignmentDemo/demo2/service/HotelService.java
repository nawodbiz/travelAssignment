package com.assignmentDemo.demo2.service;

import com.assignmentDemo.demo2.dao.HotelRepo;
import com.assignmentDemo.demo2.model.Hotel;
import com.assignmentDemo.demo2.model.Location;
import com.assignmentDemo.demo2.pojo.AddHotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {
    @Autowired
    HotelRepo hotelRepo;
    @Autowired
    LocationService locationService;

    public Hotel addHotel(AddHotel addHotel){
        Location location = locationService.findLocationById(addHotel.getLocationId()).get();
        Hotel hotel = new Hotel();
        hotel.setHotelId(addHotel.getHotelKey());
        hotel.setHotelName(addHotel.getHotelName());
        hotel.setAddress(addHotel.getAddress());
        hotel.setContactNumber(addHotel.getContactNumber());
        hotel.setLocation(location);
        return hotelRepo.save(hotel);
    }

    public List<Hotel> getAllHotels() {
        return hotelRepo.findAll();
    }
    public List<Hotel> getHotelByLocation(int locationId){
        Location location = new Location();
        location.setLocationId(locationId);
        return hotelRepo.findByLocation(location);
    }
}
