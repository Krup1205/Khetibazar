package com.example.khetibazar;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class GrainsAdapter extends ArrayAdapter<String> {

    int[] logo;
    String[] name;
    Activity context;

    public GrainsAdapter(Activity context1, int[] logo, String[] name) {
        super(context1, R.layout.item_list);
        this.logo = logo;
        this.name = name;
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
        View rowview = inflater.inflate(R.layout.item_list,null,true);


        ImageView circleImageView = rowview.findViewById(R.id.imageView);
        TextView textView =rowview.findViewById(R.id.product_name);


        circleImageView.setImageResource(logo[position]);
        textView.setText(name[position]);

        return rowview;

    }
}
