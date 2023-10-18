package com.example.appointment.doctor_perspective;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appointment.databinding.ActivityDoctorProfileBinding;

public class DoctorProfileActivity extends AppCompatActivity {

    ActivityDoctorProfileBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDoctorProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.nextButton.setOnClickListener(view -> startActivity(new Intent(this, DoctorPhoneAndEmailVerificationActivity.class)));

    }
}
