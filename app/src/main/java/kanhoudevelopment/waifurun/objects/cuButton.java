package kanhoudevelopment.waifurun.objects;


/**
 * Created by nacon on 2017-12-10.
 */

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

import kanhoudevelopment.waifurun.GameView;
import kanhoudevelopment.waifurun.R;

public class cuButton {

    private Bitmap tex;
    private int texWidth, texHeight;
    private int posX, touchX;
    private int posY, touchY;
    private int radius, touchR;
    private double scaleX, scaleY;
    private Paint p;

    public cuButton(View v, int posX, int posY, int radius, Paint p, double scaleX, double scaleY) {
        Bitmap tmp = BitmapFactory.decodeResource(v.getResources(), R.drawable.button2);
        this.tex = Bitmap.createScaledBitmap(tmp, radius, radius, false);
        this.posX = posX;
        this.posY = posY;
        this.radius = radius;
        this.p = p;

        touchX = (int)(((double)posX) / scaleX);
        touchY = (int)(((double)posY) / scaleY);
        texWidth = (int)(((double)tex.getWidth())/scaleX);
        texHeight = (int)(((double)tex.getHeight())/scaleY);
        this.scaleX = scaleX;
        this.scaleY = scaleY;
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

    public void print() {
        System.out.println("posX: " + touchX);
        System.out.println("posY: " + touchY);
        System.out.println("texWidth: " + texWidth);
        System.out.println("texHeight: " + texHeight);



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
        if (event.getX() >= touchX && event.getX() < (touchX + texWidth)
                && event.getY() >= touchY && event.getY() < (touchY + texHeight)) {

            System.out.println("TESTING BUTTON!!!");

            return true;
            //tada, if this is true, you've started your click inside your bitmap



        }
        else {
            return false;
        }
    }

}
