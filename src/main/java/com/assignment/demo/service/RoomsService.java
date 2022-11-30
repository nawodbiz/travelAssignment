package com.assignment.demo.service;

import com.assignment.demo.model.Hotel;
import com.assignment.demo.model.RoomType;
import com.assignment.demo.model.Rooms;
import com.assignment.demo.pojo.AddRooms;
import com.assignment.demo.repository.AllocationRepo;
import com.assignment.demo.repository.HotelRepo;
import com.assignment.demo.repository.RoomTypeRepo;
import com.assignment.demo.repository.RoomsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class RoomsService {
    private int remainingRoomsCount;
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

    public Rooms addRooms(AddRooms addRooms) {

        Rooms rooms = new Rooms();
        rooms.setRoomsId(addRooms.getRoomsId());
        rooms.setRoomsCount(addRooms.getRoomCount());
        rooms.setHotel(hotelRepo.findById(addRooms.getHotelId()).get());
        rooms.setRoomType(roomTypeRepo.findById(addRooms.getRoomTypeId()).get());
        return roomsRepo.save(rooms);
    }

    public int getRemainingRoomsCount() {
        return remainingRoomsCount;
    }

    public void setRemainingRoomsCount(int remainingRoomsCount) {
        this.remainingRoomsCount = remainingRoomsCount;
    }

    public Rooms getRoomsById(int roomsId) {
        return roomsRepo.findById(roomsId).get();
    }

    public List<Rooms> getAllRooms() {
        return roomsRepo.findAll();
    }

    public int getAvailableRoomsCount(int roomsId, Timestamp firstDate, Timestamp endDate) {
        int initialRoomsCount = roomsRepo.findById(roomsId).get().getRoomsCount();
        Integer allocatedRoomsCount = 0;

        List<Integer> temp = allocationRepo.getAllocatedCountByRoomsId(firstDate, endDate, roomsId);
        if (!temp.isEmpty()) {
            allocatedRoomsCount = temp.get(0);
        }
        remainingRoomsCount = initialRoomsCount - allocatedRoomsCount;
        return remainingRoomsCount;
    }

    public List<Rooms> availableRoomsForHotel(Hotel hotel, int roomTypeId) {
        return roomsRepo.findByHotel(hotel, roomTypeId);
    }

    public List<Rooms> availableRooms(Hotel hotel, Timestamp firstDate, Timestamp endDate, int adultCount, int childCount) {
        List<Integer> matchingRoomsIds = matchingRoomTypes(adultCount, childCount);
        List<Rooms> availableRoomsList = new ArrayList<>();
        for (Integer i : matchingRoomsIds) {


            List<Rooms> availableRoomsForHotel = availableRoomsForHotel(hotel, i);
            for (Rooms rooms : availableRoomsForHotel) {
                if (getAvailableRoomsCount(rooms.getRoomsId(), firstDate, endDate) > 0) {
                    rooms.setRoomsCount(remainingRoomsCount);
                    availableRoomsList.add(rooms);
                }
            }

        }

        return availableRoomsList;
    }


    public List<Integer> matchingRoomTypes(int adultCount, int childCount) {
        List<Integer> roomTypeIds = new ArrayList<>();
        for (RoomType roomType : roomTypeService.findRoomType(adultCount, childCount)) {
            roomTypeIds.add(roomType.getRoomTypeId());
        }
        return roomTypeIds;
    }


}
