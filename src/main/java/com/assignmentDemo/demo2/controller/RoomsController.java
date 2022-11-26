package com.assignmentDemo.demo2.controller;

import com.assignmentDemo.demo2.model.Rooms;
import com.assignmentDemo.demo2.pojo.AddRooms;
import com.assignmentDemo.demo2.service.RoomsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(("/rooms"))
public class RoomsController {
    @Autowired
    RoomsService roomsService;
    @PostMapping("/add")
    public Rooms addRooms(@RequestBody AddRooms addRooms){
        return roomsService.addRooms(addRooms);
    }

    @GetMapping("/getByHotel/{hotelId}")
    public List<Rooms> roomsList (@PathVariable int hotelId){
        return roomsService.findRoomsByHotelKey(hotelId);
    }
    @GetMapping("/getAll")
    public List<Rooms> getAllRooms(){
        System.out.println("here");
        return roomsService.getAllRooms();
    }
//    @PostMapping("/add")
//    public Rooms addRooms(@RequestBody Rooms rooms) {
//        return roomsService.addOneRooms(rooms);
//    }

}
