package com.example.appointment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.appointment.adapters.SpecAdapter;
import com.example.appointment.databinding.ActivityMainBinding;
import com.example.appointment.model.Specialization;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        /*binding.getRoot().setOnClickListener(v -> {
            if(getCurrentFocus() != null){
                binding.searchView.clearFocus();
            }
        });*/


        List<Specialization> list = new ArrayList<>();
        list.add(new Specialization(R.drawable.spec, "Orthopedics"));
        list.add(new Specialization(R.drawable.spec, "Pediatrics"));
        list.add(new Specialization(R.drawable.spec, "Pathology"));
        list.add(new Specialization(R.drawable.spec, "Neurology"));
        list.add(new Specialization(R.drawable.spec, "Obstetrics"));
        list.add(new Specialization(R.drawable.spec, "gynaecology"));
        list.add(new Specialization(R.drawable.spec, "Dermatology"));
        list.add(new Specialization(R.drawable.spec, "Ophthalmology"));
        list.add(new Specialization(R.drawable.spec, "Otorhinolaryngology"));
        list.add(new Specialization(R.drawable.spec, "Anesthesiology"));
        list.add(new Specialization(R.drawable.spec, "Psychiatry"));
        list.add(new Specialization(R.drawable.spec, "Radiology"));
        list.add(new Specialization(R.drawable.spec, "Gastroenterology"));
        list.add(new Specialization(R.drawable.spec, "Cardiology"));
        list.add(new Specialization(R.drawable.spec, "Internal Medicine"));
        list.add(new Specialization(R.drawable.spec, "ENT"));
        list.add(new Specialization(R.drawable.spec, "Oncology"));


        initRecyclerView(list);

        binding.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                binding.searchView.clearFocus();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                List<Specialization> newList = new ArrayList<>();
                for(int i = 0;i<list.size();i++){
                    if(list.get(i).getName().toLowerCase().contains(newText.toLowerCase())){
                        newList.add(list.get(i));
                    }
                }
                initRecyclerView(newList);

                if(newList.size() == 0 ){
                    binding.NoText.setVisibility(View.VISIBLE);
                }else binding.NoText.setVisibility(View.GONE);
                return true;
            }
        });






    }
    private void initRecyclerView(List<Specialization> list){
        SpecAdapter adapter = new SpecAdapter(list);
        binding.recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        binding.recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }


    @Override
    public void onBackPressed() {
        if(FirebaseAuth.getInstance().getCurrentUser() != null){
            finishAffinity();
        }
        super.onBackPressed();

    }
}