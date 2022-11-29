package com.assignmentDemo.demo2.pojo;

public class searchResult {
    private String hotelName;
    private String roomType;
    private int adultCount;
    private int childCount;
    private int rate;
    private String address;
//    private List<Rooms> availableRoomsList;

    public searchResult() {
    }

    public searchResult(String hotelName, String roomType, int adultCount, int childCount, int rate, String address) {
        this.hotelName = hotelName;
        this.roomType = roomType;
        this.adultCount = adultCount;
        this.childCount = childCount;
        this.rate = rate;
        this.address = address;
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

    public int getAdultCount() {
        return adultCount;
    }

    public void setAdultCount(int adultCount) {
        this.adultCount = adultCount;
    }

    public int getChildCount() {
        return childCount;
    }

    public void setChildCount(int childCount) {
        this.childCount = childCount;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
