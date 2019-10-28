package com.solin.wxsell.exception;

public class SellException {
    private String name;
    private String message;

    public SellException(RuntimeException e) {
        this(e.getClass().getName(), e.getMessage());
    }

    public SellException(String name, String message) {
        this.name = name;
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
