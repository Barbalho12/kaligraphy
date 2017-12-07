package com.barreto.kaligraphy;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class FaseFragment4 extends Fragment {

    TouchEventView tev_animation_4;
    TextView tv_information_4;
//    ImageView iv_source_4;
    ArrayList<HitDraw> points_toque;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fase4, container, false);

        tv_information_4 = (TextView) view.findViewById(R.id.tv_information_4);
//        iv_source_4 = (ImageView) view.findViewById(R.id.iv_source_4);
        tev_animation_4 = (TouchEventView) view.findViewById(R.id.tev_animation_4);
        tev_animation_4.flag_show_points = false;

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
//        points_toque.add(new HitDraw(250, 175, 15, null));
        points_toque.add(new HitDraw(360, 155, 15, null));

        points_toque.add(new HitDraw(200, 100, 15, null));
        points_toque.add(new HitDraw(200, 270, 15, null));

        points_toque.add(new HitDraw(310, 60, 15, null));
        points_toque.add(new HitDraw(300, 250, 15, null));

//        tev_animation_3.setIV(iv_source_3);
        tev_animation_4.setPointsToque(points_toque);

        return view;
    }


    public float getScore(){
        return tev_animation_4.getScore();
    }

}