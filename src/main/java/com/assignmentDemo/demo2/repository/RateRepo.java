package com.assignmentDemo.demo2.repository;

import com.assignmentDemo.demo2.model.Rate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface RateRepo extends JpaRepository<Rate,Integer> {

//    @Query ("SELECT r.rate FROM Rate r where (:startDate between r.startDate AND  r.endDate) AND r.rooms.roomsId = :roomsId ")

//    @Query ("SELECT r.rate FROM Rate r where (:startDate between r.startDate AND  r.endDate) AND r.rooms.roomsId = :roomsId ")
//    List<Integer> filterRate(@Param("startDate") Date startDate, @Param("roomsId") int roomsId);


//    @Query (value = "SELECT rate FROM Rate r WHERE :startDate > r.start_date AND r.room_id = :rooms ", nativeQuery = true)
//    List<Integer> filterRate(@Param("startDate") Date startDate, @Param("rooms") int roomsId);


    @Query ("SELECT r.rate FROM Rate r where (:startDate >= r.startDate AND :startDate <= r.endDate) AND r.rooms.roomsId = :rooms ")
    Optional<Integer> filterRate(@Param("startDate") Timestamp startDate, @Param("rooms") int roomsId);
}
