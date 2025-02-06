package com.example.khetibazar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Sign_in extends AppCompatActivity {

    Button login;

    TextView signUp;

    EditText userEmail, userPassword;

    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();

    public static final String SHARED_PREFS = "sharedprefs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        login = findViewById(R.id.getin);
        userEmail = findViewById(R.id.username);
        userPassword = findViewById(R.id.pass);

        signUp = findViewById(R.id.create);
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Signup.class);
                startActivity(intent);
            }
        });


        checkBox();


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String email, password;

                email = String.valueOf(userEmail.getText());
                password = String.valueOf(userPassword.getText());


                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(Sign_in.this, "Enter Email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(Sign_in.this, "Enter Password", Toast.LENGTH_SHORT).show();
                    return;
                }
                firebaseAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {

                                    SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
                                    SharedPreferences.Editor editor = sharedPreferences.edit();
                                    editor.putString("name", "true");
                                    editor.apply();
                                    Toast.makeText(Sign_in.this, "Login Successful", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(getApplicationContext(), home_page.class);
                                    startActivity(intent);
                                    finish();
                                } else {
                                    Toast.makeText(Sign_in.this, "Wrong email/password", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });


            }
        });


    }

    private void checkBox() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        String check = sharedPreferences.getString("name", "");
        if (check.equals("true")) {


            Intent intent = new Intent(getApplicationContext(), home_page.class);
            startActivity(intent);
            finish();

        }
    }
}