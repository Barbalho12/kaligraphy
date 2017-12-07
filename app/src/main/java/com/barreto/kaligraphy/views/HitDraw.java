package com.barreto.kaligraphy.views;

import android.graphics.Bitmap;
import android.graphics.Canvas;

/**
 * Created by Barreto on 03/12/2017.
 */

public class HitDraw {
    private float cx;
    private float cy;
    private float radius;
    private Bitmap image;

    public HitDraw(float cx, float cy, float radius, Bitmap image){
        this.cx = cx;
        this.cy = cy;
        this.radius = radius;
        this.image = image;
    }

    public boolean hit(float x, float y){
        boolean x_verify = (x < cx + radius) && x > (cx - radius);
        boolean y_verify = (y < cy + radius) && y > (cy - radius);
        return x_verify && y_verify;
    }

    public static Bitmap mergeToPin(Bitmap back, Bitmap front) {
        Bitmap result = Bitmap.createBitmap(back.getWidth(), back.getHeight(), back.getConfig());
        Canvas canvas = new Canvas(result);
        int widthBack = back.getWidth();
        int widthFront = front.getWidth();
        float move = (widthBack - widthFront) / 2;
        canvas.drawBitmap(back, 0f, 0f, null);
        canvas.drawBitmap(front, move, move, null);
        return result;
    }

    public float getCx() {
        return cx;
    }

    public void setCx(float cx) {
        this.cx = cx;
    }

    public float getCy() {
        return cy;
    }

    public void setCy(float cy) {
        this.cy = cy;
    }

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }
}
