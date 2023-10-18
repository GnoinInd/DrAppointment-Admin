package com.example.appointment.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appointment.DoctorActivity;
import com.example.appointment.databinding.SingleItemSpecBinding;
import com.example.appointment.model.Specialization;

import java.util.List;

public class HospitalAdapter extends RecyclerView.Adapter<HospitalAdapter.ViewHolder> {

    private final List<Specialization> list;
    private final String spec;

    public HospitalAdapter(List<Specialization> list, String spec) {
        this.list = list;
        this.spec = spec;
    }

    @NonNull
    @Override
    public HospitalAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        SingleItemSpecBinding binding = SingleItemSpecBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull HospitalAdapter.ViewHolder holder, int position) {
        holder.binding.name.setText(list.get(position).getName()); // set hospital name
        if(list.get(position).getImage()>0){
            holder.binding.image.setImageResource(list.get(position).getImage());
        }


        holder.binding.getRoot().setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), DoctorActivity.class);
            intent.putExtra("hospName", list.get(position).getName());
            intent.putExtra("spec", spec);
            v.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        SingleItemSpecBinding binding;
        public ViewHolder(@NonNull SingleItemSpecBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
