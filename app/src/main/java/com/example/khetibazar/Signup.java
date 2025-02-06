package com.example.khetibazar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Signup extends AppCompatActivity {

    TextView sign;

    EditText registerUsername,registerPassword,registerPhone;

    FirebaseUser currentUser; FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();


    DatabaseReference reference;

    Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        btn = findViewById(R.id.cont);
        sign=findViewById(R.id.signin);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Otp_ver.class);
                startActivity(intent);
            }
        });

        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Signup.this,Sign_in.class);
                startActivity(intent);
            }
        });


        registerUsername = findViewById(R.id.username);
        registerPhone = findViewById(R.id.phoneno);
        registerPassword = findViewById(R.id.pass);



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String email,password;
                email = String.valueOf(registerUsername.getText());
                password = String.valueOf(registerPassword.getText());

                if (TextUtils.isEmpty(email)){
                    Toast.makeText(Signup.this, "Enter Email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(password)){
                    Toast.makeText(Signup.this, "Enter Password", Toast.LENGTH_SHORT).show();
                    return;
                }

                firebaseAuth.createUserWithEmailAndPassword(email,password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    uploadData();
                                    Toast.makeText(Signup.this, "Account Created", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(getApplicationContext(),home_page.class);
                                    startActivity(intent);
                                    finish();
                                }
                                else{
                                    Toast.makeText(Signup.this, "Invalid", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });




    }

    private void uploadData() {


        String email="";
        String num="";

        currentUser = firebaseAuth.getCurrentUser();
        String uid = currentUser.getUid();

        reference = FirebaseDatabase.getInstance().getReference("ProfileDetails");

        SignUpModel model = new SignUpModel(email, num, uid);

        reference.child(uid).setValue(model).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(Signup.this, "Data uploaded", Toast.LENGTH_SHORT).show();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(Signup.this, "error " + e, Toast.LENGTH_SHORT).show();
            }
        });


    }
}