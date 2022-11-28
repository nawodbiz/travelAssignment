package com.assignmentDemo.demo2.repository;

import com.assignmentDemo.demo2.model.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface RoomTypeRepo extends JpaRepository<RoomType,Integer> {

    public Set<RoomType> findByAdultCount(int adultCount);
    public Set<RoomType> findByChildCount(int childCount);


    @Query ("SELECT u FROM RoomType u WHERE u.adultCount+u.childCount >= :adultCount+:childCount AND u.adultCount>=:adultCount")
    List<RoomType> findByTotalPax(
            @Param("adultCount") int rAdultCount,
           @Param("childCount") int rChildCountSS
    );
}
