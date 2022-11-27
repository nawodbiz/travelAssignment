package com.assignmentDemo.demo2.pojo;

public class Response2 {
    private String hotelName;
    private String roomType;

    private int rate;

    public Response2() {
    }

    public Response2(String hotelName, String roomType, int rate) {
        this.hotelName = hotelName;
        this.roomType = roomType;

        this.rate = rate;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }



    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }
}
