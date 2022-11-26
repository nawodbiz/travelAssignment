package com.assignmentDemo.demo2.controller;
import com.assignmentDemo.demo2.dto.HotelDTO;
import com.assignmentDemo.demo2.model.Hotel;
import com.assignmentDemo.demo2.pojo.AddHotel;
import com.assignmentDemo.demo2.service.HotelService;
import com.assignmentDemo.demo2.service.LocationService;
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
    public Hotel addHotel(@RequestBody AddHotel addHotel){
        return hotelService.addHotel(addHotel);
    }
    @GetMapping("/getAll")
    public List<Hotel> getAllHotels(){
        return hotelService.getAllHotels();
    }
    @GetMapping("/search/{locationId}")
    public List<Hotel> getHotelByLocationId(@PathVariable int locationId){
        return hotelService.getHotelByLocation(locationId);

    }

}
