package com.example.gatheringonthego;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addPressed(View v){
        Intent i = new Intent (this, AddActivity.class);
        startActivity(i);
    }

    public void viewPressed(View v){
        Intent i = new Intent (this, TitleViewActivity.class);
        startActivity(i);
    }
}
