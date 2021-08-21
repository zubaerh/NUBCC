package com.zubaer.nubcc.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.zubaer.nubcc.R;


public class BlueFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

         View view =  inflater.inflate(R.layout.fragment_blue, container, false);
         init();
         action();
         return view;
    }

    private void action() {

    }

    private void init() {

    }
}