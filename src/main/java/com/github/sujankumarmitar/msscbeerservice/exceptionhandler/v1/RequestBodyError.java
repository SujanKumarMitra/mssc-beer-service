package com.github.sujankumarmitar.msscbeerservice.exceptionhandler.v1;

public class RequestBodyError {
    private String error;
    private String property;
    private String valuePassed;

    public RequestBodyError() {
    }

    public RequestBodyError(String error, String property, String valuePassed) {
        this.error = error;
        this.property = property;
        this.valuePassed = valuePassed;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getValuePassed() {
        return valuePassed;
    }

    public void setValuePassed(String valuePassed) {
        this.valuePassed = valuePassed;
    }
}
