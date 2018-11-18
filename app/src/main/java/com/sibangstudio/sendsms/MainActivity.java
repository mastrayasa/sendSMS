package com.sibangstudio.sendsms;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editPhone, editMessage;
    Button btnSend;
    TextView txtLog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtLog = (TextView) findViewById(R.id.txtLog);
        editPhone = (EditText) findViewById(R.id.editPhone);
        editMessage = (EditText) findViewById(R.id.editMessage);
        btnSend = (Button) findViewById(R.id.btnSend);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendSmsByManager();
            }
        });
    }

    public void sendSmsByManager() {
        try {
            // Mengambil default instance dari SmsManager
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(editPhone.getText().toString(),
                    null,
                    editMessage.getText().toString(),
                    null,
                    null);
            Toast.makeText(getApplicationContext(), "SMS Berhasil Dikirim!",
                    Toast.LENGTH_SHORT).show();

            txtLog.append("- to " + editPhone.getText() + " : " + editMessage.getText() + "\n");
        } catch (Exception ex) {
            Toast.makeText(getApplicationContext(),"Pengiriman SMS Gagal...",
                    Toast.LENGTH_SHORT).show();
            ex.printStackTrace();
        }
    }


}
