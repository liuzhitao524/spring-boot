package com.hqins.demo.common;

import org.springframework.context.annotation.Scope;

import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Scope(scopeName = "prototype")
public class DemoResult implements  Serializable{
    private static  final long serialVersionUID =-1L;


    private boolean isSuccess = true;
    private String message = "成功";

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    private Object content ;

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    @Override
    public String toString(){
        return "Status: "+ isSuccess+" Message: "+message;
    }




}
