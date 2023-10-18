package com.example.appointment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;

import com.example.appointment.databinding.ActivityDoctorShowMoreBinding;
import com.google.firebase.auth.FirebaseAuth;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;


public class DoctorShowMoreActivity extends AppCompatActivity {

    ActivityDoctorShowMoreBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDoctorShowMoreBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.backButton.setOnClickListener(v -> getOnBackPressedDispatcher().onBackPressed());


        binding.selectedHosp.setText(getIntent().getStringExtra("hospName"));

        binding.showMoreButton.setOnClickListener(v -> {
            binding.showMoreButton.setVisibility(View.GONE);
            binding.card2.setVisibility(View.VISIBLE);
        });

        binding.close.setOnClickListener(v -> {
            binding.card2.setVisibility(View.GONE);
            binding.showMoreButton.setVisibility(View.VISIBLE);
        });

        binding.bookAppointment.setOnClickListener(v -> {
            Intent intent;
            if (FirebaseAuth.getInstance().getCurrentUser() != null) {
                intent = new Intent(this, PatientDetailsActivity.class);
            } else {
                intent = new Intent(this, SignInActivity.class);
                intent.putExtra("intent", 1);
            }
            startActivity(intent);
        });


        // calender related work

        Calendar calendar = Calendar.getInstance();
        // calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY );  // Start from Sunday
        // calendar.add(Calendar.DAY_OF_WEEK, -7);

        SimpleDateFormat dateFormat = new SimpleDateFormat("E\n dd MMM ", Locale.US);


        for (int i = 0; i < 7; i++) {
            String dateLabel = dateFormat.format(calendar.getTime());

            calendar.add(Calendar.DAY_OF_WEEK, 1); // Move to the next day

            switch (i) {
                case 0:
                    binding.day1.setText(dateLabel);
                    binding.day1.setOnClickListener(v -> {
                        binding.day1.setBackground(AppCompatResources.getDrawable(this, R.drawable.calender_selector));
                        binding.day2.setBackground(null);
                        binding.day3.setBackground(null);
                        binding.day4.setBackground(null);
                        binding.day5.setBackground(null);
                        binding.day6.setBackground(null);
                        binding.day7.setBackground(null);
                        // Toast.makeText(this, dateLabel, Toast.LENGTH_SHORT).show();
                    });
                case 1:
                    binding.day2.setText(dateLabel);
                    binding.day2.setOnClickListener(v -> {
                        binding.day1.setBackground(null);
                        binding.day2.setBackground(AppCompatResources.getDrawable(this, R.drawable.calender_selector));
                        binding.day3.setBackground(null);
                        binding.day4.setBackground(null);
                        binding.day5.setBackground(null);
                        binding.day6.setBackground(null);
                        binding.day7.setBackground(null);
                        // Toast.makeText(this, dateLabel, Toast.LENGTH_SHORT).show();
                    });
                case 2:
                    binding.day3.setText(dateLabel);
                    binding.day3.setOnClickListener(v -> {
                        binding.day1.setBackground(null);
                        binding.day2.setBackground(null);
                        binding.day3.setBackground(AppCompatResources.getDrawable(this, R.drawable.calender_selector));
                        binding.day4.setBackground(null);
                        binding.day5.setBackground(null);
                        binding.day6.setBackground(null);
                        binding.day7.setBackground(null);
                        //  Toast.makeText(this, dateLabel, Toast.LENGTH_SHORT).show();
                    });
                case 3:
                    binding.day4.setText(dateLabel);
                    binding.day4.setOnClickListener(v -> {
                        binding.day1.setBackground(null);
                        binding.day2.setBackground(null);
                        binding.day3.setBackground(null);
                        binding.day4.setBackground(AppCompatResources.getDrawable(this, R.drawable.calender_selector));
                        binding.day5.setBackground(null);
                        binding.day6.setBackground(null);
                        binding.day7.setBackground(null);
                        //  Toast.makeText(this, dateLabel, Toast.LENGTH_SHORT).show();
                    });
                case 4:
                    binding.day5.setText(dateLabel);
                    binding.day5.setOnClickListener(v -> {
                        binding.day1.setBackground(null);
                        binding.day2.setBackground(null);
                        binding.day3.setBackground(null);
                        binding.day4.setBackground(null);
                        binding.day5.setBackground(AppCompatResources.getDrawable(this, R.drawable.calender_selector));
                        binding.day6.setBackground(null);
                        binding.day7.setBackground(null);
                        // Toast.makeText(this, dateLabel, Toast.LENGTH_SHORT).show();
                    });
                case 5:
                    binding.day6.setText(dateLabel);
                    binding.day6.setOnClickListener(v -> {
                        binding.day1.setBackground(null);
                        binding.day2.setBackground(null);
                        binding.day3.setBackground(null);
                        binding.day4.setBackground(null);
                        binding.day5.setBackground(null);
                        binding.day6.setBackground(AppCompatResources.getDrawable(this, R.drawable.calender_selector));
                        binding.day7.setBackground(null);
                        //  Toast.makeText(this, dateLabel, Toast.LENGTH_SHORT).show();
                    });
                case 6:
                    binding.day7.setText(dateLabel);
                    binding.day7.setOnClickListener(v -> {
                        binding.day1.setBackground(null);
                        binding.day2.setBackground(null);
                        binding.day3.setBackground(null);
                        binding.day4.setBackground(null);
                        binding.day5.setBackground(null);
                        binding.day6.setBackground(null);
                        binding.day7.setBackground(AppCompatResources.getDrawable(this, R.drawable.calender_selector));
                        // Toast.makeText(this, dateLabel, Toast.LENGTH_SHORT).show();
                    });


            }
        }

