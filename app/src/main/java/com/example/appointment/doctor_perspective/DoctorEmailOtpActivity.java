package com.example.appointment.doctor_perspective;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;

import com.example.appointment.R;
import com.example.appointment.databinding.ActivityDoctorEmailOtpBinding;
import com.example.appointment.databinding.SuccessDialogLayoutBinding;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class DoctorEmailOtpActivity extends AppCompatActivity {

    ActivityDoctorEmailOtpBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDoctorEmailOtpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.backButton.setOnClickListener(view -> getOnBackPressedDispatcher().onBackPressed());

        binding.verifyEmailButton.setOnClickListener(view -> showSuccessDialog());
    }

    private void showSuccessDialog() {
        MaterialAlertDialogBuilder alertDialogBuilder = new MaterialAlertDialogBuilder(this);
        SuccessDialogLayoutBinding binding1 = SuccessDialogLayoutBinding.inflate(getLayoutInflater());

        AlertDialog successDialog = alertDialogBuilder.setView(binding1.getRoot()).create();
        successDialog.show();

        binding1.continueButton.setOnClickListener(view -> successDialog.dismiss());

    }
}