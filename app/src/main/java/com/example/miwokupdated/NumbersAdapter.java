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
// YEH BASICALLY ARRAYADAPTER JO KI DEFAULT CLASS HAI USSSI KO EXTEND KR RHI HAI TAKI KUCH METHOD KO OVERRIDE KR SKE
public class NumbersAdapter extends ArrayAdapter <NumbersConstructor> {

    private static final String LOG_TAG = NumbersAdapter.class.getSimpleName();
//YEH CONSTRUCTOR HAI ISS CLASS KA JO HMNE NUMBERS ACTIVITY MAI BEJA THA VO.
    public NumbersAdapter(Activity context, ArrayList<NumbersConstructor> numbersConstructors) {

        //0> KI FIRST ARRAY LIST KAITEM AA JAYE
        super(context, 0, numbersConstructors);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
/*
AB ISME KEVAL VIEWS HAI VO TEXT IMAGE MAI NEEDS K ACCORDING CONVERT HOO RHE HAI

 */
    {
        //FIRST ARRAY LIST K ITEM KO POINT OUT KR RHI HAI

        NumbersConstructor currentword = getItem(position);
        View defaultNumbersView = convertView;//TO BASICALLY CONVERT TO OTHERS VIEWS
        if(defaultNumbersView == null) {
            /*
            AB ISKE ANDER MERA LAYOUT HAI JISME MAI BASICALLY EK ROW KO DIKHA RHA HUN KI
            LIST DEK LE SAARE AISE HI PRINT KRNE HAI.

             */
            defaultNumbersView = LayoutInflater.from(getContext()).inflate(R.layout.numbersdesign, parent, false);
        }

        //NOW I'M CONVERTING MY VIEWS AND TAKINN VALUES FROM THE CONSTRUCTORS CLASS
        TextView namemiwok = (TextView) defaultNumbersView.findViewById(R.id.NumbersMiwok);
        namemiwok.setText(currentword.getMiwokNumbers());

        TextView nameenglish = (TextView) defaultNumbersView.findViewById(R.id.NumbersEnglish);
        nameenglish.setText(currentword.getDefaultNumbers());

        ImageView iconView = (ImageView) defaultNumbersView.findViewById(R.id.NumbersImage);
        iconView.setImageResource(currentword.getImageidNumber());

//AB MAI ISKO LOIST KO RETURN RH RHA HUN KYUKI MNE AB ISKO SAB SAMJA DIA HAI KI KAISE PRINT KRNI HAI CHEEZE
        return defaultNumbersView;

    }
}
