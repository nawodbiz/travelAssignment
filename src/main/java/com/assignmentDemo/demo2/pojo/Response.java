package com.assignmentDemo.demo2.pojo;

import com.assignmentDemo.demo2.model.Rooms;

import java.util.List;

public class Response {
    private String hotelName;
    private List<Rooms> availableRoomsList;

    public Response() {
    }

    public Response(String hotelName, List<Rooms> availableRoomsList) {
        this.hotelName = hotelName;
        this.availableRoomsList = availableRoomsList;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public List<Rooms> getAvailableRoomsList() {
        return availableRoomsList;
    }

    public void setAvailableRoomsList(List<Rooms> availableRoomsList) {
        this.availableRoomsList = availableRoomsList;
    }
}
