package com.assignmentDemo.demo2.controller;

import com.assignmentDemo.demo2.dao.HotelRepo;
import com.assignmentDemo.demo2.model.Hotel;
import com.assignmentDemo.demo2.model.Location;
import com.assignmentDemo.demo2.pojo.Search;
import com.assignmentDemo.demo2.pojo.SearchResult;
import com.assignmentDemo.demo2.service.SearchResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/travel")
public class TravelControl {
    @Autowired
    SearchResultService searchResultService;


}
