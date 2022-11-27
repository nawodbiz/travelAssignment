package com.assignmentDemo.demo2.service;

import com.assignmentDemo.demo2.dao.AllocationRepo;
import com.assignmentDemo.demo2.model.Allocation;
import com.assignmentDemo.demo2.model.Rooms;
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

    public List<Allocation> getFreeRooms(int roomsId) {
        Rooms rooms = new Rooms();
        rooms.setRoomsId(roomsId);
        return allocationRepo.findByRooms(rooms);
    }
    public List<Allocation> getFreeRooms(int roomsId, Date startDate, Date endDate) {
        Rooms rooms = new Rooms();
        rooms.setRoomsId(roomsId);
        return allocationRepo.findByRooms(rooms);
    }

}
