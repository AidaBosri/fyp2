package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Toast;

public class FillActivity extends AppCompatActivity {

    private EditText nameEditText;
    private EditText fromDateEditText;
    private EditText toDateEditText;
    private RadioButton sickLeavesRadioButton;
    private RadioButton medicalAppointmentRadioButton;
    private RadioButton annualLeaveRadioButton;
    private RadioButton bereavementLeaveRadioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill);

        nameEditText = findViewById(R.id.nameEditText2);
        fromDateEditText = findViewById(R.id.editTextDate3);
        toDateEditText = findViewById(R.id.editTextDate4);
        sickLeavesRadioButton = findViewById(R.id.radioButton);
        medicalAppointmentRadioButton = findViewById(R.id.radioButton2);
        annualLeaveRadioButton = findViewById(R.id.radioButton3);
        bereavementLeaveRadioButton = findViewById(R.id.radioButton4);
        Button applyButton = findViewById(R.id.button);
        Button resetButton = findViewById(R.id.resetBtn);
        ImageButton imageButton = findViewById(R.id.imageButton2);

        // Set up click listener for the apply button
        applyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the input values and check if they are valid
                String name = nameEditText.getText().toString().trim();
                String fromDate = fromDateEditText.getText().toString().trim();
                String toDate = toDateEditText.getText().toString().trim();
                boolean isSickLeavesSelected = sickLeavesRadioButton.isChecked();
                boolean isMedicalAppointmentSelected = medicalAppointmentRadioButton.isChecked();
                boolean isAnnualLeaveSelected = annualLeaveRadioButton.isChecked();
                boolean isBereavementLeaveSelected = bereavementLeaveRadioButton.isChecked();

                if (name.isEmpty() || fromDate.isEmpty() || toDate.isEmpty()) {
                    // Show a toast message if any of the input values are missing
                    Toast.makeText(FillActivity.this, "Please fill in all the required fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!isSickLeavesSelected && !isMedicalAppointmentSelected && !isAnnualLeaveSelected && !isBereavementLeaveSelected) {
                    // Show a toast message if no leave option is selected
                    Toast.makeText(FillActivity.this, "Please select a leave option", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Show a toast message to confirm that the form has been submitted
                Toast.makeText(FillActivity.this, "Leave application form submitted", Toast.LENGTH_SHORT).show();
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nameEditText.setText("");
                fromDateEditText.setText("");
                toDateEditText.setText("");
                sickLeavesRadioButton.setChecked(false);
                medicalAppointmentRadioButton.setChecked(false);
                annualLeaveRadioButton.setChecked(false);
                bereavementLeaveRadioButton.setChecked(false);
            }
        });

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FillActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });
    }
}