package com.assignmentDemo.demo2.controller;

import com.assignmentDemo.demo2.pojo.ResponseMetadata;
import com.assignmentDemo.demo2.pojo.SearchResponse;
import com.assignmentDemo.demo2.service.LocationService;
import com.assignmentDemo.demo2.service.TravelService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.naming.directory.SearchResult;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/travel")
@Validated
public class TravelControl {
    @Autowired
    LocationService locationService;

    private static final String FAILED_STATUS = "failed";
    @Autowired
    TravelService travelService;

    @GetMapping(value = "/sendRequest")
    public SearchResponse getResponse(@RequestParam(value = "locationCode")@NotNull String locationCode,
                                      @RequestParam(value = "adultCount")  @NotNull int adultCount,
                                      @RequestParam(value = "childCount") @NotNull@Min(0) int childCount,
                                      @RequestParam(value = "startDate") @NotNull Timestamp startDate,
                                      @RequestParam(value = "endDate") @NotNull Timestamp endDate){
        SearchResponse searchResponse = new SearchResponse();

        if(locationService.findByLocationCode(locationCode)==null){
            return searchResponse.setErrorMessage("Location Code Not Matching").setMetaData(ResponseMetadata.create().setStatus("failed"));
        }
        if(adultCount<=0)
            return searchResponse.setErrorMessage("invalid adult count").setMetaData(ResponseMetadata.create().setStatus("failed"));
//        if(childCount<0)
//            return searchResponse.setErrorMessage("invalid child count").setMetaData(ResponseMetadata.create().setStatus("failed"));

        SearchResponse tempDateResponse = checkDateWithCurrentDate(startDate,"start Date");

        if(tempDateResponse!=null)
            return tempDateResponse;
        tempDateResponse = checkDateWithCurrentDate(endDate,"end date");
        if(tempDateResponse!=null)
            return tempDateResponse;
        tempDateResponse = compareStartAndEndDates(startDate,endDate);
        if(tempDateResponse!=null)
            return tempDateResponse;
        searchResponse.setMetaData(new ResponseMetadata().setStatus("success"));
        var searchResultList = travelService.sendRequest(locationCode,adultCount,childCount,startDate,endDate);
        if(searchResultList.isEmpty())
            return searchResponse.setErrorMessage("no result found").setMetaData(ResponseMetadata.create().setStatus("success"));
        searchResponse.setData(searchResultList);
        return searchResponse;
    }

    private SearchResponse checkDateWithCurrentDate(Timestamp dateToCheck, String dateName ){
        String currentDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
        if ( Timestamp.valueOf(currentDate).compareTo(dateToCheck)>0){
            SearchResponse search  = new SearchResponse();
            search.setMetaData(new ResponseMetadata().setStatus("failed"));
            search.setErrorMessage("invalid Date for "+dateName );
            return search;
        }
        return null;
    }
    private SearchResponse compareStartAndEndDates(Timestamp startDate, Timestamp endDate){
        if (startDate.compareTo(endDate)>0){
            SearchResponse search  = new SearchResponse();
            search.setMetaData(new ResponseMetadata().setStatus("failed"));
            search.setErrorMessage("invalid date, end date must comes after the start date");
            return search;
        }
        return null;
    }

//    @GetMapping("/search")
//    public ResponseEntity

//    @PostMapping("/sample")
//    public void getDate(@RequestParam(value = "date") Timestamp time){
//
//        System.out.println("hit");
//    }



//    @GetMapping("/sendRequest")
//    public List<Response> getResponse(){
//        System.out.println("got");
//        return travelService.sendRequest("GAL",1,1,new Date(2022,10,10),new Date(2022,10,25));
//    }



//    public List<Response> getResponse(@RequestParam(value = "locationCode") String locationCode,
//                                      @RequestParam(value = "adultCount") int adultCount,
//                                      @RequestParam(value = "childCount") int childCount,
//                                      @RequestParam(value = "startDate") Date startDate,
//                                      @RequestParam(value = "endDate") Date endDate){
//        return travelService.sendRequest(locationCode,adultCount,childCount,startDate,endDate);
//    }



}
