package com.assignmentDemo.demo2.model;

import com.assignmentDemo.demo2.pojo.searchResult;

import java.util.List;

public class SearchResponse {
    private String status;
    private List<searchResult> data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<searchResult> getData() {
        return data;
    }

    public void setData(List<searchResult> data) {
        this.data = data;
    }
}
