package kanhoudevelopment.waifurun.objects;

import android.view.SurfaceHolder;
import android.graphics.Bitmap;
import android.graphics.Paint;

public class LivingObject
{

    protected int posX, posY, speedX, speedY;
    protected boolean active;
    protected Bitmap texture;
    Paint paint;

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
        paint = new Paint();

    }

    protected void Update()
    {
        posX += speedX;
        posY += speedY;
    }

    protected void draw(SurfaceHolder holder)
    {
        if (active)
        {
            holder.lockCanvas().drawBitmap(texture, posX, posY, paint);
        }
    }
}
