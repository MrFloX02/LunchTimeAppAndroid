package com.example.launchtimeappandroid;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.telephony.SmsManager;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btn;
    private final String number1 = "0652270680";
    private final String number2 = "0669034978";
    private final String message = "A table !";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initActivity();
    }

    /**
     * Initialise les elements UI au code
     */
    private void initActivity(){

        btn = (Button)findViewById(R.id.btnEnvoi);
        createOnClickButton();
    }

    /**
     * Au click du bouton -> envoi du message
     */
    private void createOnClickButton(){

        btn.setOnClickListener(v -> {

            try {
                SmsManager.getDefault().sendTextMessage(number1,null,message,null,null);
                SmsManager.getDefault().sendTextMessage(number2,null,message,null,null);
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("Messages envoyés");
                builder.create();
                builder.show();

            }catch (Exception ex){
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("Erreur");
                builder.create();
                builder.show();
            }
        });
    }

}