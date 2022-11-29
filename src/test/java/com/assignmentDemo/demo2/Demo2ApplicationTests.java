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


		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date parsedDate = dateFormat.parse("2022-11-01 00:00:00");
		Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());



		Integer rate = rateService.getRate(timestamp,1);
		System.out.println(rate);





//		List<Integer> rate = rateRepo.filterRate(new SimpleDateFormat("yyyy-MM-dd").parse("2022-10-30"),1);
//		System.out.println(rate);

//
//		List<Rate> rateList = rateRepo.findAll();
//		System.out.println(rateList);
//
//		List<Allocation> alList = allocationRepo.findAll();
//		System.out.println(alList);



//		List<searchResult> searchResultList = travelService.sendRequest("GAL",1,1,new Date(2022,10,10), new Date(2022,10,25));
//		System.out.println(searchResultList);


	}
}
