package com.assignmentDemo.demo2.repository;

import com.assignmentDemo.demo2.model.Allocation;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface AllocationRepo extends JpaRepository<Allocation,Integer> {
//    Boolean findByForOneDay(Date date);

//    Allocation findByAllocationCount(int roomsId);

//    List<Allocation> findByRooms(Rooms rooms);

//    @Query("SELECT allocationId FROM Allocation u WHERE (u.rooms.roomsId = :roomsId )")
//    List<Integer> findByAllocatedCount(@Param("roomsId") int roomsId);

//    @Query("SELECT u.allocationCount FROM Allocation u WHERE ((u.firstDate<=:firstDate AND u.endDate>=:firstDate) OR (u.firstDate<=:endDate AND u.endDate>=:endDate) OR (u.firstDate>=:firstDate AND u.firstDate <= :endDate) OR (u.endDate <= :endDate AND u.endDate >= :firstDate)) AND (u.rooms.roomsId=:roomsId ) order by u.allocationCount desc")





//    @Query(value = "SELECT u.allocation_count  FROM Allocation u where (u.rooms_Id=:roomsId)  and ((u.first_Date<=:firstDate AND u.end_Date>=:firstDate) OR (u.first_Date<=:endDate AND u.end_Date>=:endDate) OR (u.first_Date>=:firstDate AND u.first_Date <= :endDate) OR (u.end_Date <= :endDate AND u.end_Date >= :firstDate) ) order by u.allocation_count desc" ,nativeQuery = true)
//@Query(value = "SELECT u.allocation_count  FROM Allocation u where (u.rooms_Id=:roomsId)  and ((u.first_Date<=:firstDate AND u.end_Date>=:firstDate) OR (u.first_Date<=:endDate AND u.end_Date>=:endDate) OR (u.first_Date>=:firstDate AND u.first_Date <= :endDate) OR (u.end_Date <= :endDate AND u.end_Date >= :firstDate) ) order by u.allocation_count desc" ,nativeQuery = true)

    @Query("SELECT u.allocationCount FROM Allocation u WHERE (u.rooms.roomsId = :roomsId) AND ((u.firstDate <= :firstDate AND u.endDate >= :firstDate) OR (u.firstDate <= :endDate AND u.endDate >= :endDate) OR (u.firstDate >= :firstDate AND u.firstDate <= :endDate) OR (u.endDate <= :endDate AND u.endDate >= :firstDate)) order by u.allocationCount  desc")
    List<Integer> getAllocatedCountByRoomsId(@Param("firstDate") Timestamp firstDate, @Param("endDate") Timestamp endDate, @Param("roomsId") int roomsId);

}
