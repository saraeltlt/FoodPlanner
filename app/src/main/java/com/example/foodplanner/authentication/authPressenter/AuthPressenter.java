package com.example.foodplanner.authentication.authPressenter;

import android.content.Context;

import com.example.foodplanner.UI.MainActivity;
import com.example.foodplanner.authentication.authView.LoginFragment;
import com.example.foodplanner.firebasePackage.FirebaseUtil;

public class AuthPressenter implements AuthPressenterInterface{
    FirebaseUtil firebaseUtil ;
    static MainActivity mainActivity ;

    public AuthPressenter() {
        firebaseUtil = new FirebaseUtil(this);
        LoginFragment login = new LoginFragment();
    }

    @Override
    public void checkSignGoogle(Context context){
        firebaseUtil.googleAuth(context);
    }
    @Override
    public void googleSuccess(){
        //mainActivity.Done();
    }

    @Override
    public void loginUser(String email, String pass) {
        firebaseUtil.login(email,pass);
    }

}
