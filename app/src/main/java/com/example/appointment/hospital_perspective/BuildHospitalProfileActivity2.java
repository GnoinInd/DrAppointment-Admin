package com.example.appointment.hospital_perspective;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.appointment.databinding.ActivityBuildHospitalProfile2Binding;

public class BuildHospitalProfileActivity2 extends AppCompatActivity {

    ActivityBuildHospitalProfile2Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBuildHospitalProfile2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.save.setOnClickListener(view -> startActivity(new Intent(this, AddSpecialityActivity.class)));
    }
}