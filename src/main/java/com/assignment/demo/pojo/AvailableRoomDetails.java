package com.assignment.demo.pojo;

public class AvailableRoomDetails {
    private String roomType;
    private int availableRoomCount;


    public AvailableRoomDetails() {
    }

    public AvailableRoomDetails(String roomType, int availableRoomCount) {
        this.roomType = roomType;
        this.availableRoomCount = availableRoomCount;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public int getAvailableRoomCount() {
        return availableRoomCount;
    }

    public void setAvailableRoomCount(int availableRoomCount) {
        this.availableRoomCount = availableRoomCount;
    }
}
