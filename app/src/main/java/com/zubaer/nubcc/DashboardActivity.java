package com.zubaer.nubcc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class DashboardActivity extends AppCompatActivity {
    private CardView teacher;
    private CardView student;
    private CardView event;
    private CardView alumnus;
    private CardView bloodbank;
    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        teacher = findViewById(R.id.p_teacher);
        student = findViewById(R.id.p_student);
        event = findViewById(R.id.p_event);
        alumnus = findViewById(R.id.p_alumnus);
        bloodbank = findViewById(R.id.p_bloodbank);
        image = findViewById(R.id.iv_image);

        Picasso.get().load("https://theworldofborealis.com/wp-content/uploads/2019/10/land-of-the-northern-lights-960x1149.jpg").into(image);


    }
}