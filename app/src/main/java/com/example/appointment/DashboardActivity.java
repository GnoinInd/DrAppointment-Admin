package com.example.appointment;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.example.appointment.databinding.ActivityDashboardBinding;
import com.example.appointment.databinding.ProfileMenuItemBinding;
import com.example.appointment.hospital_perspective.BuildHospitalProfileActivity;

import de.hdodenhof.circleimageview.CircleImageView;

public class DashboardActivity extends AppCompatActivity {

    private ActivityDashboardBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDashboardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        CircleImageView profileImage = findViewById(R.id.profileImage);
        profileImage.setImageResource(R.drawable.a0);

        findViewById(R.id.profile).setOnClickListener(v -> {
            Toast.makeText(DashboardActivity.this, "profile is clicked", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, BuildHospitalProfileActivity.class));
        });


        binding.topAppBar.setOnMenuItemClickListener(item -> {
            if (item.getItemId() == R.id.timeMenu) {
                Toast.makeText(DashboardActivity.this, "Time is clicked", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(DashboardActivity.this, "notification is clicked", Toast.LENGTH_SHORT).show();
            }

            return true;

        });

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);

        NavigationUI.setupWithNavController(binding.bottomNavView, navController);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, binding.drawerLayout, binding.topAppBar, R.string.open_drawer, R.string.close_drawer);
        toggle.getDrawerArrowDrawable().setColor(getColor(R.color.skyBlue));

        toggle.setDrawerIndicatorEnabled(false);
        toggle.setHomeAsUpIndicator(R.drawable.drawer_icon);

        toggle.setToolbarNavigationClickListener(view -> {
            if (binding.drawerLayout.isDrawerVisible(GravityCompat.START)) {
                binding.drawerLayout.closeDrawer(GravityCompat.START);
            } else binding.drawerLayout.openDrawer(GravityCompat.START);
        });

        binding.drawerLayout.addDrawerListener(toggle);
        toggle.syncState();


        binding.navigationView.setNavigationItemSelectedListener(item -> {
            if (item.getItemId() == R.id.logout) {
                Toast.makeText(DashboardActivity.this, "logout", Toast.LENGTH_SHORT).show();
            } else if (item.getItemId() == R.id.hospital) {
                Toast.makeText(DashboardActivity.this, "hospital", Toast.LENGTH_SHORT).show();
            } else if (item.getItemId() == R.id.location) {
                Toast.makeText(DashboardActivity.this, "location", Toast.LENGTH_SHORT).show();
            } else if (item.getItemId() == R.id.area) {
                Toast.makeText(DashboardActivity.this, "area", Toast.LENGTH_SHORT).show();
            } else if (item.getItemId() == R.id.doctor) {
                Toast.makeText(DashboardActivity.this, "doctor", Toast.LENGTH_SHORT).show();
            } else if (item.getItemId() == R.id.shift) {
                Toast.makeText(DashboardActivity.this, "shift", Toast.LENGTH_SHORT).show();
            } else if (item.getItemId() == R.id.specialization) {
                Toast.makeText(DashboardActivity.this, "specialization", Toast.LENGTH_SHORT).show();
            } else if (item.getItemId() == R.id.notification) {
                Toast.makeText(DashboardActivity.this, "notification", Toast.LENGTH_SHORT).show();
            } else if (item.getItemId() == R.id.admin) {
                Toast.makeText(DashboardActivity.this, "admin", Toast.LENGTH_SHORT).show();
            } else Toast.makeText(DashboardActivity.this, "role", Toast.LENGTH_SHORT).show();


            binding.drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        });
    }

}