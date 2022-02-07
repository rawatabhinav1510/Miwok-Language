package com.example.miwokupdated;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//SET ON CLICK LISTNER FOR NUMBERS ACTIVITY
        TextView number = (TextView) findViewById(R.id.number);
        number.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent numbersintent =new Intent(MainActivity.this,Numbers.class);
                startActivity(numbersintent);

            }
        });
        //SET ON CLICK LISTNER FOR FAMILY MEMBER ACTIVITY
        TextView familymember = (TextView) findViewById(R.id.familymember);
        familymember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent familymemberintent =new Intent(MainActivity.this,FamilyMembers.class);
                startActivity(familymemberintent);

            }
        });
        //SET ON CLICK LISTNER FOR COLORS ACTIVITY
        TextView colors = (TextView) findViewById(R.id.colors);
        colors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent colorsintent =new Intent(MainActivity.this,Colors.class);
                startActivity(colorsintent);

            }
        });
        //SET ON CLICK LISTNER FOR PHRASES ACTIVITY

        TextView phrases = (TextView) findViewById(R.id.phrases);
        phrases.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent phrasesintent =new Intent(MainActivity.this,Phrases.class);
                startActivity(phrasesintent);

            }
        });



    }
}