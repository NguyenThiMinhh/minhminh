package com.example.dattrinh.a24h.drawer;

public class Item_drawer {
    private String ten;
    private String url;

    public Item_drawer(String ten, String url) {
        this.ten = ten;
        this.url = url;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
