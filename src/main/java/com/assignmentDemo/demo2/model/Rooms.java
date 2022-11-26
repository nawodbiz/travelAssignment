package com.assignmentDemo.demo2.model;

import javax.persistence.*;

@Entity
public class Rooms {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rooms_id")
    private int roomsId;
    @Column(name = "room_count")
    private int roomCount;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "hotel_id",referencedColumnName = "hotel_id")
    private Hotel hotel;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "room_type_id",referencedColumnName = "room_type_id")
    private RoomType roomType;

    public Rooms() {
    }

    public Rooms(int roomsId, int roomCount, Hotel hotel, RoomType roomType) {
        this.roomsId = roomsId;
        this.roomCount = roomCount;
        this.hotel = hotel;
        this.roomType = roomType;
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

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }
}
