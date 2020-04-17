package com.example.gatheringonthego;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class AddActivity extends AppCompatActivity {

    private EditText cardNameBox;
    private EditText cardManaBox;
    private EditText cardTextBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        cardNameBox = findViewById(R.id.cardNameBox);
        cardManaBox = findViewById(R.id.cardManaBox);
        cardTextBox = findViewById(R.id.cardTextBox);
    }

    public void addPressed(View v) {
        String name = cardNameBox.getText().toString();
        String cmc = cardManaBox.getText().toString();
        String oracle = cardTextBox.getText().toString();
        DatabaseManager dbm = new DatabaseManager(this);
        dbm.insert(name,cmc,oracle);
        finish();
    }
}