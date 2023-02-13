package com.example.foodplanner;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.foodplanner.welcomeView.WelcomeActivity;
import com.example.foodplanner.network.CheckInternet;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.concurrent.Executor;


public class SignUp_Fragment extends Fragment {
    private TextView login;
    private Button signupBtn;
    private EditText email,pass,confPass;
    private ProgressDialog progressDialog;
    private FirebaseAuth mAuth;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_sign_up_, container, false);
        login = view.findViewById(R.id.login);
        signupBtn=view.findViewById(R.id.SIGNUP);
        email=view.findViewById(R.id.signup_username);
        pass=view.findViewById(R.id.signup_password);
        confPass=view.findViewById(R.id.confirm_password);
        progressDialog = new ProgressDialog(this.getContext());
        progressDialog.setMessage("Processing ...");
        mAuth = FirebaseAuth.getInstance();
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.goingToLogin);
                TextView title = getActivity().findViewById(R.id.home_title);
                title.setText("Welcome Back");
            }
        });
        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (CheckInternet.getConnectivity(getContext())) {
                    String getEmail = email.getText().toString().trim();
                    String getPass = pass.getText().toString().trim();
                    String getConfPass = confPass.getText().toString().trim();
                    if (!Patterns.EMAIL_ADDRESS.matcher(getEmail).matches()) {
                        email.setError("Invalid Email");
                        email.setFocusable(true);
                    } else if (getPass.length() < 8) {
                        pass.setError("Password length must be at least 8");
                        pass.setFocusable(true);
                    } else if (!getConfPass.equals(getPass)) {
                        confPass.setError("Doesn't the same");
                        confPass.setFocusable(true);
                    } else {
                        registerUser(getEmail, getPass);
                    }
                }

            else

            {
                Toast.makeText(getContext(), R.string.checkConnection, Toast.LENGTH_SHORT).show();
            }
        }

        });

        return view;
    }

    private void registerUser(String getEmail, String getPass) {
        progressDialog.show();
       mAuth.createUserWithEmailAndPassword(getEmail,getPass)
               .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                   @Override
                   public void onComplete(@NonNull Task<AuthResult> task) {
                       if(task.isSuccessful()){

                           progressDialog.dismiss();
                           FirebaseUser user = mAuth.getCurrentUser();
                           Toast.makeText(getContext(), "Registered "+user.getEmail(), Toast.LENGTH_SHORT).show();
                           startActivity( new Intent(getActivity(), WelcomeActivity.class));
                       }else {
                           progressDialog.dismiss();
                           Toast.makeText(getContext(), "Fail to sign up", Toast.LENGTH_SHORT).show();
                       }
                   }
               }).addOnFailureListener(new OnFailureListener() {
                   @Override
                   public void onFailure(@NonNull Exception e) {
                       progressDialog.dismiss();
                       Toast.makeText(getContext(), ""+e.getMessage(), Toast.LENGTH_SHORT).show();
                   }
               });
    }

}