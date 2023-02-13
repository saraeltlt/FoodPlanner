package com.example.foodplanner.network;

import android.annotation.SuppressLint;
import android.util.Log;

import com.example.foodplanner.model.AreaResponse;
import com.example.foodplanner.model.CategoryResponse;
import com.example.foodplanner.model.IngredientsResponse;
import com.example.foodplanner.model.RandomMealsResponse;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient implements RemoteSource {
    private static ApiClient instance = null;

    private static final String BASE_URL = "https://www.themealdb.com/api/json/v1/1/";
    private ApiClient() {

    }
    public static synchronized ApiClient getInstance() {
        if (instance == null) {
            instance = new ApiClient();
        }
        return instance;
    }

    public Api creatRetro(){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL )
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        Api myApi = retrofit.create(Api.class);
        return  myApi;

    }
    @SuppressLint("CheckResult")
    @Override
    public void ObserveMeal(NetworkDelegate networkDelegate){
      Api myApi = creatRetro();
        Observable<RandomMealsResponse> observable= myApi.getRandomMeals()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        observable.subscribe(o-> {
                   networkDelegate.onSuccessResult(o.getMeals());
                },
                e-> networkDelegate.onFailureResult(e.getMessage())
        );

    }

    @Override
    public void ObserveIngrediant(NetworkDelegate networkDelegate) {
        Api myApi = creatRetro();
        Observable<IngredientsResponse> observable= myApi.getIngredients()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        observable.subscribe(o-> {
                    networkDelegate.onSuccessResultIngrediants(o.getMeals());
                },
                e-> networkDelegate.onFailureResult(e.getMessage())
        );
    }
    public void ObserveArea(NetworkDelegate networkDelegate) {
        Api myApi = creatRetro();
        Observable<AreaResponse> observable= myApi.getArea()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        observable.subscribe(o-> {
                    networkDelegate.onSuccessResultArea(o.getMeals());
                },
                e-> networkDelegate.onFailureResult(e.getMessage())
        );
    }
    public void ObserveCategory(NetworkDelegate networkDelegate) {
        Api myApi = creatRetro();
        Observable<CategoryResponse> observable= myApi.getCategory()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        observable.subscribe(o-> {
                    networkDelegate.onSuccessResultCategory(o.getCategories());
                },
                e-> networkDelegate.onFailureResult(e.getMessage())
        );
    }


}
