package com.barreto.kaligraphy;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class TouchEventView extends View {
    private Paint paint = new Paint();
    private Path path = new Path();
    Context context;

    public TouchEventView(final Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;

        paint.setAntiAlias(true);
        paint.setStrokeWidth(10f);
        paint.setColor(Color.RED);

        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);


//        setOnLongClickListener(new OnLongClickListener() {
//            @Override
//            public boolean onLongClick(View v) {
//                paint.reset();
//                Toast.makeText(context, "Long Clicked", Toast.LENGTH_SHORT).show();
//                return true;
//            }
//        });
    }

    ImageView iv_source = null;
    ArrayList<HitDraw> points_toque;

    public void setIV(ImageView iv_source){
        this.iv_source = iv_source;
    }
    public void setPointsToque(ArrayList<HitDraw> points_toque){
        this.points_toque = points_toque;
    }


    @Override
    protected void onDraw(Canvas canvas) {

        paint.setColor(Color.RED);
        canvas.drawPath(path, paint);
        paint.setColor(Color.RED);


        for(HitDraw hd : points_toque){
            canvas.drawCircle(hd.getCx(), hd.getCy(), hd.getRadius(),  paint);
        }

//
//        canvas.drawCircle(240, 60, 20,  paint);
//        canvas.drawCircle(180, 220, 20,  paint);
//        canvas.drawCircle(105, 350, 20,  paint);
//        canvas.drawCircle(20, 450, 20,  paint);
//
//        canvas.drawCircle(195, 280, 20,  paint);
//        canvas.drawCircle(300, 390, 20,  paint);
//        canvas.drawCircle(380, 470, 20,  paint);
//        canvas.drawCircle(490, 500, 20,  paint);
//
//        paint.setColor(Color.GREEN);
//        canvas.drawLine(240, 60, 180, 220, paint);
//        canvas.drawLine(180, 220, 105, 350, paint);
//        canvas.drawLine(105, 350, 20, 450, paint);
//
//        canvas.drawLine(195, 280, 300, 390, paint);
//        canvas.drawLine(300, 390, 380, 470, paint);
//        canvas.drawLine(380, 470, 490, 500, paint);
    }


    int sequence = 0;
    int points = 0;
    float score = 0;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float eventX = event.getX();
        float eventY = event.getY();

        if(iv_source != null){
//            tv.setText("X: " + eventX/512+", Y: "+eventY/512);
            for(HitDraw hd : points_toque){
                if(hd.hit(eventX,eventY)){
                    if(sequence == points_toque.indexOf(hd)){
                        points++;
                        score = points/points_toque.size();
                    }
                    sequence++;


                    iv_source.buildDrawingCache();
                    Bitmap combine_image = hd.mergeToPin(iv_source.getDrawingCache(),hd.getImage());
                    iv_source.setImageBitmap(combine_image);
                    iv_source.buildDrawingCache();
                    break;
                }
            }
        }

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                path.moveTo(eventX, eventY);
                return true;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(eventX, eventY);
                break;
            case MotionEvent.ACTION_UP:
                break;
            default:
                return false;
        }

        // Schedules a repaint.
        invalidate();
        return true;
    }
}