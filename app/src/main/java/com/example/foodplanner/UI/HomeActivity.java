package com.example.foodplanner.UI;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.foodplanner.R;
import com.example.foodplanner.database.AppDatabase;
import com.example.foodplanner.database.ConcreteLocalSource;
import com.example.foodplanner.database.LocalSource;
import com.example.foodplanner.database.MealDAO;
import com.example.foodplanner.mealModel.Meal;
import com.example.foodplanner.mealModel.Repository;
import com.example.foodplanner.network.ApiClient;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    ImageView openDrawer;
    TextView userName;
    private FirebaseAuth mAuth;

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
        View headerView = navigationView.getHeaderView(0);
        userName= headerView.findViewById(R.id.userName);
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
            mAuth = FirebaseAuth.getInstance();
            FirebaseUser user = mAuth.getCurrentUser();
            userName.setText(user.getEmail());
        }
        else{
            userName.setText(R.string.GuestName);
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
              Repository repo=  Repository.getInstance( ApiClient.getInstance() , ConcreteLocalSource.getInstance(getApplicationContext(),"0"), getApplicationContext());
              repo.deleteAll();
                finish();
                setGuestFlag(false);
                Intent intent = new Intent(HomeActivity.this, MainActivity.class);
                startActivity(intent);
                break;


        }
        return false;
    }
}