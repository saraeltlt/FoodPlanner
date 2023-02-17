package com.example.foodplanner.firebasePackage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.example.foodplanner.UI.HomeActivity;
import com.example.foodplanner.UI.MainActivity;
import com.example.foodplanner.authentication.authPressenter.AuthPressenterInterface;
import com.example.foodplanner.mealModel.Meal;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.example.foodplanner.R;
import com.example.foodplanner.network.CheckInternet;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.firebase.auth.FirebaseAuth;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class FirebaseUtil implements FirebaseInterface {
    GoogleSignInClient googleSignInClient;
    FirebaseAuth firebaseAuth;
    AuthPressenterInterface authPressenterInterface;

    public FirebaseUtil() {
    }

    public FirebaseUtil(AuthPressenterInterface authPressenterInterface) {
        this.authPressenterInterface = authPressenterInterface;
    }
    //google sign in

    @Override
    public void login(String email,String pass) {

    }

    @Override
    public void signup() {

    }

    @Override
    public void googleAuth(Context context) {
        GoogleSignInOptions googleSignInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(context.getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        // Initialize sign in client
        googleSignInClient = GoogleSignIn.getClient(context, googleSignInOptions);
        // Initialize sign in intent
        Intent intent = googleSignInClient.getSignInIntent();


        // Initialize firebase auth
        firebaseAuth = FirebaseAuth.getInstance();
        // Initialize firebase user
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();

        // Check condition
        if (firebaseUser != null) {
            // When user already sign in redirect to profile activity
            Toast.makeText(context, "inside if", Toast.LENGTH_SHORT).show();
            authPressenterInterface.googleSuccess();
        } else {
            startForResult(100, intent, context);
        }


    }
    @Override
    public  void addFav(Context context, Meal myMeal) {
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        if (firebaseAuth.getCurrentUser()==null){
            Toast.makeText(context, "you\re not logged in", Toast.LENGTH_SHORT).show();
        }
        else {

            DatabaseReference ref = FirebaseDatabase.getInstance().getReference("Registered Users");
            ref.child(firebaseAuth.getUid()).child("Favorites").child(myMeal.getStrMeal()).setValue(myMeal)
                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {
                            Toast.makeText(context, "added to your favList", Toast.LENGTH_SHORT).show();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(context, "failed to add to your favList", Toast.LENGTH_SHORT).show();

                        }
                    });
        }
    }


    @Override
    public  void removeFav(Context context, Meal myMeal) {
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        if (firebaseAuth.getCurrentUser()==null){
            Toast.makeText(context, "you\re not logged in", Toast.LENGTH_SHORT).show();
        }
        else {
            DatabaseReference ref = FirebaseDatabase.getInstance().getReference("Registered Users");
            ref.child(firebaseAuth.getUid()).child("Favorites").child(myMeal.getStrMeal()).removeValue()
                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {
                            Toast.makeText(context, "removed from your favList", Toast.LENGTH_SHORT).show();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(context, "failed to remove from your favList", Toast.LENGTH_SHORT).show();

                        }
                    });

        }
    }

    @Override
    public void addPlan(Context context, Meal myMeal) {
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        if (firebaseAuth.getCurrentUser()==null){
            Toast.makeText(context, "you\re not logged in", Toast.LENGTH_SHORT).show();
        }
        else {

            DatabaseReference ref = FirebaseDatabase.getInstance().getReference("Registered Users");
            ref.child(firebaseAuth.getUid()).child("Plan").child(myMeal.getDay()).child(myMeal.getStrMeal()).setValue(myMeal)
                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {
                            Toast.makeText(context, "added to your favList", Toast.LENGTH_SHORT).show();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(context, "failed to add to your favList", Toast.LENGTH_SHORT).show();

                        }
                    });


        }
    }

    @Override
    public void removePlan(Context context, Meal myMeal) {
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        if (firebaseAuth.getCurrentUser()==null){
            Toast.makeText(context, "you\re not logged in", Toast.LENGTH_SHORT).show();
        }
        else {
            DatabaseReference ref = FirebaseDatabase.getInstance().getReference("Registered Users");
            ref.child(firebaseAuth.getUid()).child("Plan").child(myMeal.getDay()).child(myMeal.getStrMeal()).removeValue()
                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {
                            Toast.makeText(context, "removed from your favList", Toast.LENGTH_SHORT).show();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(context, "failed to remove from your favList", Toast.LENGTH_SHORT).show();

                        }
                    });

        }
    }

    @Override
    public void getFav() {


    }

    @Override
    public void getPlan() {

    }

    private void startForResult(int requestCode, Intent data, Context context) {   // Check condition
        if (requestCode == 100) {

            // When request code is equal to 100 initialize task
            Task<GoogleSignInAccount> signInAccountTask = GoogleSignIn.getSignedInAccountFromIntent(data);
            // check condition
            if (signInAccountTask.isSuccessful()) {
                // When google sign in successful initialize string
                String s = "Google sign in successful";
                // Display Toast
                Toast.makeText(context, s, Toast.LENGTH_SHORT).show();
                ;
                // Initialize sign in account
                try {
                    // Initialize sign in account
                    GoogleSignInAccount googleSignInAccount = signInAccountTask.getResult(ApiException.class);
                    // Check condition
                    if (googleSignInAccount != null) {
                        // When sign in account is not equal to null initialize auth credential
                        AuthCredential authCredential = GoogleAuthProvider.getCredential(googleSignInAccount.getIdToken(), null);
                        // Check credential
                        firebaseAuth.signInWithCredential(authCredential).addOnCompleteListener((Activity) context, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                // Check condition
                                if (task.isSuccessful()) {
                                    // When task is successful redirect to profile activity display Toast
                                    authPressenterInterface.googleSuccess();
                                    Toast.makeText(context, "Firebase authentication successful", Toast.LENGTH_SHORT).show();
                                } else {
                                    // When task is unsuccessful display Toast
                                    Toast.makeText(context, "Authentication Failed :" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                                }
                            }
                        });
                    }
                } catch (ApiException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
