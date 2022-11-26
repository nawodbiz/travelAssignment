package com.assignmentDemo.demo2.dao;

import com.assignmentDemo.demo2.model.Rate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RateRepo extends JpaRepository<Rate,Integer> {
}
