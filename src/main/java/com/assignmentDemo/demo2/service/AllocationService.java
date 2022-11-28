package com.assignmentDemo.demo2.service;

import com.assignmentDemo.demo2.repository.AllocationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AllocationService {
    @Autowired
    AllocationRepo allocationRepo;


//    public Boolean isAvailableForOneDay(Date date) {
//        return allocationRepo.findByForOneDay(date);
//
//    }

//    public List<Allocation> getFreeRooms(int roomsId) {
//        Rooms rooms = new Rooms();
//        rooms.setRoomsId(roomsId);
//        return allocationRepo.findByRooms(rooms);
//    }
    public List<Integer> getFreeRooms(int roomsId, Date firstDate, Date endDate) {
        return allocationRepo.findByAllocatedCount(firstDate,endDate,roomsId);
    }

}
