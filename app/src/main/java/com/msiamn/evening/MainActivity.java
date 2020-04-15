package com.msiamn.evening;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button showListButton;
    Button openTasbih;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showListButton = findViewById(R.id.list_show_button);

        showListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SuraList.class);
                startActivity(intent);
            }
        });

        openTasbih = findViewById(R.id.tasbih_button);
        openTasbih.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TasbihActivity.class);
                startActivity(intent);
            }
        });
    }
}
