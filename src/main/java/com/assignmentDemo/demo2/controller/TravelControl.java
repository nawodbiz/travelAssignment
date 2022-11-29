package com.assignmentDemo.demo2.controller;

import com.assignmentDemo.demo2.pojo.searchResult;
import com.assignmentDemo.demo2.service.TravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/travel")
public class TravelControl {

    @Autowired
    TravelService travelService;
    @GetMapping(value = "/sendRequest")
    public List<searchResult> getResponse(@RequestParam(value = "locationCode") String locationCode,
                                          @RequestParam(value = "adultCount") int adultCount,
                                          @RequestParam(value = "childCount") int childCount,
                                          @RequestParam(value = "startDate") Timestamp startDate,
                                          @RequestParam(value = "endDate") Timestamp endDate){
        return travelService.sendRequest(locationCode,adultCount,childCount,startDate,endDate);
    }

//    @PostMapping("/sample")
//    public void getDate(@RequestParam(value = "date") Timestamp time){
//
//        System.out.println("hit");
//    }



//    @GetMapping("/sendRequest")
//    public List<Response> getResponse(){
//        System.out.println("got");
//        return travelService.sendRequest("GAL",1,1,new Date(2022,10,10),new Date(2022,10,25));
//    }



//    public List<Response> getResponse(@RequestParam(value = "locationCode") String locationCode,
//                                      @RequestParam(value = "adultCount") int adultCount,
//                                      @RequestParam(value = "childCount") int childCount,
//                                      @RequestParam(value = "startDate") Date startDate,
//                                      @RequestParam(value = "endDate") Date endDate){
//        return travelService.sendRequest(locationCode,adultCount,childCount,startDate,endDate);
//    }



}
