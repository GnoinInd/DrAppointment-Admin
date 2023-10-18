package com.example.appointment;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.DatePicker;

import com.example.appointment.databinding.ActivityPatientDetailsBinding;

import java.util.Calendar;
import java.util.Locale;

public class PatientDetailsActivity extends AppCompatActivity {
    ActivityPatientDetailsBinding binding;
    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPatientDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.backButton.setOnClickListener(v -> {
            getOnBackPressedDispatcher().onBackPressed();
        });


        binding.dob.setOnTouchListener((v, event) -> {
            final int DRAWABLE_LEFT = 0;
            final int DRAWABLE_TOP = 1;
            final int DRAWABLE_RIGHT = 2;
            final int DRAWABLE_BOTTOM = 3;

            if(event.getAction() == MotionEvent.ACTION_UP){
                if(event.getRawX() <= (binding.dob.getRight()) + binding.dob.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width()){

                    Calendar calendar = Calendar.getInstance();

                    DatePickerDialog datePickerDialog = new DatePickerDialog(this,(view, year, month, dayOfMonth) -> {
                        String dob = String.format(Locale.ENGLISH,"%2d/%2d/%4d",dayOfMonth, ++month,year );
                        binding.dob.setText(dob);

                    },calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH) );

                    datePickerDialog.show();

                    return true;
                }
            }
            return false;

        });

        binding.proceed.setOnClickListener(v -> {
            startActivity(new Intent(this, PhoneNoVerificationActivity.class));
        });
    }
}