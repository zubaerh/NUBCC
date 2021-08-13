package com.zubaer.nubcc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SingupActivity extends AppCompatActivity {

    private EditText fname;
    private EditText lname;
    private EditText email;
    private EditText mbl;
    private EditText sid;
    private EditText cpw;
    private Button signup_ac;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singup);

        fname = findViewById(R.id.et_fname);
        lname = findViewById(R.id.et_lname);
        email = findViewById(R.id.et_email);
        mbl = findViewById(R.id.et_mbl);
        sid = findViewById(R.id.et_sid);
        cpw = findViewById(R.id.et_cpw);
        signup_ac = findViewById(R.id.b_signup_ac);

        signup_ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SingupActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}