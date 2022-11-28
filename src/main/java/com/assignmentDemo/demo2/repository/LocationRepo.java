package com.assignmentDemo.demo2.repository;

import com.assignmentDemo.demo2.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepo extends JpaRepository<Location, Integer> {
    Location findByLocationName(String name);
    Location findByPostalCode(int postalCode);
//    @Query("SELECT locationId FROM Location l WHERE l.locationCode = :locationCode")
    Location findByLocationCode(@Param("locationCode") String locationCode);

//    @Query("SELECT allocationCount FROM Allocation u WHERE ((u.firstDate<=:firstDate AND u.endDate>=:firstDate) OR (u.firstDate<=:endDate AND u.endDate<=:endDate)) AND (u.rooms.roomsId=:roomsId )")
//    List<Integer> findByAllocatedCount(@Param("firstDate") Date firstDate, @Param("endDate") Date endDate, @Param("roomsId") int roomsId);
}
