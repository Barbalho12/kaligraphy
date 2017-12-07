package com.barreto.kaligraphy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ExercicioResult extends AppCompatActivity {

    Button bt_continuar_final;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercicio_result);


        bt_continuar_final = (Button) findViewById(R.id.bt_continuar_final) ;

        bt_continuar_final.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
