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
        if (posX < 0)
            active = false;
    }

    public void spawn(int speed, int y)
    {
        speedX = speed * -1;
        posX = 500;
        posY = y;
        active = true;
    }
}
