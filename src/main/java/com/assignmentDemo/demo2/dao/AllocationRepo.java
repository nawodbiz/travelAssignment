package com.assignmentDemo.demo2.dao;

import com.assignmentDemo.demo2.model.Allocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AllocationRepo extends JpaRepository<Allocation,Integer> {
}
