package com.example.appointment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.appointment.adapters.HospitalAdapter;
import com.example.appointment.databinding.ActivityHospitalBinding;
import com.example.appointment.model.DoctorDetails;
import com.example.appointment.model.HospitalModal;
import com.example.appointment.model.Specialization;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class HospitalActivity extends AppCompatActivity {
    ActivityHospitalBinding binding;
    String specialization,category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHospitalBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.backButton.setOnClickListener(v -> {
            getOnBackPressedDispatcher().onBackPressed();
        });

        specialization = getIntent().getStringExtra("specialization");
        category = getIntent().getStringExtra("category");


        getDesiredListAndShow(specialization, category);




    }

    public void getDesiredListAndShow(String specialization,String category ) {

        List<Specialization> list = new ArrayList<>();
        list.add(new Specialization(R.drawable.h_name, "Apollo"));
        list.add(new Specialization(R.drawable.h_name, "City Hospital"));
        list.add(new Specialization(R.drawable.h_name, "Smart Hospital"));
        list.add(new Specialization(R.drawable.h_name, "Charak Hospital"));
        list.add(new Specialization(R.drawable.h_name, "Shushrut Hospital"));
        list.add(new Specialization(R.drawable.h_name, "Unity Hospital"));
        list.add(new Specialization(R.drawable.h_name, "Vmac Hospital"));
        list.add(new Specialization(R.drawable.h_name, "Orhto Hospital"));
        list.add(new Specialization(R.drawable.h_name, "Tata Hospital"));
        list.add(new Specialization(R.drawable.h_name, "MedicosHospital"));
        list.add(new Specialization(R.drawable.h_name, "Psychiatry Hospital"));
        list.add(new Specialization(R.drawable.h_name, "Radiology Hospital"));
        list.add(new Specialization(R.drawable.h_name, "Gastroenterology Hospital"));
        list.add(new Specialization(R.drawable.h_name, "Cardiology Hospital"));

        HospitalAdapter adapter = new HospitalAdapter(list, "Orthopedics");
        binding.recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        binding.recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        /*try {
            InputStream inputStream = getAssets().open("hospitals.json");
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();

            // fetch the json file
            String json;
            int max;

            json = new String(buffer, StandardCharsets.UTF_8);
            JSONObject jsonObject = new JSONObject(json);
            JSONArray jsonArray = jsonObject.getJSONArray("hospitals");
            max = jsonArray.length();

            for(int i = 0;i<max;i++){
                JSONObject singleHospital = jsonArray.getJSONObject(i);
                JSONArray specArray = singleHospital.getJSONArray("specialization");
                String category1 = singleHospital.getString("category_type");
                for(int j=0;j<specArray.length();j++){
                    if(Objects.equals(specArray.get(j).toString(), specialization) && Objects.equals(category, category1)){
                        list.add(new Specialization(singleHospital.getString("hospital_name")));
                        break;
                    }
                }
            }
            if(list.size()>0){
                HospitalAdapter adapter = new HospitalAdapter(list, specialization);

                binding.recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
                binding.recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
            else Toast.makeText(this, "No Hospital available of "+specialization+ " of "+category, Toast.LENGTH_SHORT).show();


        } catch (Exception e) {
            binding.NoText.setText(e.getMessage());
            binding.NoText.setVisibility(View.VISIBLE);
            Toast.makeText(this, "Error\n"+e.getMessage(), Toast.LENGTH_SHORT).show();
        }
*/

    }
}