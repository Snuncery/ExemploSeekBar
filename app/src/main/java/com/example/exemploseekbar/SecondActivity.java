package com.example.exemploseekbar;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    private Button buttonVoltar;
    private TextView txtValor;
    private View bgViewSecond;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.second_activity);

        buttonVoltar = findViewById(R.id.btnVoltar);
        txtValor = findViewById(R.id.textValorVolume);
        bgViewSecond = findViewById(R.id.segundaTela);

        //recebendo os valores da primeira tela
        Integer valorVolume = getIntent().getIntExtra("VALOR", 0);

        if (valorVolume > 70) {
            bgViewSecond.setBackgroundColor(Color.GREEN);
            txtValor.setTextColor(Color.BLACK);
        } else if (valorVolume < 30){
            bgViewSecond.setBackgroundColor(Color.RED);
            txtValor.setTextColor(Color.WHITE);
        } else {
            bgViewSecond.setBackgroundColor(Color.YELLOW);
            txtValor.setTextColor(Color.BLACK);
        }

        //definindo o textview com o valor recebido da tela anterior
        txtValor.setText("Valor: " + valorVolume);

        //voltar para a tela anterior
        buttonVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
