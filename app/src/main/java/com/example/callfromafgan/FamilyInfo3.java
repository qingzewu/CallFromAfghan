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
    public static final String NAME3 = "name";
    public static final String NUMBER3 = "number";
    public static final String PHONE3 = "phone";

    private String getName3;
    private String getArea3;
    private String getPhone3;

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
                Intent intent = new Intent(FamilyInfo3.this, MainActivity2.class);
                startActivity(intent);
            }
        });
    }
    public void saveData(){
        SharedPreferences sharedPreferences= getSharedPreferences(SHARED_PREFS3,MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(NAME3,Name3);
        editor.putString(NUMBER3, Area3);
        editor.putString(PHONE3, Phone3);
    }

    public void loadData(){
        SharedPreferences sharedPreferences= getSharedPreferences(SHARED_PREFS3,MODE_PRIVATE);
        getName3 = sharedPreferences.getString(NAME3,"");
        getArea3 = sharedPreferences.getString(NUMBER3, "");
        getPhone3= sharedPreferences.getString(PHONE3,"");
    }

    public void updateViews(){
        editTextName3.setText(getName3);
        editTextNumber3.setText(getArea3);
        editTextPhone3.setText(getPhone3);
    }
}