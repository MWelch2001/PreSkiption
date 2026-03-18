package com.example.myapplication.ui.staff.staff_queue;

import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class StaffQueueViewModel extends ViewModel {
    ArrayList<String> patients = new ArrayList<>();

    public StaffQueueViewModel() {
        PopulatePatients();
    }

    public void PopulateView(FragmentActivity activity, ListView patientListView){
        ArrayAdapter<String> adapter = new ArrayAdapter<>(activity, android.R.layout.simple_list_item_1, patients);
        patientListView.setAdapter(adapter);
    }

    public void FilterListView(FragmentActivity activity, ListView patientListView, String query) {
        ArrayList<String> filteredList = new ArrayList<>();
        if (query.isEmpty()) {
            filteredList.addAll(patients);
        }
        for (String patient : patients) {
            if (patient.toLowerCase().contains(query.toLowerCase())) {
                filteredList.add(patient);
            }
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(activity, android.R.layout.simple_list_item_1, filteredList);
        patientListView.setAdapter(adapter);
    }

    private void PopulatePatients() {
        patients.add("Patient 1");
        patients.add("Patient 2");
        patients.add("Patient 3");
        patients.add("Patient 4");
        patients.add("Patient 5");
        patients.add("Patient 6");
        patients.add("Patient 7");
        patients.add("Patient 8");
        patients.add("Patient 9");
        patients.add("Patient 10");
        patients.add("Patient 11");
        patients.add("Patient 12");

    }
}