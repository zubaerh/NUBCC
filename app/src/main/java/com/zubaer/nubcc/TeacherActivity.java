package com.zubaer.nubcc;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
    private Button button;
private DatabaseReference teachers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher);
        button = findViewById(R.id.bt_add);
        rec_teacher = findViewById(R.id.rec_teacher);
        teachers= FirebaseDatabase.getInstance().getReference("nubcc").child("teacher");
        teacherArrayList = new ArrayList<>();
        teacherRecyclerAdapter = new TeacherRecyclerAdapter(teacherArrayList, TeacherActivity.this);
        linearLayoutManager = new LinearLayoutManager(TeacherActivity.this);

        rec_teacher.setLayoutManager(linearLayoutManager);
        rec_teacher.setAdapter(teacherRecyclerAdapter);
        loadData();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(TeacherActivity.this);
                dialog.setContentView(R.layout.dialog_teacher_add);

               Button button_submit = dialog.findViewById(R.id.bt_submit);
               EditText deg =  dialog.findViewById(R.id.et_deg);
               EditText name =  dialog.findViewById(R.id.et_name2);
               EditText image =  dialog.findViewById(R.id.et_image);
               EditText phone =  dialog.findViewById(R.id.et_phone);
               EditText id =  dialog.findViewById(R.id.et_id);

               button_submit.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       Teacher teacher = new Teacher(image.getText().toString(),name.getText().toString(),deg.getText().toString(),Integer.parseInt(phone.getText().toString()));
                       teachers.child(id.getText().toString()).setValue(teacher);
                       dialog.cancel();
                   }
               });

                dialog.show();


            }
        });
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