package com.barreto.kaligraphy.activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import com.barreto.kaligraphy.R;
import com.barreto.kaligraphy.fragments.FaseFragment0;
import com.barreto.kaligraphy.fragments.FaseFragment1;
import com.barreto.kaligraphy.fragments.FaseFragment2;
import com.barreto.kaligraphy.fragments.FaseFragment3;
import com.barreto.kaligraphy.fragments.FaseFragment4;
import com.barreto.kaligraphy.model.UserManager;

import static android.content.ContentValues.TAG;

public class MainActivity extends AppCompatActivity {

    private Button bt_parar;
    private Button bt_voltar;
    private Button bt_avancar;

    private int fase = 0;

    private FaseFragment4 faseFragment4;
    private FaseFragment3 faseFragment3;
    private FaseFragment2 faseFragment2;
    private FaseFragment1 faseFragment1;
    private FaseFragment0 faseFragment0;

    float score = 0;

    private UserManager userManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        userManager = new UserManager(getApplicationContext());

        faseFragment0 = new FaseFragment0();
        faseFragment1 = new FaseFragment1();
        faseFragment2 = new FaseFragment2();
        faseFragment3 = new FaseFragment3();
        faseFragment4 = new FaseFragment4();

        final FragmentManager manager = getSupportFragmentManager();
        final FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container, faseFragment0);
//        transaction.addToBackStack(null);
        transaction.commit();

        bt_voltar = (Button) findViewById(R.id.bt_voltar) ;
        bt_parar = (Button) findViewById(R.id.bt_parar) ;
        bt_avancar = (Button) findViewById(R.id.bt_avancar) ;

        bt_voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                switch (fase){
                    case 0:
                        //TODO
                        break;
                    case 1:
                        transaction.replace(R.id.container, faseFragment0);
                        transaction.commit();
                        fase--;
                        break;
                    case 2:
                        transaction.replace(R.id.container, faseFragment1);
                        transaction.commit();
                        fase--;
                        break;
                    case 3:
                        transaction.replace(R.id.container, faseFragment2);
                        transaction.commit();
                        fase--;
                        break;
                    case 4:
                        transaction.replace(R.id.container, faseFragment3);
                        transaction.commit();
                        fase--;
                        break;
                    default:
                        //TODO
                        break;
                }
            }
        });

        bt_parar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alert();
            }
        });

        bt_avancar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                switch (fase){
                    case 0:
                        score += 1;
                        transaction.replace(R.id.container, faseFragment1);
//                        transaction.addToBackStack(null);
                        transaction.commit();
                        fase++;
                        break;
                    case 1:
                        score += faseFragment1.getScore();
                        transaction.replace(R.id.container, faseFragment2);
                        transaction.commit();
                        fase++;
                        break;
                    case 2:
                        score += faseFragment2.getScore();
                        transaction.replace(R.id.container, faseFragment3);
                        transaction.commit();
                        fase++;
                        break;
                    case 3:
                        score += faseFragment3.getScore();
                        transaction.replace(R.id.container, faseFragment4);
                        transaction.commit();
                        fase++;
                        break;
                    case 4:
                        score += faseFragment4.getScore();

                        if(userManager.getActiveUser() == null){
                            Intent intent = new Intent(MainActivity.this, HomeNoUserActivity.class);
                            startActivity(intent);
                            finish();
                        }else{
                            Intent intent = new Intent(MainActivity.this, ExercicioResult.class);

                            userManager.getActiveUser().setPontuacao(score);
                            userManager.getActiveUser().addExercicios_realizados(0);
                            userManager.getActiveUser().addExercicios_vizualizados(0);
                            userManager.getActiveUser().addKnjiVisto();
                            userManager.save( getApplicationContext());
                            startActivity(intent);
                            finish();
                        }


                        break;
                    default:
                        //TODO
                        break;
                }

                Log.v(TAG, "Score Final: "+score);

            }
        });
    }

    void alert(){
        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
        alertDialog.setTitle("Alerta");
        alertDialog.setMessage("Seu progresso será perdido, confirme para SAIR:");
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Sair",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
//                        dialog.dismiss();
                        finish();
//                        finishAffinity();
                    }
                });
        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Cancelar",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
