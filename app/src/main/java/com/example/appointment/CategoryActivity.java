package com.example.appointment;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appointment.databinding.ActivityCategoryBinding;

public class CategoryActivity extends AppCompatActivity {
    ActivityCategoryBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCategoryBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.backButton.setOnClickListener(v -> {
            onBackPressed();
        });

        String spec = getIntent().getStringExtra("specialization");

        final String[] checkedRank = new String[1];
        //int checkedButton = binding.radioGroup.getCheckedRadioButtonId();

        binding.radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if (checkedId == binding.rank1.getId()) {
                    checkedRank[0] = "expensive";
                } else if (checkedId == binding.rank2.getId()) {
                    checkedRank[0] = "medium";
                } else if (checkedId == binding.rank3.getId()) {
                    checkedRank[0] = "under budget";
                } else checkedRank[0] = "cheap";
            }
        });

        binding.nextButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, HospitalActivity.class);
            intent.putExtra("specialization", spec);
            if (checkedRank[0] != null) {
                intent.putExtra("category", checkedRank[0]);
            } else {
                Toast.makeText(this, "Please select any radio button", Toast.LENGTH_SHORT).show();
                return;
            }
            startActivity(intent);
        });
    }
}