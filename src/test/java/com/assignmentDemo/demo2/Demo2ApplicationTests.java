package com.assignmentDemo.demo2;

import com.assignmentDemo.demo2.model.Hotel;
import com.assignmentDemo.demo2.model.Location;
import com.assignmentDemo.demo2.model.Rooms;
import com.assignmentDemo.demo2.pojo.Response;
import com.assignmentDemo.demo2.repository.AllocationRepo;
import com.assignmentDemo.demo2.service.HotelService;
import com.assignmentDemo.demo2.service.RoomsService;
import com.assignmentDemo.demo2.service.TravelService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

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


	@Test
	void contextLoads() {

		List<Response> responseList = travelService.sendRequest("GAL",1,1,new Date(2022,11,10), new Date(2022,11,25));
		System.out.println(responseList);

//		int count =roomsService.getAvailableRoomsCount(5,new Date(2022,10,10),new Date(2022,10,25));
//		System.out.println(count);
//		List<Integer> list = allocationRepo.findByAllocatedCount(new Date(2022,11,10),new Date(2022,11,25),6);
//		System.out.println(list);
//		int allocatedCount = roomsService.getAvailableRoomsCount(5,new Date(2022,11,10),new Date(2022,11,25));
//		System.out.println(allocatedCount);

//		List<Rooms> roomsList =  roomsService.availableRooms(new Hotel(1),new Date(2022,11,10),new Date(2022,11,25));
//		System.out.println(roomsList);

//		List<Response> responseList = travelService.getSampleResponse("gal", new Date(2022,10,10),new Date(2022,10,25));
//		System.out.println(responseList);

//		List<Response> responseList = travelService.sample("GAL");
//		System.out.println(responseList);

//		List<Hotel> hotelList = hotelService.getHotelsByLocationCode("GAL");
//		System.out.println(hotelList);

	}
}
