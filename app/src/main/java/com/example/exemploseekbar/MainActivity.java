package com.example.exemploseekbar;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private SeekBar seekBar;
    private TextView textViewValor;
    private View bgView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        seekBar = findViewById(R.id.seekBarVolume);
        textViewValor = findViewById(R.id.textSeekBar);
        bgView = findViewById(R.id.main);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textViewValor.setText("Volume: " + progress);
                if (progress > 70) {
                    bgView.setBackgroundColor(Color.GREEN);
                    textViewValor.setTextColor(Color.BLACK);
                } else if (progress < 30){
                    bgView.setBackgroundColor(Color.RED);
                    textViewValor.setTextColor(Color.WHITE);
                } else {
                    bgView.setBackgroundColor(Color.YELLOW);
                    textViewValor.setTextColor(Color.BLACK);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}