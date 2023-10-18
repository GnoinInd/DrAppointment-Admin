package com.example.appointment.doctor_perspective;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.appointment.databinding.ActivityDoctorPhoneAndEmailVerificationBinding;

public class DoctorPhoneAndEmailVerificationActivity extends AppCompatActivity {

    ActivityDoctorPhoneAndEmailVerificationBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDoctorPhoneAndEmailVerificationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.backButton.setOnClickListener(view -> getOnBackPressedDispatcher().onBackPressed());


        binding.sendOTPButton.setOnClickListener(view -> startActivity(new Intent(this, DoctorPhoneNoOtpActivity.class)));
    }
}