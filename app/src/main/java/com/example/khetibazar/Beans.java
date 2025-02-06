package com.example.khetibazar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class Beans extends AppCompatActivity {

    ListView listView;

    int[] logo  = {R.drawable.mag,R.drawable.chana};

    String[] name = {"moong","brown chana"};

    String[] price = {"RS.200/kg","RS.200/kg","RS.200/kg","RS.200/kg",};

    String[] farmername = {"Raj","Raj","Raj","Raj",};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beans);

        listView = findViewById(R.id.beans_list);

        BeansAdapter fruitsCustomeAdapter = new BeansAdapter(this, logo, name,price,farmername);
        listView.setAdapter(fruitsCustomeAdapter);
    }
}