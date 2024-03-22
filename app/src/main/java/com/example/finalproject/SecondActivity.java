package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class SecondActivity extends AppCompatActivity {

    private EditText usernameEditText;
    private EditText passwordEditText;
    private EditText contactEditTextNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        usernameEditText = findViewById(R.id.nameEditText);
        passwordEditText = findViewById(R.id.emaileditTextEmailAddress);
        contactEditTextNumber = findViewById(R.id.contacteditTextNumber);

        Button registerButton = findViewById(R.id.regisbtn);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();
                String contactNumber = contactEditTextNumber.getText().toString().trim();

                if (username.isEmpty() || password.isEmpty() || contactNumber.isEmpty() || !isValidPassword(password)) {
                    Toast.makeText(SecondActivity.this, "Register done please login", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(SecondActivity.this, ProfileActivity.class);
                    intent.putExtra("username", username);
                    intent.putExtra("password", password);
                    intent.putExtra("contactNumber", contactNumber);
                    startActivity(intent);
                }
            }
        });
        Button loginButton = findViewById(R.id.loginbtn2);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(intent);}
        });
    }

    private static boolean isValidPassword(String password) {
        if (password.length() < 6 || !password.matches("\\d+")) {
            return false;
        }

        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(SecondActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}