package com.example.foodplanner.model;

import java.util.ArrayList;
import java.util.List;

public class Ingredient {
    String ingredientName;
    String ingredientMeasure;


    public static List<Ingredient> constructList(Meals meal){
      List<Ingredient> ingredientsList = new ArrayList<>();
            if (meal.getStrIngredient1()!=null)
                ingredientsList.add(new Ingredient(meal.getStrIngredient1(), meal.getStrMeasure1()));
            if (meal.getStrIngredient2()!=null)
              ingredientsList.add(new Ingredient(meal.getStrIngredient2(), meal.getStrMeasure2()));
            if (meal.getStrIngredient3()!=null)
                ingredientsList.add(new Ingredient(meal.getStrIngredient3(), meal.getStrMeasure3()));
            if (meal.getStrIngredient4()!=null)
                ingredientsList.add(new Ingredient(meal.getStrIngredient4(), meal.getStrMeasure4()));
            if (meal.getStrIngredient5()!=null)
                ingredientsList.add(new Ingredient(meal.getStrIngredient5(), meal.getStrMeasure5()));
            if (meal.getStrIngredient6()!=null)
                ingredientsList.add(new Ingredient(meal.getStrIngredient6(), meal.getStrMeasure6()));
            if (meal.getStrIngredient7()!=null)
                ingredientsList.add(new Ingredient(meal.getStrIngredient7(), meal.getStrMeasure7()));
            if (meal.getStrIngredient8()!=null)
                ingredientsList.add(new Ingredient(meal.getStrIngredient8(), meal.getStrMeasure8()));
            if (meal.getStrIngredient9()!=null)
                ingredientsList.add(new Ingredient(meal.getStrIngredient9(), meal.getStrMeasure9()));
            if (meal.getStrIngredient10()!=null)
                ingredientsList.add(new Ingredient(meal.getStrIngredient10(), meal.getStrMeasure10()));
            if (meal.getStrIngredient11()!=null)
                ingredientsList.add(new Ingredient(meal.getStrIngredient11(), meal.getStrMeasure11()));
            if (meal.getStrIngredient12()!=null)
                ingredientsList.add(new Ingredient(meal.getStrIngredient12(), meal.getStrMeasure12()));
            if (meal.getStrIngredient13()!=null)
                ingredientsList.add(new Ingredient(meal.getStrIngredient13(), meal.getStrMeasure13()));
            if (meal.getStrIngredient14()!=null)
                ingredientsList.add(new Ingredient(meal.getStrIngredient14(), meal.getStrMeasure14()));
            if (meal.getStrIngredient15()!=null)
                ingredientsList.add(new Ingredient(meal.getStrIngredient15(), meal.getStrMeasure15()));
            if (meal.getStrIngredient16()!=null)
                ingredientsList.add(new Ingredient(meal.getStrIngredient16(), meal.getStrMeasure16()));
            if (meal.getStrIngredient17()!=null)
                ingredientsList.add(new Ingredient(meal.getStrIngredient17(), meal.getStrMeasure17()));
        if (meal.getStrIngredient18()!=null)
            ingredientsList.add(new Ingredient(meal.getStrIngredient18(), meal.getStrMeasure18()));
        if (meal.getStrIngredient19()!=null)
            ingredientsList.add(new Ingredient(meal.getStrIngredient19(), meal.getStrMeasure19()));
        if (meal.getStrIngredient20()!=null)
            ingredientsList.add(new Ingredient(meal.getStrIngredient20(), meal.getStrMeasure20()));

        return ingredientsList;
    }

    public Ingredient() {}

    public Ingredient(String ingredientName, String ingredientMeasure) {
        this.ingredientName = ingredientName;
        this.ingredientMeasure = ingredientMeasure;
    }


    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public String getIngredientMeasure() {
        return ingredientMeasure;
    }

    public void setIngredientMeasure(String ingredientMeasure) {
        this.ingredientMeasure = ingredientMeasure;
    }


}