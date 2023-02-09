package com.example.foodplanner.model;

public class Ingredients {
    String title ;
    String link ;

    public Ingredients() {
    }

    public Ingredients(String title) {
        this.title = title;
    }

    public Ingredients(String title, String link) {
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
