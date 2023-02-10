package com.example.foodplanner.model;

public class Ingredients {
    String strIngredient;
    String link ;

    public Ingredients() {
    }

    public Ingredients(String strIngredient) {
        this.strIngredient = strIngredient;
    }

    public Ingredients(String strIngredient, String link) {
        this.strIngredient = strIngredient;
        this.link = link;
    }

    public String getStrIngredient() {
        return strIngredient;
    }

    public void setStrIngredient(String strIngredient) {
        this.strIngredient = strIngredient;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
