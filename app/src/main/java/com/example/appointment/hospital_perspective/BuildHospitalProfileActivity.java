package com.example.appointment.hospital_perspective;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.appointment.databinding.ActivityBuildHospitalProfileBinding;

public class BuildHospitalProfileActivity extends AppCompatActivity {
    ActivityBuildHospitalProfileBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBuildHospitalProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.registerHospital.setOnClickListener(view -> startActivity(new Intent(this, HospitalPhoneAndEmailVerificationActivity.class)));
    }
}