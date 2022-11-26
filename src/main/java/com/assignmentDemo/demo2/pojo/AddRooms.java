package com.assignmentDemo.demo2.pojo;

public class AddRooms {
    private int roomsId;
    private int roomCount;
    private int hotelId;
    private int roomTypeId;

    public AddRooms() {
    }

    public AddRooms(int roomsId, int roomCount, int hotelId, int roomTypeId) {
        this.roomsId = roomsId;
        this.roomCount = roomCount;
        this.hotelId = hotelId;
        this.roomTypeId = roomTypeId;
    }

    public int getRoomsId() {
        return roomsId;
    }

    public void setRoomsId(int roomsId) {
        this.roomsId = roomsId;
    }

    public int getRoomCount() {
        return roomCount;
    }

    public void setRoomCount(int roomCount) {
        this.roomCount = roomCount;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public int getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(int roomTypeId) {
        this.roomTypeId = roomTypeId;
    }
}
