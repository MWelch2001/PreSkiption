package com.example.myapplication.ui.staff.staff_dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.databinding.FragmentStaffDashboardBinding;
import com.example.myapplication.ui.staff.staff_dashboard.StaffDashboardViewModel;

public class StaffDashboardFragment extends Fragment {

    private FragmentStaffDashboardBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        StaffDashboardViewModel staffDashboardViewModel =
                new ViewModelProvider(this).get(StaffDashboardViewModel.class);

        binding = FragmentStaffDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}