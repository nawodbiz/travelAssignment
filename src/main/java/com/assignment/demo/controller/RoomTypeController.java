package com.assignment.demo.controller;

import com.assignment.demo.model.RoomType;
import com.assignment.demo.service.RoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roomType")
public class RoomTypeController {
    @Autowired
    RoomTypeService roomTypeService;

    @PostMapping("/add")
    public RoomType setRoomType(@RequestBody RoomType roomType) {
        return roomTypeService.setRoomType(roomType);
    }

    @GetMapping("/get/{roomTypeId}")
    public RoomType getRoomType(@PathVariable int roomTypeId) {
        return roomTypeService.getRoomType(roomTypeId);
    }

    @PutMapping("/update")
    public RoomType updateRoomType(@RequestBody RoomType roomType) {
        return roomTypeService.updateRoomType(roomType);
    }

    @DeleteMapping("/delete/{roomTypeId}")
    public String deleteRoomType(@PathVariable int roomTypeId) {
        return roomTypeService.deleteRoomType(roomTypeId);
    }

    @GetMapping("/getAll")
    public List<RoomType> getAllRoomTypes() {
        return roomTypeService.getAllRoomTypes();
    }

}
