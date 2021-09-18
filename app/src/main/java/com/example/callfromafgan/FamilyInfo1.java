package com.example.callfromafgan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;



public class FamilyInfo1 extends AppCompatActivity {

    String Name1;
    String Area1;
    String Phone1;
    EditText editTextName1;
    EditText editTextNumber1;
    EditText editTextPhone1;

    public static final String SHARED_PREFS1 = "sharedPrefs";
    public static final String NAME1 = "name";
    public static final String NUMBER1 = "number";
    public static final String PHONE1 = "phone";

    private String getName1;
    private String getArea1;
    private String getPhone1;


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
                Phone1=editTextPhone1.getText().toString();
                Intent intent = new Intent(FamilyInfo1.this, FamilyInfo2.class);
                startActivity(intent);
            }
        });
    }

    public void saveData(){
        SharedPreferences sharedPreferences= getSharedPreferences(SHARED_PREFS1,MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(NAME1,Name1);
        editor.putString(NUMBER1, Area1);
        editor.putString(PHONE1, Phone1);
    }

    public void loadData(){
        SharedPreferences sharedPreferences= getSharedPreferences(SHARED_PREFS1,MODE_PRIVATE);
        getName1 = sharedPreferences.getString(NAME1,"");
        getArea1 = sharedPreferences.getString(NUMBER1, "");
        getPhone1= sharedPreferences.getString(PHONE1,"");
    }

    public void updateViews(){
        editTextName1.setText(getName1);
        editTextNumber1.setText(getArea1);
        editTextPhone1.setText(getPhone1);
    }
}