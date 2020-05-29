package com.example.Toy;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class ToyReview extends AppCompatActivity {
    BottomNavigationView navView;
    List<Toys> toysList;
    private ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toy_review);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setTitle("Review Best Selling Toys");

        toysList = new ArrayList<>(); //referencing to arrayList

        list = (ListView) findViewById(R.id.listView);
        toysList.add(new Toys(R.drawable.cottage, "Cape Cottage House", "Little Tikes", "This cottage play house make it the perfect first playhouse! ", "Price: $103.95","Outdoor"));
        toysList.add(new Toys(R.drawable.slide_swing_set, "Slide and Swing Set", "Solowave Design", "Kids are going to have a blast as they learn and play on the two level clubhouse!", "Price: $1622.20","Outdoor"));
        toysList.add(new Toys(R.drawable.harrypotter, "LEGO Harry Potter", "LEGO", "Build and recreate a magical fantasy realm - 4 level ", "Price: $70.20","Outdoor"));
        toysList.add(new Toys(R.drawable.monopoly, "Monopoly", "Hasbro", "In the mood to play the Monopoly game but don't have a lot of time? ", "Price: $15.05","Outdoor"));
        toysList.add(new Toys(R.drawable.thomas, "Thomas&Friends Wood Harvey", "Fisher-Price", "Children create when they discover the world of Thomas & Friends Wood toys?", "Price: $7.59","Outdoor"));
        toysList.add(new Toys(R.drawable.cascading_cove_sand, "Cascading Cove Sand&Water Table", "Step 2", "All-in-one table provides both sand & water fun!", "Price: $107.24","Outdoor"));
        toysList.add(new Toys(R.drawable.batman, "LEGO Super Heroes Batman", "LEGO", "LEGO DC Batman 76137 Batman vs. The Riddler Robbery toy playset.", "Price: $17.24","LEGO"));
        toysList.add(new Toys(R.drawable.starwars, "LEGO Star Wars", "LEGO", "Compact construction playset includes 4 LEGO Star Wars Mandalorian warrior minifigures", "Price: $15.97","LEGO"));
        toysList.add(new Toys(R.drawable.uno, "UNO Flip Game", "Mattel", "Brace yourself for the next iteration of classic UNO: UNO FLIP!", "Price: $7.88","Games"));
        toysList.add(new Toys(R.drawable.crocodile, "Hasbro Gaming Crocodile Dentist", "Hasbro", "CROC CHOMPING FUN: Kids can have loads of fun playing this easy and simple", "Price: $18.67","Games"));
        toysList.add(new Toys(R.drawable.bouncer, "Little Tikes - Shady Jump 'N Slide Bouncer", "MGA", "A backyard inflatable with a shade canopy for bouncy fun in the sun!", "Price: $68.18","Outdoor"));
        toysList.add(new Toys(R.drawable.trampoline, "Little Tikes - Easy Store Trampoline", "MGA", "Little Tikes knows it''s important for kids to stay active! ", "Price: $107.24","Outdoor"));
        toysList.add(new Toys(R.drawable.firetruck, "Marshall'S Firetruck Ride On Vehicle Red", "Toys R Us", "Fire Truck Ride On Vehicle allows kids to enjoying riding around in a fire truck", "Price: $227.24","V"));
        toysList.add(new Toys(R.drawable.henessy_gt, "Hennessy Venom GT", "Toys Toys", "The Hennessy Venom GT comes with working headlights and tail lights", "Price: $52.54","Outdoor"));
        toysList.add(new Toys(R.drawable.jcb7_excavator, "JCB - 7\" Excavator", "HTI Toys", "HTI are proud to present this chunky 7- inch free-wheeling JCB Excavator ", "Price: $5.16","Outdoor"));
        toysList.add(new Toys(R.drawable.rc_helicopter, "RC Aeroquest Helicopter Blue", "Addo Play", "Have fun with RC Heli!", "Price: $407.24","Outdoor"));

        CustomListAdaptor adaptor = new CustomListAdaptor(this, R.layout.my_list_items, toysList);
        list.setAdapter(adaptor);

        navView = findViewById(R.id.toyNavView);

        navView.setSelectedItemId(R.id.navProduct);
        navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navHome:
                        startActivity(new Intent(ToyReview.this, MainActivity.class));
                        break;
                    case R.id.navCart:
                        startActivity(new Intent(ToyReview.this, CartActivity.class));
                        break;
                    case R.id.navMoreInfo:
                        startActivity(new Intent(ToyReview.this, MoreInfoActivity.class));
                        break;
                }
                return true;
            }
        });
    }
    public void onClick(View view)
    {
  // startActivity(new Intent(ToyReview.this, ViewWebview.class));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater iflat = getMenuInflater();
        iflat.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            //All
            case R.id.item0:
                toysList.clear();
                toysList = new ArrayList<>(); //referencing to arrayList

                list = (ListView) findViewById(R.id.listView);
                toysList.add(new Toys(R.drawable.cottage, "Cape Cottage House", "Little Tikes", "This cottage play house make it the perfect first playhouse! ", "Price: $103.95","Outdoor"));
                toysList.add(new Toys(R.drawable.slide_swing_set, "Slide and Swing Set", "Solowave Design", "Kids are going to have a blast as they learn and play on the two level clubhouse!", "Price: $1622.20","Outdoor"));
                toysList.add(new Toys(R.drawable.harrypotter, "LEGO Harry Potter", "LEGO", "Build and recreate a magical fantasy realm - 4 level ", "Price: $70.20","Outdoor"));
                toysList.add(new Toys(R.drawable.monopoly, "Monopoly", "Hasbro", "In the mood to play the Monopoly game but don't have a lot of time? ", "Price: $15.05","Outdoor"));
                toysList.add(new Toys(R.drawable.thomas, "Thomas&Friends Wood Harvey", "Fisher-Price", "Children create when they discover the world of Thomas & Friends Wood toys?", "Price: $7.59","Outdoor"));
                toysList.add(new Toys(R.drawable.cascading_cove_sand, "Cascading Cove Sand & Water Table", "Step 2", "All-in-one table provides both sand & water fun!", "Price: $107.24","Outdoor"));
                toysList.add(new Toys(R.drawable.batman, "LEGO Super Heroes Batman", "LEGO", "LEGO DC Batman 76137 Batman vs. The Riddler Robbery toy playset.", "Price: $17.24","LEGO"));
                toysList.add(new Toys(R.drawable.starwars, "LEGO Star Wars TM Mandalorian Battle Pack", "LEGO", "Compact construction playset includes 4 LEGO Star Wars Mandalorian warrior minifigures", "Price: $15.97","LEGO"));
                toysList.add(new Toys(R.drawable.uno, "UNO Flip Game", "Mattel", "Brace yourself for the next iteration of classic UNO: UNO FLIP!", "Price: $7.88","Games"));
                toysList.add(new Toys(R.drawable.crocodile, "Hasbro Gaming Crocodile Dentist", "Hasbro", "CROC CHOMPING FUN: Kids can have loads of fun playing this easy and simple", "Price: $18.67","Games"));
                toysList.add(new Toys(R.drawable.bouncer, "Little Tikes - Shady Jump 'N Slide Bouncer", "MGA", "A backyard inflatable with a shade canopy for bouncy fun in the sun!", "Price: $68.18","Outdoor"));
                toysList.add(new Toys(R.drawable.trampoline, "Little Tikes - Easy Store Trampoline", "MGA", "Little Tikes knows it''s important for kids to stay active! ", "Price: $107.24","Outdoor"));
                toysList.add(new Toys(R.drawable.firetruck, "Marshall'S Firetruck Ride On Vehicle Red", "Toys R Us", "Fire Truck Ride On Vehicle allows kids to enjoying riding around in a fire truck", "Price: $227.24","V"));
                toysList.add(new Toys(R.drawable.henessy_gt, "Hennessy Venom GT", "Toys Toys", "The Hennessy Venom GT comes with working headlights and tail lights", "Price: $52.54","Outdoor"));
                toysList.add(new Toys(R.drawable.jcb7_excavator, "JCB - 7 Excavator", "HTI Toys", "HTI are proud to present this chunky 7- inch free-wheeling JCB Excavator ", "Price: $5.16","Outdoor"));
                toysList.add(new Toys(R.drawable.rc_helicopter, "RC Aeroques Helicopter Blue", "Addo Play", "Have fun with RC Heli!", "Price: $407.24","Outdoor"));

                CustomListAdaptor adaptor = new CustomListAdaptor(this, R.layout.my_list_items, toysList);
                list.setAdapter(adaptor);

                return true;

            //Games, puzzles
            case R.id.item1:
                Toast.makeText(this, "Games and Puzzles Category", Toast.LENGTH_SHORT).show();
                toysList.clear();
                toysList = new ArrayList<>(); //referencing to arrayList
                toysList.add(new Toys(R.drawable.monopoly, "Monopoly", "Hasbro", "In the mood to play the Monopoly game but don't have a lot of time? ", "Price: $15.05","Outdoor"));
                toysList.add(new Toys(R.drawable.uno, "UNO Flip Game", "Mattel", "Brace yourself for the next iteration of classic UNO: UNO FLIP!", "Price: $7.88","Games"));
                toysList.add(new Toys(R.drawable.crocodile, "Hasbro Gaming Crocodile Dentist", "Hasbro", "CROC CHOMPING FUN: Kids can have loads of fun playing this easy and simple", "Price: $18.67","Games"));

                adaptor = new CustomListAdaptor(this, R.layout.my_list_items, toysList);
                list.setAdapter(adaptor);

                return true;

            //LEGO
            case R.id.item2:
                Toast.makeText(this, "LEGO Category", Toast.LENGTH_SHORT).show();
                toysList.clear();
                toysList = new ArrayList<>(); //referencing to arrayList
                toysList.add(new Toys(R.drawable.harrypotter, "LEGO Harry Potter ", "LEGO", "Build and recreate a magical fantasy realm - 4 level ", "Price: $70.20","Outdoor"));
                toysList.add(new Toys(R.drawable.batman, "LEGO Super Heroes Batman", "LEGO", "LEGO DC Batman 76137 Batman vs. The Riddler Robbery toy playset.", "Price: $17.24","LEGO"));
                toysList.add(new Toys(R.drawable.starwars, "LEGO Star Wars TM Mandalorian Battle Pack", "LEGO", "Compact construction playset includes 4 LEGO Star Wars Mandalorian warrior minifigures", "Price: $15.97","LEGO"));

                adaptor = new CustomListAdaptor(this, R.layout.my_list_items, toysList);
                list.setAdapter(adaptor);
                return true;

            //Outdoors
            case R.id.item3:
                Toast.makeText(this, "Outdoors Category", Toast.LENGTH_SHORT).show();
                toysList.clear();
                toysList = new ArrayList<>(); //referencing to arrayList
                toysList.add(new Toys(R.drawable.cottage, "Cape Cottage House", "Little Tikes", "This cottage play house make it the perfect first playhouse! ", "Price: $103.95","Outdoor"));
                toysList.add(new Toys(R.drawable.slide_swing_set, "Slide and Swing Set", "Solowave Design", "Kids are going to have a blast as they learn and play on the two level clubhouse!", "Price: $1622.20","Outdoor"));
                toysList.add(new Toys(R.drawable.cascading_cove_sand, "Cascading Cove Sand&Water Table", "Step 2", "All-in-one table provides both sand & water fun!", "Price: $107.24","Outdoor"));
                toysList.add(new Toys(R.drawable.bouncer, "Little Tikes - Shady Jump 'N Slide Bouncer", "MGA", "A backyard inflatable with a shade canopy for bouncy fun in the sun!", "Price: $68.18","Outdoor"));
                toysList.add(new Toys(R.drawable.trampoline, "Little Tikes - Easy Store Trampoline", "MGA", "Little Tikes knows it''s important for kids to stay active! ", "Price: $107.24","Outdoor"));

                adaptor = new CustomListAdaptor(this, R.layout.my_list_items, toysList);
                list.setAdapter(adaptor);
                return true;

            //vehicles
            case R.id.item4:
                Toast.makeText(this, "Vehicles Category", Toast.LENGTH_SHORT).show();
                toysList.clear();
                toysList = new ArrayList<>(); //referencing to arrayList
                toysList.add(new Toys(R.drawable.thomas, "Thomas&Friends Wood Harvey", "Fisher-Price", "Children create when they discover the world of Thomas & Friends Wood toys?", "Price: $7.59","Outdoor"));
                toysList.add(new Toys(R.drawable.firetruck, "Marshall'S Firetruck Ride On Vehicle Red", "Toys R Us", "Fire Truck Ride On Vehicle allows kids to enjoying riding around in a fire truck", "Price: $227.24","V"));
                toysList.add(new Toys(R.drawable.henessy_gt, "Hennessy Venom GT", "Toys Toys", "The Hennessy Venom GT comes with working headlights and tail lights", "Price: $52.54","Outdoor"));
                toysList.add(new Toys(R.drawable.jcb7_excavator, "JCB - 7 Excavator", "HTI Toys", "HTI are proud to present this chunky 7- inch free-wheeling JCB Excavator ", "Price: $5.16","Outdoor"));
                toysList.add(new Toys(R.drawable.rc_helicopter, "RC Aeroquest Helicopter Blue", "Addo Play", "Have fun with RC Heli!", "Price: $407.24","Outdoor"));

                adaptor = new CustomListAdaptor(this, R.layout.my_list_items, toysList);
                list.setAdapter(adaptor);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
