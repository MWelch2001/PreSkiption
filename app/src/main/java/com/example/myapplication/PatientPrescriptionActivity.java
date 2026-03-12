package com.example.myapplication;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.databinding.ActivityPatientPrescriptionBinding;

public class PatientPrescriptionActivity extends AppCompatActivity {

private ActivityPatientPrescriptionBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

     binding = ActivityPatientPrescriptionBinding.inflate(getLayoutInflater());
     setContentView(binding.getRoot());

     final Button joinQueueButton = binding.joinQueueButton;



        joinQueueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}