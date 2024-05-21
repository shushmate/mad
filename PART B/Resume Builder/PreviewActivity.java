package com.example.resumebuilder;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class PreviewActivity extends AppCompatActivity {

    TextView name,email,phone,quali,gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        name=findViewById(R.id.t1);
        email=findViewById(R.id.t2);
        phone=findViewById(R.id.t3);
        quali=findViewById(R.id.t4);
        gender=findViewById(R.id.t5);

        Intent i=getIntent();
        name.append("\t"+i.getStringExtra("name"));
        email.append("\t"+i.getStringExtra("email"));
        phone.append("\t"+i.getStringExtra("phone"));
        quali.append("\t"+i.getStringExtra("quali"));
        gender.append("\t"+i.getStringExtra("gender"));
    }
}
