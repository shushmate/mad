package com.example.database;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button insert,display;
    EditText name,age,addr;
    TextView t;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        insert=findViewById(R.id.b1);
        display=findViewById(R.id.b2);

        name=findViewById(R.id.e1);
        age=findViewById(R.id.e2);
        addr=findViewById(R.id.e3);

        t=findViewById(R.id.textView);

        insert.setOnClickListener(this);
        display.setOnClickListener(this);
    }

    @SuppressLint("Range")
    @Override
    public void onClick(View view) {
        String n, a, ad;
        n=name.getText().toString();
        a=age.getText().toString();
        ad=addr.getText().toString();

        try{
            db=this.openOrCreateDatabase("sample",MODE_PRIVATE,null);
            db.execSQL("CREATE TABLE IF NOT EXISTS TEST(name varchar(20),age varchar(3),address varchar(50))");

            if(view.getId()==insert.getId()){
                db.execSQL("INSERT INTO TEST VALUES('"+n+"','"+a+"','"+ad+"')");
                Toast.makeText(this,"Successfully inserted",Toast.LENGTH_SHORT).show();
            }

            if(view.getId()==display.getId()){
                String msg;
                msg="Name\t\t"+"Age\t\t"+"Address\n";
                Cursor c=db.rawQuery("SELECT * FROM TEST",null);

                if(c!=null){
                    if(c.moveToFirst()){
                        do{
                            n=c.getString(c.getColumnIndex("name"));
                            a=c.getString(c.getColumnIndex("age"));
                            ad=c.getString(c.getColumnIndex("address"));
                            msg=msg+n+"\t\t"+a+"\t\t"+ad+"\n";
                        }while(c.moveToNext());
                        t.setText(msg);
                    }
                }
            }


        }catch (SQLException e){
            Toast.makeText(this,"Error "+e,Toast.LENGTH_SHORT).show();
        }
        finally {
            if(db!=null){
                db.close();
            }
        }

    }
}