package com.example.foodplanner.model;

public class Ingrd {
    String title ;
    String link ;

    public Ingrd() {
    }

    public Ingrd(String title) {
        this.title = title;
    }

    public Ingrd(String title, String link) {
        this.title = title;
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
