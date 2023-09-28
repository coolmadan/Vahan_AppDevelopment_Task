package com.example.javauniexplorer;

import java.util.List;

public class UniModel {
  //  int img;
    String name;
    String country;
    List<String>web_pages;
    public UniModel(String name, String country,List<String>web_pages) {
        this.name = name;
        this.country = country;
        this.web_pages=web_pages;
    }

    public List<String> getWeb_pages() {
        return web_pages;
    }

    public void setWeb_pages(List<String> web_pages) {
        this.web_pages = web_pages;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
