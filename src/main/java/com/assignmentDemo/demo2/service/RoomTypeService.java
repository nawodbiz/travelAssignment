package com.assignmentDemo.demo2.service;

import com.assignmentDemo.demo2.dao.RoomTypeRepo;
import com.assignmentDemo.demo2.model.RoomType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomTypeService {

    @Autowired
    RoomTypeRepo roomTypeRepo;

    public RoomType setRoomType(RoomType roomType) {
        return roomTypeRepo.save(roomType);
    }

    public RoomType getRoomType(int roomTypeId) {
        return roomTypeRepo.findById(roomTypeId).get();
    }

    public RoomType UpdateRoomType(RoomType roomType) {
        RoomType tempRoomType = new RoomType();
        tempRoomType.setRoomTypeId(roomType.getRoomTypeId());
        tempRoomType.setRoomTypeName(roomType.getRoomTypeName());
        tempRoomType.setAdultCount(roomType.getAdultCount());
        tempRoomType.setChildCount(roomType.getChildCount());
        return roomTypeRepo.save(tempRoomType);
    }
    public String deleteRoomType(int roomTypeId){
        roomTypeRepo.delete(roomTypeRepo.findById(roomTypeId).get());
        return "Room Type Deleted for Id "+roomTypeId;
    }

    public List<RoomType> getAllRoomTypes() {
        return roomTypeRepo.findAll();
    }
}
