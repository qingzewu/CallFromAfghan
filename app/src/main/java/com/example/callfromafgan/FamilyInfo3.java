package com.example.callfromafgan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FamilyInfo3 extends AppCompatActivity {

    String Name3;
    String Area3;
    String Phone3;
    EditText editTextName3;
    EditText editTextNumber3;
    EditText editTextPhone3;

    public static final String SHARED_PREFS3 = "sharedPrefs";
    public static final String NAME3 = "name3";
    public static final String NUMBER3 = "number3";
    public static final String PHONE3 = "phone3";

    static String getName3;
    static String getArea3;
    static String getPhone3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family_info3);
        editTextName3 =  findViewById(R.id.editTextName3);
        editTextNumber3 = findViewById(R.id.editTextNumber3);
        editTextPhone3 =  findViewById(R.id.editTextPhone3);
        Button done = (Button) findViewById(R.id.doneButton3);
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Name3 = editTextName3.getText().toString();
                Area3 = (editTextNumber3.getText().toString());
                Phone3 =(editTextPhone3.getText().toString());
                saveData3();
                Intent intent = new Intent(FamilyInfo3.this, MainActivity2.class);
                startActivity(intent);
            }
        });
        loadData3();
        updateViews3();
    }
    public void saveData3(){
        SharedPreferences sharedPreferences3= getSharedPreferences(SHARED_PREFS3,MODE_PRIVATE);
        SharedPreferences.Editor editor3 = sharedPreferences3.edit();
        editor3.putString(NAME3,Name3);
        editor3.putString(NUMBER3, Area3);
        editor3.putString(PHONE3, Phone3);
        editor3.apply();
    }

    public void loadData3(){
        SharedPreferences sharedPreferences3= getSharedPreferences(SHARED_PREFS3,MODE_PRIVATE);
        getName3 = sharedPreferences3.getString(NAME3,"");
        getArea3 = sharedPreferences3.getString(NUMBER3, "");
        getPhone3= sharedPreferences3.getString(PHONE3,"");
    }

    public void updateViews3(){
        editTextName3.setText(getName3);
        editTextNumber3.setText(getArea3);
        editTextPhone3.setText(getPhone3);
    }
}