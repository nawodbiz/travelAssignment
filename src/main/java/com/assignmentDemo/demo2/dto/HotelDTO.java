package com.assignmentDemo.demo2.dto;

import com.assignmentDemo.demo2.model.Location;

public class HotelDTO {
    private int hotelKey;
    private String hotelName;
    private String ContactNumber;
    private String address;
    private Location location;

    public HotelDTO() {
    }

    public HotelDTO(int hotelKey, String hotelName, String contactNumber, String address, Location location) {
        this.hotelKey = hotelKey;
        this.hotelName = hotelName;
        ContactNumber = contactNumber;
        this.address = address;
        this.location = location;
    }

    public int getHotelKey() {
        return hotelKey;
    }

    public void setHotelKey(int hotelKey) {
        this.hotelKey = hotelKey;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getContactNumber() {
        return ContactNumber;
    }

    public void setContactNumber(String contactNumber) {
        ContactNumber = contactNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
