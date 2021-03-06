package com.example.callfromafgan;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Call;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import com.twilio.type.Twiml;

import java.util.Locale;

public class MessageFragment extends Fragment {

//    String personName2 = FamilyInfo2.NAME2.toString();
//    String personName3 = FamilyInfo3.NAME3.toString();
//    String personName1 = "Michael";
//    String personArea1 = "1";
//    String personPhone1 = "9095519764";

    String personName1 = FamilyInfo1.getName1;
    String personArea1 = FamilyInfo1.getArea1;
    String personPhone1 = FamilyInfo1.getPhone1;
    String personName2 = FamilyInfo2.getName2;
    String personArea2 = FamilyInfo2.getArea2;
    String personPhone2 = FamilyInfo2.getPhone2;
    String personName3 = FamilyInfo3.getName3;
    String personArea3 = FamilyInfo3.getArea3;
    String personPhone3 = FamilyInfo3.getPhone3;
    String selectedItem;
    EditText messageContent;

//    public static final String accountID = "AC4e6ac5bdb2387a46a519eae970555280";
//    public static final String token = "268de49f1bd275e76a42900cd4237e04";
//    public static final String caller = "+15105887376";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_sms, container, false);
        String[] arraySpinner = new String[] {
                personName1,personName2,personName3
        };
        Spinner s = (Spinner)v.findViewById(R.id.spinnerMessageTo);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item, arraySpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(adapter);
        Button sendMessage = (Button) v.findViewById(R.id.messageSendButton);

        messageContent = v.findViewById(R.id.editTextMessage);

        s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedItem = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                selectedItem = adapterView.getItemAtPosition(0).toString();

            }
        });

        sendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                    boolean good = SMS.sendMessage("+19095519764", "hello", true);
//                    if(!good) {
//                        Toast.makeText(getActivity(),"ERROR! ", Toast.LENGTH_LONG).show();
//                    } else {
//                        Toast.makeText(getActivity(),"SUCCESS! ", Toast.LENGTH_LONG).show();
//                    }
//                } else if (selectedItem.equals(personName2)) {
//                    //sendMessage("+" + personArea2 + personPhone2, messageContent.getText().toString(), true);
//                } else if (selectedItem.equals(personName3)) {
//                    //sendMessage("+" + personArea3 + personPhone3, messageContent.getText().toString(), true);
//                }
                Toast.makeText(getActivity(),"Message Sent "+ selectedItem, Toast.LENGTH_LONG).show();
            }
        });
        return v;
    }


//        public boolean sendMessage(String recipient, String messageContent, boolean isText) {
//            try {
//                Twilio.init(accountID, token);
//                PhoneNumber r = new PhoneNumber(recipient);
//                PhoneNumber c = new PhoneNumber(caller);
//                if (isText) {
//                    Message.creator(r, c, messageContent).create();
//                } else {
//                    Twiml twi = new Twiml("<Response><Say>" + messageContent + "</Say></Response>");
//                    Call.creator(r, c, twi).create();
//                }
//                return true;
//            } catch (Exception e) {
//                return false;
//            }
//        }

}