package com.assignment.demo.service;

import com.assignment.demo.model.Hotel;
import com.assignment.demo.model.Rooms;
import com.assignment.demo.pojo.SearchResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
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

    public List<SearchResult> sendRequest(String locationCode, int adultCount, int childCount, Timestamp startDate, Timestamp endDate) {
        List<SearchResult> searchResultList = new ArrayList<>();

        for (Hotel hotel : availableHotelList(locationCode)) {
            for (Rooms rooms : roomsService.availableRooms(hotel, startDate, endDate, adultCount, childCount)) {
                if (rateService.getRate(startDate, rooms.getRoomsId()).isPresent()) {
                    SearchResult searchResult = new SearchResult();
                    searchResult.setHotelName(hotel.getHotelName());
                    searchResult.setRoomType(rooms.getRoomType().getRoomTypeName());
                    searchResult.setAdultCount(rooms.getRoomType().getAdultCount());
                    searchResult.setChildCount(rooms.getRoomType().getChildCount());
                    searchResult.setAvailableRoomCount(rooms.getRoomsCount());
                    searchResult.setAddress(hotel.getAddress());
                    searchResult.setRate(rateService.getRate(startDate, rooms.getRoomsId()).get());
                    searchResultList.add(searchResult);
                }
            }
        }
        return searchResultList.stream().sorted((o1, o2) -> Integer.compare(o1.getRate(), o2.getRate())).collect(Collectors.toList());
    }

    public List<Hotel> availableHotelList(String locationCode) {

        return hotelService.getHotelsByLocationCode(locationCode);
    }
}
