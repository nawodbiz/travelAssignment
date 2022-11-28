package com.assignmentDemo.demo2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Location")

public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "location_id")
    private int locationId;
    @Column(name = "location_name")
    private String locationName;
    @Column(name = "location_code")
    private String locationCode;
    @Column(name = "postal_code")
    private int postalCode;

    @JsonIgnore
    @OneToMany(mappedBy = "location")
    private Set<Hotel> hotelList = new HashSet<>();

    public Set<Hotel> getHotelList() {
        return hotelList;
    }

    public Location() {
    }

    public Location(int locationId) {
        this.locationId = locationId;
    }

    public Location(int locationId, String locationName, String locationCode, int postalCode) {
        this.locationId = locationId;
        this.locationName = locationName;
        this.locationCode = locationCode;
        this.postalCode = postalCode;
    }

    public String getLocationCode() {
        return locationCode;
    }

    public void setLocationCode(String locationCode) {
        this.locationCode = locationCode;
    }

    public void setHotelList(Set<Hotel> hotelList) {
        this.hotelList = hotelList;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }
}
