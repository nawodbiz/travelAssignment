package com.assignment.demo.service;

import com.assignment.demo.model.RoomType;
import com.assignment.demo.repository.RoomTypeRepo;
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

    public RoomType updateRoomType(RoomType roomType) {
        RoomType tempRoomType = new RoomType();
        tempRoomType.setRoomTypeId(roomType.getRoomTypeId());
        tempRoomType.setRoomTypeName(roomType.getRoomTypeName());
        tempRoomType.setAdultCount(roomType.getAdultCount());
        tempRoomType.setChildCount(roomType.getChildCount());
        return roomTypeRepo.save(tempRoomType);
    }

    public String deleteRoomType(int roomTypeId) {
        roomTypeRepo.delete(roomTypeRepo.findById(roomTypeId).get());
        return "Room Type Deleted for Id " + roomTypeId;
    }

    public List<RoomType> getAllRoomTypes() {
        return roomTypeRepo.findAll();
    }

    public RoomType findProperRoomType(int adultCount, int childCount) {
        RoomType properRoomType = new RoomType();
        for (RoomType roomType : roomTypeRepo.findAll()) {
            if (roomType.getAdultCount() + roomType.getChildCount() >= adultCount + childCount &&
                    roomType.getAdultCount() >= adultCount) {
                properRoomType = roomType;
                return properRoomType;
            }
        }
        return properRoomType;
    }

    public List<RoomType> findRoomType(int adultCount, int childCount) {
        return roomTypeRepo.findByTotalPax(adultCount, childCount);

    }
}



