package com.example.khetibazar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class vegetables_activity extends AppCompatActivity {

    ListView listView;

    int[] logo  = {R.drawable.tomato,R.drawable.potato,R.drawable.lady};

    String[] name = {"tomato","potato","ladyfinger",};

    String[] price = {"RS.200/kg","RS.200/kg","RS.200/kg",};

    String[] farmername = {"Raj","Raj","Raj",};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vegetables);

        listView = findViewById(R.id.vegetables_list);

        vegetableAdapter vegetableAdapter = new vegetableAdapter(this,logo,name,price,farmername);
        listView.setAdapter(vegetableAdapter);
    }
}