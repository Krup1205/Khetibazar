package com.example.khetibazar;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class BeansAdapter extends ArrayAdapter<String> {

    int [] logo;
    String[] name;
    String [] price;
    String [] farmername;
    Activity context;

    public BeansAdapter(Activity context1, int[] logo, String[] name, String[] price, String[] farmername) {
        super(context1,R.layout.categories_item);
        this.logo = logo;
        this.name = name;
        this.price = price;
        this.farmername = farmername;
        this.context = context1;
    }

    @Override
    public int getCount() {
        return name.length;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowview = inflater.inflate(R.layout.categories_item,null,true);


        ImageView circleImageView = rowview.findViewById(R.id.imageView);
        TextView textView =rowview.findViewById(R.id.product_name);
        TextView textView1 =rowview.findViewById(R.id.product_price);
        TextView textView2 =rowview.findViewById(R.id.Farmer_name);

        circleImageView.setImageResource(logo[position]);
        textView.setText(name[position]);
        textView1.setText(price[position]);
        textView2.setText(farmername[position]);

        return rowview;
    }
}
