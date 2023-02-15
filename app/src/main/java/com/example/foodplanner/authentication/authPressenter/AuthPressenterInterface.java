package com.example.foodplanner.authentication.authPressenter;

import android.content.Context;

public interface AuthPressenterInterface {
    public void checkSignGoogle(Context context);
    public void googleSuccess();
    public void loginUser(String email, String pass);
}
