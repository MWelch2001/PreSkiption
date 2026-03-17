package com.example.myapplication.ui.staff.staff_queue;

import static androidx.databinding.DataBindingUtil.setContentView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentStaffQueueBinding;
import com.example.myapplication.ui.staff.StaffViewPrescriptionActivity;
import com.example.myapplication.ui.staff.staff_queue.StaffQueueViewModel;

import java.util.ArrayList;

public class StaffQueueFragment extends Fragment {

    private FragmentStaffQueueBinding binding;
    ArrayList<String> patientNames = new ArrayList<>();
    private ListView patientListView;
    private Button tempButton;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        StaffQueueViewModel staffQueueViewModel =
                new ViewModelProvider(this).get(StaffQueueViewModel.class);

        binding = FragmentStaffQueueBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        populateListView();

        patientListView = root.findViewById(R.id.patientListView);
        tempButton = root.findViewById(R.id.tempButton);

        tempButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, patientNames);
                patientListView.setAdapter(adapter);
            }
        });

        patientListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(StaffQueueFragment.this.getActivity(), StaffViewPrescriptionActivity.class);
                StaffQueueFragment.this.startActivity(intent);
            }
        });
        return root;
    }

    private void populateListView() {

        patientNames.add("Patient 1");
        patientNames.add("Patient 2");
        patientNames.add("Patient 3");
        patientNames.add("Patient 4");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}