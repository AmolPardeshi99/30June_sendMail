package com.example.a30june_sendmail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText metEmail, metCC, metMessage;
    private Button mbtnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        mbtnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String[] str = metCC.getText().toString().split(",");
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT, metMessage.getText().toString());
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{metEmail.getText().toString()});
                intent.putExtra(Intent.EXTRA_CC, str);
                intent.setType("message/rfc822");

                if(intent.resolveActivity(getPackageManager()) != null){
                    startActivity(intent);
                }
            }
        });
    }

    private void initView() {
        metEmail = findViewById(R.id.etEmail);
        metCC = findViewById(R.id.etCC);
        metMessage = findViewById(R.id.etMessage);
        mbtnSend = findViewById(R.id.btnSend);
    }
}