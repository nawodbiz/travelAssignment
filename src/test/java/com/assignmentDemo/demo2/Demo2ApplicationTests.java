package com.assignmentDemo.demo2;

import com.assignmentDemo.demo2.dao.AllocationRepo;
import com.assignmentDemo.demo2.model.Rooms;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
class Demo2ApplicationTests {
@Autowired
	AllocationRepo allocationRepo;
	@Test
	void contextLoads() {
		List<Integer> sampleC= allocationRepo.findByAllocatedCount(new Date(2022,11,10),new Date(2022,11,25),10);
		System.out.println(sampleC);
	}



}
