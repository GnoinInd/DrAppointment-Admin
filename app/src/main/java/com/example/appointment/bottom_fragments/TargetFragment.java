package com.example.appointment.bottom_fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.appointment.R;
import com.example.appointment.databinding.FragmentTargetBinding;

public class TargetFragment extends Fragment {

    public TargetFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    FragmentTargetBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentTargetBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }
}