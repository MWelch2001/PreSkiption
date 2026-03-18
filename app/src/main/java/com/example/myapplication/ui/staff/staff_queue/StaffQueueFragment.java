package com.example.myapplication.ui.staff.staff_queue;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentStaffQueueBinding;
import com.example.myapplication.ui.staff.StaffViewPrescriptionActivity;
import com.example.myapplication.ui.staff.staff_queue.StaffQueueViewModel;


public class StaffQueueFragment extends Fragment {

    private FragmentStaffQueueBinding binding;
    private ListView patientListView;
    private Button tempButton;
    private SearchView searchView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        StaffQueueViewModel staffQueueViewModel =
                new ViewModelProvider(this).get(StaffQueueViewModel.class);

        binding = FragmentStaffQueueBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        patientListView = root.findViewById(R.id.patientListView);
        tempButton = root.findViewById(R.id.tempButton);
        searchView = root.findViewById(R.id.searchView);


        tempButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                staffQueueViewModel.PopulateView(getActivity(), patientListView);
            }
        });

        patientListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(StaffQueueFragment.this.getActivity(), StaffViewPrescriptionActivity.class);
                StaffQueueFragment.this.startActivity(intent);
            }
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextChange(String query) {
                        staffQueueViewModel.FilterListView(getActivity() ,patientListView, query);
                return false;
            }

            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }
        });
        return root;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}