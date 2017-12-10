package kanhoudevelopment.waifurun.objects;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

import kanhoudevelopment.waifurun.GameView;
import kanhoudevelopment.waifurun.R;

/**
 * Created by nacon on 2017-12-10.
 */

public class cuButton {

    private Bitmap tex;
    private int posX;
    private int posY;
    private int radius;
    private Paint p;

    public cuButton(View v, int posX, int posY, int radius, Paint p) {
        this.tex = BitmapFactory.decodeResource(v.getResources(), R.drawable.button_round);
        this.posX = posX;
        this.posY = posY;
        this.radius = radius;
        this.p = p;
    }

    public Bitmap getBitMap() { return tex;}
    public int getPosX(){
        return posX;
    }
    public int getPosY() {
        return posY;
    }
    public Paint getPaint() {
        return p;
    }
    public int getRadius() {
        return radius;
    }


    //SET
    public void setBitMap(Bitmap bm) {this.tex = bm;}
    public void setPosX(int newPosX){
        this.posX = newPosX;
    }
    public void setPosY(int newPosY) {
        this.posY = newPosY;
    }
    public void setPaint(Paint p) {
        this.p = p;
    }
    public void setRadius(int radius) {
        this.radius = radius;
    }

    public void draw(GameView gv){
        gv.draw(tex, posX, posY);
    }

    public boolean isPressed(MotionEvent event) {
        if (event.getX() >= posX && event.getX() < (posX + tex.getWidth())
                && event.getY() >= posY && event.getY() < (posY + tex.getHeight())) {

            return true;
            //tada, if this is true, you've started your click inside your bitmap
        }
        else {
            return false;
        }
    }

}