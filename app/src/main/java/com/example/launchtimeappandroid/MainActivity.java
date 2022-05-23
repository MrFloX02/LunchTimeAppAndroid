package com.example.launchtimeappandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText phone;
    private EditText msg;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initActivity();
    }

    private void initActivity(){
        phone = (EditText)findViewById(R.id.txtPhone);
        msg = (EditText)findViewById(R.id.txtMessage);
        btn = (Button)findViewById(R.id.btnEnvoi);
        createOnClickButton();
    }

    private void createOnClickButton(){

        btn.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v){
                SmsManager.getDefault().sendTextMessage(phone.getText().toString(),null,msg.getText().toString(),null,null);

            }
        });


    }

}