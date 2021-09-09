package com.zubaer.nubcc;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class TeacherActivity extends AppCompatActivity {

    private RecyclerView rec_teacher;
    private TeacherRecyclerAdapter teacherRecyclerAdapter;
    private LinearLayoutManager linearLayoutManager;
    private ArrayList<Teacher> teacherArrayList;
private DatabaseReference teachers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher);
        rec_teacher = findViewById(R.id.rec_teacher);
        teachers= FirebaseDatabase.getInstance().getReference("nubcc").child("teacher");
        teacherArrayList = new ArrayList<>();
        teacherRecyclerAdapter = new TeacherRecyclerAdapter(teacherArrayList, TeacherActivity.this);
        linearLayoutManager = new LinearLayoutManager(TeacherActivity.this);

        rec_teacher.setLayoutManager(linearLayoutManager);
        rec_teacher.setAdapter(teacherRecyclerAdapter);
        loadData();
    }

    private void loadData(){
        teachers.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                teacherArrayList.clear();
                for(DataSnapshot ds : snapshot.getChildren()){
                    Log.d("test",ds.toString());
                    Teacher teacher = ds.getValue(Teacher.class);
                   teacherArrayList.add(teacher);
                }
                teacherRecyclerAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}