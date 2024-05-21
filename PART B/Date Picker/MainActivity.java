package com.example.datepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner s;
    DatePicker dp;
    ArrayAdapter ad;
    String s2[]={"cse","ece","ise","mech"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        s=findViewById(R.id.spinner);
        dp=findViewById(R.id.dp);
        s.setOnItemSelectedListener(this);
        ad=new ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,s2);
        s.setAdapter(ad);

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String item=ad.getItem(i).toString();
        String date=dp.getDayOfMonth()+"-"+(dp.getMonth()+1)+"-"+dp.getYear();
        Toast.makeText(this,"Joined on: "+date+" selected course: "+item,Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}