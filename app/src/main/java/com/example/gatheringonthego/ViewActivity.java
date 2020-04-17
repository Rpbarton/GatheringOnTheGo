package com.example.gatheringonthego;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ViewActivity extends AppCompatActivity {

    private TextView cardName;
    private TextView manaCost;
    private TextView oracleText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        cardName = findViewById(R.id.cardName);
        manaCost = findViewById(R.id.manaCost);
        oracleText = findViewById(R.id.oracleText);

        DatabaseManager dbm = new DatabaseManager(this);
        Intent i = getIntent();
        String name = i.getStringExtra("NAME");
        String[] entry = dbm.get(name);
        cardName.setText(entry[0]);
        manaCost.setText(entry[1]);
        oracleText.setText(entry[2]);
    }
}
