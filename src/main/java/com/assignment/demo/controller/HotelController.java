package com.assignment.demo.controller;

import com.assignment.demo.model.Hotel;
import com.assignment.demo.pojo.AddHotel;
import com.assignment.demo.service.HotelService;
import com.assignment.demo.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController {
    @Autowired
    HotelService hotelService;
    @Autowired
    LocationService locationService;

    @PostMapping("/addHotel")
    public Hotel addHotel(@RequestBody AddHotel addHotel) {
        return hotelService.addHotel(addHotel);
    }

    @GetMapping("/getAll")
    public List<Hotel> getAllHotels() {
        return hotelService.getAllHotels();
    }

    @GetMapping("/search/{locationId}")
    public List<Hotel> getHotelByLocationId(@PathVariable int locationId) {
        return hotelService.getHotelByLocation(locationId);

    }

}
