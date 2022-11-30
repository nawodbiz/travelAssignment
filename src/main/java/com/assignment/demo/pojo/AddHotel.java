package com.assignment.demo.pojo;

public class AddHotel {
    private int hotelKey;
    private String hotelName;
    private String contactNumber;
    private String address;
    private int locationId;

    public AddHotel() {
    }

    public AddHotel(int hotelKey, String hotelName, String contactNumber, String address, int locationId) {
        this.hotelKey = hotelKey;
        this.hotelName = hotelName;
        this.contactNumber = contactNumber;
        this.address = address;
        this.locationId = locationId;
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
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }
}
