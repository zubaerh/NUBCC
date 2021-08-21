package com.zubaer.nubcc.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zubaer.nubcc.R;


public class RedFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

         View view =  inflater.inflate(R.layout.fragment_red, container, false);
         init();
         action();
         return view;
    }

    private void action() {

    }

    private void init() {

    }
}