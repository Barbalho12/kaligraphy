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

public class FaseFragment2 extends Fragment {

    TouchEventView tev_animation_2;
    TextView tv_information_2;
    ImageView iv_source_2;
    ArrayList<HitDraw> points_toque;

    public float getScore(){
        return tev_animation_2.getScore();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fase2, container, false);

        tv_information_2 = (TextView) view.findViewById(R.id.tv_information_2);
        iv_source_2 = (ImageView) view.findViewById(R.id.iv_source_2);
        tev_animation_2 = (TouchEventView) view.findViewById(R.id.tev_animation_2);

//        Bitmap bm1 = BitmapFactory.decodeResource(view.getResources(),
//                R.drawable.together_1);
//        Bitmap bm2 = BitmapFactory.decodeResource(view.getResources(),
//                R.drawable.together_2);
//        Bitmap bm3 = BitmapFactory.decodeResource(view.getResources(),
//                R.drawable.together_3);
//        Bitmap bm4 = BitmapFactory.decodeResource(view.getResources(),
//                R.drawable.together_4);
//        Bitmap bm5 = BitmapFactory.decodeResource(view.getResources(),
//                R.drawable.together_5);
//        Bitmap bm6 = BitmapFactory.decodeResource(view.getResources(),
//                R.drawable.together_6);
        points_toque = new ArrayList<>();
//        points_toque.add(new HitDraw(170, 420, 20, bm1));
//        points_toque.add(new HitDraw(380, 420, 20, bm2));
//        points_toque.add(new HitDraw(80, 325, 20, bm3));
//        points_toque.add(new HitDraw(120, 190, 20, bm4));
//        points_toque.add(new HitDraw(200, 100, 20, bm5));
//        points_toque.add(new HitDraw(310, 60, 20, bm6));

        tev_animation_2.setIV(iv_source_2);
        tev_animation_2.setPointsToque(points_toque);

        return view;
    }


}