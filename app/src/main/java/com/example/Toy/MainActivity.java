package com.example.Toy;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView navView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navView = findViewById(R.id.homeNavView);
        navView.setSelectedItemId(R.id.navHome);
        navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navProduct:
                        startActivity(new Intent(MainActivity.this, ToyReview.class));
                        break;
                    case R.id.navCart:
                        startActivity(new Intent(MainActivity.this, CartActivity.class));
                        break;
                    case R.id.navMoreInfo:
                        startActivity(new Intent(MainActivity.this, MoreInfoActivity.class));
                        break;
                }
                return true;
            }
        });
    }
}
