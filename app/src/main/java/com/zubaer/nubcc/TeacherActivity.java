package com.zubaer.nubcc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class TeacherActivity extends AppCompatActivity {

    private RecyclerView rec_teacher;
    private TeacherRecyclerAdapter teacherRecyclerAdapter;
    private LinearLayoutManager linearLayoutManager;
    private ArrayList<Teacher> teacherArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher);
        rec_teacher = findViewById(R.id.rec_teacher);
        teacherArrayList = new ArrayList<>();
        teacherRecyclerAdapter = new TeacherRecyclerAdapter(teacherArrayList, TeacherActivity.this);
        linearLayoutManager = new LinearLayoutManager(TeacherActivity.this);

        rec_teacher.setLayoutManager(linearLayoutManager);
        rec_teacher.setAdapter(teacherRecyclerAdapter);
        loadData();
    }

    private void loadData(){
        for (int i=0; i<100; i++)
            teacherArrayList.add(new Teacher("https://c8.alamy.com/comp/R75XPE/beautiful-teacher-standing-in-classroom-and-holding-glasses-R75XPE.jpg","Marry","Math Teacher","+8801987654321"));
        teacherRecyclerAdapter.notifyDataSetChanged();
    }
}