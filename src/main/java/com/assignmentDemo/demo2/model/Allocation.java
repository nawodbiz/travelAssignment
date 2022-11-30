package com.assignmentDemo.demo2.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Allocation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "allocation_id")
    private int allocationId;
    @Column(name = "allocation_count")
    private int allocationCount;
    @Column(name = "first_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date firstDate;
    @Column(name = "end_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rooms_id")
    private Rooms rooms;

    public Allocation() {
    }

    public Allocation(int allocationId, int allocationCount, Date firstDate, Date endDate, Rooms rooms) {
        this.allocationId = allocationId;
        this.allocationCount = allocationCount;
        this.firstDate = firstDate;
        this.endDate = endDate;
        this.rooms = rooms;
    }

    public int getAllocationId() {
        return allocationId;
    }

    public void setAllocationId(int allocationId) {
        this.allocationId = allocationId;
    }

    public int getAllocationCount() {
        return allocationCount;
    }

    public void setAllocationCount(int allocationCount) {
        this.allocationCount = allocationCount;
    }

    public Date getFirstDate() {
        return firstDate;
    }

    public void setFirstDate(Date firstDate) {
        this.firstDate = firstDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Rooms getRooms() {
        return rooms;
    }

    public void setRooms(Rooms rooms) {
        this.rooms = rooms;
    }
}
