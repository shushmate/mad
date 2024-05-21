package com.example.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText url;
    Button def,search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        url=findViewById(R.id.text);
        search=findViewById(R.id.b1);
        def=findViewById(R.id.b2);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MainActivity2.class);
                i.putExtra("load",url.getText().toString());
                startActivity(i);
            }
        });

        def.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MainActivity2.class);
                i.putExtra("load","default12");
                startActivity(i);
            }
        });

    }
}