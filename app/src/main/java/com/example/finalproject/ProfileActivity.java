package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    private TextView usernameTextView;
    private TextView passwordTextView;
    private TextView contactTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        usernameTextView = findViewById(R.id.usernameTextView);
        passwordTextView = findViewById(R.id.passwordTextView);
        contactTextView = findViewById(R.id.contactTextView);

        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
        String password = intent.getStringExtra("password");
        String contactNumber = intent.getStringExtra("contactNumber");

        usernameTextView.setText("Username: " + username);
        contactTextView.setText("Contact Number: " + contactNumber);
        passwordTextView.setText("Password: " + password);
    }
}