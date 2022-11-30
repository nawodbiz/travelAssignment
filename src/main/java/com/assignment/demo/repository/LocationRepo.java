package com.assignment.demo.repository;

import com.assignment.demo.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepo extends JpaRepository<Location, Integer> {
    Location findByLocationName(String name);
    Location findByPostalCode(int postalCode);

    Location findByLocationCode(@Param("locationCode") String locationCode);


}
