package com.assignmentDemo.demo2.service;

import com.assignmentDemo.demo2.model.Hotel;
import com.assignmentDemo.demo2.model.Rooms;
import com.assignmentDemo.demo2.pojo.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public List<Response> sendRequest(String locationCode,int adultCount, int childCount, Date startDate, Date endDate) {
        List<Response> responseList = new ArrayList<>();

        for(Hotel hotel:availableHotelList(locationCode)){
            Response response = new Response();
            response.setHotelName(hotel.getHotelName());
            response.setAvailableRoomsList(roomsService.availableRoomsForHotel(hotel));
            responseList.add(response);
        }
        return responseList;

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
