package com.example.callfromafgan;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FamilyInfo1 extends AppCompatActivity {
    static String Name1;
    static String Area1;
    static String Phone1;
    EditText editTextName1;
    EditText editTextNumber1;
    EditText editTextPhone1;

    public static final String SHARED_PREFS1 = "sharedPrefs";
    public static final String NAME1 = "name1";
    public static final String NUMBER1 = "number1";
    public static final String PHONE1 = "phone1";

    static String getName1;
    static String getArea1;
    static String getPhone1;


    @Nullable
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family_info1);
        editTextName1 =  findViewById(R.id.editTextName1);
        editTextNumber1 =  findViewById(R.id.editTextNumber1);
        editTextPhone1 = findViewById(R.id.editTextPhone1);

        Button done1 = (Button) findViewById(R.id.doneButton1);
        done1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Name1 = editTextName1.getText().toString();
                Area1 = editTextNumber1.getText().toString();
                Phone1 = editTextPhone1.getText().toString();
                saveData1();
                Intent intent = new Intent(FamilyInfo1.this, MainActivity2.class);
                startActivity(intent);
            }
        });

        Button add1 = (Button) findViewById(R.id.addButton1);
        add1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Name1 = editTextName1.getText().toString();
                Area1 = editTextNumber1.getText().toString();
                Phone1 = editTextPhone1.getText().toString();
                saveData1();
                Intent intent = new Intent(FamilyInfo1.this, FamilyInfo2.class);
                startActivity(intent);
            }
        });
        loadData1();
        updateViews1();
//        Toast.makeText(this, getName1, Toast.LENGTH_SHORT).show();
    }

    public void saveData1(){
        SharedPreferences sharedPreferences1= getSharedPreferences(SHARED_PREFS1,MODE_PRIVATE);
        SharedPreferences.Editor editor1 = sharedPreferences1.edit();
        editor1.putString(NAME1, Name1);
        editor1.putString(NUMBER1, Area1);
        editor1.putString(PHONE1, Phone1);
        editor1.apply();
//        Toast.makeText(this, NAME1, Toast.LENGTH_SHORT).show();
    }

    public void loadData1(){
        SharedPreferences sharedPreferences1 = getSharedPreferences(SHARED_PREFS1,MODE_PRIVATE);
        getName1 = sharedPreferences1.getString(NAME1,"");
        getArea1 = sharedPreferences1.getString(NUMBER1, "");
        getPhone1= sharedPreferences1.getString(PHONE1,"");
    }

    public void updateViews1(){
        editTextName1.setText(getName1);
        editTextNumber1.setText(getArea1);
        editTextPhone1.setText(getPhone1);
        // Toast.makeText(this, "Data updated", Toast.LENGTH_SHORT).show();
    }
}