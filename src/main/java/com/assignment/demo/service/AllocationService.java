package com.assignment.demo.service;

import com.assignment.demo.repository.AllocationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AllocationService {
    @Autowired
    AllocationRepo allocationRepo;


}
