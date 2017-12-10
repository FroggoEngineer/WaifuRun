package kanhoudevelopment.waifurun.objects;

import kanhoudevelopment.waifurun.GameView;
import android.graphics.Bitmap;

public class LivingObject
{

    protected int posX, posY, speedX, speedY, width, height;
    protected boolean active;
    protected Bitmap texture;

    protected boolean isActive()
    {
        return active;
    }

    public int getPosX() { return posX; }
    public int getPosY() { return posY; }

    protected void LoadContent(Bitmap t)
    {
        posX = 0;
        posY = 0;
        width = 0;
        height = 0;
        speedX = 0;
        active = false;
        texture = t;
    }

    protected void Update()
    {
        posX += speedX;
        posY += speedY;
    }

    protected void draw(GameView v)
    {
        if (active)
        {
           v.draw(texture, posX, posY);
        }
    }
}
