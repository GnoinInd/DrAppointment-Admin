package com.example.appointment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.appointment.adapters.DoctorAdapter;
import com.example.appointment.adapters.HospitalAdapter;
import com.example.appointment.databinding.ActivityDoctorBinding;
import com.example.appointment.model.DoctorDetails;
import com.example.appointment.model.Specialization;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DoctorActivity extends AppCompatActivity {
    ActivityDoctorBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDoctorBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.backButton.setOnClickListener(v -> {
            onBackPressed();
        });

        String spec = getIntent().getStringExtra("spec");
        String hospName = getIntent().getStringExtra("hospName");

        getDesiredListAndShow(spec, hospName);
    }


    public void getDesiredListAndShow(String spec, String hospName ) {

        List<DoctorDetails> list = new ArrayList<>();

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
                String hospName1 = singleHospital.getString("hospital_name");
                for(int j=0;j<specArray.length();j++){
                    if(Objects.equals(specArray.get(j).toString(), spec) && Objects.equals(hospName, hospName1)){
                        JSONArray doctorArray = singleHospital.getJSONArray("doctor_list");
                        for(int k = 0;k< doctorArray.length();k++){
                            JSONObject singleDoctor = doctorArray.getJSONObject(k);
                            if(singleDoctor.getString("doctor_specialization").equals(spec)){
                                list.add(new DoctorDetails(R.drawable.a0, singleDoctor.getString("doctor_name"),
                                        singleDoctor.getString("doctor_degree"), singleDoctor.getString("doctor_specialization"),
                                        singleDoctor.getString("gender"), singleDoctor.getString("doctor_availability")));
                            }

                        }
                        break;
                    }
                }
                if(list.size()>0){
                    DoctorAdapter adapter = new DoctorAdapter(list, hospName);

                    binding.recyclerview.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                    break;
                }

            }
            if(list.size() ==0){
                Toast.makeText(this, "No Doctor available of "+ spec + " of "+hospName, Toast.LENGTH_SHORT).show();
            }


        } catch (Exception e) {
            Toast.makeText(this, "Error\n"+e.getMessage(), Toast.LENGTH_SHORT).show();
        }*/

        list.add(new DoctorDetails(R.drawable.a0, "Alpha", "M.B.B.S", "Orthopedics", "Male", "Sun, Tue, Fri"));
        list.add(new DoctorDetails(R.drawable.a0, "Beta", "M.B.B.S", "Orthopedics", "Female", "Sun, Tue, Fri"));
        list.add(new DoctorDetails(R.drawable.a0, "Alpha", "M.B.B.S", "Orthopedics", "Male", "Sun, Tue, Fri"));
        list.add(new DoctorDetails(R.drawable.a0, "Beta", "M.B.B.S", "Orthopedics", "Female", "Sun, Tue, Fri"));
        list.add(new DoctorDetails(R.drawable.a0, "Alpha", "M.B.B.S", "Orthopedics", "Male", "Sun, Tue, Fri"));
        list.add(new DoctorDetails(R.drawable.a0, "Beta", "M.B.B.S", "Orthopedics", "Female", "Sun, Tue, Fri"));
        list.add(new DoctorDetails(R.drawable.a0, "Alpha", "M.B.B.S", "Orthopedics", "Male", "Sun, Tue, Fri"));
        list.add(new DoctorDetails(R.drawable.a0, "Beta", "M.B.B.S", "Orthopedics", "Female", "Sun, Tue, Fri"));
        list.add(new DoctorDetails(R.drawable.a0, "Alpha", "M.B.B.S", "Orthopedics", "Male", "Sun, Tue, Fri"));
        list.add(new DoctorDetails(R.drawable.a0, "Beta", "M.B.B.S", "Orthopedics", "Female", "Sun, Tue, Fri"));
        list.add(new DoctorDetails(R.drawable.a0, "Alpha", "M.B.B.S", "Orthopedics", "Male", "Sun, Tue, Fri"));
        list.add(new DoctorDetails(R.drawable.a0, "Beta", "M.B.B.S", "Orthopedics", "Female", "Sun, Tue, Fri"));
        list.add(new DoctorDetails(R.drawable.a0, "Alpha", "M.B.B.S", "Orthopedics", "Male", "Sun, Tue, Fri"));
        list.add(new DoctorDetails(R.drawable.a0, "Beta", "M.B.B.S", "Orthopedics", "Female", "Sun, Tue, Fri"));
        list.add(new DoctorDetails(R.drawable.a0, "Alpha", "M.B.B.S", "Orthopedics", "Male", "Sun, Tue, Fri"));
        list.add(new DoctorDetails(R.drawable.a0, "Beta", "M.B.B.S", "Orthopedics", "Female", "Sun, Tue, Fri"));



        DoctorAdapter adapter = new DoctorAdapter(list, "Apollo Hospital");
        binding.recyclerview.setAdapter(adapter );
        adapter.notifyDataSetChanged();

    }

}