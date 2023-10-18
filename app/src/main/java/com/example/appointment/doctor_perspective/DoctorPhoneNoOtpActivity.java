package com.example.appointment.doctor_perspective;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.appointment.R;
import com.example.appointment.databinding.ActivityDoctorPhoneNoOtpBinding;

public class DoctorPhoneNoOtpActivity extends AppCompatActivity {

    ActivityDoctorPhoneNoOtpBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDoctorPhoneNoOtpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.backButton.setOnClickListener(view -> getOnBackPressedDispatcher().onBackPressed());

        binding.verifyMobileButton.setOnClickListener(view -> startActivity(new Intent(this, DoctorEmailOtpActivity.class)));
    }
}