package com.example.miwokupdated;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Colors extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors);
        Toast.makeText(this, "WELCOME TO COLORS ACTIVITY", Toast.LENGTH_SHORT).show();

        ArrayList<ColorsConstructor> colors=new ArrayList<ColorsConstructor>(0);

        colors.add(new ColorsConstructor("red","weṭeṭṭi",R.drawable.color_red));
        colors.add(new ColorsConstructor("green","chokokki",R.drawable.color_green));
        colors.add(new ColorsConstructor("brown","nicvkdn",R.drawable.color_brown));
        colors.add(new ColorsConstructor("gray","xvdvdvd",R.drawable.color_gray));
        colors.add(new ColorsConstructor("black","efewfewf",R.drawable.color_black));
        colors.add(new ColorsConstructor("white","xtbryb",R.drawable.color_white));
        colors.add(new ColorsConstructor("dusty yellow","sdsf",R.drawable.color_dusty_yellow));
        colors.add(new ColorsConstructor("mustard yellow","wcscdseṭeṭṭi",R.drawable.color_mustard_yellow));


        ColorsAdapter adaptercolor = new ColorsAdapter(this ,colors);

        ListView listView = (ListView) findViewById(R.id.ColorsList);

        listView.setAdapter(adaptercolor);


    }
}