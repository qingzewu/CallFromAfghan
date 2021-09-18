package com.example.callfromafgan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FamilyInfo2 extends AppCompatActivity {

    String Name2;
    String  Area2;
    String Phone2;
    EditText editTextName2;
    EditText editTextNumber2;
    EditText editTextPhone2;

    public static final String SHARED_PREFS2 = "sharedPrefs";
    public static final String NAME2 = "name";
    public static final String NUMBER2 = "number";
    public static final String PHONE2 = "phone";

    private String getName2;
    private String getArea2;
    private String getPhone2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family_info2);
        editTextName2 =  findViewById(R.id.editTextName2);
        editTextNumber2 = findViewById(R.id.editTextNumber2);
        editTextPhone2 =  findViewById(R.id.editTextPhone2);
        Button done2 = (Button) findViewById(R.id.doneButton2);
        done2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Name2 = editTextName2.getText().toString();
                Area2 = (editTextNumber2.getText().toString());
                Phone2= (editTextPhone2.getText().toString());
                Intent intent = new Intent(FamilyInfo2.this, MainActivity2.class);
                startActivity(intent);
            }
        });
        Button add2 = (Button) findViewById(R.id.addButton2);
        add2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Name2 = editTextName2.getText().toString();
                Area2 = (editTextNumber2.getText().toString());
                Phone2 = (editTextPhone2.getText().toString());
                Intent intent = new Intent(FamilyInfo2.this, FamilyInfo3.class);
                startActivity(intent);
            }
        });
    }
    public void saveData(){
        SharedPreferences sharedPreferences= getSharedPreferences(SHARED_PREFS2,MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(NAME2,Name2);
        editor.putString(NUMBER2, Area2);
        editor.putString(PHONE2, Phone2);
    }

    public void loadData(){
        SharedPreferences sharedPreferences= getSharedPreferences(SHARED_PREFS2,MODE_PRIVATE);
        getName2 = sharedPreferences.getString(NAME2,"");
        getArea2 = sharedPreferences.getString(NUMBER2, "");
        getPhone2= sharedPreferences.getString(PHONE2,"");
    }

    public void updateViews(){
        editTextName2.setText(getName2);
        editTextNumber2.setText(getArea2);
        editTextPhone2.setText(getPhone2);
    }
}