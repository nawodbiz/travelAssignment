package com.assignmentDemo.demo2.pojo;

import com.assignmentDemo.demo2.model.Rooms;

import java.util.List;

public class SearchResult {
    private String hotelName;
    private int rate;
    private List<Rooms> roomsList;

    public SearchResult() {
    }

    public SearchResult(String hotelName, int rate, List<Rooms> roomsList) {
        this.hotelName = hotelName;
        this.rate = rate;
        this.roomsList = roomsList;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public List<Rooms> getRoomsList() {
        return roomsList;
    }

    public void setRoomsList(List<Rooms> roomsList) {
        this.roomsList = roomsList;
    }
}
