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
import android.widget.Toast;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

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
//                Twilio.init("AC4e6ac5bdb2387a46a519eae970555280", "268de49f1bd275e76a42900cd4237e04");
//                PhoneNumber r = new PhoneNumber("+19095519764");
//                PhoneNumber c = new PhoneNumber("+15105887376");
//                String m = "hello";
//                Message.creator(r, c, m).create();
                myName = editTextMyName.getText().toString();
                myArea = editTextMyNumber.getText().toString();
                myPhone =editTextMyPhone.getText().toString();
                saveData0();
                Intent intent = new Intent(MainActivity.this, FamilyInfo1.class);
                startActivity(intent);
            }
        });
        loadData0();
        updateViews0();
//        Toast.makeText(this, "Data updated", Toast.LENGTH_SHORT).show();
    }

    public void saveData0(){
        SharedPreferences sharedPreferences0= getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences0.edit();
        editor.putString(MYNAME,myName);
        editor.putString(MYNUMBER, myArea);
        editor.putString(MYPHONE, myPhone);
        editor.apply();
//        Toast.makeText(this, "Data saved", Toast.LENGTH_SHORT).show();
    }

    public void loadData0(){
        SharedPreferences sharedPreferences0= getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
        getMyName = sharedPreferences0.getString(MYNAME,"");
        getMyArea = sharedPreferences0.getString(MYNUMBER, "");
        getMyPhone= sharedPreferences0.getString(MYPHONE,"");
    }

    public void updateViews0(){
        editTextMyName.setText(getMyName);
        editTextMyNumber.setText(getMyArea);
        editTextMyPhone.setText(getMyPhone);

    }






}