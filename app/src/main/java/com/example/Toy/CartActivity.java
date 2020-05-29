package com.example.Toy;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class CartActivity extends AppCompatActivity {
    ListView listView;
    BottomNavigationView navView;
    Button checkout;
    public static List<Toys> cartList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        try {
            listView = (ListView) findViewById(R.id.lvCart);
            CartItemListAdapter adapter = new CartItemListAdapter(this, R.layout.cart_list_items, cartList);
            listView.setAdapter(adapter);

            navView = (BottomNavigationView) findViewById(R.id.cartNavView);
            navView.setSelectedItemId(R.id.navCart);
            navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.navProduct:
                            startActivity(new Intent(CartActivity.this, ToyReview.class));
                            break;
                        case R.id.navHome:
                            startActivity(new Intent(CartActivity.this, MainActivity.class));
                            break;
                        case R.id.navMoreInfo:
                            startActivity(new Intent(CartActivity.this, MoreInfoActivity.class));
                            break;
                    }
                    return true;
                }
            });
        }
        catch (Exception e){
            e.printStackTrace();
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }

        //cartList != null || !cartList.isEmpty()
        checkout = (Button) findViewById(R.id.btnCheckout);
        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getId() == R.id.btnCheckout){
                    if(cartList.size() > 0){
                        startActivity(new Intent(CartActivity.this, ConfirmActivity.class));
                    }else{
                        Toast.makeText(CartActivity.this,"Please select a toy first.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