        binding.prevWeekButton.setOnClickListener(view -> {
            if (dateFormat.format(Calendar.getInstance().getTime()).equalsIgnoreCase(binding.day1.getText().toString())) {
                return;
            }
            calendar.add(Calendar.DAY_OF_WEEK, -8);
            for (int i = 0; i < 7; i++) {
                String dateLabel = dateFormat.format(calendar.getTime());

                switch (i) {
                    case 0:
                        binding.day7.setText(dateLabel);
                        binding.day7.setOnClickListener(v -> {
                            binding.day1.setBackground(null);
                            binding.day2.setBackground(null);
                            binding.day3.setBackground(null);
                            binding.day4.setBackground(null);
                            binding.day5.setBackground(null);
                            binding.day6.setBackground(null);
                            binding.day7.setBackground(AppCompatResources.getDrawable(this, R.drawable.calender_selector));
                            // Toast.makeText(this, dateLabel, Toast.LENGTH_SHORT).show();
                        });

                    case 1:
                        binding.day6.setText(dateLabel);
                        binding.day6.setOnClickListener(v -> {
                            binding.day1.setBackground(null);
                            binding.day2.setBackground(null);
                            binding.day3.setBackground(null);
                            binding.day4.setBackground(null);
                            binding.day5.setBackground(null);
                            binding.day6.setBackground(AppCompatResources.getDrawable(this, R.drawable.calender_selector));
                            binding.day7.setBackground(null);
                            //  Toast.makeText(this, dateLabel, Toast.LENGTH_SHORT).show();
                        });
                    case 2:
                        binding.day5.setText(dateLabel);
                        binding.day5.setOnClickListener(v -> {
                            binding.day1.setBackground(null);
                            binding.day2.setBackground(null);
                            binding.day3.setBackground(null);
                            binding.day4.setBackground(null);
                            binding.day5.setBackground(AppCompatResources.getDrawable(this, R.drawable.calender_selector));
                            binding.day6.setBackground(null);
                            binding.day7.setBackground(null);
                            // Toast.makeText(this, dateLabel, Toast.LENGTH_SHORT).show();
                        });
                    case 3:
                        binding.day4.setText(dateLabel);
                        binding.day4.setOnClickListener(v -> {
                            binding.day1.setBackground(null);
                            binding.day2.setBackground(null);
                            binding.day3.setBackground(null);
                            binding.day4.setBackground(AppCompatResources.getDrawable(this, R.drawable.calender_selector));
                            binding.day5.setBackground(null);
                            binding.day6.setBackground(null);
                            binding.day7.setBackground(null);
                            //  Toast.makeText(this, dateLabel, Toast.LENGTH_SHORT).show();
                        });

                    case 4:
                        binding.day3.setText(dateLabel);
                        binding.day3.setOnClickListener(v -> {
                            binding.day1.setBackground(null);
                            binding.day2.setBackground(null);
                            binding.day3.setBackground(AppCompatResources.getDrawable(this, R.drawable.calender_selector));
                            binding.day4.setBackground(null);
                            binding.day5.setBackground(null);
                            binding.day6.setBackground(null);
                            binding.day7.setBackground(null);
                            //  Toast.makeText(this, dateLabel, Toast.LENGTH_SHORT).show();
                        });

                    case 5:
                        binding.day2.setText(dateLabel);
                        binding.day2.setOnClickListener(v -> {
                            binding.day1.setBackground(null);
                            binding.day2.setBackground(AppCompatResources.getDrawable(this, R.drawable.calender_selector));
                            binding.day3.setBackground(null);
                            binding.day4.setBackground(null);
                            binding.day5.setBackground(null);
                            binding.day6.setBackground(null);
                            binding.day7.setBackground(null);
                            // Toast.makeText(this, dateLabel, Toast.LENGTH_SHORT).show();
                        });

                    case 6:
                        binding.day1.setText(dateLabel);
                        binding.day1.setOnClickListener(v -> {
                            binding.day1.setBackground(AppCompatResources.getDrawable(this, R.drawable.calender_selector));
                            binding.day2.setBackground(null);
                            binding.day3.setBackground(null);
                            binding.day4.setBackground(null);
                            binding.day5.setBackground(null);
                            binding.day6.setBackground(null);
                            binding.day7.setBackground(null);
                            // Toast.makeText(this, dateLabel, Toast.LENGTH_SHORT).show();
                        });


                }

                calendar.add(Calendar.DAY_OF_WEEK, -1); // Move to the prev day
            }
            calendar.add(Calendar.DAY_OF_WEEK, 8);
        });

