package com.assignmentDemo.demo2.dao;

import com.assignmentDemo.demo2.model.Allocation;
import com.assignmentDemo.demo2.model.Rooms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface AllocationRepo extends JpaRepository<Allocation,Integer> {
//    Boolean findByForOneDay(Date date);

//    Allocation findByAllocationCount(int roomsId);

    List<Allocation> findByRooms(Rooms rooms);
}
