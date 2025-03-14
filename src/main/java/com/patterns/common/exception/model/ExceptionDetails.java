package com.patterns.common.exception.model;

import java.util.Date;
import java.util.List;

public class ExceptionDetails {

    private String type;

    private String title;

    private String code;

    private String detail;

    private Integer status;

    private Date date;

    private List<CustomError> errors;

    public ExceptionDetails(String type, String title, String code, String detail, Integer status, Date date, List<CustomError> errors) {
        this.type = type;
        this.title = title;
        this.code = code;
        this.detail = detail;
        this.status = status;
        this.date = date;
        this.errors = errors;
    }

    public String getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }

    public String getCode() {
        return code;
    }

    public String getDetail() {
        return detail;
    }

    public Integer getStatus() {
        return status;
    }

    public Date getDate() {
        return date;
    }

    public List<CustomError> getErrors() {
        return errors;
    }
}