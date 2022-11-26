package com.assignmentDemo.demo2.dao;

import com.assignmentDemo.demo2.model.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomTypeRepo extends JpaRepository<RoomType,Integer> {
}
