package com.assignmentDemo.demo2.controller;

import com.assignmentDemo.demo2.model.Allocation;
import com.assignmentDemo.demo2.service.AllocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/allocation")
public class AllocationController {
    @Autowired
    AllocationService allocationService;

//    @GetMapping("/isFree")
//    public Boolean isAvailableForOneDay(Date date){
//        return allocationService.isAvailableForOneDay(date);
//
//    }
    @GetMapping("/availableRooms/{roomsId}")
    public List<Allocation> getFreeRooms(@PathVariable int roomsId) {
        return allocationService.getFreeRooms(roomsId);

    }

//    @GetMapping("/availableRooms)
//    public List<Allocation> getFreeRooms(@RequestParam(value = "roomsId") int roomsId, ) {
//        return allocationService.getFreeRooms(roomsId);
//
//    }



}
