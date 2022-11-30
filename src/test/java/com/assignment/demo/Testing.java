package com.assignment.demo;

import com.assignment.demo.controller.TravelControl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@SpringBootTest
class Testing {
    @Autowired
    TravelControl travelControl;
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    @Test
    void invalidLocationCode() throws ParseException {
        var result = travelControl.getResponse(
                "AA",
                1,
                1,
                new java.sql.Timestamp(dateFormat.parse("2023-01-05 00:00:00").getTime()),
                new java.sql.Timestamp(dateFormat.parse("2023-01-10 00:00:00").getTime())
        );
        Assertions.assertEquals("failed", result.getMetaData().getStatus());
        Assertions.assertEquals("Location Code Not Matching", result.getErrorMessage());
    }

    @Test
    void invalidAdultCount() throws ParseException {
        var result = travelControl.getResponse(
                "RU",
                100,
                1,
                new java.sql.Timestamp(dateFormat.parse("2023-01-05 00:00:00").getTime()),
                new java.sql.Timestamp(dateFormat.parse("2023-01-10 00:00:00").getTime())
        );
        Assertions.assertEquals("success", result.getMetaData().getStatus());
        Assertions.assertEquals("no result found", result.getErrorMessage());
    }

    @Test
    void noAdultsIncluded() throws ParseException {
        var result = travelControl.getResponse(
                "RU",
                0,
                1,
                new java.sql.Timestamp(dateFormat.parse("2023-01-05 00:00:00").getTime()),
                new java.sql.Timestamp(dateFormat.parse("2023-01-10 00:00:00").getTime())
        );
        Assertions.assertEquals("failed", result.getMetaData().getStatus());
        Assertions.assertEquals("invalid adult count", result.getErrorMessage());
    }

    @Test
    void invalidChildCount() throws ParseException {
        var result = travelControl.getResponse(
                "RU",
                1,
                100,
                new java.sql.Timestamp(dateFormat.parse("2023-01-05 00:00:00").getTime()),
                new java.sql.Timestamp(dateFormat.parse("2023-01-10 00:00:00").getTime())
        );
        Assertions.assertEquals("success", result.getMetaData().getStatus());
        Assertions.assertEquals("no result found", result.getErrorMessage());
    }

    @Test
    void startDateIsInPast() throws ParseException {
        var result = travelControl.getResponse(
                "RU",
                1,
                100,
                new java.sql.Timestamp(dateFormat.parse("2022-01-05 00:00:00").getTime()),
                new java.sql.Timestamp(dateFormat.parse("2023-01-10 00:00:00").getTime())
        );
        Assertions.assertEquals("failed", result.getMetaData().getStatus());
        Assertions.assertEquals("invalid Date for start Date", result.getErrorMessage());
    }

    @Test
    void endingDateIsInPast() throws ParseException {
        var result = travelControl.getResponse(
                "RU",
                1,
                100,
                new java.sql.Timestamp(dateFormat.parse("2023-01-05 00:00:00").getTime()),
                new java.sql.Timestamp(dateFormat.parse("2022-01-10 00:00:00").getTime())
        );
        Assertions.assertEquals("failed", result.getMetaData().getStatus());
        Assertions.assertEquals("invalid Date for end date", result.getErrorMessage());
    }

    @Test
    void firstDateComesAfterEndingDate() throws ParseException {
        var result = travelControl.getResponse(
                "RU",
                1,
                100,
                new java.sql.Timestamp(dateFormat.parse("2023-01-05 00:00:00").getTime()),
                new java.sql.Timestamp(dateFormat.parse("2022-01-10 00:00:00").getTime())
        );
        Assertions.assertEquals("failed", result.getMetaData().getStatus());
        Assertions.assertEquals("invalid date, end date must comes after the start date", result.getErrorMessage());
    }
}
