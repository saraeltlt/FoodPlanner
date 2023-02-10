package com.example.foodplanner.model;

import java.util.ArrayList;
import java.util.List;

public class MealIngredients {
    String ingredientName;
    String ingredientMeasure;


    public static List<MealIngredients> constructList(Meal meal){
      List<MealIngredients> ingredientsList = new ArrayList<>();
            if (meal.getStrIngredient1()!=null ||  meal.getStrIngredient1()!="")
                ingredientsList.add(new MealIngredients(meal.getStrIngredient1(), meal.getStrMeasure1()));
            if (meal.getStrIngredient2()!=null ||  meal.getStrIngredient2()!="")
              ingredientsList.add(new MealIngredients(meal.getStrIngredient2(), meal.getStrMeasure2()));
            if (meal.getStrIngredient3()!=null ||  meal.getStrIngredient3()!="")
                ingredientsList.add(new MealIngredients(meal.getStrIngredient3(), meal.getStrMeasure3()));
            if (meal.getStrIngredient4()!=null ||  meal.getStrIngredient4()!="")
                ingredientsList.add(new MealIngredients(meal.getStrIngredient4(), meal.getStrMeasure4()));
            if (meal.getStrIngredient5()!=null ||  meal.getStrIngredient5()!="")
                ingredientsList.add(new MealIngredients(meal.getStrIngredient5(), meal.getStrMeasure5()));
            if (meal.getStrIngredient6()!=null ||  meal.getStrIngredient6()!="")
                ingredientsList.add(new MealIngredients(meal.getStrIngredient6(), meal.getStrMeasure6()));
            if (meal.getStrIngredient7()!=null ||  meal.getStrIngredient7()!="")
                ingredientsList.add(new MealIngredients(meal.getStrIngredient7(), meal.getStrMeasure7()));
            if (meal.getStrIngredient8()!=null ||  meal.getStrIngredient8()!="")
                ingredientsList.add(new MealIngredients(meal.getStrIngredient8(), meal.getStrMeasure8()));
            if (meal.getStrIngredient9()!=null ||  meal.getStrIngredient9()!="")
                ingredientsList.add(new MealIngredients(meal.getStrIngredient9(), meal.getStrMeasure9()));
            if (meal.getStrIngredient10()!=null ||  meal.getStrIngredient10()!="")
                ingredientsList.add(new MealIngredients(meal.getStrIngredient10(), meal.getStrMeasure10()));
            if (meal.getStrIngredient11()!=null ||  meal.getStrIngredient11()!="")
                ingredientsList.add(new MealIngredients(meal.getStrIngredient11(), meal.getStrMeasure11()));
            if (meal.getStrIngredient12()!=null ||  meal.getStrIngredient12()!="")
                ingredientsList.add(new MealIngredients(meal.getStrIngredient12(), meal.getStrMeasure12()));
            if (meal.getStrIngredient13()!=null ||  meal.getStrIngredient13()!="")
                ingredientsList.add(new MealIngredients(meal.getStrIngredient13(), meal.getStrMeasure13()));
            if (meal.getStrIngredient14()!=null ||  meal.getStrIngredient14()!="")
                ingredientsList.add(new MealIngredients(meal.getStrIngredient14(), meal.getStrMeasure14()));
            if (meal.getStrIngredient15()!=null ||  meal.getStrIngredient15()!="")
                ingredientsList.add(new MealIngredients(meal.getStrIngredient15(), meal.getStrMeasure15()));
            if (meal.getStrIngredient16()!=null ||  meal.getStrIngredient16()!="")
                ingredientsList.add(new MealIngredients(meal.getStrIngredient16(), meal.getStrMeasure16()));
            if (meal.getStrIngredient17()!=null ||  meal.getStrIngredient17()!="")
                ingredientsList.add(new MealIngredients(meal.getStrIngredient17(), meal.getStrMeasure17()));
        if (meal.getStrIngredient18()!=null ||  meal.getStrIngredient18()!="")
            ingredientsList.add(new MealIngredients(meal.getStrIngredient18(), meal.getStrMeasure18()));
        if (meal.getStrIngredient19()!=null ||  meal.getStrIngredient19()!="")
            ingredientsList.add(new MealIngredients(meal.getStrIngredient19(), meal.getStrMeasure19()));
        if (meal.getStrIngredient20()!=null ||  meal.getStrIngredient20()!="")
            ingredientsList.add(new MealIngredients(meal.getStrIngredient20(), meal.getStrMeasure20()));

        return ingredientsList;
    }

    public MealIngredients() {}

    public MealIngredients(String ingredientName, String ingredientMeasure) {
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
