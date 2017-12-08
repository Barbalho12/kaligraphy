package com.barreto.kaligraphy.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.barreto.kaligraphy.R;
import com.barreto.kaligraphy.model.UserManager;

public class ExercicioResult extends AppCompatActivity {

    Button bt_continuar_final;

    private UserManager userManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        userManager = new UserManager(getApplicationContext());

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercicio_result);


        bt_continuar_final = (Button) findViewById(R.id.bt_continuar_final) ;



        TextView tv_pontos = (TextView) findViewById(R.id.tv_pontos) ;

        tv_pontos.setText("+"+userManager.getActiveUser().getPontuacao());

        bt_continuar_final.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ExercicioResult.this, InicialAllActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
