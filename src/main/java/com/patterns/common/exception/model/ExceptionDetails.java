package com.patterns.common.exception.model;

import java.util.Date;
import java.util.Map;

public class ExceptionDetails {

    private String type;

    private String title;

    private String code;

    private String detail;

    private Integer status;

    private Date date;

    private Map<String, String> errors;

    public ExceptionDetails(String type, String title, String code, String detail, Integer status, Date date, Map<String, String> errors) {
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

    public Map<String, String> getErrors() {
        return errors;
    }
}