package com.assignmentDemo.demo2;

import com.assignmentDemo.demo2.repository.AllocationRepo;
import com.assignmentDemo.demo2.service.HotelService;
import com.assignmentDemo.demo2.service.RateService;
import com.assignmentDemo.demo2.service.RoomsService;
import com.assignmentDemo.demo2.service.TravelService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
class Demo2ApplicationTests {
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
