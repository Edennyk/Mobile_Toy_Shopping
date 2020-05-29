package com.example.Toy;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SendEmail extends AppCompatActivity {

    public static Context context;
    private EditText sendemailText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_email);

        Button startBtn = (Button) findViewById(R.id.sendEmail);
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendEmail(context);
            }
        });
    }

    protected void sendEmail(Context context) {
        sendemailText = (EditText)findViewById(R.id.sendemailText);
        Log.i("Send email", "");

        Intent email = new Intent(Intent.ACTION_SEND);
        email.setType("plain/Text");
        email.putExtra(Intent.EXTRA_EMAIL, new String[]{sendemailText.getText().toString()});
        email.putExtra(Intent.EXTRA_SUBJECT, "<" + getString(R.string.app_name) + " - " + "Order successfully placed! " + ">");
        email.putExtra(Intent.EXTRA_TEXT, "Thank you for your order! \n \n We are delighted that you have found something you like! ");
        email.setType("message/rfc822");
        startActivity(email);

        try {
            startActivity(Intent.createChooser(email, "Send mail..."));
            finish();
            Log.i("Finished sending email.", "");
        }
        catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(context, "Email sent Error", Toast.LENGTH_SHORT).show();
            Toast.makeText(SendEmail.this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
    }
}
