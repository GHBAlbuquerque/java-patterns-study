package com.patterns.common.exception.model;

import java.time.LocalDateTime;
import java.util.Map;

public class ExceptionDetails {

    private String title;

    private String code;

    private String detail;

    private Integer status;

    private LocalDateTime timestamp;

    private Map<String, String> errors;

    public ExceptionDetails(String title, String code, String detail, Integer status, LocalDateTime timestamp, Map<String, String> errors) {
        this.title = title;
        this.code = code;
        this.detail = detail;
        this.status = status;
        this.timestamp = timestamp;
        this.errors = errors;
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

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public Map<String, String> getErrors() {
        return errors;
    }
}