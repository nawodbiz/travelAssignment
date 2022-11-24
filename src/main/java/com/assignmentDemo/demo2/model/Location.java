package com.assignmentDemo.demo2.model;

import javax.persistence.*;

@Entity
@Table(name = "Location")

public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int locationKey;
    private String locationName;
    private int postalCode;

    public Location() {
    }

    public Location(int locationKey, String locationName, int postalCode) {
        this.locationKey = locationKey;
        this.locationName = locationName;
        this.postalCode = postalCode;
    }

    public int getLocationKey() {
        return locationKey;
    }

    public void setLocationKey(int locationKey) {
        this.locationKey = locationKey;
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
