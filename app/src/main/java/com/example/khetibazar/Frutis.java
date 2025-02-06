package com.example.khetibazar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class Frutis extends AppCompatActivity {

    ListView listView;

    int[] logo  = {R.drawable.apple,R.drawable.orange,R.drawable.blueberry,R.drawable.strawbeery};

    String[] name = {"Apple","orange","blue berry pie","strawberry",};

    String[] price = {"RS.200/kg","RS.200/kg","RS.200/kg","RS.200/kg",};

    String[] farmername = {"Raj","Raj","Raj","Raj",};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frutis);

        listView = findViewById(R.id.apple_list);

        FrutisAdapter fruitsCustomeAdapter = new FrutisAdapter(this, logo, name,price,farmername);
        listView.setAdapter(fruitsCustomeAdapter);


    }
}