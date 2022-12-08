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

public class LoginActivity extends AppCompatActivity {
    private final static int NUMBER_RETRY = 3;
    Button registerBtn, loginBtn;
    EditText usernameET, passwordET;
    String receivedUser, receivedPass, inputUser, inputPass;
    static int lockedAccountCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameET = findViewById(R.id.username);
        passwordET = findViewById(R.id.password);
        registerBtn = findViewById(R.id.createaccountbtn);
        loginBtn = findViewById(R.id.loginbtn);

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToRegister = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(goToRegister);
            }
        });

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("RegisterPreferences", Context.MODE_PRIVATE);
                receivedUser = sharedPreferences.getString("Name", null);
                receivedPass = sharedPreferences.getString("Password", null);
                inputUser = usernameET.getText().toString();
                inputPass = passwordET.getText().toString();

                if (usernameET.getText().toString().isEmpty() || passwordET.getText().toString().isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Details cannot be blank", Toast.LENGTH_SHORT).show();
                    ;
                } else if (usernameET.getText().toString().equals(receivedUser) && passwordET.getText().toString().equals(receivedPass)) {
                    Intent goToQuestions = new Intent(LoginActivity.this, QuestionActivity.class);
                    startActivity(goToQuestions);
                } else if (!inputUser.equals(receivedUser) || !inputPass.equals(receivedPass)) {
                    Toast.makeText(LoginActivity.this, "Incorrect credentials.", Toast.LENGTH_SHORT).show();
                    lockedAccountCounter++;
                    if (lockedAccountCounter == NUMBER_RETRY) {
                        loginBtn.setEnabled(false);
                        loginBtn.setBackgroundColor(getResources().getColor(android.R.color.darker_gray));
                        loginBtn.setTextColor(getResources().getColor(android.R.color.holo_green_dark));
                        Toast.makeText(LoginActivity.this, "Contact your Admin.", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }
}