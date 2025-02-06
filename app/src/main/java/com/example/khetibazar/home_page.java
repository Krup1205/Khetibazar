package com.example.khetibazar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class home_page extends AppCompatActivity {

    ListView listView;
    FloatingActionButton floatingActionButton;
    ImageView imageView;

    int[] logo  = {R.drawable.vegetables,R.drawable.fruits,R.drawable.beans,R.drawable.grains};

    String[] name = {"Vegetables","Fruits","Beans","Grains"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);

        listView = findViewById(R.id.Fruits_list);
        floatingActionButton = findViewById(R.id.floatingbtn);
        imageView = findViewById(R.id.message);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),sell_form.class);
                startActivity(intent);
            }
        });

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Message.class);
                startActivity(intent);
            }
        });
        HomePageAdapter homePageAdapter = new HomePageAdapter(this, logo, name);
        listView.setAdapter(homePageAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i== 0){
                    Intent intent = new Intent(getApplicationContext(),vegetables_activity.class);
                    startActivity(intent);
                } else if (i==1) {
                    Intent intent = new Intent(getApplicationContext(),Frutis.class);
                    startActivity(intent);

                }
                else if(i==2) {
                    Intent intent = new Intent(getApplicationContext(),Beans.class);
                    startActivity(intent);

                }
                else if(i==3) {
                    Intent intent = new Intent(getApplicationContext(),grains.class);
                    startActivity(intent);

                }

            }
        });
    }
}