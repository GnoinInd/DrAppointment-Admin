package com.example.appointment.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appointment.CategoryActivity;
import com.example.appointment.DoctorShowMoreActivity;
import com.example.appointment.SignInActivity;
import com.example.appointment.databinding.SingleRowDoctorDetailBinding;
import com.example.appointment.model.DoctorDetails;

import java.util.List;

public class DoctorAdapter extends RecyclerView.Adapter<DoctorAdapter.ViewHolder> {

    private final List<DoctorDetails> list;
    private final String hospName;

    public DoctorAdapter(List<DoctorDetails> list, String hospName) {
        this.list = list;
        this.hospName = hospName;
    }

    @NonNull
    @Override
    public DoctorAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        SingleRowDoctorDetailBinding binding = SingleRowDoctorDetailBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull DoctorAdapter.ViewHolder holder, int position) {
        holder.binding.doctorName.setText(list.get(position).getDoctor_name());
        holder.binding.doctorName.setSelected(true);
        holder.binding.image.setImageResource(list.get(position).getImage());
        holder.binding.dayAvailability.setText(list.get(position).getDoctor_availability());
        holder.binding.degree.setText(list.get(position).getDoctor_degree());
      //  holder.binding.gender.setText(list.get(position).getGender());
        holder.binding.spec.setText(list.get(position).getDoctor_specialization());


        holder.binding.bookAppointment.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), DoctorShowMoreActivity.class);
            intent.putExtra("hospName", hospName);
            v.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        SingleRowDoctorDetailBinding binding;

        public ViewHolder(@NonNull SingleRowDoctorDetailBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}

