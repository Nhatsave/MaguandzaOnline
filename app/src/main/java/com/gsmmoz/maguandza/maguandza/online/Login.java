package com.gsmmoz.maguandza.maguandza.online;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Login extends AppCompatActivity {

    private EditText txt_email;
    private EditText txt_password;
    private Button btn_login;

    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference().child("Users");

        txt_email = findViewById(R.id.txt_email);
        txt_email = (EditText) findViewById(R.id.txt_email);
        txt_password = findViewById(R.id.txt_password);
        //txt_password = findViewById(R.id.txt_password);
        btn_login = findViewById(R.id.btn_login);


        btn_login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    checkLogin();
                }
            });
        }

    private void checkLogin() {
        String email = txt_email.getText().toString();
        String password = txt_password.getText().toString();

        if (!TextUtils.isEmpty(email) && !TextUtils.isEmpty(password)){
            mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>(){
                @Override
                public void onComplete(@NonNull Task<AuthResult> task){

                    if (task.isSuccessful()){
                        Toast.makeText(Login.this, "Login Sucess", Toast.LENGTH_LONG).show();

                        checKUserExist();

                        Intent homeIntent = new Intent( Login.this, HomeActivity.class);
                        homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(homeIntent);

                    }else{
                        Toast.makeText(Login.this, "Error Login", Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
    }

    private void checKUserExist() {
        String user_id = mAuth.getCurrentUser().getUid();

        Intent homeIntent = new Intent( Login.this, HomeActivity.class);
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {



                if (dataSnapshot.hasChild(user_id)){


                    homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(homeIntent);
                    finish();

                }else {

                    Toast.makeText(Login.this, "Email Nao Registado. ", Toast.LENGTH_LONG).show();
                }
            }



            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}