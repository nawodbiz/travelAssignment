package com.assignment.demo.repository;

import com.assignment.demo.model.Allocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface AllocationRepo extends JpaRepository<Allocation, Integer> {
    @Query("SELECT u.allocationCount FROM Allocation u WHERE (u.rooms.roomsId = :roomsId) AND ((u.firstDate <= :firstDate AND u.endDate >= :firstDate) OR (u.firstDate <= :endDate AND u.endDate >= :endDate) OR (u.firstDate >= :firstDate AND u.firstDate <= :endDate) OR (u.endDate <= :endDate AND u.endDate >= :firstDate)) order by u.allocationCount  desc")
    List<Integer> getAllocatedCountByRoomsId(@Param("firstDate") Timestamp firstDate, @Param("endDate") Timestamp endDate, @Param("roomsId") int roomsId);

}
