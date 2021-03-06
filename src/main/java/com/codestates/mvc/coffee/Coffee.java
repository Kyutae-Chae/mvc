package com.codestates.mvc.coffee;

public class Coffee {
    private String engName;
    private String korName;
    private int price;

    public Coffee(String engName, String korName, int price) {
        this.engName = engName;
        this.korName = korName;
        this.price = price;
    }

    public String getEngName() {
        return engName;
    }

    public void setEngName(String engName) {
        this.engName = engName;
    }

    public String getKorName() {
        return korName;
    }

    public void setKorName(String korName) {
        this.korName = korName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
