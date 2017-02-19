package com.sionach.ux.colorsReport;

public class Color {

    private String hex;
    private Long count;

    public Color(String hex, Long count){
        this.hex = hex;
        this.count = count;
    }

    public String getHex() {
        return hex;
    }

    public Long getCount() {
        return count;
    }
}
