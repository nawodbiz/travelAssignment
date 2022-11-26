package com.assignmentDemo.demo2.service;

import com.assignmentDemo.demo2.dao.HotelRepo;
import com.assignmentDemo.demo2.dao.RoomTypeRepo;
import com.assignmentDemo.demo2.dao.RoomsRepo;
import com.assignmentDemo.demo2.model.Hotel;
import com.assignmentDemo.demo2.model.Rooms;
import com.assignmentDemo.demo2.pojo.AddRooms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomsService {
    @Autowired
    RoomsRepo roomsRepo;
    @Autowired
    HotelRepo hotelRepo;
    @Autowired
    RoomTypeRepo roomTypeRepo;
    public Rooms addRooms(AddRooms addRooms) {

        Rooms rooms = new Rooms();
        rooms.setRoomsId(addRooms.getRoomsId());
        rooms.setRoomCount(addRooms.getRoomCount());
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

}
