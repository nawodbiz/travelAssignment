package com.assignment.demo.controller;

import com.assignment.demo.model.Rooms;
import com.assignment.demo.pojo.AddRooms;
import com.assignment.demo.service.RoomsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(("/rooms"))
public class RoomsController {
    @Autowired
    RoomsService roomsService;

    @PostMapping("/add")
    public Rooms addRooms(@RequestBody AddRooms addRooms) {
        return roomsService.addRooms(addRooms);
    }


    @GetMapping("/getAll")
    public List<Rooms> getAllRooms() {
        return roomsService.getAllRooms();
    }


}
