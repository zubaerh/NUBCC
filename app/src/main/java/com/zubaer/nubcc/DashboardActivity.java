package com.zubaer.nubcc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.squareup.picasso.Picasso;

public class DashboardActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private CardView teacher;
    private CardView student;
    private CardView event;
    private CardView alumnus;
    private CardView chat;
    private CardView bloodbank;
    private ImageView image;
    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        teacher = findViewById(R.id.p_teacher);
        student = findViewById(R.id.p_student);
        event = findViewById(R.id.p_event);
        alumnus = findViewById(R.id.p_alumnus);
        chat = findViewById(R.id.p_chat);
        bloodbank = findViewById(R.id.p_bloodbank);
        image = findViewById(R.id.iv_image);
        drawerLayout = findViewById(R.id.drawer_lay);
        toolbar = findViewById(R.id.toolbar);
        navigationView = findViewById(R.id.nav_lay);

        setSupportActionBar(toolbar);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.nav_open,R.string.nav_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();


        teacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this,TeacherActivity.class);
                startActivity(intent);
            }
        });

        student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this,StudentActivity.class);
                startActivity(intent);
            }
        });

        event.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this,EventActivity.class);
                startActivity(intent);
            }
        });

        alumnus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this,AlumnusActivity.class);
                startActivity(intent);
            }
        });

        chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this,ChatActivity.class);
                startActivity(intent);
            }
        });

        bloodbank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this,BloodbankActivity.class);
                startActivity(intent);
            }
        });

        Picasso.get().load("https://theworldofborealis.com/wp-content/uploads/2019/10/land-of-the-northern-lights-960x1149.jpg").into(image);


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_1:
                Toast.makeText(this, "item 1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_2:
                Toast.makeText(this, "item 2", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_3:
                Toast.makeText(this, "item 3", Toast.LENGTH_SHORT).show();
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}