package com.example.appointment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.appointment.databinding.ActivityConfirmAppointmentBinding;

public class ConfirmAppointmentActivity extends AppCompatActivity {

    ActivityConfirmAppointmentBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityConfirmAppointmentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.backButton.setOnClickListener(v -> {
            getOnBackPressedDispatcher().onBackPressed();
        });

        binding.confirmAppointment.setOnClickListener(v -> {
            startActivity(new Intent(this, PaymentActivity.class));
        });
    }
}