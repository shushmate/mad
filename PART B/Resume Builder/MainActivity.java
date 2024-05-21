package com.example.resumebuilder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    Button preview;
    EditText name,email,phone,quali;
    RadioButton male,female;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preview=findViewById(R.id.button);

        name=findViewById(R.id.e1);
        email=findViewById(R.id.e2);
        phone=findViewById(R.id.e3);
        quali=findViewById(R.id.e4);

        male=findViewById(R.id.male);
        female=findViewById(R.id.female);

        preview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), PreviewActivity.class);
                i.putExtra("name",name.getText().toString());
                i.putExtra("email",email.getText().toString());
                i.putExtra("phone",phone.getText().toString());
                i.putExtra("quali",quali.getText().toString());
                i.putExtra("gender",(male.isChecked()?"Male":"Female"));
                startActivity(i);
            }
        });

    }
}