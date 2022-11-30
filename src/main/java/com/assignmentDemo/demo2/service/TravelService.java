package com.assignmentDemo.demo2.service;

import com.assignmentDemo.demo2.model.Hotel;
import com.assignmentDemo.demo2.model.RoomType;
import com.assignmentDemo.demo2.model.Rooms;
import com.assignmentDemo.demo2.pojo.searchResult;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Comparator;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TravelService {

    @Autowired
    RoomsService roomsService;
    @Autowired
    HotelService hotelService;
    @Autowired
    LocationService locationService;

    @Autowired
    RateService rateService;

    @Autowired
    RoomTypeService roomTypeService;

    public List<searchResult> sendRequest(String locationCode, int adultCount, int childCount, Timestamp startDate, Timestamp endDate) {
        List<searchResult> searchResultList = new ArrayList<>();

        for(Hotel hotel:availableHotelList(locationCode)){
            for(Rooms rooms: roomsService.availableRooms(hotel,startDate,endDate, adultCount, childCount)){
                if(rateService.getRate(startDate,rooms.getRoomsId()).isPresent()){
                    searchResult searchResult = new searchResult();
                    searchResult.setHotelName(hotel.getHotelName());
                    searchResult.setRoomType(rooms.getRoomType().getRoomTypeName());
                    searchResult.setAdultCount(rooms.getRoomType().getAdultCount());
                    searchResult.setChildCount(rooms.getRoomType().getChildCount());
                    searchResult.setAvailableRoomCount(rooms.getRoomsCount());
                    searchResult.setAddress(hotel.getAddress());
                    searchResult.setRate(rateService.getRate(startDate,rooms.getRoomsId()).get());
                    searchResultList.add(searchResult);
                }

            }
        }

        return searchResultList.stream().sorted(new Comparator<searchResult>() {
            @Override
            public int compare(searchResult o1, searchResult o2) {
                return Integer.compare(o1.getRate(),o2.getRate());
            }
        }).collect(Collectors.toList());

    }
    public List<Hotel> availableHotelList(String locationCode){
        List<Hotel> locationHotelList =  hotelService.getHotelsByLocationCode(locationCode);
        return locationHotelList;
    }




}
