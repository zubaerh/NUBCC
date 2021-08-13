package com.zubaer.nubcc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ImageView logo;
    private EditText name;
    private EditText password;
    private Button login;
    private Button signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logo = findViewById(R.id.iv_logo);
        name = findViewById(R.id.et_name);
        password = findViewById(R.id.et_password);
        login = findViewById(R.id.b_login);
        signup = findViewById(R.id.b_signup);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SingupActivity.class);
                startActivity(intent);
            }
        });



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Toast.makeText(MainActivity.this, "Succesfully login", Toast.LENGTH_SHORT).show();
                if (name.getText().toString().equals(""))
                {
                    name.setError("Name can't be empty");
                }else if (password.getText().toString().equals(""))
                {
                    password.setError("Password can't be empty");
                }else if (password.getText().toString().length()<6)
                {
                    password.setError("Password minimum length is 6");
                }else if (name.getText().toString().equals("Zubaer")&&password.getText().toString().equals("123456"))
                {
                    Toast.makeText(MainActivity.this, "Successfully login", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this,DashboardActivity.class);
                    startActivity(intent);
                }else
                {
                    Toast.makeText(MainActivity.this, "User name or password incorrect", Toast.LENGTH_SHORT).show();
                }

               // Intent intent = new Intent(MainActivity.this,DashboardActivity.class);
               // startActivity(intent);
            }
        });
    }
}