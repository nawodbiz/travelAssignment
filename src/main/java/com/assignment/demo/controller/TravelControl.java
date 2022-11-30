package com.assignment.demo.controller;

import com.assignment.demo.pojo.ResponseMetadata;
import com.assignment.demo.pojo.SearchResponse;
import com.assignment.demo.service.LocationService;
import com.assignment.demo.service.TravelService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/travel")
@Validated
public class TravelControl {
    public static final String SUCCESS_STATUS = "success";
    private static final String FAILED_STATUS = "failed";
    @Autowired
    LocationService locationService;
    @Autowired
    TravelService travelService;

    @GetMapping(value = "/sendRequest")
    @ApiOperation(value = "Find hotel rooms availability for your details"
            , notes = "Provide relevent correct data "
            , response = SearchResponse.class

    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved Data", response = SearchResponse.class)
    })
    public SearchResponse getResponse(@ApiParam(name = "locationCode", value = "Location Code of the relevant Location", example = "RU") @RequestParam(value = "locationCode") @NotNull String locationCode,
                                      @RequestParam(value = "adultCount") @NotNull int adultCount,
                                      @RequestParam(value = "childCount") @NotNull @Min(0) int childCount,
                                      @RequestParam(value = "startDate") @NotNull Timestamp startDate,
                                      @RequestParam(value = "endDate") @NotNull Timestamp endDate) {
        SearchResponse searchResponse = new SearchResponse();

        if (locationService.findByLocationCode(locationCode) == null) {
            return searchResponse.setErrorMessage("Location Code Not Matching").setMetaData(ResponseMetadata.create().setStatus(FAILED_STATUS));
        }
        if (adultCount <= 0)
            return searchResponse.setErrorMessage("invalid adult count").setMetaData(ResponseMetadata.create().setStatus(FAILED_STATUS));
        SearchResponse tempDateResponse = checkDateWithCurrentDate(startDate, "start Date");
        if (tempDateResponse != null)
            return tempDateResponse;
        tempDateResponse = checkDateWithCurrentDate(endDate, "end date");
        if (tempDateResponse != null)
            return tempDateResponse;
        tempDateResponse = compareStartAndEndDates(startDate, endDate);
        if (tempDateResponse != null)
            return tempDateResponse;
        searchResponse.setMetaData(new ResponseMetadata().setStatus(SUCCESS_STATUS));
        var searchResultList = travelService.sendRequest(locationCode, adultCount, childCount, startDate, endDate);
        if (searchResultList.isEmpty())
            return searchResponse.setErrorMessage("no result found").setMetaData(ResponseMetadata.create().setStatus(SUCCESS_STATUS));
        searchResponse.setData(searchResultList);
        return searchResponse;

    }

    private SearchResponse checkDateWithCurrentDate(Timestamp dateToCheck, String dateName) {
        String currentDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
        if (Timestamp.valueOf(currentDate).compareTo(dateToCheck) > 0) {
            SearchResponse search = new SearchResponse();
            search.setMetaData(new ResponseMetadata().setStatus(FAILED_STATUS));
            search.setErrorMessage("invalid Date for " + dateName);
            return search;
        }
        return null;
    }

    private SearchResponse compareStartAndEndDates(Timestamp startDate, Timestamp endDate) {
        if (startDate.compareTo(endDate) > 0) {
            SearchResponse search = new SearchResponse();
            search.setMetaData(new ResponseMetadata().setStatus(FAILED_STATUS));
            search.setErrorMessage("invalid date, end date must comes after the start date");
            return search;
        }
        return null;
    }
}
