package com.example.callfromafgan;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    String myName;
    String myArea;
    String myPhone;
    EditText editTextMyName;
    EditText editTextMyNumber;
    EditText editTextMyPhone;

    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String MYNAME = "name";
    public static final String MYNUMBER = "number";
    public static final String MYPHONE = "phone";

    private String getMyName;
    private String getMyArea;
    private String getMyPhone;


    @Nullable
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button nextButton = findViewById(R.id.nextButtonMain);
        editTextMyName = findViewById(R.id.editTextMyName);
        editTextMyNumber = findViewById(R.id.editTextMyNumber);
        editTextMyPhone = findViewById(R.id.editTextMyPhone);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myName = editTextMyName.getText().toString();
                myArea = editTextMyNumber.getText().toString();
                myPhone =editTextMyPhone.getText().toString();
                Intent intent = new Intent(MainActivity.this, FamilyInfo1.class);
                startActivity(intent);
            }
        });
    }

    public void saveData(){
        SharedPreferences sharedPreferences= getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(MYNAME,myName);
        editor.putString(MYNUMBER, myArea);
        editor.putString(MYPHONE, myPhone);
    }

    public void loadData(){
        SharedPreferences sharedPreferences= getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
        getMyName = sharedPreferences.getString(MYNAME,"");
        getMyArea = sharedPreferences.getString(MYNUMBER, "");
        getMyPhone= sharedPreferences.getString(MYPHONE,"");
    }

    public void updateViews(){
        editTextMyName.setText(getMyName);
        editTextMyNumber.setText(getMyArea);
        editTextMyPhone.setText(getMyPhone);
    }






}