package com.example.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText nameEditText;
    private EditText passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEditText = findViewById(R.id.nameEditText3);
        passwordEditText = findViewById(R.id.passeditText);
        Button registerButton = findViewById(R.id.regisbtn2);
        Button loginButton = findViewById(R.id.loginbtn);

        // Set a click listener to the login button
        loginButton.setOnClickListener(v -> {
            // Get the input values and trim any leading or trailing whitespace
            String name = nameEditText.getText().toString().trim();
            String password = passwordEditText.getText().toString().trim();

            // Check if any of the input values are empty
            if (name.isEmpty() || password.isEmpty()) {
                // Show a Toast message to the user to fill out the form
                Toast.makeText(MainActivity.this, "Please fill out the form", Toast.LENGTH_SHORT).show();
            } else {
                // Start the FormActivity when the login button is clicked
                Intent intent = new Intent(MainActivity.this, FillActivity.class);
                startActivity(intent);
            }
        });

        // Set a click listener to the register button
        registerButton.setOnClickListener(v -> {
            // Start the SecondActivity when the register button is clicked
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
        });
    }
}