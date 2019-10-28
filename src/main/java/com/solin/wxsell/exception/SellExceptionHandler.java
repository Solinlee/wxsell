package com.solin.wxsell.exception;

public class SellExceptionHandler extends RuntimeException {
    private String mes;

    public SellExceptionHandler(String mes) {
        this.mes = mes;
    }


    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }
}
