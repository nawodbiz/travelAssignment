package com.assignmentDemo.demo2.model;

import javax.persistence.*;

@Entity
@Table(name = "Hotel")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hotel_id")
    private int hotelId;
    @Column(name = "hotel_name")
    private String hotelName;
    @Column(name = "contact_Number")
    private String ContactNumber;
    @Column(name = "address")
    private String address;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id",referencedColumnName = "location_id")
    private Location location;
    public Hotel() {
    }

    public Hotel(int hotelId) {
        this.hotelId = hotelId;
    }

    public Hotel(int hotelId, String hotelName, String contactNumber, String address, Location location) {
        this.hotelId = hotelId;
        this.hotelName = hotelName;
        ContactNumber = contactNumber;
        this.address = address;
        this.location = location;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
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
