package com.assignmentDemo.demo2.pojo;



//@ApiModel(description = "response meta data")

public class ResponseMetadata {
    private String status;
    public String getStatus(){return status;}

    public ResponseMetadata setStatus(String status){
        this.status = status;
        return this;
    }


    public static ResponseMetadata create(){
        return new ResponseMetadata();
    }
    public ResponseMetadata(){
    }

}
