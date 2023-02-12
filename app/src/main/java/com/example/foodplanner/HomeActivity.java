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

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    ImageView openDrawer;
    static boolean flagLang=false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        drawerLayout = findViewById(R.id.drawer_layout);
        openDrawer = findViewById(R.id.btn_open);
        navigationView=findViewById(R.id.navigationViw);
        navigationView.setNavigationItemSelectedListener(this);
        openDrawer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawerLayout.isDrawerOpen(GravityCompat.END)) {
                    drawerLayout.closeDrawer(GravityCompat.END);
                }
                drawerLayout.openDrawer(GravityCompat.END);

            }
        });
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        NavController navController = Navigation.findNavController(this, R.id.navHostFragment);

     /*   bottomNavigationView.getMenu().getItem(0).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(@NonNull MenuItem item) {
                if(item.getItemId()==R.id.homeFragment)
                    Toast.makeText(HomeActivity.this, "home", Toast.LENGTH_SHORT).show();
                return false;
            }
        });*/
        NavigationUI.setupWithNavController(bottomNavigationView, navController);


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.logout:
                Toast.makeText(this, "logout", Toast.LENGTH_SHORT).show();
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