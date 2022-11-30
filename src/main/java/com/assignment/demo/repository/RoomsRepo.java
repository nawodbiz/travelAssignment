package com.assignment.demo.repository;

import com.assignment.demo.model.Hotel;
import com.assignment.demo.model.Rooms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomsRepo extends JpaRepository<Rooms, Integer> {
    @Query("SELECT u FROM Rooms u WHERE u.hotel = :hotel AND u.roomType.roomTypeId = :roomTypeId")
    List<Rooms> findByHotel(@Param("hotel") Hotel hotel, @Param("roomTypeId") int roomTypeId);


}
