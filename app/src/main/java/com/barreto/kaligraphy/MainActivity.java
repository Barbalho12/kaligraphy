package com.barreto.kaligraphy;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.MotionEvent;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button bt_parar;
    private Button bt_voltar;
    private Button bt_avancar;

    private int fase = 0;

    private FaseFragment1 faseFragment1;
    private FaseFragment0 faseFragment0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        faseFragment0 = new FaseFragment0();
        faseFragment1 = new FaseFragment1();

        final FragmentManager manager = getSupportFragmentManager();
        final FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container, faseFragment0);
        transaction.addToBackStack(null);
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
                    default:
                        //TODO
                        break;
                }
            }
        });

        bt_parar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO
            }
        });

        bt_avancar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                switch (fase){
                    case 0:
                        transaction.replace(R.id.container, faseFragment1);
                        transaction.addToBackStack(null);
                        transaction.commit();
                        fase++;
                        break;
                    case 1:
                        //TODO
                        break;
                    default:
                        //TODO
                        break;
                }

            }
        });
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
