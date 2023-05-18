package com.sheetal.amigo_thestudybuddy;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Select_Branch extends Fragment implements AdapterView.OnItemSelectedListener {

    private Spinner branchSpinner;
    private Spinner semesterSpinner;
    private Spinner subjectSpinner;
    private Button submitButton;
    private String selectedBranch;

    private String selectedSemester;
    private String selectedSubject;


    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_select__branch, container, false);

        branchSpinner = view.findViewById(R.id.spinner_branch);
        semesterSpinner = view.findViewById(R.id.spinner_semester);
        subjectSpinner = view.findViewById(R.id.spinner_subject);
        submitButton = view.findViewById(R.id.submit_btn);

        // Set up branch spinner
        ArrayAdapter<CharSequence> branchAdapter = ArrayAdapter.createFromResource(requireContext().getApplicationContext(),
                R.array.Branches, android.R.layout.simple_spinner_item);
        branchAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        branchSpinner.setAdapter(branchAdapter);
        branchSpinner.setOnItemSelectedListener(this);


        // Set up semester spinner
        ArrayAdapter<CharSequence> semesterAdapter = ArrayAdapter.createFromResource(requireContext().getApplicationContext(),
                R.array.Semesters, android.R.layout.simple_spinner_item);
        semesterAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        semesterSpinner.setAdapter(semesterAdapter);
        semesterSpinner.setOnItemSelectedListener(this);

        // Set up submit button
        submitButton.setOnClickListener(v -> {

            if (selectedBranch != null && selectedSubject != null && selectedSemester != null) {

                if(selectedBranch.equals("Computer Engineering")&& selectedSemester.equals("Semester 6") && selectedSubject.equals("WP")){
                    Intent intent = new Intent(requireContext(), ContentActivity.class);
                    startActivity(intent);
                }

            } else {
                Toast.makeText(requireContext(), "Please select all options", Toast.LENGTH_SHORT).show();
            }
        });


        return view;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        int spinnerId = parent.getId();
        selectedSubject=parent.getItemAtPosition(position).toString();
        if (spinnerId == R.id.spinner_branch) {
            selectedBranch = parent.getItemAtPosition(position).toString();
        } else if (spinnerId == R.id.spinner_semester) {
            selectedSemester = parent.getItemAtPosition(position).toString();
            updateSubjectSpinner();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        //do nothing
    }


    private void updateSubjectSpinner() {
        if (selectedSemester != null) {

            // Get subjects based on selected semester
            List<String> subjects = new ArrayList<>();
            switch (selectedSemester) {
                case "Semester 6":
                    subjects.add("WP");
                    subjects.add("IOT");
                    subjects.add("TOC");
                    subjects.add("SS");
                    break;
                case "Semester 5":
                    subjects.add("ADA");
                    subjects.add("TOC");
                    subjects.add("SE");
                    break;

                default:
                    break;
            }
            // Set up subject spinner with the updated subjects list
            ArrayAdapter<String> subjectAdapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_spinner_item, subjects);
            subjectAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            subjectSpinner.setAdapter(subjectAdapter);
            subjectSpinner.setOnItemSelectedListener(this);



        }
    }
}