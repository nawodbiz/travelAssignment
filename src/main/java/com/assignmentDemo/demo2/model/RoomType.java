package com.assignmentDemo.demo2.model;

import javax.persistence.*;

@Entity
@Table(name = "room_type")
public class RoomType {
    @Id
    @Column(name = "room_type_id")
    private int roomTypeId;
    @Column(name = "room_type_name")
    private String roomTypeName;
    @Column(name = "adult_count")
    private int adultCount;
    @Column(name = "child_count")
    private int childCount;



    public RoomType() {
    }

    public RoomType(int roomTypeId, String roomTypeName, int adultCount, int childCount, int rate) {
        this.roomTypeId = roomTypeId;
        this.roomTypeName = roomTypeName;
        this.adultCount = adultCount;
        this.childCount = childCount;

    }



    public int getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(int roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    public String getRoomTypeName() {
        return roomTypeName;
    }

    public void setRoomTypeName(String roomTypeName) {
        this.roomTypeName = roomTypeName;
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
}
