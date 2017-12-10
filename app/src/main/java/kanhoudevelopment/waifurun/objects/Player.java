package kanhoudevelopment.waifurun.objects;

import kanhoudevelopment.waifurun.GameView;
import kanhoudevelopment.waifurun.R;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class Player
{

    private int posX, posY;
    private int speedY;
    private boolean jumping;
    Bitmap tex;


    public Player(int x, int y, GameView v) {
        posX = x;
        posY = y;
        tex = BitmapFactory.decodeResource(v.getResources(), R.drawable.reisensprite);
    }

    public void update() {
        posY += speedY;
    }

    public void landing() {
        speedY = 0;
        jumping = false;
    }

    public void jump() {
        if(!jumping) {
            speedY = -10;
            jumping = true;
        }

    }

    public void draw(GameView view) {
        view.draw(tex, posX, posY);
    }
}
