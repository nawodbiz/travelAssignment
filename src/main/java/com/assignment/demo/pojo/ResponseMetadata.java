package com.assignment.demo.pojo;


//@ApiModel(description = "response meta data")

public class ResponseMetadata {
    private String status;


    public static ResponseMetadata create() {
        return new ResponseMetadata();
    }


    public String getStatus() {
        return status;
    }

    public ResponseMetadata setStatus(String status) {
        this.status = status;
        return this;
    }

}
