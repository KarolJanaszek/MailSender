package com.example.mailsender;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText addres = (EditText) findViewById(R.id.address);
        final EditText subject = (EditText) findViewById(R.id.subject);
        final EditText message = (EditText) findViewById(R.id.message);

        Button send = (Button) findViewById(R.id.send);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent sendIntent = new Intent(Intent.ACTION_SEND);
                sendIntent.setType("message/rfc822");
                sendIntent.putExtra(Intent.EXTRA_EMAIL, addres.getText());
                sendIntent.putExtra(Intent.EXTRA_SUBJECT, subject.getText());
                sendIntent.putExtra(Intent.EXTRA_TEXT, message.getText());

                startActivity(Intent.createChooser(sendIntent, "Send mail..."));

            }
        });


    }
}
