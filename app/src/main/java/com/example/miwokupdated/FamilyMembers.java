package com.example.miwokupdated;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class FamilyMembers extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family_members);
        Toast.makeText(this, "WELCOME TO FAMILYMEMBER ACTIVITY", Toast.LENGTH_SHORT).show();
    }
}