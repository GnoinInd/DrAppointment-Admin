package com.example.appointment.hospital_perspective;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.appointment.databinding.ActivityHospitalPhoneAndEmailVerification2Binding;

public class HospitalPhoneAndEmailVerificationActivity2 extends AppCompatActivity {

    ActivityHospitalPhoneAndEmailVerification2Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHospitalPhoneAndEmailVerification2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.backButton.setOnClickListener(view -> getOnBackPressedDispatcher().onBackPressed());

        binding.verifyEmailButton.setOnClickListener(view -> {
            startActivity(new Intent(this, BuildHospitalProfileActivity2.class));
        });
    }
}