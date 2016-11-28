package com.example.marcos.motofrete;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    EditText txtDist, txtConsumo, txtLitroGas, txtLucro;
    Button btnConsultaMapas, btnConsultaFrete, btnAjustaTela;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAjustaTela = (Button) findViewById(R.id.btnAjustaTela);
        final LinearLayout fundoTela = (LinearLayout) findViewById(R.id.fundoTela);
        btnConsultaMapas = (Button) findViewById(R.id.btnConsultaMapas);

        btnAjustaTela.setOnClickListener(new Button.OnClickListener() {
                                             public void onClick(View v) {
                                                 fundoTela.setBackgroundColor(Color.parseColor("#BEBEBE"));
                                             }
                                         }
        );

        btnConsultaMapas.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, MapaActivity.class);
                startActivity(i);
            }

        });

    }
}
