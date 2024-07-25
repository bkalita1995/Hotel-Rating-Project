package com.microservice.hotel.exception;

public class ResourceNotFoundException extends  RuntimeException{
    public ResourceNotFoundException(){
        super("No Resource Found");
    }

    public  ResourceNotFoundException(String msg){
        super(msg);
    }
}
