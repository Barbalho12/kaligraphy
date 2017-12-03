package com.barreto.kaligraphy;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
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
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView tv_information;
    TouchEventView tev;
    ImageView iv_source;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
//                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
//        drawer.setDrawerListener(toggle);
//        toggle.syncState();

//        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
//        navigationView.setNavigationItemSelectedListener(this);



        tv_information = (TextView) findViewById(R.id.tv_information);
        tev = (TouchEventView) findViewById(R.id.tev_animation);
        iv_source = (ImageView) findViewById(R.id.iv_source);
        tev.setIV(iv_source);

//        int width = iv_source.getDrawable().getIntrinsicWidth();
//        int height = iv_source.getDrawable().getIntrinsicHeight();

//        tv_information.setText("Height: "+height+", Width: "+width);

//
//        iv_source.setOnTouchListener(new View.OnTouchListener() {
//
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                float eventX = event.getX();
//                float eventY = event.getY();
//
//
//                tv_information.setText("X: " + eventX+", Y: "+eventY);
//
//                return true;
//            }
//        });

        Bitmap bm1 = BitmapFactory.decodeResource(getApplicationContext().getResources(),
                R.drawable.together_1);
        Bitmap bm2 = BitmapFactory.decodeResource(getApplicationContext().getResources(),
                R.drawable.together_2);
        Bitmap bm3 = BitmapFactory.decodeResource(getApplicationContext().getResources(),
                R.drawable.together_3);
        Bitmap bm4 = BitmapFactory.decodeResource(getApplicationContext().getResources(),
                R.drawable.together_4);
        Bitmap bm5 = BitmapFactory.decodeResource(getApplicationContext().getResources(),
                R.drawable.together_5);
        Bitmap bm6 = BitmapFactory.decodeResource(getApplicationContext().getResources(),
                R.drawable.together_6);


        ArrayList<HitDraw> points_toque = new ArrayList<>();
        points_toque.add(new HitDraw(170, 420, 20, bm1));
        points_toque.add(new HitDraw(380, 420, 20, bm2));
        points_toque.add(new HitDraw(80, 325, 20, bm3));
        points_toque.add(new HitDraw(120, 190, 20, bm4));
        points_toque.add(new HitDraw(200, 100, 20, bm5));
        points_toque.add(new HitDraw(310, 60, 20, bm6));

        tev.setPointsToque(points_toque);

//        ArrayList<Bitmap> bmps = new ArrayList<>();
//        bmps.add(bm1);
//        bmps.add(bm2);
//        bmps.add(bm3);
//        bmps.add(bm4);
//        bmps.add(bm5);
//        bmps.add(bm6);

//        Bitmap bm_temp = bm1;
//        for(Bitmap bm : bmps){
//            if(!bm.equals(bmps))
//                bm_temp = mergeToPin(bm_temp, bm);
//        }
//        iv_source.setImageBitmap(bm_temp);
    }

//    public static Bitmap mergeToPin(Bitmap back, Bitmap front) {
//        Bitmap result = Bitmap.createBitmap(back.getWidth(), back.getHeight(), back.getConfig());
//        Canvas canvas = new Canvas(result);
//        int widthBack = back.getWidth();
//        int widthFront = front.getWidth();
//        float move = (widthBack - widthFront) / 2;
//        canvas.drawBitmap(back, 0f, 0f, null);
//        canvas.drawBitmap(front, move, move, null);
//        return result;
//    }

//    @Override
//    public void onBackPressed() {
//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        if (drawer.isDrawerOpen(GravityCompat.START)) {
//            drawer.closeDrawer(GravityCompat.START);
//        } else {
//            super.onBackPressed();
//        }
//    }

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

//    @SuppressWarnings("StatementWithEmptyBody")
//    @Override
//    public boolean onNavigationItemSelected(MenuItem item) {
//        // Handle navigation view item clicks here.
//        int id = item.getItemId();
//
//        if (id == R.id.nav_camera) {
//            // Handle the camera action
//        } else if (id == R.id.nav_gallery) {
//
//        } else if (id == R.id.nav_slideshow) {
//
//        } else if (id == R.id.nav_manage) {
//
//        } else if (id == R.id.nav_share) {
//
//        } else if (id == R.id.nav_send) {
//
//        }
//
//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        drawer.closeDrawer(GravityCompat.START);
//        return true;
//    }
}
