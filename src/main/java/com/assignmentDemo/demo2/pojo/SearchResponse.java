package com.assignmentDemo.demo2.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;


import java.util.List;

public class SearchResponse {


    private ResponseMetadata metaData;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<searchResult> data;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String errorMessage;


    public ResponseMetadata getMetaData() {
        return metaData;
    }

    public SearchResponse(ResponseMetadata metaData, List<searchResult> data, String errorMessage) {
        this.metaData = metaData;
        this.data = data;
        this.errorMessage = errorMessage;
    }

    public SearchResponse setMetaData(ResponseMetadata metaData) {
        this.metaData = metaData;
        return this;
    }

    public List<searchResult> getData() {
        return data;
    }

    public void setData(List<searchResult> data) {
        this.data = data;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public SearchResponse setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
        return this;
    }

    public SearchResponse() {
    }
}


