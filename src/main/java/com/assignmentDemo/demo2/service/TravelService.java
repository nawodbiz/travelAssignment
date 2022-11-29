package com.assignmentDemo.demo2.service;

import com.assignmentDemo.demo2.model.Hotel;
import com.assignmentDemo.demo2.model.Rooms;
import com.assignmentDemo.demo2.pojo.searchResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    public List<searchResult> sendRequest(String locationCode, int adultCount, int childCount, Timestamp startDate, Timestamp endDate) {
        List<searchResult> searchResultList = new ArrayList<>();

        for(Hotel hotel:availableHotelList(locationCode)){
            if(roomsService.availableRoomsForHotel(hotel).isEmpty())
                continue;
            for(Rooms rooms: roomsService.availableRoomsForHotel(hotel)){
                if(rateService.getRate(startDate,rooms.getRoomsId()).isPresent()){
                    searchResult searchResult = new searchResult();
                    searchResult.setHotelName(hotel.getHotelName());
                    searchResult.setRoomType(rooms.getRoomType().getRoomTypeName());
                    searchResult.setAdultCount(rooms.getRoomType().getAdultCount());
                    searchResult.setChildCount(rooms.getRoomType().getChildCount());
                    searchResult.setAddress(hotel.getAddress());
                    searchResult.setRate(rateService.getRate(startDate,rooms.getRoomsId()).get());
                    searchResultList.add(searchResult);
                }

            }



        }

        return searchResultList;

    }
    public List<Hotel> availableHotelList(String locationCode){
        List<Hotel> locationHotelList =  hotelService.getHotelsByLocationCode(locationCode);
        return locationHotelList;
    }

//    public List<Response> getSampleResponse (String locationCode, Date startDate, Date endDate ){
//        List<Response> hotelListResponse = new ArrayList<>();
//        for(Hotel hotel: hotelService.getHotelsByLocationCode(locationCode)){
//            Response response = new Response();
//            response.setHotelName(hotel.getHotelName());
//            response.setAvailableRoomsList(roomsService.availableRooms(hotel,startDate,endDate));
//            hotelListResponse.add(response);
//        }
//        return hotelListResponse;
//
//    }
//    public List<Response> sample (String locationCode){
//        List<Response> responseList = new ArrayList<>();
//        for(Hotel hotel: hotelService.getHotelsByLocationCode(locationCode)){
//            Response response = new Response();
//            response.setHotelName(hotel.getHotelName());
//            responseList.add(response);
//        }
//        return responseList;
//    }


}
