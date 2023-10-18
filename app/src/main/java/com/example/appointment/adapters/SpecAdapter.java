package com.example.appointment.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appointment.CategoryActivity;
import com.example.appointment.HospitalActivity;
import com.example.appointment.databinding.SingleItemSpecBinding;
import com.example.appointment.model.Specialization;

import java.util.List;

public class SpecAdapter extends RecyclerView.Adapter<SpecAdapter.ViewHolder> {

    private final List<Specialization> list;
    public SpecAdapter(List<Specialization> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public SpecAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        SingleItemSpecBinding binding = SingleItemSpecBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull SpecAdapter.ViewHolder holder, int position) {
        holder.binding.name.setText(list.get(position).getName()); // set spec name
        holder.binding.image.setImageResource(list.get(position).getImage());

        holder.binding.getRoot().setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), HospitalActivity.class);
            intent.putExtra("specialization", list.get(position).getName());
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
