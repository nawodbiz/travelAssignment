package com.assignmentDemo.demo2.service;

import com.assignmentDemo.demo2.dao.RoomTypeRepo;
import com.assignmentDemo.demo2.model.RoomType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    public String deleteRoomType(int roomTypeId) {
        roomTypeRepo.delete(roomTypeRepo.findById(roomTypeId).get());
        return "Room Type Deleted for Id " + roomTypeId;
    }

    public List<RoomType> getAllRoomTypes() {
        return roomTypeRepo.findAll();
    }

    public String getRoomTypeName(int totalPax) {
        if (totalPax == 1) {
            return "Single";
        } else if (totalPax == 2) {
            return "Double";
        } else if (totalPax == 3) {
            return "Triple";
        } else
            return "Family";

    }

    public int getRoomRate(int totalPax) {
        int roomRate;
        if (totalPax == 1) {
            return roomRate = 100;

        } else if (totalPax == 2) {
            return roomRate = 150;
        } else if (totalPax == 3) {
            return roomRate = 200;
        } else
            return roomRate = 300;

    }

    public RoomType findProperRoomType(int adultCount, int childCount) {
        RoomType properRoomType = new RoomType();
        for (RoomType roomType : roomTypeRepo.findAll()) {
            if (roomType.getAdultCount() + roomType.getChildCount() >= adultCount + childCount &&
                    roomType.getAdultCount() >= adultCount) {
                properRoomType = roomType;
                return properRoomType;
            }
//            else{
//                properRoomType = roomType;
//                return properRoomType;
//            }

        }
        return properRoomType;
    }

    public List<RoomType> findRoomType(int adultCount, int childCount) {
        return roomTypeRepo.findByTotalPax(adultCount,childCount);

    }
}



