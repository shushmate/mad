package com.example.calldatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button insert,call;
    EditText usn,name,phno,usncall;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        insert=findViewById(R.id.b1);
        call=findViewById(R.id.b2);

        usn=findViewById(R.id.e1);
        name=findViewById(R.id.e2);
        phno=findViewById(R.id.e3);
        usncall=findViewById(R.id.e4);

        insert.setOnClickListener(this);
        call.setOnClickListener(this);
    }

    @SuppressLint("Range")
    @Override
    public void onClick(View view) {
        String u,n,ph,usntocall;
        u=usn.getText().toString();
        n=name.getText().toString();
        ph=phno.getText().toString();
        usntocall=usncall.getText().toString();

        try{
            db=this.openOrCreateDatabase("calldb",MODE_PRIVATE,null);
            db.execSQL("CREATE TABLE IF NOT EXISTS TEST(usn varchar(20),name varchar(20),phno varchar(20))");

            if(view.getId()==insert.getId()){
                db.execSQL("INSERT INTO TEST VALUES('"+u+"','"+n+"','"+ph+"')");
                Toast.makeText(this,"Successfully inserted",Toast.LENGTH_SHORT).show();
            }

            if(view.getId()==call.getId()){
                Cursor c=db.rawQuery("SELECT * FROM TEST WHERE usn='"+usntocall+"'",null);
                if(c.getCount()!=1){
                    Toast.makeText(this,"Does not exist",Toast.LENGTH_SHORT).show();
                }
                else{
                    c.moveToNext();
                    ph=c.getString(c.getColumnIndex("phno"));
                    Intent i=new Intent(Intent.ACTION_DIAL);
                    i.setData(Uri.parse("tel:"+ph));
                    startActivity(i);
                }
            }

        }catch (SQLException e){
            Toast.makeText(this,"Database Error "+e,Toast.LENGTH_SHORT).show();
        }finally {
            if(db!=null){
                db.close();
            }
        }

    }
}