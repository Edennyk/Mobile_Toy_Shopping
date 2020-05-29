package com.example.Toy;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

/*import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;*/

public class ConfirmActivity extends AppCompatActivity {
    BottomNavigationView navView;
    Button confirm;
    TextView subtotal, tax, total;
    EditText name, address,postalCode,phone;
    double amount = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);

        name = findViewById(R.id.etShipName);
        address= findViewById(R.id.etShipAddress);
        postalCode = findViewById(R.id.etShipPostCode);
        phone = findViewById(R.id.etShipPhone);

        //set up BottomNavigationView
        navView = findViewById(R.id.summaryNavView);
        navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navHome:
                        startActivity(new Intent(ConfirmActivity.this, MainActivity.class));
                        break;
                    case R.id.navProduct:
                        startActivity(new Intent(ConfirmActivity.this, ToyReview.class));
                        break;
                    case R.id.navCart:
                        startActivity(new Intent(ConfirmActivity.this, CartActivity.class));
                        break;
                    case R.id.navMoreInfo:
                        startActivity(new Intent(ConfirmActivity.this, MoreInfoActivity.class));
                        break;
                }
                return true;
            }
        });

        try {
            subtotal = findViewById(R.id.tvOrderSubtotal);
            tax = findViewById(R.id.tvOrderTax);
            total = findViewById(R.id.tvOrderTotal);
            for (Toys b : CartActivity.cartList) {
                String s = b.getPrice().substring(8);//get toy price
                amount += Double.parseDouble(s); //parse price from string to double and add the price to total amount
            }
            //calculate order price from static CartActivity.cartList
            subtotal.setText(String.format("$%.2f", amount));
            tax.setText(String.format("$%.2f", amount * 0.13));
            total.setText(String.format("$%.2f", amount * 1.13));
        }
        catch (Exception e){
            e.printStackTrace();
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        confirm = findViewById(R.id.btnComfirm);
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            if(v.getId() == R.id.btnComfirm){
                if(name.getText().toString().matches("")  || address.getText().toString().matches("")|| postalCode.getText().toString().matches("") || phone.getText().toString().matches("")) {
                    Toast.makeText(ConfirmActivity.this, "Please fill out all the fields above.", Toast.LENGTH_SHORT).show();
                }
                    else{
                        SharedPreferences sharedPreferences = ConfirmActivity.this.getSharedPreferences("myPref", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("name",name.getText().toString());
                        editor.putString("total", total.getText().toString());
                        editor.putString("phone",phone.getText().toString());
                        editor.commit();
                        startActivity(new Intent(ConfirmActivity.this, SummaryActivity.class));
                    }
                }
            }
        });
    }
}
