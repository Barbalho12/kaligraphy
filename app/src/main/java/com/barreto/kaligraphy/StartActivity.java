package com.barreto.kaligraphy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartActivity extends AppCompatActivity {

    Button bt_iniciar;
    Button bt_cadastrar;
    Button bt_experimente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        bt_iniciar = (Button) findViewById(R.id.bt_iniciar);
        bt_cadastrar = (Button) findViewById(R.id.bt_cadastrar);
        bt_experimente = (Button) findViewById(R.id.bt_experimente);


        bt_iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        bt_cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartActivity.this, CadastrarActivity.class);
                startActivity(intent);
            }
        });

        bt_experimente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartActivity.this, HomeNoUserActivity.class);
                startActivity(intent);
            }
        });


    }
}
