package com.example.foodplanner.authentication.authView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.foodplanner.R;
import com.example.foodplanner.UI.HomeActivity;
import com.example.foodplanner.authentication.authPressenter.AuthPressenter;
import com.example.foodplanner.authentication.authPressenter.AuthPressenterInterface;
import com.example.foodplanner.database.ConcreteLocalSource;
import com.example.foodplanner.firebasePackage.FirebaseUtil;
import com.example.foodplanner.mealModel.Meal;
import com.example.foodplanner.mealModel.Repository;
import com.example.foodplanner.network.ApiClient;
import com.example.foodplanner.network.CheckInternet;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class LoginFragment extends Fragment implements LoginAuthInterface {
    private TextView signup;
    private Button login;
    private EditText userName, password;
    private FirebaseAuth mAuth;
    ProgressDialog progressDialog;
    AuthPressenterInterface authPressenterInterface ;
    FirebaseUtil firebaseUtil;

    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_login_, container, false);
        signup = view.findViewById(R.id.Signup);
        login = view.findViewById(R.id.LOGIN);
        userName = view.findViewById(R.id.login_username);
        password = view.findViewById(R.id.login_password);
        mAuth = FirebaseAuth.getInstance();
        authPressenterInterface = new AuthPressenter();
       firebaseUtil= new FirebaseUtil();

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Navigation.findNavController(view).navigate(R.id.goingToSignup);
                TextView title = getActivity().findViewById(R.id.home_title);
                title.setText("Hello");
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (CheckInternet.getConnectivity(getContext())) {
                    String email = userName.getText().toString();
                    String pass = password.getText().toString().trim();
                    if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                        userName.setError("Invalid Email");
                        userName.setFocusable(true);
                    } else if (pass.length() < 8) {
                        password.setError("Invalid Password");
                        password.setFocusable(true);
                    } else {
                        loginUser(email, pass);
                    }

                }
                else{
                    Toast.makeText(getContext(), R.string.checkConnection, Toast.LENGTH_SHORT).show();
                }
            }

        });
        progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("Logging in... ");

        return view;
    }

    private void loginUser(String email, String pass) {
        progressDialog.show();
        mAuth.signInWithEmailAndPassword(email, pass)
                .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            progressDialog.dismiss();
                            FirebaseUser user = mAuth.getCurrentUser();
                            firebaseUtil.getFav(getContext(), user);
                            firebaseUtil.getPlan(getContext(), user,"Sunday");
                            firebaseUtil.getPlan(getContext(), user,"Monday");
                            firebaseUtil.getPlan(getContext(), user,"Tuesday");
                            firebaseUtil.getPlan(getContext(), user,"Wednesday");
                            firebaseUtil.getPlan(getContext(), user,"Thursday");
                            firebaseUtil.getPlan(getContext(), user,"Friday");
                            firebaseUtil.getPlan(getContext(), user,"Saturday");

                            startActivity(new Intent(getActivity(), HomeActivity.class));
                            getActivity().finish();
                        } else {
                            // If sign in fails, display a message to the user.
                            progressDialog.dismiss();
                            Toast.makeText(getContext(), "Authentication failed.", Toast.LENGTH_SHORT).show();
                        }
                    }
                }).addOnFailureListener(e -> {
                    progressDialog.dismiss();
                    Toast.makeText(getContext(), "" + e.getMessage(), Toast.LENGTH_SHORT).show();
                });
    }


}