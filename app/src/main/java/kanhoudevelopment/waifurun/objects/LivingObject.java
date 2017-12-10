package kanhoudevelopment.waifurun.objects;

import kanhoudevelopment.waifurun.GameView;
import android.graphics.Bitmap;
import android.graphics.Paint;

public class LivingObject
{

    protected int posX, posY, speedX, speedY;
    protected boolean active;
    protected Bitmap texture;

    protected boolean isActive()
    {
        return active;
    }

    protected void LoadContent(Bitmap t)
    {
        posX = 0;
        posY = 0;
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
