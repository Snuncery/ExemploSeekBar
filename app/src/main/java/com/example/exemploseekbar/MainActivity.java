package com.example.exemploseekbar;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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
    private Button buttonEnviar;
    private int valor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        seekBar = findViewById(R.id.seekBarVolume);
        textViewValor = findViewById(R.id.textSeekBar);
        bgView = findViewById(R.id.main);
        buttonEnviar = findViewById(R.id.btnEnviar);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textViewValor.setText("Volume: " + progress);
                //inserindo o valor progress em uma variável
                valor = progress;
                //alterando o plano de fundo de acordo com o valor de volume
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

        buttonEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //chamando a segunda activity
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                //enviando a variável para a segunda tela
                intent.putExtra("VALOR", valor);
                startActivity(intent);
            }
        });
    }
}