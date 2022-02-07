package com.example.miwokupdated;


import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ColorsAdapter extends ArrayAdapter <ColorsConstructor> {
    private int mColorResourceId;

    private static final String LOG_TAG = ColorsAdapter.class.getSimpleName();

    public ColorsAdapter(Activity context, ArrayList<ColorsConstructor> ColorsConstructors) {
        //ARRAYADRAAPTER CONSTRUCTOR.
        //0->KYUKI HUMNE APNA LAYOUT BANNA RAKHA HAI WE ARE NOT DEPENT ON ANDROID
        super(context, 0, ColorsConstructors);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    //CONVERT VIEW IS BASICALLY A RECYCLE VIEW
    //LIST ITEM IS ADDED TO PARENT VIEW GROUP
    {
        ColorsConstructor currentcolor = getItem(position);
        //1ST) position ko point kr rha hai
        View defaultColorsView = convertView;
        if (defaultColorsView == null) {
            defaultColorsView = LayoutInflater.from(getContext()).inflate(R.layout.colorsdesign, parent, false);
        }

        TextView namecolormiwok = (TextView) defaultColorsView.findViewById(R.id.miwokcolor);
        namecolormiwok.setText(currentcolor.getMiwokColor());

        TextView namecolorenglish = (TextView) defaultColorsView.findViewById(R.id.englishcolor);
        namecolorenglish.setText(currentcolor.getDefaultColor());

        ImageView coloricon = (ImageView) defaultColorsView.findViewById(R.id.imagecolor);
        coloricon.setImageResource(currentcolor.getColorimage());


        return defaultColorsView;

    }
}
