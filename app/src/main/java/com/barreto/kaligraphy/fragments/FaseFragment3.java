package com.barreto.kaligraphy.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.barreto.kaligraphy.views.HitDraw;
import com.barreto.kaligraphy.R;
import com.barreto.kaligraphy.views.TouchEventView;

import java.util.ArrayList;

public class FaseFragment3 extends Fragment {

    TouchEventView tev_animation_3;
    TextView tv_information_3;
    ArrayList<HitDraw> points_toque;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fase3, container, false);

        tv_information_3 = (TextView) view.findViewById(R.id.tv_information_3);
        tev_animation_3 = (TouchEventView) view.findViewById(R.id.tev_animation_3);


        points_toque = new ArrayList<>();

        points_toque.add(new HitDraw(100, 480, 15, null));
        points_toque.add(new HitDraw(160, 430, 15, null));
        points_toque.add(new HitDraw(200, 380, 15, null));

        points_toque.add(new HitDraw(320, 375, 15, null));
        points_toque.add(new HitDraw(370, 410, 15, null));
        points_toque.add(new HitDraw(400, 440, 15, null));

        points_toque.add(new HitDraw(80, 325, 15, null));
        points_toque.add(new HitDraw(200, 300, 15, null));
        points_toque.add(new HitDraw(300, 295, 15, null));
        points_toque.add(new HitDraw(460, 285, 15, null));

        points_toque.add(new HitDraw(120, 190, 15, null));
        points_toque.add(new HitDraw(360, 155, 15, null));

        points_toque.add(new HitDraw(200, 100, 15, null));
        points_toque.add(new HitDraw(200, 270, 15, null));

        points_toque.add(new HitDraw(310, 60, 15, null));
        points_toque.add(new HitDraw(300, 250, 15, null));

        tev_animation_3.setPointsToque(points_toque);

        return view;
    }


    public float getScore(){
        return tev_animation_3.getScore();
    }

}