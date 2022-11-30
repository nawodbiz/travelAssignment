package com.assignmentDemo.demo2.service;

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
    public List<Rooms> findRoomsByHotelKey(int hotelId){
        Hotel hotel = new Hotel();
        hotel.setHotelId(hotelId);
        return roomsRepo.findByHotel(hotel);
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
    public List<Rooms> availableRoomsForHotel(Hotel hotel){
        return roomsRepo.findByHotel(hotel);
    }
    public List<Rooms> availableRooms(Hotel hotel, Timestamp firstDate, Timestamp endDate) {
        List<Rooms> availableRoomsList = new ArrayList<>();
        List<Rooms> availableRoomsForHotel = availableRoomsForHotel(hotel);
        for (Rooms rooms : availableRoomsForHotel) {
            if (getAvailableRoomsCount(rooms.getRoomsId(), firstDate, endDate) > 0) {
                rooms.setRoomsCount(remainingRoomsCount);
                availableRoomsList.add(rooms);
            }
        }
        return availableRoomsList;
    }



//    public List<Rooms> getAvailableRoomsForLocation(List<Hotel> hotelListForLocation, Date firstDate, Date endDate){
//
//        List<Rooms> availableRooms = new ArrayList<>();
//        int id;
//
//        for(Rooms room: availableRoomsForHotel(hotelId)){
//            id = availableRooms(room.getRoomsId(),firstDate,endDate);
//            getRoomsById(id);
//        }
//        return availableRooms;
//        for(Hotel hotel: hotelListForLocation){
//
//        }



    }
