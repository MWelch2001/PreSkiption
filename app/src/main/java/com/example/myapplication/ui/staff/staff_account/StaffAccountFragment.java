package com.example.myapplication.ui.staff.staff_account;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.databinding.FragmentStaffAccountBinding;

public class StaffAccountFragment extends Fragment {

    private FragmentStaffAccountBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        StaffAccountViewModel staffAccountViewModel =
                new ViewModelProvider(this).get(StaffAccountViewModel.class);

        binding = FragmentStaffAccountBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}