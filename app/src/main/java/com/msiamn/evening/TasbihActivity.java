package com.msiamn.evening;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TasbihActivity extends AppCompatActivity {

    Button resetButton;
    Button tasbihCounterButton;
    TextView tasbihStatus;
    public int tasbihCount = 0;
    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasbih);
        resetButton =(Button) findViewById(R.id.resetTasbihButton);
        tasbihCounterButton =(Button) findViewById(R.id.tasbih_button);
        tasbihStatus =(TextView) findViewById(R.id.tasbihCounter);
        tasbihStatus.setText(String.valueOf(tasbihCount));

    }
    public void setReset (View view) {
        tasbihCount = 0;
        tasbihStatus.setText("0");
    }
    public void setIncrease (View v) {
        tasbihCount++;
        tasbihStatus.setText(String.valueOf(tasbihCount));
    }

}
