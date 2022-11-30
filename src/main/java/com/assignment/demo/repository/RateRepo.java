package com.assignment.demo.repository;

import com.assignment.demo.model.Rate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.Optional;

@Repository
public interface RateRepo extends JpaRepository<Rate, Integer> {
    @Query("SELECT r.rate FROM Rate r where (:startDate >= r.startDate AND :startDate <= r.endDate) AND r.rooms.roomsId = :rooms ")
    Optional<Integer> filterRate(@Param("startDate") Timestamp startDate, @Param("rooms") int roomsId);
}
