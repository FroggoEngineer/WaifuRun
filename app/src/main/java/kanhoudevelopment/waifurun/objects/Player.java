package kanhoudevelopment.waifurun.objects;

import android.graphics.Bitmap;

public class Player extends LivingObject
{
    @Override
    protected void LoadContent(Bitmap t)
    {
        super.LoadContent(t);
        width = 128;
        height = 128;
        texture = Bitmap.createScaledBitmap(t, width, height, false);
    }
}
