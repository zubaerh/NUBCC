package com.zubaer.nubcc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.zubaer.nubcc.Fragment.BlueFragment;
import com.zubaer.nubcc.Fragment.GreenFragment;
import com.zubaer.nubcc.Fragment.RedFragment;

public class ChatActivity extends AppCompatActivity {
    private TabLayout tab;
    private ViewPager2 viewPager;
    private ViewPagerAdapter viewPagerAdapter;

    private int [] icon = {R.drawable.ic_computer,R.drawable.ic_mobile_phone,R.drawable.ic_stadium};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        tab = findViewById(R.id.tab);
        viewPager = findViewById(R.id.Viewpager);

       viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(),getLifecycle());
       viewPagerAdapter.addFragment(new RedFragment(), "Red");
       viewPagerAdapter.addFragment(new GreenFragment(), "Green");
       viewPagerAdapter.addFragment(new BlueFragment(), "Blue");
       viewPager.setAdapter(viewPagerAdapter);



       viewPager.setAdapter(viewPagerAdapter);
        new TabLayoutMediator(tab,viewPager,(tab1, position) -> tab1.setIcon(icon[position])).attach();


    }
}