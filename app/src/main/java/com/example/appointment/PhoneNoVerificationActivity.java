package com.example.appointment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.appointment.databinding.ActivityPhoneNoVerificationBinding;

public class PhoneNoVerificationActivity extends AppCompatActivity {
    ActivityPhoneNoVerificationBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPhoneNoVerificationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.backButton.setOnClickListener(v -> {
            getOnBackPressedDispatcher().onBackPressed();
        });

        binding.submitOTP.setOnClickListener(v -> {
            startActivity(new Intent(this, ConfirmAppointmentActivity.class));
        });
    }
}