package com.example.Toy;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MoreInfoActivity extends AppCompatActivity implements View.OnClickListener{

    final private int REQUEST_INTERNET = 123;

    EditText myText;
    Button search;
    TextView text;

    BottomNavigationView navView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moreinfo);

        navView = (BottomNavigationView) findViewById(R.id.moreinfoNavView);
        navView.setSelectedItemId(R.id.navMoreInfo);
        navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navHome:
                        startActivity(new Intent(MoreInfoActivity.this, MainActivity.class));
                        break;
                    case R.id.navCart:
                        startActivity(new Intent(MoreInfoActivity.this, CartActivity.class));
                        break;
                    case R.id.navProduct:
                        startActivity(new Intent(MoreInfoActivity.this, ToyReview.class));
                        break;
                }
                return true;
            }
        });
    }

    @Override
    public void onClick(View v) {
        startActivity(new Intent(MoreInfoActivity.this, ViewWebview.class));
    }
}
