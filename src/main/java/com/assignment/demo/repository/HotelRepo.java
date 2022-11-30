package com.assignment.demo.repository;

import com.assignment.demo.model.Hotel;
import com.assignment.demo.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepo extends JpaRepository<Hotel, Integer> {
    List<Hotel> findByLocation(Location location);

}
