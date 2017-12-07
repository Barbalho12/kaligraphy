package com.barreto.kaligraphy.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.barreto.kaligraphy.R;
import com.barreto.kaligraphy.model.UserManager;

public class StartActivity extends AppCompatActivity {

    Button bt_iniciar;
    Button bt_cadastrar;
    Button bt_experimente;

    void verifySession(){
        UserManager userManager = new UserManager(getApplicationContext());
        if(userManager.getActiveUser() != null){
            Intent intent = new Intent(getApplicationContext(), InicialAllActivity.class);
            startActivity(intent);
            finish();
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        verifySession();

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
