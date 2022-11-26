package com.assignmentDemo.demo2.pojo;

import com.assignmentDemo.demo2.model.Rooms;

import java.util.List;

public class SearchResult {
    private String hotel;
    private int rate;
    private List<Rooms> roomsList;

    public SearchResult() {
    }

    public SearchResult(String hotel, int rate, List<Rooms> roomsList) {
        this.hotel = hotel;
        this.rate = rate;
        this.roomsList = roomsList;
    }

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
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
