package kanhoudevelopment.waifurun.objects;

import android.graphics.Bitmap;

public class Block extends LivingObject
{
    private static final int BLOCK_SIZE = 64;

    @Override
    protected void LoadContent(Bitmap t)
    {
        super.LoadContent(t);
        width = BLOCK_SIZE;
        height = BLOCK_SIZE;
        texture = Bitmap.createScaledBitmap(t, width, height, false);
    }

    @Override
    protected void Update()
    {
        if (posX < 0 - width)
            active = false;
        super.Update();
    }

    public void spawn(int speed, int y, int q)
    {
        speedX = speed * -1;
        if (q == 0)
            posX = 1920 + BLOCK_SIZE;
        else
            posX = q + BLOCK_SIZE;

        posY = y;
        active = true;
    }
}
