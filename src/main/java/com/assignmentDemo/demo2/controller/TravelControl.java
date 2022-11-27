package com.assignmentDemo.demo2.controller;

import com.assignmentDemo.demo2.model.RoomType;
import com.assignmentDemo.demo2.pojo.Response2;
import com.assignmentDemo.demo2.service.RoomTypeService;
import com.assignmentDemo.demo2.service.SearchResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/travel")
public class TravelControl {
    @Autowired
    SearchResultService searchResultService;
    @Autowired
    RoomTypeService roomTypeService;

    @GetMapping("/1")
    public Response2 response2(@RequestParam(value = "count") int count,@RequestParam(value = "locationCode")String locationCode){
        Response2 response2 = new Response2();
        response2.setRoomType(roomTypeService.getRoomTypeName(count));
        response2.setRate(roomTypeService.getRoomRate(count));
        return response2;
    }
    @GetMapping("/2")
    public RoomType roomTypeResponse (@RequestParam(value = "adultCount") int adultCount, @RequestParam(value = "childCount")int childCount){


        return roomTypeService.findProperRoomType(adultCount,childCount);

    }
    @GetMapping("/3")
    public List<RoomType> preferedRoomType(@RequestParam(value = "adultCount") int adultCount, @RequestParam(value = "childCount")int childCount){
        return roomTypeService.findRoomType(adultCount,childCount);

    }



}
