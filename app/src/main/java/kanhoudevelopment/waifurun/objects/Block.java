package kanhoudevelopment.waifurun.objects;

import android.graphics.Bitmap;

public class Block extends LivingObject
{

    @Override
    protected void LoadContent(Bitmap t)
    {
        super.LoadContent(t);
        width = 128;
        height = 128;
        texture = Bitmap.createScaledBitmap(t, width, height, false);
    }

    @Override
    protected void Update()
    {
        if (posX < 0 - width)
            active = false;
        super.Update();
    }

    public void spawn(int speed, int y)
    {
        speedX = speed * -1;
        posX = 1920;
        posY = y;
        active = true;
    }
}
