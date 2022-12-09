package com.example.quizapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText userET,passET;
    Button registerBtn, goLogin;
    String usernameStr, passwordStr;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        userET = findViewById(R.id.name);
        passET = findViewById(R.id.password);
        registerBtn = findViewById(R.id.register);
        goLogin =findViewById(R.id.gologin);
        sharedPreferences = getSharedPreferences("RegisterPreferences", Context.MODE_PRIVATE);

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                usernameStr = userET.getText().toString();
                passwordStr = passET.getText().toString();

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("Name",usernameStr);
                editor.putString("Password",passwordStr);
                editor.commit();

                Toast.makeText(RegisterActivity.this, "Username registered.", Toast.LENGTH_SHORT).show();
            }
        });

        goLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToLogin = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(goToLogin);
            }
        });

    }
}