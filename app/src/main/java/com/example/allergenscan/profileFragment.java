package com.example.allergenscan;

import static android.content.Intent.getIntent;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class profileFragment extends Fragment {
    View view;
    TextView userName;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_profile, container, false);
        Bundle args = getArguments();
        userName = view.findViewById(R.id.profile_username);
        userName.setText("Welcome "+args);
        return view;
    }

}