package com.zubaer.nubcc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.zubaer.nubcc.Fragment.BlueFragment;
import com.zubaer.nubcc.Fragment.GreenFragment;
import com.zubaer.nubcc.Fragment.RedFragment;

public class ChatActivity extends AppCompatActivity {
    private TabLayout tab;
    private ViewPager2 viewPager;
    private ViewPagerAdapter viewPagerAdapter;

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


        tab.getTabAt(0).setIcon(R.drawable.ic_launcher_background);
        tab.getTabAt(1).setIcon(R.drawable.ic_mobile_phone);
        tab.getTabAt(2).setIcon(R.drawable.ic_stadium);

        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                tab.selectTab(tab.getTabAt(position));
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });


    }
}