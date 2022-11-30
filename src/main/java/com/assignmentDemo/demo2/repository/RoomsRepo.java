package com.assignmentDemo.demo2.repository;

import com.assignmentDemo.demo2.model.Hotel;
import com.assignmentDemo.demo2.model.RoomType;
import com.assignmentDemo.demo2.model.Rooms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomsRepo extends JpaRepository<Rooms,Integer> {
    @Query("SELECT u FROM Rooms u WHERE u.hotel = :hotel AND u.roomType.roomTypeId = :roomTypeId")
    List<Rooms> findByHotel(@Param("hotel") Hotel hotel, @Param("roomTypeId") int roomTypeId);

//    @Query ("SELECT u FROM RoomType u WHERE u.adultCount+u.childCount >= :adultCount+:childCount AND u.adultCount>=:adultCount")
//    List<RoomType> findByTotalPax(
//            @Param("adultCount") int rAdultCount,
//            @Param("childCount") int rChildCountSS
//    );

}