        binding.nextWeekButton.setOnClickListener(view -> {
            for (int i = 0; i < 7; i++) {
                String dateLabel = dateFormat.format(calendar.getTime());

                switch (i) {
                    case 0:
                        binding.day1.setText(dateLabel);
                        binding.day1.setOnClickListener(v -> {
                            binding.day1.setBackground(AppCompatResources.getDrawable(this, R.drawable.calender_selector));
                            binding.day2.setBackground(null);
                            binding.day3.setBackground(null);
                            binding.day4.setBackground(null);
                            binding.day5.setBackground(null);
                            binding.day6.setBackground(null);
                            binding.day7.setBackground(null);
                            // Toast.makeText(this, dateLabel, Toast.LENGTH_SHORT).show();
                        });
                    case 1:
                        binding.day2.setText(dateLabel);
                        binding.day2.setOnClickListener(v -> {
                            binding.day1.setBackground(null);
                            binding.day2.setBackground(AppCompatResources.getDrawable(this, R.drawable.calender_selector));
                            binding.day3.setBackground(null);
                            binding.day4.setBackground(null);
                            binding.day5.setBackground(null);
                            binding.day6.setBackground(null);
                            binding.day7.setBackground(null);
                            // Toast.makeText(this, dateLabel, Toast.LENGTH_SHORT).show();
                        });
                    case 2:
                        binding.day3.setText(dateLabel);
                        binding.day3.setOnClickListener(v -> {
                            binding.day1.setBackground(null);
                            binding.day2.setBackground(null);
                            binding.day3.setBackground(AppCompatResources.getDrawable(this, R.drawable.calender_selector));
                            binding.day4.setBackground(null);
                            binding.day5.setBackground(null);
                            binding.day6.setBackground(null);
                            binding.day7.setBackground(null);
                            //  Toast.makeText(this, dateLabel, Toast.LENGTH_SHORT).show();
                        });
                    case 3:
                        binding.day4.setText(dateLabel);
                        binding.day4.setOnClickListener(v -> {
                            binding.day1.setBackground(null);
                            binding.day2.setBackground(null);
                            binding.day3.setBackground(null);
                            binding.day4.setBackground(AppCompatResources.getDrawable(this, R.drawable.calender_selector));
                            binding.day5.setBackground(null);
                            binding.day6.setBackground(null);
                            binding.day7.setBackground(null);
                            //  Toast.makeText(this, dateLabel, Toast.LENGTH_SHORT).show();
                        });
                    case 4:
                        binding.day5.setText(dateLabel);
                        binding.day5.setOnClickListener(v -> {
                            binding.day1.setBackground(null);
                            binding.day2.setBackground(null);
                            binding.day3.setBackground(null);
                            binding.day4.setBackground(null);
                            binding.day5.setBackground(AppCompatResources.getDrawable(this, R.drawable.calender_selector));
                            binding.day6.setBackground(null);
                            binding.day7.setBackground(null);
                            // Toast.makeText(this, dateLabel, Toast.LENGTH_SHORT).show();
                        });
                    case 5:
                        binding.day6.setText(dateLabel);
                        binding.day6.setOnClickListener(v -> {
                            binding.day1.setBackground(null);
                            binding.day2.setBackground(null);
                            binding.day3.setBackground(null);
                            binding.day4.setBackground(null);
                            binding.day5.setBackground(null);
                            binding.day6.setBackground(AppCompatResources.getDrawable(this, R.drawable.calender_selector));
                            binding.day7.setBackground(null);
                            //  Toast.makeText(this, dateLabel, Toast.LENGTH_SHORT).show();
                        });
                    case 6:
                        binding.day7.setText(dateLabel);
                        binding.day7.setOnClickListener(v -> {
                            binding.day1.setBackground(null);
                            binding.day2.setBackground(null);
                            binding.day3.setBackground(null);
                            binding.day4.setBackground(null);
                            binding.day5.setBackground(null);
                            binding.day6.setBackground(null);
                            binding.day7.setBackground(AppCompatResources.getDrawable(this, R.drawable.calender_selector));
                            // Toast.makeText(this, dateLabel, Toast.LENGTH_SHORT).show();
                        });


                }

                calendar.add(Calendar.DAY_OF_WEEK, 1); // Move to the next day
            }
        });


    }
}