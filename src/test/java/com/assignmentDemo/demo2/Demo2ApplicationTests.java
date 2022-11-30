package com.assignmentDemo.demo2;

import com.assignmentDemo.demo2.model.RoomType;
import com.assignmentDemo.demo2.model.Rooms;
import com.assignmentDemo.demo2.repository.AllocationRepo;
import com.assignmentDemo.demo2.service.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootTest
class Demo2ApplicationTests {

@Autowired
	RoomTypeService roomTypeService;



	@Test
	void contextLoads() {

		List<RoomType> roomTypes = roomTypeService.findRoomType(1,3);
		System.out.println(roomTypes);


	}
}
