package com.assignmentDemo.demo2.dao;

import com.assignmentDemo.demo2.model.Hotel;
import com.assignmentDemo.demo2.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HotelRepo extends JpaRepository <Hotel, Integer> {
    List<Hotel> findByLocation(Location location);

}
