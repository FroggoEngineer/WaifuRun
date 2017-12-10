package kanhoudevelopment.waifurun.objects;

import android.graphics.Bitmap;

public class Block extends LivingObject
{

    @Override
    protected void LoadContent(Bitmap t)
    {
        super.LoadContent(t);
    }

    @Override
    protected void Update()
    {
        if (posX < -254)
            active = false;
        super.Update();
    }

    public void spawn(int speed, int y)
    {
        speedX = speed * -1;
        posX = 1280;
        posY = y;
        active = true;
    }
}
