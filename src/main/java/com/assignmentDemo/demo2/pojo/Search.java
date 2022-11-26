package com.assignmentDemo.demo2.pojo;

import java.util.Date;

public class Search {
    private String location;
    private int adultCount;
    private int childCount;
    private Date startDate;
    private Date endDate;

    public Search() {
    }

    public Search(String location, int adultCount, int childCount, Date startDate, Date endDate) {
        this.location = location;
        this.adultCount = adultCount;
        this.childCount = childCount;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
