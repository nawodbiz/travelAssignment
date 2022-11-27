package com.assignmentDemo.demo2.dao;

import com.assignmentDemo.demo2.model.Allocation;
import com.assignmentDemo.demo2.model.RoomType;
import com.assignmentDemo.demo2.model.Rooms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface AllocationRepo extends JpaRepository<Allocation,Integer> {
//    Boolean findByForOneDay(Date date);

    Allocation findByAllocationCount(int roomsId);

    List<Allocation> findByRooms(Rooms rooms);

    @Query("SELECT allocationCount FROM Allocation u WHERE ((u.firstDate<=firstDate AND u.endDate>=firstDate) OR (u.firstDate<=firstDate AND u.endDate<=endDate)) AND (u.rooms=rooms )")
    List<Integer> findByAllocatedCount(@Param("firstDate") Date firstDate, @Param("endDate") Date endDate, @Param("roomId") int rooms);

}
