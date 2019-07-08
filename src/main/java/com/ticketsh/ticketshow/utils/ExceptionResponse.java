package com.ticketsh.ticketshow.utils;

import java.util.Date;

public class ExceptionResponse {

    private String message;
    private Date time;
    private String detail;


    public ExceptionResponse(String message, Date time, String detail) {
        this.message = message;
        this.time = time;
        this.detail = detail;
    }

    public String getMessage() {
        return message;
    }

    public Date getTime() {
        return time;
    }

    public String getDetail() {
        return detail;
    }
}
