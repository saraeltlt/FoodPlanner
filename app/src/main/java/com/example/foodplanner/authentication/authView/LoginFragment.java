package com.example.foodplanner.authentication.authView;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.foodplanner.R;
import com.example.foodplanner.UI.HomeActivity;
import com.example.foodplanner.authentication.authPressenter.AuthPressenter;
import com.example.foodplanner.authentication.authPressenter.AuthPressenterInterface;
import com.example.foodplanner.firebasePackage.FirebaseUtil;
import com.example.foodplanner.network.CheckInternet;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class LoginFragment extends Fragment implements LoginAuthInterface {
    private TextView signup, forgetPass;
    private Button login;
    private EditText userName, password;
    private FirebaseAuth mAuth;
    ProgressDialog progressDialog;
    AuthPressenterInterface authPressenterInterface;
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
        forgetPass = view.findViewById(R.id.forgetPassword);
        mAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(getContext());
        authPressenterInterface = new AuthPressenter();
        firebaseUtil = new FirebaseUtil();

        forgetPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle("Recover Password");

                LinearLayout linearLayout = new LinearLayout(getContext());
                EditText emailET = new EditText(getContext());
                emailET.setHint("Email");
                emailET.setMinEms(10);
                emailET.setTextColor(getResources().getColor( R.color.black));
                emailET.setInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
                linearLayout.addView(emailET);
                linearLayout.setPadding(10, 10, 10, 10);

                builder.setView(linearLayout);
                //Recover Button
                builder.setPositiveButton("Recover", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String email = emailET.getText().toString().trim();
                        progressDialog.setMessage("Sending Email... ");
                        progressDialog.show();
                        mAuth.sendPasswordResetEmail(email)
                                .addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        progressDialog.dismiss();
                                        if(task.isSuccessful()){
                                            Toast.makeText(getContext(), "Email sent", Toast.LENGTH_SHORT).show();
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
                });
                //Cancel button
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                //show dialog
                builder.create().show();
            }
        });

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

                } else {
                    Toast.makeText(getContext(), R.string.checkConnection, Toast.LENGTH_SHORT).show();
                }
            }

        });


        return view;
    }

    private void loginUser(String email, String pass) {
        progressDialog.setMessage("Logging in... ");
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
                            firebaseUtil.getPlan(getContext(), user, "Sunday");
                            firebaseUtil.getPlan(getContext(), user, "Monday");
                            firebaseUtil.getPlan(getContext(), user, "Tuesday");
                            firebaseUtil.getPlan(getContext(), user, "Wednesday");
                            firebaseUtil.getPlan(getContext(), user, "Thursday");
                            firebaseUtil.getPlan(getContext(), user, "Friday");
                            firebaseUtil.getPlan(getContext(), user, "Saturday");

                            startActivity(new Intent(getActivity(), HomeActivity.class));
                            getActivity().finish();
                        } else {
                            // If sign in fails, display a message to the user.
                            progressDialog.dismiss();
                            // Toast.makeText(getContext(), "Authentication failed.", Toast.LENGTH_SHORT).show();
                        }
                    }
                }).addOnFailureListener(e -> {
                    progressDialog.dismiss();
                    Toast.makeText(getContext(), "" + e.getMessage(), Toast.LENGTH_SHORT).show();
                });
    }


}