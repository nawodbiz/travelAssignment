package com.assignmentDemo.demo2.repository;

import com.assignmentDemo.demo2.model.Hotel;
import com.assignmentDemo.demo2.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepo extends JpaRepository <Hotel, Integer> {
    List<Hotel> findByLocation(Location location);

}
