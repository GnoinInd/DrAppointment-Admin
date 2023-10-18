package com.example.appointment.hospital_perspective;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.appointment.databinding.ActivityHospitalPhoneAndEmailVerificationBinding;

public class HospitalPhoneAndEmailVerificationActivity extends AppCompatActivity {

    ActivityHospitalPhoneAndEmailVerificationBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHospitalPhoneAndEmailVerificationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.backButton.setOnClickListener(view -> getOnBackPressedDispatcher().onBackPressed());

        binding.sendOTPButton.setOnClickListener(view -> {
            startActivity(new Intent(this, HospitalPhoneAndEmailVerificationActivity2.class));
            overridePendingTransition(0,0);
        });
    }
}