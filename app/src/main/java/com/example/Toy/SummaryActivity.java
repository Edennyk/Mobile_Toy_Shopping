package com.example.Toy;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SummaryActivity extends AppCompatActivity {
    TextView summary;
    SharedPreferences sharedPreferences;
    String name, total,message;
    Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        btnSend= findViewById(R.id.btnSend);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SummaryActivity.this,SendSMS.class));
            }
        });

        summary = findViewById(R.id.tvSummary);
        btnSend = findViewById(R.id.btnSend);
        sharedPreferences = getSharedPreferences("myPref",MODE_PRIVATE);
        name = sharedPreferences.getString("name",null);
        total = sharedPreferences.getString("total",null);
        //payment = sharedPreferences.getString("payMethod",null);

        message = String.format("Hello, %s !", name);
        summary.setText(message);
    }
}
