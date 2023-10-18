package com.example.appointment.hospital_perspective;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;

import android.content.Intent;
import android.os.Bundle;

import com.example.appointment.R;
import com.example.appointment.databinding.ActivityAddSpecialityBinding;
import com.example.appointment.doctor_perspective.DoctorPhoneAndEmailVerificationActivity;
import com.example.appointment.doctor_perspective.DoctorProfileActivity;

public class AddSpecialityActivity extends AppCompatActivity {

    ActivityAddSpecialityBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddSpecialityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        binding.save.setOnClickListener(view -> startActivity(new Intent(this, DoctorProfileActivity.class)));
    }
}