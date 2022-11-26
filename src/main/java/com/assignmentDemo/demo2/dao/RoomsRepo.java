package com.assignmentDemo.demo2.dao;

import com.assignmentDemo.demo2.model.Hotel;
import com.assignmentDemo.demo2.model.Rate;
import com.assignmentDemo.demo2.model.Rooms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomsRepo extends JpaRepository<Rooms,Integer> {
    List<Rooms> findByHotel(Hotel hotel);
    List<Rooms> findByRate(Rate rate);
}
