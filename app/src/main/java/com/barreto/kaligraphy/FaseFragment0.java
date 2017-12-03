package com.barreto.kaligraphy;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class FaseFragment0 extends Fragment {



    TextView tv_information_0;
    ImageView iv_source_0;
    ArrayList<HitDraw> points_toque;
    Thread t_tutorial = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fase0, container, false);

        tv_information_0 = (TextView) view.findViewById(R.id.tv_information_0);
        iv_source_0 = (ImageView) view.findViewById(R.id.iv_source_0);

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

        t_tutorial_init_loop(view);

        t_tutorial.start();

        return view;
    }

    public void t_tutorial_init_loop(final View view){
        t_tutorial = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int k=0 ; k<(points_toque.size()+1)*4; k++) {
                    final int index = k%(points_toque.size()+1);

                    iv_source_0.post(new Runnable() {
                        @Override
                        public void run() {
                            if(index == 0){
                                iv_source_0.setImageBitmap(BitmapFactory.decodeResource(view.getResources(),
                                        R.drawable.together_0));
                                iv_source_0.buildDrawingCache();
                            }else{
                                iv_source_0.buildDrawingCache();
                                HitDraw hd = points_toque.get(index-1);
                                Bitmap combine_image = hd.mergeToPin(iv_source_0.getDrawingCache(),hd.getImage());
                                iv_source_0.setImageBitmap(combine_image);
                                iv_source_0.buildDrawingCache();
                            }
                        }
                    });
                    try {
                        Thread.sleep(700);
                    } catch(InterruptedException e) {

                    }
                }
            }
        });
    }

}
