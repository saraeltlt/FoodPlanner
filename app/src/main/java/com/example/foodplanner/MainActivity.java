package com.example.foodplanner;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.foodplanner.network.CheckInternet;


public class MainActivity extends AppCompatActivity {
    CardView cardView ;
    Button guestModeBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        guestModeBtn =findViewById(R.id.guest);
        cardView= findViewById(R.id.google_card);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "clicked", Toast.LENGTH_SHORT).show();

            }
        });
        guestModeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!CheckInternet.getConnectivity(MainActivity.this)) {
                    Toast.makeText(MainActivity.this, R.string.checkConnectionGuest, Toast.LENGTH_SHORT).show();
                }
                else if (CheckInternet.getConnectivity(MainActivity.this)) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle(R.string.sureMsg);
                    builder.setMessage(R.string.titleGuest);
                    builder.setCancelable(true);

                    builder.setPositiveButton(R.string.continueGuest, (DialogInterface.OnClickListener) (dialog, which) -> {
                            HomeActivity.setGuestFlag(true);
                            Toast.makeText(MainActivity.this, R.string.loginGuest, Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(MainActivity.this,HomeActivity.class);
                            startActivity(intent);
                    });

                    builder.setNegativeButton(R.string.cancelGuest, (DialogInterface.OnClickListener) (dialog, which) -> {
                        dialog.cancel();
                    });

                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();

                }
            }
        });

    }
}