package com.assignmentDemo.demo2.service;

import com.assignmentDemo.demo2.model.RoomType;
import com.assignmentDemo.demo2.repository.RateRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@Service
public class RateService {
    @Autowired
    RateRepo rateRepo;
    @Autowired
    RoomsService roomsService;
    public Optional<Integer> getRate(Timestamp startDate, int roomsId){
        return rateRepo.filterRate(startDate,roomsId);

    }
}
