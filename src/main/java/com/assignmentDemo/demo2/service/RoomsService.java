package com.assignmentDemo.demo2.service;

import com.assignmentDemo.demo2.model.RoomType;
import com.assignmentDemo.demo2.repository.AllocationRepo;
import com.assignmentDemo.demo2.repository.HotelRepo;
import com.assignmentDemo.demo2.repository.RoomTypeRepo;
import com.assignmentDemo.demo2.repository.RoomsRepo;
import com.assignmentDemo.demo2.model.Hotel;
import com.assignmentDemo.demo2.model.Rooms;
import com.assignmentDemo.demo2.pojo.AddRooms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class RoomsService {
    @Autowired
    RoomsRepo roomsRepo;
    @Autowired
    HotelRepo hotelRepo;
    @Autowired
    RoomTypeRepo roomTypeRepo;
    @Autowired
    AllocationRepo allocationRepo;

    @Autowired
    RoomTypeService roomTypeService;
    public int remainingRoomsCount;
    public Rooms addRooms(AddRooms addRooms) {

        Rooms rooms = new Rooms();
        rooms.setRoomsId(addRooms.getRoomsId());
        rooms.setRoomsCount(addRooms.getRoomCount());
        rooms.setHotel(hotelRepo.findById(addRooms.getHotelId()).get());
        rooms.setRoomType(roomTypeRepo.findById(addRooms.getRoomTypeId()).get());
        return roomsRepo.save(rooms);
    }
//    public Rooms addOneRooms(Rooms rooms){
//        RoomType roomType = new RoomType();
//        roomType.se
//        return roomsRepo.save(rooms);
//    }
    public Rooms getRoomsById(int roomsId){
        return roomsRepo.findById(roomsId).get();
    }
    public List<Rooms> getAllRooms(){
        return roomsRepo.findAll();
    }

    public int getAvailableRoomsCount(int roomsId, Timestamp firstDate, Timestamp endDate){
        int initialRoomsCount = roomsRepo.findById(roomsId).get().getRoomsCount();
        Integer allocatedRoomsCount =0;
//        for(Integer i: allocationRepo.getAllocatedCountByRoomsId(firstDate,endDate,roomsId)){
//            allocatedRoomsCount+=i;
//        }

        List<Integer> temp = allocationRepo.getAllocatedCountByRoomsId(firstDate,endDate,roomsId);
        if(!temp.isEmpty()) {
            allocatedRoomsCount = temp.get(0);
        }

        return remainingRoomsCount = initialRoomsCount-allocatedRoomsCount;
    }
    public List<Rooms> availableRoomsForHotel(Hotel hotel , int roomTypeId){
         return roomsRepo.findByHotel(hotel, roomTypeId);
    }
    public List<Rooms> availableRooms(Hotel hotel, Timestamp firstDate, Timestamp endDate, int adultCount, int childCount) {
        List<Integer> matchingRoomsIds = matchingRoomTypes(adultCount,childCount);
        List<Rooms> availableRoomsList = new ArrayList<>();
        for(Integer i : matchingRoomsIds){


            List<Rooms> availableRoomsForHotel = availableRoomsForHotel(hotel,i);
            for (Rooms rooms : availableRoomsForHotel) {
                if (getAvailableRoomsCount(rooms.getRoomsId(), firstDate, endDate) > 0) {
                    rooms.setRoomsCount(remainingRoomsCount);
                    availableRoomsList.add(rooms);
                }
            }

        }

        return availableRoomsList;
    }



    public List<Integer> matchingRoomTypes(int adultCount, int childCount){
        List<Integer> roomTypeIds = new ArrayList<>();
        for(RoomType roomType: roomTypeService.findRoomType(adultCount,childCount)){
            roomTypeIds.add(roomType.getRoomTypeId());
        }
        return roomTypeIds;
    }


    }
