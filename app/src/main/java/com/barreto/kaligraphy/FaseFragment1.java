package com.barreto.kaligraphy;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class FaseFragment1 extends Fragment {

    TouchEventView tev_animation_1;
    TextView tv_information_1;
    ImageView iv_source_1;
    ArrayList<HitDraw> points_toque;

    public float getScore(){
        return tev_animation_1.getScore();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fase1, container, false);

        tv_information_1 = (TextView) view.findViewById(R.id.tv_information_1);
        iv_source_1 = (ImageView) view.findViewById(R.id.iv_source_1);
        tev_animation_1 = (TouchEventView) view.findViewById(R.id.tev_animation_1);

        Bitmap bm1 = BitmapFactory.decodeResource(view.getResources(),
                R.drawable.together_1);
        Bitmap bm2 = BitmapFactory.decodeResource(view.getResources(),
                R.drawable.together_2);
        Bitmap bm3 = BitmapFactory.decodeResource(view.getResources(),
                R.drawable.together_3);
        Bitmap bm4 = BitmapFactory.decodeResource(view.getResources(),
                R.drawable.together_4);
        Bitmap bm5 = BitmapFactory.decodeResource(view.getResources(),
                R.drawable.together_5);
        Bitmap bm6 = BitmapFactory.decodeResource(view.getResources(),
                R.drawable.together_6);
        points_toque = new ArrayList<>();
        points_toque.add(new HitDraw(170, 420, 20, bm1));
        points_toque.add(new HitDraw(380, 420, 20, bm2));
        points_toque.add(new HitDraw(80, 325, 20, bm3));
        points_toque.add(new HitDraw(120, 190, 20, bm4));
        points_toque.add(new HitDraw(200, 100, 20, bm5));
        points_toque.add(new HitDraw(310, 60, 20, bm6));

        tev_animation_1.setIV(iv_source_1);
        tev_animation_1.setPointsToque(points_toque);

        return view;
    }


}