package com.assignment.demo.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;

import java.util.List;

@ApiModel
public class SearchResponse {


    private ResponseMetadata metaData;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<SearchResult> data;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String errorMessage;

//    private ErrorDa


    public SearchResponse(ResponseMetadata metaData, List<SearchResult> data, String errorMessage) {
        this.metaData = metaData;
        this.data = data;
        this.errorMessage = errorMessage;
    }

    public SearchResponse() {
    }

    public static SearchResponse create() {
        return new SearchResponse();
    }

    public ResponseMetadata getMetaData() {
        return metaData;
    }

    public SearchResponse setMetaData(ResponseMetadata metaData) {
        this.metaData = metaData;
        return this;
    }

    public List<SearchResult> getData() {
        return data;
    }

    public void setData(List<SearchResult> data) {
        this.data = data;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public SearchResponse setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
        return this;
    }
}


