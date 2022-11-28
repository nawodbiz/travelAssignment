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
    List<Rooms> findByHotel(Hotel hotel);

}
