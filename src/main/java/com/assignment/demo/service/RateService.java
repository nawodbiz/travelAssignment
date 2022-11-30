package com.assignment.demo.service;

import com.assignment.demo.repository.RateRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Optional;

@Service
public class RateService {
    @Autowired
    RateRepo rateRepo;
    @Autowired
    RoomsService roomsService;

    public Optional<Integer> getRate(Timestamp startDate, int roomsId) {
        return rateRepo.filterRate(startDate, roomsId);

    }
}
