package com.barreto.kaligraphy;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeNoUserActivity extends AppCompatActivity {


    Button bt_nou_estudar;
    Button bt_nou_nivel;
    Button bt_nou_cadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_no_user);

        bt_nou_estudar = (Button) findViewById(R.id.bt_nou_estudar);
        bt_nou_nivel = (Button) findViewById(R.id.bt_nou_nivel);
        bt_nou_cadastrar = (Button) findViewById(R.id.bt_nou_cadastrar);


        bt_nou_estudar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeNoUserActivity.this, InicialAllActivity.class);
                startActivity(intent);
            }
        });

        bt_nou_nivel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog alertDialog = new AlertDialog.Builder(HomeNoUserActivity.this).create();
                alertDialog.setTitle("Alerta");
                alertDialog.setMessage("Não implementado");
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                alertDialog.show();
            }
        });

        bt_nou_cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeNoUserActivity.this, CadastrarActivity.class);
                startActivity(intent);
            }
        });
    }
}
