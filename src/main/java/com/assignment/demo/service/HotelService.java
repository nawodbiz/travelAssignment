package com.assignment.demo.service;

import com.assignment.demo.model.Hotel;
import com.assignment.demo.model.Location;
import com.assignment.demo.pojo.AddHotel;
import com.assignment.demo.repository.HotelRepo;
import com.assignment.demo.repository.LocationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {
    @Autowired
    HotelRepo hotelRepo;
    @Autowired
    LocationRepo locationRepo;


    public Hotel addHotel(AddHotel addHotel) {
        Location location = locationRepo.findById(addHotel.getLocationId()).get();
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

    public List<Hotel> getHotelByLocation(int locationId) {
        Location location = new Location();
        location.setLocationId(locationId);
        return hotelRepo.findByLocation(location);
    }

    public List<Hotel> getHotelsByLocationCode(String locationCode) {
        int locationId = locationRepo.findByLocationCode(locationCode).getLocationId();
        return hotelRepo.findByLocation(new Location(locationId));
    }
}
