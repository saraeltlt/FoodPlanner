package com.example.foodplanner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.foodplanner.welcomeView.SplashScreenActivity;
import com.example.foodplanner.welcomeView.WelcomeActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    ImageView openDrawer;
    public static NavController navController;
    public static Boolean guestFlag = false;
    static boolean flagLang=false;
    public static HomeActivity homeActivity;

    public static Boolean getGuestFlag() {
        return guestFlag;
    }

    public static void setGuestFlag(Boolean guestFlag) {
        HomeActivity.guestFlag = guestFlag;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        homeActivity=this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        drawerLayout = findViewById(R.id.drawer_layout);
        openDrawer = findViewById(R.id.btn_open);
        navigationView=findViewById(R.id.navigationViw);
        navigationView.setNavigationItemSelectedListener(this);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        navController = Navigation.findNavController(this, R.id.navHostFragment);
        openDrawer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawerLayout.isDrawerOpen(GravityCompat.END)) {
                    drawerLayout.closeDrawer(GravityCompat.END);
                }
                drawerLayout.openDrawer(GravityCompat.END);

            }
        });
        if (!getGuestFlag()) { //logged in user
            NavigationUI.setupWithNavController(bottomNavigationView, navController);
        }
        else{
            bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.homeFragment:

                           while (HomeActivity.navController.popBackStack() == true) {
                            }
                            Navigation.findNavController(HomeActivity.this, R.id.navHostFragment).navigate(R.id.homeFragment);
                            return true;

                        case R.id.searchFragment:

                            while (HomeActivity.navController.popBackStack() == true) {
                            }
                            Navigation.findNavController(HomeActivity.this, R.id.navHostFragment).navigate(R.id.searchFragment);
                            return true;

                        case R.id.favouriteFragment:
                            Toast.makeText(HomeActivity.this, R.string.access, Toast.LENGTH_SHORT).show();
                            return false;

                        case R.id.planFragment:
                            Toast.makeText(HomeActivity.this, R.string.access, Toast.LENGTH_SHORT).show();
                            return false;


                    }

                  return false;
                }

            });
        }


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.logout:
                FirebaseAuth.getInstance().signOut();
                setGuestFlag(false);
                Intent intent = new Intent(HomeActivity.this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.lang:
                Toast.makeText(this, "language", Toast.LENGTH_SHORT).show();
            if (!flagLang) {
                item.setTitle("English");
                flagLang=true;
            }
            else{
                item.setTitle("العربية");
                flagLang=false;
            }

                break;


        }
        return false;
    }
}