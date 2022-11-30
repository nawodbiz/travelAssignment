package com.assignment.demo;

import com.assignment.demo.repository.AllocationRepo;
import com.assignment.demo.service.HotelService;
import com.assignment.demo.service.RateService;
import com.assignment.demo.service.RoomsService;
import com.assignment.demo.service.TravelService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;

@SpringBootTest
class APIApplicationTests {
    @Autowired
    RoomsService roomsService;
    @Autowired
    AllocationRepo allocationRepo;
    @Autowired
    TravelService travelService;
    @Autowired
    HotelService hotelService;
    @Autowired
    RateService rateService;


    @Test
    void contextLoads() throws ParseException {

//		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//		Date parsedDate = dateFormat.parse("2023-01-05 00:00:00");
//		Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());
//
//		SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//		Date parsedDate2 = dateFormat.parse("2023-01-10 00:00:00");
//		Timestamp timestamp2 = new java.sql.Timestamp(parsedDate2.getTime());
//
//		Integer rooms = roomsService.getAvailableRoomsCount(5,timestamp,timestamp2);
//		System.out.println(rooms);


    }
}
